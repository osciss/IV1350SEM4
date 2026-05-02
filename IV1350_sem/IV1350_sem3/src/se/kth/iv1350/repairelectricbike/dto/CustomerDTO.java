package se.kth.iv1350.repairelectricbike.dto;

/**
 * DTO for customer data.
 */
public class CustomerDTO {
    public final String name;
    public final String email;
    public final String bikeBrand;
    public final String bikeSerialNo;

    public CustomerDTO(String name, String email, String bikeBrand, String bikeSerialNo) {
        this.name = name;
        this.email = email;
        this.bikeBrand = bikeBrand;
        this.bikeSerialNo = bikeSerialNo;
    }
}