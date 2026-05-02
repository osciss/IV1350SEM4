package se.kth.iv1350.repairelectricbike.model;

public class Customer {
    private  String name;
    private  String email;
    private  String phoneNumber;
    private  String bikeBrand;
    private  String bikeSerialNo;
    private  String bikeModel;
/**
 * Creates a new Customer.
 *
 * @param name The customer's name.
 * @param email The customer's email.
 * @param bikeBrand The bike's brand.
 * @param bikeSerialNo The bike's serial number.
 * @param bikeModel The bike's model.
 */
    public Customer(String name, String email, String phoneNumber, String bikeBrand, String bikeSerialNo, String bikeModel) {
        this.name = name;
        this.email = email;
        this.bikeBrand = bikeBrand;
        this.bikeSerialNo = bikeSerialNo;
        this.bikeModel = bikeModel;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }   
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getBikeBrand() {
        return bikeBrand;
    }
    public String getBikeSerialNo() {
        return bikeSerialNo;
    }
    public String getBikeModel() {
        return bikeModel;
    }



}