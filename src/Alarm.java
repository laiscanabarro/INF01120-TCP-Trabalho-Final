package src;

import java.util.Date;

public class Alarm {
    private Date date;
    Notification notification;

    public Alarm(Date time, Notification notification){
        this.date = time;
        this.notification = notification;
    }

    public Date getDate(){
        return this.date;
    }

    public Notification getNotification(){
        return this.notification;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setNotification(Notification notification){
        this.notification = notification;
    }

    public void compareDate(){
        Date currentDate = new Date();
        
        if (currentDate.compareTo(this.date) == 0){
            NotificationList.addNotification(this.notification);
        }
    }
}