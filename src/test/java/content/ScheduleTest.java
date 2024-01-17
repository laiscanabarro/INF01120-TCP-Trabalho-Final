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

    @BeforeAll
    public static void start(){
        System.out.println("Initiating Schedule tests");
    }

    @BeforeEach
    public void init(){
        date = LocalDate.now();
        event = new Event("test", date);
        schedule = new Schedule(date);
    }
    
    @Test
    public void addTask(){
        
    }
    
    @Test
    public void removeTask(){
        
    }
    
    @Test
    public void searchTask(){
        
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
        boolean eventFinded = schedule.searchEvent(event); 
        assertEquals(true, eventFinded);
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Schedule testes");
    }
}