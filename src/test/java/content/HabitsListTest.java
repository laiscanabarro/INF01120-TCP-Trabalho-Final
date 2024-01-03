package content;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HabitsListTest {
    private HabitsList habitsList;
    private Recurrence recurrence;
    private Habit habit1;
    private Habit habit2;
    private Habit habit3;

    @BeforeEach
    public void init() {
        habitsList = new HabitsList("Health");

        recurrence = new Recurrence();
        recurrence.setDaily(true);

        habit1 = new Habit("Exercise", "Physical", recurrence, 30);
        habit2 = new Habit("Read", "Mental", recurrence, 15);
        habit3 = new Habit("Teach", "Educational", recurrence, 45);

        habitsList.addHabit(habit1);
        habitsList.addHabit(habit2);
        habitsList.addHabit(habit3);
    }

    @Test
    public void testAddHabit() {
        Habit habitWithSameName = new Habit("Exercise", "Physical", recurrence, 20);
        assertEquals(false, habitsList.addHabit(habitWithSameName));
    }

    @Test
    public void testRemoveHabit() {
        assertEquals(true, habitsList.removeHabit("Exercise"));
        assertEquals(false, habitsList.removeHabit("NonExistentHabit"));
    }

    @Test
    public void testHabitChangeOrderGoalAscending() {
        habitsList.habitChangeOrder("goalAscending");

        assertEquals(habit2, habitsList.getHabits().get(0));
        assertEquals(habit1, habitsList.getHabits().get(1));
        assertEquals(habit3, habitsList.getHabits().get(2));
    }

    @Test
    public void testHabitChangeOrderGoalDescending() {
        habitsList.habitChangeOrder("goalDescending");

        assertEquals(habit3, habitsList.getHabits().get(0));
        assertEquals(habit1, habitsList.getHabits().get(1));
        assertEquals(habit2, habitsList.getHabits().get(2));
    }

    @Test
    public void testHabitChangeOrderByName() {
        habitsList.habitChangeOrder("name");

        assertEquals(habit1, habitsList.getHabits().get(0));
        assertEquals(habit2, habitsList.getHabits().get(1));
        assertEquals(habit3, habitsList.getHabits().get(2));
    }

    @Test
    public void testHabitChangeOrderByCategory() {
        habitsList.habitChangeOrder("category");

        assertEquals(habit3, habitsList.getHabits().get(0));
        assertEquals(habit2, habitsList.getHabits().get(1));
        assertEquals(habit1, habitsList.getHabits().get(2));
    }
}