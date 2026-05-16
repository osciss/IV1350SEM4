package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

/**
 * An observer that prints the contents of a repair order to
 * {@link System#out} whenever it is updated. This view informs
 * technicians and receptionists about updates to repair orders
 * without them having to ask the system for them.
 */
public class RepairOrderView implements RepairOrderObserver {

    /**
     * Creates a new instance.
     */
    public RepairOrderView() {
    }

    /**
     * Called whenever a repair order is updated. Prints the updated
     * repair order to {@link System#out}.
     *
     * @param repairOrder The repair order that was updated.
     */
    @Override
    public void repairOrderUpdated(RepairOrder repairOrder) {
        System.out.println("=== Repair Order Updated ===");
        System.out.println(repairOrder);
        System.out.println("============================");
    }
}