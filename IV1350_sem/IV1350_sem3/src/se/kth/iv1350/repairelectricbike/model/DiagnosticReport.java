import java.util.Date;

public class DiagnosticReport {
    private Date date;
    private String taskResult;
    private int repairOrderId;

    public DiagnosticReport(String taskResult, int repairOrderId) {
        this.date = new Date(); // Sätter aktuellt datum vid skapandet
        this.taskResult = taskResult;
        this.repairOrderId = repairOrderId;}

    public String getTaskResult() {
        return taskResult;}


    public Date getDate() {
        return date;}

    public int getRepairOrderId() {
        return repairOrderId;}
}