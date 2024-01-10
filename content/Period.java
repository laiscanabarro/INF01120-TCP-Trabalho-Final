package content;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Period {
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public Period(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime){
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Period (LocalDate start, LocalDate end){
        this.startDate = start;
        this.endDate = end;
        this.startTime = LocalTime.of(0, 0, 0);
        this.endTime = LocalTime.of(0, 0, 0);
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

    public void setStartDate(LocalDate date){
        this.startDate = date;
    }

    public void setEndDate(LocalDate date){
        this.endDate = date;
    }

    public void setStartTime(LocalTime time){
        this.startTime = time;
    }

    public void setEndTime(LocalTime time){
        this.endTime = time;
    }

    public long countDays(){
        return ChronoUnit.DAYS.between(this.startDate, this.endDate);
    }
}