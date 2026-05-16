package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.model.RepairOrder;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * An observer that logs the contents of a repair order to a file
 * whenever it is updated.
 */
public class RepairOrderLogger implements RepairOrderObserver {

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

    /**
     * Called whenever a repair order is updated. Logs the updated
     * repair order to file.
     *
     * @param repairOrder The repair order that was updated.
     */
    @Override
    public void repairOrderUpdated(RepairOrder repairOrder) {
        if (logStream != null) {
            logStream.println("[" + LocalDateTime.now() + "] Repair order updated:");
            logStream.println(repairOrder);
            logStream.println();
        }
    }
}