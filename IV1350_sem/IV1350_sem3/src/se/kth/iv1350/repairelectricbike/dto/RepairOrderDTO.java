package se.kth.iv1350.repairelectricbike.dto;
import java.time.LocalDate;


public class RepairOrderDTO {
    public final int id;
    public final LocalDate date;
    public final String problemDesc;
    public final String state;

    public RepairOrderDTO(int id, String problemDesc,LocalDate date, String state) {
        this.id = id;
        this.date = date;
        this.problemDesc = problemDesc;
        this.state = state;
    }
}