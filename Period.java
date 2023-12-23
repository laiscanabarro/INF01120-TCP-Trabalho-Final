import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Period {
    LocalDate startDate;
    LocalDate endDate;
    LocalTime startTime;
    LocalTime endTime;

    public Period (LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime){
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getStartDate(){
        return this.startDate;
    }

    public LocalDate getEndDate(){
        return this.endDate;
    }

    public LocalTime getStartTime(){
        return this.startTime;
    }

    public LocalTime getEndTime(){
        return this.endTime;
    }

    public void setStartDate(LocalDate start){
        this.startDate = start;
    }

    public void setEndDate(LocalDate end){
        this.endDate = end;
    }

    public void setStartTime(LocalTime start){
        this.startTime = start;
    }

    public void setEndTime(LocalTime end){
        this.endTime = end;
    }

    public long countDays(LocalDate startDate, LocalDate endDate){
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
}