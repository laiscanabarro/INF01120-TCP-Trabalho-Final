package content;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class CalenderTest {
    LocalDate date;
    Period period;
    Event event1;
    Event event2;
    Schedule schedule;
    Calendar calender;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating Calender tests");
    }

    @BeforeEach
    public void init(){
        date = LocalDate.now();
        period = new Period(date, date);
        event1 = new Event("class", period);
        event2 = new Event("test", period);
        schedule = new Schedule(date);
        calender = new Calendar();
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

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Calender testes");
    }
}