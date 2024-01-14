package content;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Recurrence;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class HabitTest {
    private Recurrence recurrence;
    private Habit habit;

    @BeforeEach
    public void init() {
        recurrence = new Recurrence();

        habit = new Habit("Exercise", "Physical", recurrence, 30);
    }

    @Test
    public void testCheckCompletionDaily() {
        recurrence.setDaily(true);

        habit.changeStatus();
        habit.setLastCompletionDate(LocalDate.now().minusDays(1));

        habit.checkCompletion();
        assertFalse(habit.isComplete());

        habit.changeStatus();
        habit.setLastCompletionDate(LocalDate.now());

        habit.checkCompletion();
        assertTrue(habit.isComplete());
    }

    @Test
    public void testCheckCompletionWeekday() {
        recurrence.setWeekday(true);
        habit.setComplete(true);

        habit.changeStatus();
        habit.setLastCompletionDate(LocalDate.now().minusDays(1));

        habit.checkCompletion();
        assertFalse(habit.isComplete());

        habit.changeStatus();
        habit.setLastCompletionDate(LocalDate.now());

        habit.checkCompletion();
        assertTrue(habit.isComplete());
    }

    @Test
    public void testCheckCompletionWeekly() {
        recurrence.setWeekly(true);

        habit.changeStatus();
        habit.setLastCompletionDate(LocalDate.now().minusDays(7));

        habit.checkCompletion();
        assertFalse(habit.isComplete());

        habit.changeStatus();
        habit.setLastCompletionDate(LocalDate.now());

        habit.checkCompletion();
        assertTrue(habit.isComplete());
    }

    @Test
    public void testCheckCompletionMonthly() {
        recurrence.setMonthly(true);

        habit.changeStatus();
        habit.setLastCompletionDate(LocalDate.now().minusDays(30));

        habit.checkCompletion();
        assertFalse(habit.isComplete());

        habit.changeStatus();
        habit.setLastCompletionDate(LocalDate.now().minusDays(28));

        habit.checkCompletion();
        assertTrue(habit.isComplete());
    }

    @Test
    public void testCheckCompletionAnnually() {
        recurrence.setAnnually(true);

        habit.changeStatus();
        habit.setLastCompletionDate(LocalDate.now().minusDays(365));

        habit.checkCompletion();
        assertFalse(habit.isComplete());

        habit.changeStatus();
        habit.setLastCompletionDate(LocalDate.now().minusDays(300));

        habit.checkCompletion();
        assertTrue(habit.isComplete());
    }

    @Test
    public void testGetProgress() {
        assertEquals(0.0, habit.getProgress(), 0.01);

        habit.setComplete(false);
        habit.changeStatus();
        assertEquals(3.33, habit.getProgress(), 0.01);

        habit.setComplete(false);
        habit.changeStatus();
        assertEquals(6.67, habit.getProgress(), 0.01);

        habit.setComplete(false);
        habit.changeStatus();
        assertEquals(10.0, habit.getProgress(), 0.01);

        habit.changeStatus();
        assertEquals(6.67, habit.getProgress(), 0.01);
    } 

    @Test
    public void testMarkCompleteAndIncomplete() {
        habit.changeStatus();

        assertNull(habit.getPrevLastCompletionDate());
        assertEquals(LocalDate.now(), habit.getLastCompletionDate());

        habit.changeStatus();

        assertNull(habit.getPrevLastCompletionDate());
        assertNull(habit.getLastCompletionDate());

        habit.setLastCompletionDate(LocalDate.now().minusDays(300));

        habit.changeStatus();

        assertEquals(LocalDate.now().minusDays(300), habit.getPrevLastCompletionDate());
        assertEquals(LocalDate.now(), habit.getLastCompletionDate());

        habit.changeStatus();

        assertEquals(LocalDate.now().minusDays(300), habit.getPrevLastCompletionDate());
        assertEquals(LocalDate.now().minusDays(300), habit.getLastCompletionDate());
    }
}