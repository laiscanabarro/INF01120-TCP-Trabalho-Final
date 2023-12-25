import org.junit.Test;
import static org.junit.Assert.*;

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
}