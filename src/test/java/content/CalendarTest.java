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
    Calendar calendar;
    ArrayList<TaskList> taskLists;
    Task task;
    TaskList taskList;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating Calender tests");
    }

    @BeforeEach
    public void init(){
        date = LocalDate.of(2023, 12, 13);
        event1 = new Event("class", date);
        event2 = new Event("test", date);
        schedule = new Schedule(date);
        taskLists = new ArrayList<>();
        calendar = new Calendar(taskLists);
        task = new Task();
        taskList = new TaskList();

    }

    @Test
    public void addEvent(){
        int beforeEventSize = calendar.getEvents().size();
        calendar.addEvent(event1);
        assertNotEquals(beforeEventSize, calendar.getEvents().size());
    }

    @Test 
    public void removeEvent(){
        calendar.addEvent(event1);
        int beforeEventSize = calendar.getEvents().size();
        calendar.removeEvent(event1);
        assertNotEquals(beforeEventSize, calendar.getEvents().size());
    }
    
    @Test
    public void addSchecule(){
        int beforeScheduleSize = calendar.getSchedules().size();
        calendar.addSchecule(schedule);
        assertNotEquals(beforeScheduleSize, calendar.getSchedules().size());
    }
    
    @Test
    public void addTask(){
        taskLists.add(taskList);
        calendar.addSchecule(schedule);
        int beforeTaskSize = calendar.getTasks().size();
        calendar.addTask(task);
        taskList.addTask(task);
        assertNotEquals(beforeTaskSize, calendar.getTasks().size());
    }

    @Test 
    public void removeTask(){
        taskLists.add(taskList);
        calendar.addSchecule(schedule);
        task.setDeadline(date);
        calendar.addTask(task);
        taskList.addTask(task);
        int beforeEventSize = calendar.getTasks().size();
        calendar.removeTask(task);
        taskList.removeTask(task);
        assertNotEquals(beforeEventSize, calendar.getTasks().size());
    }
    
    @Test
    public void searchSchedule(){
        calendar.addSchecule(schedule);
        Schedule scheduleFound = calendar.searchSchedule(date);
        assertEquals(scheduleFound, schedule);        
    }
    
    @Test
    public void displayMonthYear(){
        String dateString = calendar.displayMonthYear(date);
        assertEquals(dateString, "DECEMBER 2023");
    }
    
    @Test
    public void searchEvent(){
        calendar.addEvent(event1);
        Event eventFound = calendar.searchEvent(event1);
        assertEquals(eventFound, event1);
    }
    
    @Test
    public void searchTask(){
        calendar.addTask(task);
        Task taskFound = calendar.searchTask(task);
        assertEquals(taskFound, task);        
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Calender testes");
    }
}