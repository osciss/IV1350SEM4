package se.kth.iv1350.repairelectricbike.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepairOrderTest {

    @Test
    void testConstructor() {
        RepairOrder order = new RepairOrder(1, "Battery problem");

        assertEquals("NEWLY CREATED", order.getState());
        assertEquals(1, order.getId());
        assertEquals("Battery problem", order.getProblemDesc());
    }

    @Test
    void testOnAddRepairTask() {
        RepairOrder order = new RepairOrder(1, "Chain issue");

        order.addRepairTask("Replace chain");

        assertTrue(order.toString().contains("Replace chain"));
    }

    @Test
    void testOnAddDiagnosticResult() {
        RepairOrder order = new RepairOrder(1, "Test");

        order.addDiagnosticResult(1, "Motor is broken");

        assertTrue(order.toString().contains("Motor is broken"));
    }

    @Test
    void testOnSetState() {
        RepairOrder order = new RepairOrder(1, "Test");

        order.setState("ACCEPTED");

        assertEquals("ACCEPTED", order.getState());
    }
}