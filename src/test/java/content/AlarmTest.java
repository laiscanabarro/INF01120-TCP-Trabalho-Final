package content;

import org.junit.jupiter.api.*;

import user.User;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class AlarmTest {
    Alarm alarmCurrent;
    Alarm alarmFuture;
    LocalDate testDate;
    LocalDate futureDate;
    Alarm alarm;
    User user;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating Alarm tests");
    }

    @BeforeEach
    public void init(){
        testDate = LocalDate.now();
        futureDate = LocalDate.of(2024, 12, 13);
        alarmCurrent = new Alarm(testDate, "Today");
        alarmFuture = new Alarm(futureDate, "Future");
        alarm = new Alarm(testDate, "test");
        user = new User();
    }

    @Test
    public void compareDate(){
        int beforeNotification = user.getNotifications().getNotifications().size();
        alarm.compareDate(user);
        assertNotEquals(beforeNotification, user.getNotifications().getNotifications().size());
        alarmCurrent.compareDate(user);
        alarmFuture.compareDate(user);
        // only the notification for alarmCurrent gets added
        assertEquals(2, user.getNotifications().getNotifications().size());
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Alarm tests");
    }
}
