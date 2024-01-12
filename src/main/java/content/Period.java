package content;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

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
    
    public Period (LocalDate date){
        this.startDate = date;
        this.endDate = date;
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
    
    public String displayPeriod(){
        String periodString;
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        
        if (startDate.equals(endDate)){
             periodString = startDate.format(formatterDate);
        }
        else if (startTime.equals(LocalTime.of(0, 0, 0))) {
            periodString = startDate.format(formatterDate) + endDate.format(formatterDate);
        }
        else {
            periodString = 
                    startDate.format(formatterDate) + endDate.format(formatterDate)
                    + startTime.format(formatterTime) + endTime.format(formatterTime);
        }
    
        return periodString;
    }
}