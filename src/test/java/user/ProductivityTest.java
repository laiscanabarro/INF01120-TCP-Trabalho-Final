package user;

import org.junit.jupiter.api.*;
import user.Productivity;
import user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductivityTest {
    Productivity productivity = new Productivity();
    @BeforeAll
    public static void start() {
        System.out.println("Initiating Productivity tests");
    }

    @BeforeEach
    public void init() {}

    @Test
    @DisplayName("test calculating Daily Task Progress")
    void calculateDailyTaskProgress() {
        productivity.setDailyTaskGoal(10);
        productivity.setTasksCompletedToday(5);
        productivity.calculateDailyTaskProgress();
        assertEquals(50.00, productivity.getDailyTaskProgress());
    }

    @Test
    @DisplayName("test calculating Daily Habit Progress")
    void calculateDailyHabitProgress() {
        productivity.setDailyHabitGoal(10);
        productivity.setHabitsCompletedToday(1);
        assertEquals(10.00, productivity.getDailyHabitProgress());
    }

    @Test
    @DisplayName("test increasing and decreasing Daily Task Goal")
    void increaseDecreaseDailyTaskGoal() {
        productivity.increaseDailyTaskGoal();
        assertEquals(1, productivity.getDailyTaskGoal());
        productivity.decreaseDailyTaskGoal();
        assertEquals(0.00, productivity.getDailyTaskGoal());
        productivity.decreaseDailyTaskGoal();
        assertEquals(0.00, productivity.getDailyTaskGoal());
    }

    @Test
    @DisplayName("test increasing and decreasing Daily Habit Goal")
    void increaseDecreaseDailyHabitGoal() {
        productivity.increaseDailyHabitGoal();
        assertEquals(1, productivity.getDailyHabitGoal());
        productivity.decreaseDailyHabitGoal();
        assertEquals(0.00, productivity.getDailyHabitGoal());
        productivity.decreaseDailyHabitGoal();
        assertEquals(0.00, productivity.getDailyHabitGoal());
    }


    @AfterAll
    public static void close() {
        System.out.println("Finalizing Productivity tests");
    }
}
