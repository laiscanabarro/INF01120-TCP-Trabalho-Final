package tests;

import content.Habit;
import content.Recurrence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
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

        habit.markComplete();
        habit.setLastCompletionDate(LocalDate.now().minusDays(1));

        habit.checkCompletion();
        assertEquals(false, habit.isComplete());

        habit.markComplete();
        habit.setLastCompletionDate(LocalDate.now());

        habit.checkCompletion();
        assertEquals(true, habit.isComplete());
    }

    @Test
    public void testCheckCompletionWeekday() {
        recurrence.setWeekday(true);

        habit.markComplete();
        habit.setLastCompletionDate(LocalDate.now().minusDays(1));

        habit.checkCompletion();
        assertEquals(false, habit.isComplete());

        habit.markComplete();
        habit.setLastCompletionDate(LocalDate.now());

        habit.checkCompletion();
        assertEquals(true, habit.isComplete());
    }

    @Test
    public void testCheckCompletionWeekly() {
        recurrence.setWeekly(true);

        habit.markComplete();
        habit.setLastCompletionDate(LocalDate.now().minusDays(7));

        habit.checkCompletion();
        assertEquals(false, habit.isComplete());

        habit.markComplete();
        habit.setLastCompletionDate(LocalDate.now());

        habit.checkCompletion();
        assertEquals(true, habit.isComplete());
    }

    @Test
    public void testCheckCompletionMonthly() {
        recurrence.setMonthly(true);

        habit.markComplete();
        habit.setLastCompletionDate(LocalDate.now().minusDays(30));

        habit.checkCompletion();
        assertEquals(false, habit.isComplete());

        habit.markComplete();
        habit.setLastCompletionDate(LocalDate.now().minusDays(28));

        habit.checkCompletion();
        assertEquals(true, habit.isComplete());
    }

    @Test
    public void testCheckCompletionAnnually() {
        recurrence.setAnnually(true);

        habit.markComplete();
        habit.setLastCompletionDate(LocalDate.now().minusDays(365));

        habit.checkCompletion();
        assertEquals(false, habit.isComplete());

        habit.markComplete();
        habit.setLastCompletionDate(LocalDate.now().minusDays(300));

        habit.checkCompletion();
        assertEquals(true, habit.isComplete());
    }

    @Test
    public void testGetProgress() {
        assertEquals(0.0, habit.getProgress(), 0.01);

        habit.setComplete(false);
        habit.markComplete();
        assertEquals(3.33, habit.getProgress(), 0.01);

        habit.setComplete(false);
        habit.markComplete();
        assertEquals(6.67, habit.getProgress(), 0.01);

        habit.setComplete(false);
        habit.markComplete();
        assertEquals(10.0, habit.getProgress(), 0.01);

        habit.markIncomplete();
        assertEquals(6.67, habit.getProgress(), 0.01);
    } 
}