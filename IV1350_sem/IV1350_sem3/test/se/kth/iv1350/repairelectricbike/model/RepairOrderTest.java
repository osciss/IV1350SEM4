package se.kth.iv1350.repairelectricbike.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderUpdateDTO;

/**
 * Unit tests for the RepairOrder class.
 */
public class RepairOrderTest {

    private RepairOrder order;
    private TestObserver observer;

    @BeforeEach
    void setUp() {
        order = new RepairOrder(1, "Battery problem", "01234", 12345);
        observer = new TestObserver();
        order.addObserver(observer);
    }

    @Test
    void testConstructor() {
        assertEquals("NEWLY CREATED", order.getState(),
                "A newly created repair order should have state NEWLY CREATED.");
        assertEquals(1, order.getId(),
                "getId should return the id set in the constructor.");
        assertEquals("Battery problem", order.getProblemDesc(),
                "getProblemDesc should return the description set in the constructor.");
        assertEquals("01234", order.getCustomerPhone(),
                "getCustomerPhone should return the phone number set in the constructor.");
        assertEquals(12345, order.getBikeSerialNo(),
                "getBikeSerialNo should return the serial number set in the constructor.");
    }

    @Test
    void testOnAddRepairTask() {
        RepairTask repairTask = new RepairTask("Replace chain", "Description: Replace chain", 0.0, "NEW");
        order.addRepairTask(repairTask);
        assertTrue(order.toString().contains("Replace chain"),
                "Added repair task should appear in toString output.");
    }

    @Test
    void testOnAddDiagnosticResult() {
        order.addDiagnosticResult(1, "Motor is broken");
        assertTrue(order.toString().contains("Motor is broken"),
                "Added diagnostic result should appear in toString output.");
    }

    @Test
    void testOnSetStateAccepted() {
        order.setState("ACCEPTED");
        assertEquals("ACCEPTED", order.getState(),
                "State should be ACCEPTED after calling setState(ACCEPTED).");
    }

    @Test
    void testOnSetStateRejected() {
        order.setState("REJECTED");
        assertEquals("REJECTED", order.getState(),
                "State should be REJECTED after calling setState(REJECTED).");
    }

    @Test
    void testObserverReceivesRepairOrderUpdateDTO() {
        order.addDiagnosticResult(1, "Motor is broken");

        assertNotNull(observer.latestUpdate,
                "Observer should receive an update DTO when the repair order changes.");
        assertEquals(order.getId(), observer.latestUpdate.id(),
                "Observer DTO should contain the repair order id.");
        assertEquals(order.getProblemDesc(), observer.latestUpdate.problemDesc(),
                "Observer DTO should contain the repair order problem description.");
        assertTrue(observer.latestUpdate.diagnosticResults().contains("ID: 1 - Motor is broken"),
                "Observer DTO should contain the added diagnostic result.");
    }

    private static class TestObserver implements RepairOrderObserver {
        private RepairOrderUpdateDTO latestUpdate;

        @Override
        public void repairOrderUpdated(RepairOrderUpdateDTO repairOrderUpdate) {
            latestUpdate = repairOrderUpdate;
        }
    }
}
