package content;

import java.time.LocalDate;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import user.User;

public class AlarmTest {
    LocalDate date;
    Alarm alarm;
    User user;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating Alarm tests");
    }

    @BeforeEach
    public void init(){
        date = LocalDate.now();
        alarm = new Alarm(date, "test");
        user = new User();
    }

    @Test
    public void compareDate(){
        int beforeNotification = user.getNotifications().getNotifications().size();
        alarm.compareDate(user);
        assertNotEquals(beforeNotification, user.getNotifications().getNotifications().size());
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Alarm testes");
    }
}
