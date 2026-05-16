package se.kth.iv1350.repairelectricbike.model.discount;

public class NoDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscount(DiscountContext context) {
        return 0;
    }

}
