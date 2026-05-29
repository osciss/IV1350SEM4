package se.kth.iv1350.repairelectricbike.model.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * Immutable update data for observers interested in repair order changes.
 */
public record RepairOrderUpdateDTO(
        int id,
        LocalDate date,
        String problemDesc,
        String state,
        List<String> repairTasks,
        List<String> diagnosticResults) {

    /**
     * Creates an immutable snapshot of a repair order update.
     *
     * @param id The repair order identifier.
     * @param date The creation date of the repair order.
     * @param problemDesc The problem description.
     * @param state The current state of the repair order.
     * @param repairTasks A snapshot of the repair tasks.
     * @param diagnosticResults A snapshot of the diagnostic results.
     */
    public RepairOrderUpdateDTO {
        repairTasks = List.copyOf(repairTasks);
        diagnosticResults = List.copyOf(diagnosticResults);
    }

    /**
     * Returns a formatted string suitable for observer output.
     *
     * @return A formatted string with repair order update details.
     */
    @Override
    public String toString() {
        return "Repair Order ID: " + id + "\n"
                + "Date: " + date + "\n"
                + "Problem: " + problemDesc + "\n"
                + "State: " + state + "\n"
                + "Repair Tasks: " + repairTasks + "\n"
                + "Diagnostic Results: " + diagnosticResults;
    }
}
