package content;

import org.junit.jupiter.api.*;

import utils.Recurrence;
import utils.Recurrence.RecurrenceType;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class RecurrenceTest {
    Recurrence recurrence;
    ArrayList<TaskList> taskLists;
    Calendar calendar;
    LocalDate date;
    Event event;
    
    @BeforeAll
    public static void start(){
        System.out.println("Initiating Recurrence tests");
    }
    
    @BeforeEach
    public void init(){
        recurrence = new Recurrence();
        taskLists = new ArrayList<>();
        calendar = new Calendar(taskLists);
        date = LocalDate.of(2024, 1, 1);
        event = new Event("test", date);
    }
    
    @Test
    public void getRecurrenceType(){
        recurrence.setWeekly(true);
        RecurrenceType type = recurrence.getRecurrenceType();
        assertEquals(type, RecurrenceType.WEEKLY);
    }
    
    @Test
    public void verifyRecurrence(){
        recurrence.setAnnually(true);
        boolean value = recurrence.verifyRecurrence();
        assertEquals(value, true);

        recurrence.setAnnually(false);
        value = recurrence.verifyRecurrence();
        assertEquals(value, false);
    }
    
    @Test
    public void toStringTest(){
        recurrence.setMonthly(true);
        String type = recurrence.toString();
        assertEquals(type, "Monthly");
    }
    
    @Test
    public void changeRecurrence(){
        recurrence.setAnnually(true);
        RecurrenceType type = RecurrenceType.DAILY;
        recurrence.changeRecurrence(type, calendar, event);
        assertEquals(recurrence.getAnnualy(), false);
        assertEquals(recurrence.getDaily(),  true);
    }
    
    @Test
    public void clear(){
        recurrence.setDaily(true);
        recurrence.setWeekday(true);
        recurrence.clear(calendar, event);
        assertEquals(recurrence.getDaily(), false);
        assertEquals(recurrence.getWeekday(), false);
        assertEquals(recurrence.verifyRecurrence(), false);
    }
    
    @AfterAll
    public static void close(){
        System.out.println("Finalizing Recurrence testes");
    }
    
}
