import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Alarm {
    private int time;
    private boolean minutes;
    private boolean hours;
    private boolean days;
    private boolean weeks;

    public Alarm(){
        this.time = 0;
        this.minutes = false;
        this.hours = false;
        this.days = false;
        this.weeks = false;
    }

    public int getTime(){
        return this.time;
    }

    public boolean getMinutes(){
        return this.minutes;
    }

    public boolean getHours(){
        return this.hours;
    }

    public boolean getDays(){
        return this.days;
    }

    public boolean getWeeks(){
        return this.weeks;
    }

    public void setTime(int value){
        this.time = value;
    }

    public void setMinutes(boolean value){
        this.minutes = value;
    }

    public void setHours(boolean value){
        this.hours = value;
    }

    public void setDays(boolean value){
        this.days = value;
    }

    public void setWeeks(boolean value){
        this.weeks = value;
    }

    private LocalTime minutesToLocalTime(int minutes) {
        Duration duration = Duration.ofMinutes(minutes);
        LocalTime localTime = LocalTime.MIDNIGHT.plus(duration);

        return localTime;
    }

    public LocalTime calculeTime(){
        int minute = 0;
        if (minutes == true){
            minute = 1;
        }
        else if (hours == true){
            minute = 60;
        }
        else if (days == true){
            minute = 1440;
        }
        else if (weeks = true){
            minute = 10080;
        }

        int minutesTotal = (this.time)*minute;

        return minutesToLocalTime(minutesTotal);
    }

    //private LocalDateTime subtracTime(LocalTime deadlineTime, LocalDate deadlineDate, LocalTime alarm) {}

    //public void startTimer(LocalTime deadline, LocalTime alarm) {}
}