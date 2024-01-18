package content;

import org.junit.jupiter.api.*;
import utils.Period;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class PeriodTest {
    LocalDate date1;
    LocalDate date2;
    LocalDate date3;
    LocalTime time1;
    LocalTime time2;
    Period period1;
    Period period2;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating Period tests");
    }

    @BeforeEach
    public void init(){
        date1 = LocalDate.of(2023, 12, 13);
        date2 = LocalDate.of(2024, 1, 10);
        date3 = LocalDate.of(2023, 12, 15);
        time1 = LocalTime.of(12, 0);
        time2 = LocalTime.of(13, 10);
        period1 = new Period(date1, date2, time1, time2);
        period2 = new Period(date1, date3);
    }

    @Test 
    public void countDays(){
        long daysPeriod1 = period1.countDays();
        long daysPeriod2= period2.countDays();

        assertEquals(28, daysPeriod1);
        assertEquals(2, daysPeriod2);
    }
    
    @Test
    public void displayPeriod(){
        String period = period2.displayPeriod();
        assertEquals("13/12/2023 - 15/12/2023", period);
        
        period = period1.displayPeriod();
        assertEquals("13/12/2023 - 10/01/2024, 12:00 - 13:10", period);
    }
    
    @Test
    public void convertStringToLocalDate(){
        LocalDate date = period2.convertStringToLocalDate("13/12/2023");
        assertEquals(LocalDate.of(2023, 12, 13), date);
    }   
    
    @Test
    public void convertStringToLocalTime(){
        LocalTime time = period1.convertStringToLocalTime("12:00");
        assertEquals(LocalTime.of(12, 0), time); 
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Period testes");
    }
}