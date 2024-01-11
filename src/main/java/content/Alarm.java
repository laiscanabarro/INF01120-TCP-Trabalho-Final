package content;

import java.time.LocalDate;
import user.User;

public class Alarm {
    private LocalDate date;
    private String name;
    private Notification notification;

    public Alarm(LocalDate date, String name){
        this.date = date;
        this.name = name;
        this.notification = new Notification(name, date);
    }

    public LocalDate getDate(){
        return this.date;
    }

    public String getName(){
        return this.name;
    }

    public Notification getNotification(){
        return this.notification;
    }

    public void setDate(LocalDate date){
        this.date = date;
        this.notification.setDate(date);
    }

    public void setName(String name){
        this.name = name;
        this.notification.setName(name);
    }

    public void setNotification(Notification notification){
        this.notification = notification;
        this.date = notification.getDate();
        this.name = notification.getName();
    }

    /*
    public void compareDate(User user){
        LocalDate currentDate = LocalDate.now();
        
        if (currentDate.compareTo(this.date) == 0){
            user.getNotificationList().addNotification(this.notification);
        }
    }
     */

}