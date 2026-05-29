package se.kth.iv1350.repairelectricbike.model;

import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderUpdateDTO;

/**
 * A listener interface for receiving notifications about updated repair orders.
 * The class that is interested in such notifications implements this interface,
 * and the object created with that class is registered with
 * {@link RepairOrder#addObserver(RepairOrderObserver)}.
 * When a repair order is updated, that object's
 * {@link #repairOrderUpdated(RepairOrderUpdateDTO)} method is invoked.
 */
public interface RepairOrderObserver {

    /**
     * Invoked when a repair order has been updated in any way.
     *
     * @param repairOrderUpdate Immutable data describing the updated repair order.
     */
    void repairOrderUpdated(RepairOrderUpdateDTO repairOrderUpdate);
}
