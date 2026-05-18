package se.kth.iv1350.repairelectricbike.model;

/**
 * Template method base class for repair order observers.
 * Concrete observers should implement the two abstract hooks
 * `doHandleRepairOrderUpdate` and `handleErrors`.
 */
public abstract class AbstractRepairOrderObserver implements RepairOrderObserver {

	@Override
	public final void repairOrderUpdated(RepairOrder repairOrder) {
		handleRepairOrderUpdate(repairOrder);
	}

	private void handleRepairOrderUpdate(RepairOrder repairOrder) {
		try {
			doHandleRepairOrderUpdate(repairOrder);
		} catch (Exception ex) {
			handleErrors(ex, repairOrder);
		}
	}

	protected abstract void doHandleRepairOrderUpdate(RepairOrder repairOrder);

	protected abstract void handleErrors(Exception ex, RepairOrder repairOrder);
}
