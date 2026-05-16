package se.kth.iv1350.repairelectricbike.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderDTO;

import java.util.List;

/**
 * Unit tests for the RepairOrderRegistry class.
 */
public class RepairOrderRegistryTest {

    private RepairOrderRegistry repairOrderRegistry;

    @BeforeEach
    public void setUp() {
    repairOrderRegistry =
            repairOrderRegistry.sharedRepairOrders();

    repairOrderRegistry.removeAllRepairOrders();
}

    @Test
    public void testFindRepairOrderReturnsNullWhenEmpty() {
        RepairOrder result = repairOrderRegistry.findRepairOrder(1);
        assertNull(result,
                "findRepairOrder should return null when no orders have been added.");
    }

    @Test
    public void testCreateAndFindRepairOrder() {
        RepairOrder order = new RepairOrder(1, "Brake problem.", "01234", 12345);
        repairOrderRegistry.createRepairOrder(order);
        RepairOrder found = repairOrderRegistry.findRepairOrder(1);
        assertNotNull(found,
                "findRepairOrder should return the order after it has been created.");
        assertEquals(1, found.getId(),
                "Found order should have the same id as the created one.");
    }

    @Test
    public void testFindAllRepairOrdersIsEmptyInitially() {
        List<RepairOrderDTO> result = repairOrderRegistry.findAllRepairOrders();
        assertEquals(0, result.size(),
                "A new registry should contain zero repair orders.");
    }

    @Test
    public void testFindAllRepairOrdersReturnsAllCreated() {
        repairOrderRegistry.createRepairOrder(new RepairOrder(1, "Problem 1.", "01234", 12345));
        repairOrderRegistry.createRepairOrder(new RepairOrder(2, "Problem 2.", "05678", 23456));
        List<RepairOrderDTO> result = repairOrderRegistry.findAllRepairOrders();
        assertEquals(2, result.size(),
                "findAllRepairOrders should return exactly as many orders as were created.");
    }
    @Test
    public void testFindCorrectNumberOfCustomerOrders() {
        repairOrderRegistry.createRepairOrder(new RepairOrder(1, "Problem 1.", "01234", 12345));
        repairOrderRegistry.createRepairOrder(new RepairOrder(2, "Problem 2.", "05678", 23456));
        repairOrderRegistry.createRepairOrder(new RepairOrder(3, "Problem 3.", " 01234", 34567));
        int result = repairOrderRegistry.countCustomerOrders("01234");
        assertEquals(2, result,
                "countCustomerOrders should return the correct number of orders for the given customer phone number.");
    }
    @Test
    public void testUpdateRepairOrderChangesState() {
        RepairOrder order = new RepairOrder(1, "Chain slips.", "091011", 34567);
        repairOrderRegistry.createRepairOrder(order);
        order.setState("ACCEPTED");
        repairOrderRegistry.updateRepairOrder(order);
        RepairOrder updated = repairOrderRegistry.findRepairOrder(1);
        assertEquals("ACCEPTED", updated.getState(),
                "State should be updated in registry after updateRepairOrder is called.");
    }
}
