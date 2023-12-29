package tests;

import content.Habit;
import content.HabitsList;
import content.Recurrence;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class HabitTest {

    @Test
    public void testCheckCompletionDaily() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence = new Recurrence();
        recurrence.setDaily(true);

        Habit dailyHabit = new Habit("Exercise", "Physical", recurrence, 30);
        habitsList.addHabit(dailyHabit);

        dailyHabit.markComplete();
        dailyHabit.setLastCompletionDate(LocalDate.now().minusDays(1));

        dailyHabit.checkCompletion();
        assertEquals(false, dailyHabit.isComplete());

        dailyHabit.markComplete();
        dailyHabit.setLastCompletionDate(LocalDate.now());

        dailyHabit.checkCompletion();
        assertEquals(true, dailyHabit.isComplete());
    }

    @Test
    public void testCheckCompletionWeekday() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence = new Recurrence();
        recurrence.setWeekday(true);

        Habit weekdayHabit = new Habit("Exercise", "Physical", recurrence, 30);
        habitsList.addHabit(weekdayHabit);

        weekdayHabit.markComplete();
        weekdayHabit.setLastCompletionDate(LocalDate.now().minusDays(1));

        weekdayHabit.checkCompletion();
        assertEquals(false, weekdayHabit.isComplete());

        weekdayHabit.markComplete();
        weekdayHabit.setLastCompletionDate(LocalDate.now());

        weekdayHabit.checkCompletion();
        assertEquals(true, weekdayHabit.isComplete());
    }

    @Test
    public void testCheckCompletionWeekly() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence = new Recurrence();
        recurrence.setWeekly(true);

        Habit weeklyHabit = new Habit("Exercise", "Physical", recurrence, 30);
        habitsList.addHabit(weeklyHabit);

        weeklyHabit.markComplete();
        weeklyHabit.setLastCompletionDate(LocalDate.now().minusDays(7));

        weeklyHabit.checkCompletion();
        assertEquals(false, weeklyHabit.isComplete());

        weeklyHabit.markComplete();
        weeklyHabit.setLastCompletionDate(LocalDate.now());

        weeklyHabit.checkCompletion();
        assertEquals(true, weeklyHabit.isComplete());
    }

    @Test
    public void testCheckCompletionMonthly() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence = new Recurrence();
        recurrence.setMonthly(true);

        Habit monthlyHabit = new Habit("Exercise", "Physical", recurrence, 30);
        habitsList.addHabit(monthlyHabit);

        monthlyHabit.markComplete();
        monthlyHabit.setLastCompletionDate(LocalDate.now().minusDays(30));

        monthlyHabit.checkCompletion();
        assertEquals(false, monthlyHabit.isComplete());

        monthlyHabit.markComplete();
        monthlyHabit.setLastCompletionDate(LocalDate.now().minusDays(28));

        monthlyHabit.checkCompletion();
        assertEquals(true, monthlyHabit.isComplete());
    }

    @Test
    public void testCheckCompletionAnnually() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence = new Recurrence();
        recurrence.setAnnually(true);

        Habit annuallyHabit = new Habit("Exercise", "Physical", recurrence, 30);
        habitsList.addHabit(annuallyHabit);

        annuallyHabit.markComplete();
        annuallyHabit.setLastCompletionDate(LocalDate.now().minusDays(365));

        annuallyHabit.checkCompletion();
        assertEquals(false, annuallyHabit.isComplete());

        annuallyHabit.markComplete();
        annuallyHabit.setLastCompletionDate(LocalDate.now().minusDays(300));

        annuallyHabit.checkCompletion();
        assertEquals(true, annuallyHabit.isComplete());
    }

    @Test
    public void testGetProgress() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence = new Recurrence();
        recurrence.setDaily(true);

        Habit habit = new Habit("Exercise", "Physical", recurrence, 30);
        habitsList.addHabit(habit);

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
