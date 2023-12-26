import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

public class HabitsTest {

    @Test
    public void testAddHabit() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence1 = new Recurrence();
        recurrence1.setDaily(true);

        Recurrence recurrence2 = new Recurrence();
        recurrence2.setWeekday(true);

        Habit habit1 = new Habit("Exercise", "Physical", recurrence1, 30, 60);
        Habit habit2 = new Habit("Read", "Mental", recurrence2, 15, 30);

        assertEquals(true, habitsList.addHabit(habit1));
        assertEquals(true, habitsList.addHabit(habit2));

        Habit habitWithSameName = new Habit("Exercise", "Physical", recurrence1, 20, 50);
        assertEquals(false, habitsList.addHabit(habitWithSameName));
    }

    @Test
    public void testRemoveHabit() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence1 = new Recurrence();
        recurrence1.setDaily(true);

        Recurrence recurrence2 = new Recurrence();
        recurrence2.setWeekday(true);

        Habit habit1 = new Habit("Exercise", "Physical", recurrence1, 30, 60);
        Habit habit2 = new Habit("Read", "Mental", recurrence2, 15, 30);

        habitsList.addHabit(habit1);
        habitsList.addHabit(habit2);

        assertEquals(true, habitsList.removeHabit("Exercise"));
        assertEquals(false, habitsList.removeHabit("NonExistentHabit"));
    }

    @Test
    public void testCheckCompletionDaily() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence = new Recurrence();
        recurrence.setDaily(true);

        Habit dailyHabit = new Habit("Exercise", "Physical", recurrence, 30, 60);
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

        Habit weekdayHabit = new Habit("Exercise", "Physical", recurrence, 30, 60);
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

        Habit weeklyHabit = new Habit("Exercise", "Physical", recurrence, 30, 60);
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

        Habit monthlyHabit = new Habit("Exercise", "Physical", recurrence, 30, 60);
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

        Habit annuallyHabit = new Habit("Exercise", "Physical", recurrence, 30, 60);
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

}