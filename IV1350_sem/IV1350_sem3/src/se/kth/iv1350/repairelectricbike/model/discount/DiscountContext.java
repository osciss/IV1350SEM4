package se.kth.iv1350.repairelectricbike.model.discount;

public class DiscountContext {
    private final double totalPrice;
    private final int nrOfPrevOrders;

    public DiscountContext(double totalPrice, int nrOfPrevOrders) {
        this.totalPrice = totalPrice;
        this.nrOfPrevOrders = nrOfPrevOrders;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getNrOfPrevOrders() {
        return nrOfPrevOrders;
    }


}
