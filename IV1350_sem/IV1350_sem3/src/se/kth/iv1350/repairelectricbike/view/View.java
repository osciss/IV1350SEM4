package se.kth.iv1350.repairelectricbike.view;

import java.util.List;

import se.kth.iv1350.repairelectricbike.controller.Controller;
import se.kth.iv1350.repairelectricbike.model.dto.CustomerDTO;
import se.kth.iv1350.repairelectricbike.model.dto.RepairOrderDTO;

public class View {
    private final Controller controller;

    public View(Controller controller){
        this.controller = controller;
    }

    public void run(){
        findCustomerStep();
        createRepairOrderStep();
        findAllRepairOrdersStep();
        addDiagnosticResultStep();  
        addRepairTaskStep();    
        acceptRepairOrderStep();
    }

    private void findCustomerStep(){
        System.out.println(" Find customer ");
        CustomerDTO customer = controller.findCustomer("0701234567");
        if(customer != null){
            System.out.println("Customer found: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void createRepairOrderStep(){
        System.out.println(" Create repair order ");
        controller.createRepairOrder("Battery ded", "0701234567", 12345);
        System.out.println("Repair order created.");}

    private void findAllRepairOrdersStep(){
        System.out.println(" Find all repair orders ");
        List<RepairOrderDTO> orders = controller.findAllRepairOrders();
        for(RepairOrderDTO order : orders){
            System.out.println("ID: " + order.id + ", Date: " + order.date + ", Problem: " + order.problemDesc + ", State: " + order.state);
        }
    }

    private void addDiagnosticResultStep(){
        System.out.println(" Add diagnostic result ");
        controller.addDiagnosticResult(1, "Replace ded battery");
        System.out.println("Diagnostic result added.");
    }

    private void addRepairTaskStep(){
        System.out.println(" Add repair task ");
        controller.addRepairTask(1, "Replace battery");
        System.out.println("Repair task added.");
    }

    private void acceptRepairOrderStep(){
        System.out.println(" Accept repair order ");
        controller.acceptRepairOrder(1);
        System.out.println("Repair order accepted.");
    }
    
}
