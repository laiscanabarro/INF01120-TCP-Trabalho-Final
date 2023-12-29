package tests;

import content.Habit;
import content.HabitsList;
import content.Recurrence;

import org.junit.Test;
import static org.junit.Assert.*;

public class HabitsListTest {

    @Test
    public void testAddHabit() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence1 = new Recurrence();
        recurrence1.setDaily(true);

        Recurrence recurrence2 = new Recurrence();
        recurrence2.setWeekday(true);

        Habit habit1 = new Habit("Exercise", "Physical", recurrence1, 30);
        Habit habit2 = new Habit("Read", "Mental", recurrence2, 15);

        assertEquals(true, habitsList.addHabit(habit1));
        assertEquals(true, habitsList.addHabit(habit2));

        Habit habitWithSameName = new Habit("Exercise", "Physical", recurrence1, 20);
        assertEquals(false, habitsList.addHabit(habitWithSameName));
    }

    @Test
    public void testRemoveHabit() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence1 = new Recurrence();
        recurrence1.setDaily(true);

        Recurrence recurrence2 = new Recurrence();
        recurrence2.setWeekday(true);

        Habit habit1 = new Habit("Exercise", "Physical", recurrence1, 30);
        Habit habit2 = new Habit("Read", "Mental", recurrence2, 15);

        habitsList.addHabit(habit1);
        habitsList.addHabit(habit2);

        assertEquals(true, habitsList.removeHabit("Exercise"));
        assertEquals(false, habitsList.removeHabit("NonExistentHabit"));
    }

    @Test
    public void testHabitChangeOrderGoalAscending() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence = new Recurrence();
        recurrence.setDaily(true);

        Habit habit1 = new Habit("Exercise", "Physical", recurrence, 30);
        Habit habit2 = new Habit("Read", "Mental", recurrence, 15);
        Habit habit3 = new Habit("Teach", "Educational", recurrence, 45);

        habitsList.addHabit(habit1);
        habitsList.addHabit(habit2);
        habitsList.addHabit(habit3);

        habitsList.habitChangeOrder("goalAscending");

        assertEquals(habit2, habitsList.getHabits().get(0));
        assertEquals(habit1, habitsList.getHabits().get(1));
        assertEquals(habit3, habitsList.getHabits().get(2));
    }

    @Test
    public void testHabitChangeOrderGoalDescending() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence = new Recurrence();
        recurrence.setDaily(true);

        Habit habit1 = new Habit("Exercise", "Physical", recurrence, 30);
        Habit habit2 = new Habit("Read", "Mental", recurrence, 15);
        Habit habit3 = new Habit("Teach", "Educational", recurrence, 45);

        habitsList.addHabit(habit1);
        habitsList.addHabit(habit2);
        habitsList.addHabit(habit3);

        habitsList.habitChangeOrder("goalDescending");

        assertEquals(habit3, habitsList.getHabits().get(0));
        assertEquals(habit1, habitsList.getHabits().get(1));
        assertEquals(habit2, habitsList.getHabits().get(2));
    }

    @Test
    public void testHabitChangeOrderByName() {
        HabitsList habitsList = new HabitsList("Health");
    
        Recurrence recurrence = new Recurrence();
        recurrence.setDaily(true);
    
        Habit habit1 = new Habit("Exercise", "Physical", recurrence, 30);
        Habit habit2 = new Habit("Read", "Mental", recurrence, 15);
        Habit habit3 = new Habit("Teach", "Educational", recurrence, 45);
    
        habitsList.addHabit(habit1);
        habitsList.addHabit(habit2);
        habitsList.addHabit(habit3);
    
        habitsList.habitChangeOrder("name");
    
        assertEquals(habit1, habitsList.getHabits().get(0));
        assertEquals(habit2, habitsList.getHabits().get(1));
        assertEquals(habit3, habitsList.getHabits().get(2));
    }

    @Test
    public void testHabitChangeOrderByCategory() {
        HabitsList habitsList = new HabitsList("Health");

        Recurrence recurrence = new Recurrence();
        recurrence.setDaily(true);

        Habit habit1 = new Habit("Exercise", "Physical", recurrence, 30);
        Habit habit2 = new Habit("Read", "Mental", recurrence, 15);
        Habit habit3 = new Habit("Teach", "Educational", recurrence, 45);

        habitsList.addHabit(habit1);
        habitsList.addHabit(habit2);
        habitsList.addHabit(habit3);

        habitsList.habitChangeOrder("category");

        assertEquals(habit3, habitsList.getHabits().get(0));
        assertEquals(habit2, habitsList.getHabits().get(1));
        assertEquals(habit1, habitsList.getHabits().get(2));
    }
}
