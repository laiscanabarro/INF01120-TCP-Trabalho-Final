package test;
import java.time.LocalDate;

import content.*;

public class TestNotificationList {
    public static void main(String args[]){

        LocalDate date = LocalDate.now();
        Notification notification = new Notification("Name", date);
        NotificationList notificationList = new NotificationList();
        notificationList.addNotification(notification);
    }
}