package se.kth.iv1350.repairelectricbike.model.discount;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NoDiscountTest {
    
    @Test
    void shouldReturnZeroDiscount() {
        DiscountContext context = new DiscountContext(1000, 2);
        DiscountStrategy discount = new NoDiscount();
        double discountAmount = discount.calculateDiscount(context);
        assertEquals(0, discountAmount, "NoDiscount should always return zero discount.");
    }


}
