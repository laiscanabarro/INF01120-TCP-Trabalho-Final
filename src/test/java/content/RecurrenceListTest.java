package content;

import java.time.LocalDate;
import org.junit.jupiter.api.*;

import utils.RecurrenceList;

import static org.junit.jupiter.api.Assertions.*;

public class RecurrenceListTest {
    RecurrenceList recurrenceList;
    LocalDate date;
    Event event;
    Schedule schedule;
    
    @BeforeAll
    public static void start(){
        System.out.println("Initiating RecurrenceList tests");
    }
    
    @BeforeEach
    public void init(){
        recurrenceList = new RecurrenceList();
        date = LocalDate.of(2024, 1, 1);
        event = new Event("test", date);
    }
    
    @Test
    public void addDaily(){
        int beforeDaily = recurrenceList.getDaily().size();
        recurrenceList.addDaily(event);
        assertNotEquals(beforeDaily, recurrenceList.getDaily().size());
    }
    
    @Test
    public void removeDaily(){
        recurrenceList.addDaily(event);
        int beforeDaily = recurrenceList.getDaily().size();
        recurrenceList.removeDaily(event);
        assertNotEquals(beforeDaily, recurrenceList.getDaily().size());
    }
    
    @Test
    public void addWeekday(){
        int beforeWeekday = recurrenceList.getWeekday().size();
        recurrenceList.addWeekday(event);
        assertNotEquals(beforeWeekday, recurrenceList.getWeekday().size());
    }
    
    @Test
    public void removeWeekday(){
        recurrenceList.addWeekday(event);
        int beforeWeekday = recurrenceList.getWeekday().size();
        recurrenceList.removeWeekday(event);
        assertNotEquals(beforeWeekday, recurrenceList.getWeekday().size());
    }
    
    @Test
    public void addWeekly(){
        int beforeWeekly = recurrenceList.getWeekly().size();
        recurrenceList.addWeekly(event);
        assertNotEquals(beforeWeekly, recurrenceList.getWeekly().size());
    }
    
    @Test
    public void removeWeekly(){
        recurrenceList.addWeekly(event);
        int beforeWeekly = recurrenceList.getWeekly().size();
        recurrenceList.removeWeekly(event);
        assertNotEquals(beforeWeekly, recurrenceList.getWeekly().size());
    }
    
    @Test
    public void addMonthly(){
        int beforeMonthly = recurrenceList.getMonthly().size();
        recurrenceList.addMonthly(event);
        assertNotEquals(beforeMonthly, recurrenceList.getMonthly().size());
    }
    
    @Test
    public void removeMonthly(){
        recurrenceList.addMonthly(event);
        int beforeMonthly = recurrenceList.getMonthly().size();
        recurrenceList.removeMonthly(event);
        assertNotEquals(beforeMonthly, recurrenceList.getMonthly().size());
    }
    
    @Test
    public void addAnnually(){
        int beforeAnnually = recurrenceList.getAnnually().size();
        recurrenceList.addAnnually(event);
        assertNotEquals(beforeAnnually, recurrenceList.getAnnually().size());
    }
    
    @Test
    public void removeAnnually(){
        recurrenceList.addAnnually(event);
        int beforeAnnually = recurrenceList.getAnnually().size();
        recurrenceList.removeDaily(event);
        assertEquals(beforeAnnually, recurrenceList.getAnnually().size());
    }
    
    @AfterAll
    public static void close(){
        System.out.println("Finalizing RecurrenceList testes");
    }
    
}
