
package se.kth.iv1350.repairelectricbike.integration;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;


/// This class is responsible for creating the customer and repairorder registry and its dependencies.
/**
 * This class is responsible for creating the customer and repair order registry and its dependencies.
 */
public class RegistryCreator {
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;

    /**
     * Creates the registry and its dependencies.
     */
    public RegistryCreator() {
        customerRegistry = new CustomerRegistry();
        repairOrderRegistry = new RepairOrderRegistry();  
    }

    public CustomerRegistry getCustomerRegistry() {
        return customerRegistry;
    }

    public RepairOrderRegistry getRepairOrderRegistry() {
        return repairOrderRegistry;
    }
}