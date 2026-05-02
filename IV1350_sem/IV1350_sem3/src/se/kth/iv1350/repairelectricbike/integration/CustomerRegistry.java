package se.kth.iv1350.repairelectricbike.integration;
import java.util.ArrayList;
import se.kth.iv1350.repairelectricbike.model.Customer;

public class CustomerRegistry {
    private ArrayList<Customer> customers;
    // Constructor for the CustomerRegistry class.
    // Initializes the customer registry with some sample customers.
    public CustomerRegistry(){
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Oscar", "0701234567"));
        customers.add(new Customer(2, "Aleena", "0707654321"));
        customers.add(new Customer(3, "Emilia", "0709876543"));
    }
    // Method to find a customer by their phone number.
    public Customer findCustomer(String phoneNumber){
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null; // Return null if no customer is found with the given phone number.
    }
    
}
