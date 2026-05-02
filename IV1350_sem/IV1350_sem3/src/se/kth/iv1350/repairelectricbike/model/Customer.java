package se.kth.iv1350.repairelectricbike.model;

public class Customer {
    private int customerID;
    private String name;
    private String phoneNumber;

    // Constructor for the Customer class.
    public Customer(int customerID, String name, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    // Getters for the Customer class.
    public int getCustomerID() {
        return customerID;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
