package se.kth.iv1350.repairelectricbike.model.discount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class NewCustomerDiscountTest {
    @Test
    void shouldReturn50PercentDiscountForNewCustomer() {
        DiscountContext context = new DiscountContext(1000, 0);
        DiscountStrategy discount = new NewCustomerDiscount();
        double discountAmount = discount.calculateDiscount(context);
        assertEquals(500, discountAmount, "NewCustomerDiscount should return 50% of total price for new customers.");
    }
    

}
