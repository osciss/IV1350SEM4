package se.kth.iv1350.repairelectricbike.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.repairelectricbike.controller.exception.CustomerOperationFailedException;
import se.kth.iv1350.repairelectricbike.integration.Printer;
import se.kth.iv1350.repairelectricbike.integration.RegistryCreator;
import se.kth.iv1350.repairelectricbike.integration.exception.CustomerNotFoundException;
import se.kth.iv1350.repairelectricbike.model.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;

import java.util.List;

/**
 * Unit tests for the Controller class.
 */
public class ControllerTest {

    private Controller controller;

    private static final String EXISTING_PHONE = "01234";
    private static final String NONEXISTENT_PHONE = "00000";
    private static final String DB_FAILURE_PHONE = "99999";

    @BeforeEach
    public void setUp() {
    RepairOrderRegistry.sharedRepairOrders().removeAllRepairOrders();

    RegistryCreator creator = new RegistryCreator();
    Printer printer = new Printer();
    controller = new Controller(creator, printer);
}

    @Test
    public void testFindCustomerReturnsCustomerForExistingPhone() throws CustomerNotFoundException {
        CustomerDTO result = controller.findCustomer(EXISTING_PHONE);
        assertNotNull(result,
                "findCustomer should return a CustomerDTO for an existing phone number.");
    }

    @Test
    public void testFindCustomerThrowsCustomerNotFoundExceptionForUnknownPhone() {
        assertThrows(CustomerNotFoundException.class,
                () -> controller.findCustomer(NONEXISTENT_PHONE),
                "findCustomer should throw CustomerNotFoundException for an unknown phone number.");
    }

    @Test
    public void testFindCustomerThrowsCustomerOperationFailedExceptionForDatabaseFailure() {
        assertThrows(CustomerOperationFailedException.class,
                () -> controller.findCustomer(DB_FAILURE_PHONE),
                "findCustomer should throw CustomerOperationFailedException when database fails.");
    }

    @Test
    public void testCreateRepairOrderAppearsInFindAll() {
        controller.createRepairOrder("Wheel wobbles.", EXISTING_PHONE, 1);
        List<RepairOrderDTO> orders = controller.findAllRepairOrders();
        assertEquals(1, orders.size(),
                "After creating one repair order, findAllRepairOrders should return one.");
    }

    @Test
    public void testFindAllRepairOrdersIsEmptyBeforeAnyCreated() {
        List<RepairOrderDTO> orders = controller.findAllRepairOrders();
        assertEquals(0, orders.size(),
                "Before any repair orders are created, findAllRepairOrders should return empty.");
    }

    @Test
    public void testAcceptRepairOrderChangesStateToAccepted() {
        controller.createRepairOrder("Throttle stuck.", EXISTING_PHONE, 1);
        int orderId = controller.findAllRepairOrders().get(0).id;
        controller.acceptRepairOrder(orderId);
        assertEquals("ACCEPTED", controller.findAllRepairOrders().get(0).state,
                "State should be ACCEPTED after acceptRepairOrder is called.");
    }

    @Test
    public void testRejectRepairOrderChangesStateToRejected() {
        controller.createRepairOrder("Display broken.", EXISTING_PHONE, 1);
        int orderId = controller.findAllRepairOrders().get(0).id;
        controller.rejectRepairOrder(orderId);
        assertEquals("REJECTED", controller.findAllRepairOrders().get(0).state,
                "State should be REJECTED after rejectRepairOrder is called.");
    }

    @Test
    public void testAddRepairTaskDoesNotThrow() {
        controller.createRepairOrder("Motor noise.", EXISTING_PHONE, 1);
        int orderId = controller.findAllRepairOrders().get(0).id;
        assertDoesNotThrow(() -> controller.addRepairTask(orderId, "Replace motor.", 200.0),
                "addRepairTask should not throw any exception.");
    }

    @Test
    public void testAddDiagnosticResultDoesNotThrow() {
        controller.createRepairOrder("Strange noise.", EXISTING_PHONE, 1);
        int orderId = controller.findAllRepairOrders().get(0).id;
        assertDoesNotThrow(() -> controller.addDiagnosticResult(orderId, "Bearing worn."),
                "addDiagnosticResult should not throw any exception.");
    }
}