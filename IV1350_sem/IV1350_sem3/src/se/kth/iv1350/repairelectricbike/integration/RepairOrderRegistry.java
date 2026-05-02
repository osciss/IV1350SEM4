package se.kth.iv1350.repairelectricbike.integration;

import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.dto.RepairOrderDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulates storage of repair orders.
 */
public class RepairOrderRegistry {

    private List<RepairOrder> repairOrders = new ArrayList<>();

    /**
     * Creates an empty registry.
     */
    public RepairOrderRegistry() {
    }

    /**
     * Stores a repair order.
     */
    public void createRepairOrder(RepairOrder repairOrder) {
        repairOrders.add(repairOrder);
    }

    /**
     * Updates a repair order.
     * Not really needed since objects are updated by reference.
     */
    public void updateRepairOrder(RepairOrder repairOrder) {
        for (int i = 0; i < repairOrders.size(); i++) {
            if (repairOrders.get(i).getId() == repairOrder.getId()) {
                repairOrders.set(i, repairOrder);
                return;
            }
        }
    }

    /**
     * Returns all repair orders as DTOs.
     */
    public List<RepairOrderDTO> findAllRepairOrders() {
        List<RepairOrderDTO> result = new ArrayList<>();

        for (RepairOrder order : repairOrders) {
            result.add(new RepairOrderDTO(
                    order.getId(),
                    order.getProblemDesc(),
                    order.getState()
            ));
        }
        return result;
    }
}