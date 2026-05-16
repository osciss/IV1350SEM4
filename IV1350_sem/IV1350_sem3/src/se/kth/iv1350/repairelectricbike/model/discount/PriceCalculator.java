package se.kth.iv1350.repairelectricbike.model.discount;

public class PriceCalculator {
     private final DiscountStrategy strategy;
    
    

    // The `public PriceCalculator(DiscountStrategy chosenStrategy)` constructor in the
    // `PriceCalculator` class is initializing the `strategy` field with the `chosenStrategy` parameter
    // that is passed to the constructor. This means that when an instance of `PriceCalculator` is
    // created, it will be associated with a specific `DiscountStrategy` implementation that will be
    // used for calculating discounts.
    public PriceCalculator(DiscountStrategy chosenStrategy){
        this.strategy  = chosenStrategy;
    }
    
    /**
     * The function calculates the discounted price by subtracting the discount amount from the total
     * price.
     * 
     * @param context The `context` parameter in the `calculateDiscountedPrice` contains
     * information related to the total price and nr of orders.
     * @return The final price after discount.
     */
    public double calculateDiscountedPrice(DiscountContext context){
        double discountAmount = strategy.calculateDiscount(context);
        double finalPrice = context.getTotalPrice() - discountAmount;
        return finalPrice;
    }



}
