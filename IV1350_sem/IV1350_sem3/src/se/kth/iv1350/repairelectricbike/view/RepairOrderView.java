package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderUpdateDTO;

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
     * @param repairOrderUpdate Immutable data for the updated repair order.
     */
    @Override
    public void repairOrderUpdated(RepairOrderUpdateDTO repairOrderUpdate) {
        System.out.println("=== Repair Order Updated ===");
        System.out.println(repairOrderUpdate);
        System.out.println("============================");
    }
}
