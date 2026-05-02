package se.kth.iv1350.repairelectricbike.model.dto;

/**
 * Contains customer information and is used to transfer data between the layers.
 */
public class CustomerDTO {
    public final String name;
    public final String email;
    public final String bikeBrand;
    public final String bikeSerialNo;

/**
 * Creates a new CustomerDTO.
 *
 * @param name The customer's name.
 * @param email The customer's email.
 * @param bikeBrand The bike's brand.
 * @param bikeSerialNo The bike's serial number.
 */
    public CustomerDTO(String name, String email, String bikeBrand, String bikeSerialNo) {
        this.name = name;
        this.email = email;
        this.bikeBrand = bikeBrand;
        this.bikeSerialNo = bikeSerialNo;
    }
}