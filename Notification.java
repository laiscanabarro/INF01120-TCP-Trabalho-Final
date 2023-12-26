import java.time.LocalDateTime;

public class Notification {
    Alarm alarm;
    Invitation invitation;
    LocalDateTime time;

    public Notification(Alarm alarm){
        this.alarm = alarm;
        //this.time = alarm.;
    }

    public Notification(Invitation invitation){
        this.invitation = invitation;
        this.time = LocalDateTime.now();
    }
    
    public Alarm getAlarm(){
        return this.alarm;
    }

    public Invitation geInvitation(){
        return this.invitation;
    }

    public LocalDateTime getTime(){
        return time;
    }

}