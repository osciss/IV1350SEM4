package se.kth.iv1350.repairelectricbike.model.discount;

public class NewCustomerDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscount(DiscountContext context) {
        return context.getTotalPrice() * 0.50; // 5% discount for new customers
    }


}
