package content;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class NotificationList {
    private ArrayList<Notification> notifications = new ArrayList<>();

    public ArrayList<Notification> getNotifications(){
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications){
        this.notifications = notifications;
    }

    public void addNotification(Notification notification){
        notifications.add(notification);
        displayNotification(notification);        
    }

    public void removeNotification(Notification notification){
        notifications.remove(notification);
    }

    public void clear(){
        notifications.clear();
    }

    private static void displayNotification(Notification notification){
        String name = notification.getName();
        LocalDate date = notification.getDate();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDate = date.format(formatter);
        System.out.printf("%s %s%n", name, formattedDate);
    }

    //public selectNotification(Notification notification){}

}