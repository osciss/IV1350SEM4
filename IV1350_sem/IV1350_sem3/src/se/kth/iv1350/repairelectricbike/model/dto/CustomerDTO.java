package se.kth.iv1350.repairelectricbike.model.dto;

/**
 * Contains customer information and is used to transfer data between the layers.
 */
public class CustomerDTO {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String bikeBrand;
    private final String bikeSerialNo;
    private final String bikeModel;

/**
 * Creates a new CustomerDTO.
 *
 * @param name The customer's name.
 * @param email The customer's email.
 * @param bikeBrand The bike's brand.
 * @param bikeSerialNo The bike's serial number.
 * @param bikeModel The bike's model.
 */
    public CustomerDTO(String name, String email, String phoneNumber, String bikeBrand, String bikeSerialNo, String bikeModel) {
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