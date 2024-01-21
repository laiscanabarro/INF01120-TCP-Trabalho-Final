package content;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NotificationListTest {
    Notification notification1;
    Notification notification2;
    NotificationList list;
    LocalDate date;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating NotificationList tests");
    }

    @BeforeEach
    public void init(){
        notification1 = new Notification("Alarm");
        notification2 = new Notification("Invitation");
        list = new NotificationList();
        date = date.now();
    }

    @Test
    public void addNotification(){
        list.addNotification(notification1);
        int beforeAdd = list.getNotifications().size();
        list.addNotification(notification2);
        assertNotEquals(beforeAdd, list.getNotifications().size());
    }

    @Test 
    public void removeNotification(){
        list.addNotification(notification2);
        int beforeRemove = list.getNotifications().size();
        list.removeNotification(notification2);
        assertNotEquals(beforeRemove, list.getNotifications().size());
    }

    @Test
    public void displayNotification(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDate = date.format(formatter);
        String notificationString = list.displayNotification(notification1);
        String string = "Alarm " + formattedDate;
        assertEquals(notificationString, string);
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing NotificationList testes");
    }
}