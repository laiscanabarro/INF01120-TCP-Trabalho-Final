package src;
import java.time.LocalDate;
import java.time.LocalTime;


//usando só pra testar o alarme
public class Deadline {
    private LocalDate date;
    private LocalTime time;

    public Deadline(LocalDate date, LocalTime time){
        this.date = date;
        this.time = time;
    }

    public Deadline(LocalDate date){
        this.date = date;
        this.time = currentTime();
    }

    public LocalDate getDate(){
        return this.date;
    }
    public LocalTime getTime(){
        return this.time;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setTime(LocalTime time){
        this.time = time;
    }

    private static LocalTime currentTime(){
        // Get current time
        LocalTime currentTime = LocalTime.now();

        LocalTime hourMinute = LocalTime.of(currentTime.getHour(), currentTime.getMinute());

        return hourMinute;    
    }
}