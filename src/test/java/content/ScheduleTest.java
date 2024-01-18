package content;

import org.junit.jupiter.api.*;
import utils.Period;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ScheduleTest {
    LocalDate date;
    Period period;
    Event event;
    Schedule schedule;
    Task task;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating Schedule tests");
    }

    @BeforeEach
    public void init(){
        date = LocalDate.now();
        event = new Event("test", date);
        schedule = new Schedule(date);
        task = new Task();
    }
    
    @Test
    public void addTask(){
        int beforeTaskSize = schedule.getTasks().size();
        schedule.addTask(task);
        assertNotEquals(beforeTaskSize, schedule.getTasks().size());
    }
    
    @Test
    public void removeTask(){
        schedule.addTask(task);
        int beforeTaskSize = schedule.getTasks().size();
        schedule.removeTask(task);
        assertNotEquals(beforeTaskSize, schedule.getTasks().size());
    }
    
    @Test
    public void searchTask(){
        schedule.addTask(task);
        boolean taskFound = schedule.searchTask(task); 
        assertEquals(true, taskFound);
    }

    @Test 
    public void addEvent(){
        int beforeEventSize = schedule.getEvents().size();
        schedule.addEvent(event);
        assertNotEquals(beforeEventSize, schedule.getEvents().size());
    }

    @Test
    public void removeEvent(){
        schedule.addEvent(event);
        int beforeEventSize = schedule.getEvents().size();
        schedule.removeEvent(event);
        assertNotEquals(beforeEventSize, schedule.getEvents().size());
    }

    @Test
    public void searchEvent(){
        schedule.addEvent(event);
        boolean eventFound = schedule.searchEvent(event); 
        assertEquals(true, eventFound);
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Schedule testes");
    }
}