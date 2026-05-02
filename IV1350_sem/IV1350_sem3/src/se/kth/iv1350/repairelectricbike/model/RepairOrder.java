package se.kth.iv1350.repairelectricbike.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepairOrder {
    private int orderID;
    private LocalDate date;
    private String problemDescr;
    private String state;

    private List<String> repairTasks = new ArrayList<>();
    private List<String> diagnosticResults = new ArrayList<>();

    // Constructor
    public RepairOrder(int orderID, String problemDescr) {
        this.orderID = orderID;
        this.date = LocalDate.now();
        this.problemDescr = problemDescr;
        this.state = "NEWLY CREATED";
    }

    public void setState(String state) {
        this.state = state;
    }

    public void addDiagnosticResult(int id, String result) {
        diagnosticResults.add("ID: " + id + " - " + result);
    }

    public void addRepairTask(String task) {
        repairTasks.add(task);
    }

    public int getId() {
        return orderID;
    }

    public String getProblemDesc() {
        return problemDescr;
    }

    public String getState() {
        return state;
    }
}