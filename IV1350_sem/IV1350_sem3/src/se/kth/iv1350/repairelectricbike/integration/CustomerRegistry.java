package se.kth.iv1350.repairelectricbike.integration;
import java.util.ArrayList;
import se.kth.iv1350.repairelectricbike.model.Customer;
import se.kth.iv1350.repairelectricbike.model.dto.CustomerDTO;

public class CustomerRegistry {
    private ArrayList<Customer> customers;
    // Constructor for the CustomerRegistry class.
    // Initializes the customer registry with some sample customers.
    public CustomerRegistry(){
        customers = new ArrayList<>();
        customers.add(new Customer("Alice", "alice@example.com", "0701234567", "Trek", "SN123456", "Fuel EX"));
        customers.add(new Customer("Bob", "bob@example.com", "0707654321", "Giant", "SN789012", "Trance 2"));
        customers.add(new Customer("Oscar", "oscar@example.com", "0709876543", "Cannondale", "SN345678", "Superior Pro"));
        customers.add(new Customer("Aleena", "aleena@example.com", "0705555555", "Specialized", "SN987654", "Turbo Vado"));
        customers.add(new Customer("Emilia", "emilia@example.com", "0701111111", "Trek", "SN234567", "Fuel EX"));
    }
    /**
     * Finds a customer by phone number.
     *
     * @param phoneNumber The customer's phone number.
     * @return The matching customer, or null if none found.
     */
    public CustomerDTO findCustomer(String phoneNumber){
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                
                return new CustomerDTO(customer.getName(), customer.getEmail(), customer.getPhoneNumber(), customer.getBikeBrand(), customer.getBikeSerialNo(), customer.getBikeModel());
            }
        }
        return null; // Return null if no customer is found with the given phone number.
    }
    
}
