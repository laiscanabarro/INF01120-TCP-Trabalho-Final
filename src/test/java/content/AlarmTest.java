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
    User testUser;

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
        testUser = new User();
    }

    @Test
    public void compareDate(){
        alarmCurrent.compareDate(testUser);
        alarmFuture.compareDate(testUser);
        // only the notification for alarmCurrent gets added
        assertEquals(1, testUser.getNotifications().getNotifications().size());
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Alarm tests");
    }
}