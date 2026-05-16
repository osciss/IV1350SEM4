package se.kth.iv1350.repairelectricbike.model.discount;

public class DiscountFactory {
    
    
    public DiscountFactory() {
        
    }
    /**
     * The function `selectDiscount` returns a specific discount strategy based on the number of
     * previous orders in the given context.
     * 
     * @param context The `DiscountContext` object contains information about the customer's previous
     * orders, such as the number of previous orders (`nrOfPrevOrders`). Based on this information, the
     * `selectDiscount` method determines which discount strategy to apply for the current order.
     * @return An instance of a discount strategy class is being returned based on the number of
     * previous orders in the given context. If the number of previous orders is 0, a
     * NewCustomerDiscount instance is returned. If the number of previous orders is even, a
     * FrequentCustomerDiscount instance is returned. Otherwise, a NoDiscount instance is returned.
     */
    public DiscountStrategy selectDiscount(DiscountContext context) {
        int currentNrOfOrders = context.getNrOfPrevOrders() + 1;
        if (context.getNrOfPrevOrders() == 0) {
            return new NewCustomerDiscount(); 
        }
        if (currentNrOfOrders % 3 == 0){
            return new FrequentCustomerDiscount();
        }
        return new NoDiscount();

    }
}
