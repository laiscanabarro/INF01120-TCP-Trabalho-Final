package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import src.*;
import java.time.LocalDate;
import java.util.ArrayList;

import content.Event;
import content.Period;

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
        period = new Period(date, date);
        event = new Event("test", period);
        schedule = new Schedule(date);
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