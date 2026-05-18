package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.model.AbstractRepairOrderObserver;

/**
 * An observer that prints the contents of a repair order to
 * {@link System#out} whenever it is updated. This view informs
 * technicians and receptionists about updates to repair orders
 * without them having to ask the system for them.
 */
public class RepairOrderView extends AbstractRepairOrderObserver {

    /**
     * Creates a new instance.
     */
    public RepairOrderView() {
    }



    @Override
    protected void doHandleRepairOrderUpdate(RepairOrder repairOrder) {
        System.out.println("=== Repair Order Updated ===");
        System.out.println(repairOrder);
        System.out.println("============================");
    }

    @Override
    protected void handleErrors(Exception ex, RepairOrder repairOrder) {
        System.err.println("WARNING: Could not display repair order update: " + ex.getMessage());
        ex.printStackTrace(System.err);
    }
}