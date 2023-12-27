package src;

import java.util.Date;
import java.util.ArrayList;

public class NotificationList {
    private static ArrayList<Notification> notifications;

    public ArrayList<Notification> getNotifications(){
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications){
        NotificationList.notifications = notifications;
    }

    public static void addNotification(Notification notification){
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
        Date date = notification.getDate();
        
        System.out.printf(name + date.getTime());
    }

    //public selectNotification(Notification notification){}

}