package se.kth.iv1350.repairelectricbike.view;

import java.util.List;
import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.controller.exception.CustomerOperationFailedException;
import se.kth.iv1350.repairelectricbike.integration.exception.CustomerNotFoundException;
import se.kth.iv1350.repairelectricbike.model.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderDTO;

/**
 * Represents the user interface. Handles all user-facing output,
 * including informative error messages when exceptions are caught.
 */
public class View {

    private final Controller controller;

    /**
     * Creates a new view and registers repair order observers with the controller.
     *
     * @param controller Used to communicate with the system.
     */
    public View(Controller controller) {
        this.controller = controller;
        controller.addRepairOrderObserver(new RepairOrderView());
        controller.addRepairOrderObserver(new RepairOrderLogger());
    }

    /**
     * Runs the program by executing all steps of the basic flow,
     * as well as demonstrating error handling for alternative flows.
     */
    public void run() {
        findCustomerStep();
        createRepairOrderStep();
        findAllRepairOrdersStep();
        addDiagnosticResultStep();
        addRepairTaskStep();
        calculateTotalPriceStep();
        acceptRepairOrderStep();

        System.out.println("\n--- Demonstrating error handling ---");
        findCustomerNotFoundStep();
        findCustomerDatabaseFailureStep();
    }

    /**
     * Finds a customer and prints the result.
     */
    private void findCustomerStep() {
        System.out.println("1. Find customer");
        try {
            CustomerDTO customer = controller.findCustomer("01234");
            System.out.println("   Customer found: " + customer.getName());
        } catch (CustomerNotFoundException ex) {
            System.out.println("   ERROR: No customer found with that phone number.");
        } catch (CustomerOperationFailedException ex) {
            System.out.println("   ERROR: Could not reach the database. Please try again later.");
        }
    }

    /**
     * Demonstrates alternative flow 5a: phone number not found.
     */
    private void findCustomerNotFoundStep() {
        System.out.println("Finding customer with unknown number:");
        try {
            controller.findCustomer("00000");
        } catch (CustomerNotFoundException ex) {
            System.out.println("   ERROR: No customer found with phone number "
                    + ex.getPhoneNumber() + ".");
        } catch (CustomerOperationFailedException ex) {
            System.out.println("   ERROR: Could not reach the database. Please try again later.");
        }
    }

    /**
     * Demonstrates database failure handling.
     */
    private void findCustomerDatabaseFailureStep() {
        System.out.println("Finding customer causing database failure:");
        try {
            controller.findCustomer("99999");
        } catch (CustomerNotFoundException ex) {
            System.out.println("   ERROR: No customer found with phone number "
                    + ex.getPhoneNumber() + ".");
        } catch (CustomerOperationFailedException ex) {
            System.out.println("   ERROR: Could not reach the database. Please try again later.");
        }
    }

    /**
     * Creates a repair order.
     */
    private void createRepairOrderStep() {
        System.out.println("2. Create repair order");
        controller.createRepairOrder("Battery dead", "01234", 12345);
        System.out.println("   Repair order created.");
    }

    /**
     * Gets and prints all repair orders.
     */
    private void findAllRepairOrdersStep() {
        System.out.println("3. Find all repair orders");
        List<RepairOrderDTO> orders = controller.findAllRepairOrders();
        for (RepairOrderDTO order : orders) {
            System.out.println(
                    "   ID: " + order.id
                    + ", Date: " + order.date
                    + ", Problem: " + order.problemDesc
                    + ", State: " + order.state);
        }
    }

    /**
     * Adds a diagnostic result.
     */
    private void addDiagnosticResultStep() {
        System.out.println("4. Add diagnostic result");
        controller.addDiagnosticResult(1, "Replace dead battery");
        System.out.println("   Diagnostic result added.");
    }

    /**
     * Adds a repair task.
     */
    private void addRepairTaskStep() {
        System.out.println("5. Add repair task");
        controller.addRepairTask(1, "Replace battery", 100.0);
        System.out.println("   Repair task added.");
        controller.addRepairTask(1, "Test ride bike", 250.0);
        System.out.println("   Repair task added.");
        controller.addRepairTask(1, "Clean bike", 50.0);
        System.out.println("   Repair task added.");
        System.out.println("  All repair task added.");
    }
    private void calculateTotalPriceStep(){
        System.out.println("6. Calculate proposed price");
        double totalPrice = controller.calculateRepairOrderPrice(1);
        System.out.println("   Proposed price: " + totalPrice);
    }

    /**
     * Accepts a repair order.
     */
    private void acceptRepairOrderStep() {
        System.out.println("7. Accept repair order\n");
        controller.acceptRepairOrder(1);
        System.out.println("   Repair order accepted.");
    }
}