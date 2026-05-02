package se.kth.iv1350.repairelectricbike.integration;

import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderDTO;

import java.util.ArrayList;
import java.util.List;

//Ännu en gång, @params och @returns kommentarer behövs i alla publika metoder teehee
/**
 * Simulates storage of repair orders.
 */
public class RepairOrderRegistry {

    private List<RepairOrder> repairOrders = new ArrayList<>();

    /** 
     * Creates a new instance of RepairOrderRegistry.
     */
    public RepairOrderRegistry() {
    }

    /**
     * Stores a repair order.
     * @param repairOrder
     */
    public void createRepairOrder(RepairOrder repairOrder) {
        repairOrders.add(repairOrder);
    }

    /**
     * Updates a repair order.
     * @param repairOrder
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
     * Finds a repair order by its ID.
     * @param id
     * @return
     */
    public RepairOrder findRepairOrder(int id){
        for(RepairOrder order : repairOrders){
            if(order.getId() == id){
                return order;
            }
        }
        return null;
    }

    /**
     * Returns all repair orders as DTOs.
     * @return List of RepairOrderDTOs
     */
    public List<RepairOrderDTO> findAllRepairOrders() {
        List<RepairOrderDTO> result = new ArrayList<>();

        for (RepairOrder order : repairOrders) {
            result.add(new RepairOrderDTO(
                    order.getId(),
                    order.getDate(), //date saknas i RepairOrder, behöver läggas till
                    order.getProblemDesc(),
                    order.getState()
            ));
        }
        return result;
    }
}