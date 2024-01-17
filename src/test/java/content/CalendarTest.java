package content;

import org.junit.jupiter.api.*;
import utils.Period;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarTest {
    LocalDate date;
    Period period;
    Event event1;
    Event event2;
    Schedule schedule;
    Calendar calender;
    ArrayList<TaskList> taskLists;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating Calender tests");
    }

    @BeforeEach
    public void init(){
        date = LocalDate.now();
        event1 = new Event("class", date);
        event2 = new Event("test", date);
        schedule = new Schedule(date);
        taskLists = new ArrayList<>();
        calender = new Calendar(taskLists);
    }

    @Test
    public void addEvent(){
        int beforeEventSize = calender.getEvents().size();
        calender.addEvent(event1);
        assertNotEquals(beforeEventSize, calender.getEvents().size());
    }

    @Test 
    public void removeEvent(){
        calender.addEvent(event1);
        int beforeEventSize = calender.getEvents().size();
        calender.removeEvent(event1);
        assertNotEquals(beforeEventSize, calender.getEvents().size());
    }
    
    @Test
    public void addSchecule(){
        
    }
    
    @Test
    public void addTask(){
        
    }
    
    @Test
    public void removeTask(){
        
    }
    
    @Test
    public void searchSchedule(){
        
    }
    
    @Test
    public void displayMonthYear(){
        
    }
    
    @Test
    public void searchEvent(){
        
    }
    
    @Test
    public void searchTask(){
        
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Calender testes");
    }
}