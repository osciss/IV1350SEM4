package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.model.AbstractRepairOrderObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * An observer that logs the contents of a repair order to a file
 * whenever it is updated.
 */
public class RepairOrderLogger extends AbstractRepairOrderObserver {

    private static final String LOG_FILE = "repair-order-log.txt";
    private PrintWriter logStream;

    /**
     * Creates a new instance and opens the log file for writing.
     * An existing log file will be appended to.
     */
    public RepairOrderLogger() {
        try {
            logStream = new PrintWriter(new FileWriter(LOG_FILE, true), true);
        } catch (IOException ex) {
            System.err.println("WARNING: Could not open repair order log file: " + ex.getMessage());
        }
    }

    @Override
    protected void doHandleRepairOrderUpdate(RepairOrder repairOrder) {
        if (logStream != null) {
            logStream.println("[" + LocalDateTime.now() + "] Repair order updated:");
            logStream.println(repairOrder);
            logStream.println();
        }
    }

    @Override
    protected void handleErrors(Exception ex, RepairOrder repairOrder) {
        if (logStream != null) {
            logStream.println("[" + LocalDateTime.now() + "] WARNING: Could not log repair order update: " + ex.getMessage());
        } else {
            System.err.println("WARNING: Could not log repair order update: " + ex.getMessage());
        }
        ex.printStackTrace(System.err);
    }
}