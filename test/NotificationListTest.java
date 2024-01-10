package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import content.*;

public class NotificationListTest {
    Notification notification1;
    Notification notification2;
    NotificationList list;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating NotificationList tests");
    }

    @BeforeEach
    public void init(){
        notification1 = new Notification("Alarm");
        notification2 = new Notification("Invitation");
        list = new NotificationList();
    }

    @Test
    public void addNotification(){
        list.addNotification(notification1);
        ArrayList<Notification> notifications = list.getNotifications();
        list.addNotification(notification2);
        assertEquals(notifications, list.getNotifications());
    }

    @Test 
    public void removeNotification(){
        list.addNotification(notification2);
        ArrayList<Notification> notifications = list.getNotifications();
        list.removeNotification(notification2);
        assertEquals(notifications, list.getNotifications());
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing NotificationList testes");
    }
}