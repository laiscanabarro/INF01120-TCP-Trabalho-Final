package content;

import org.junit.jupiter.api.*;
import user.Productivity;
import user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductivityTest {
    Productivity productivity = new Productivity();
    User user1;
    User user2;
    Task task;
    TaskList taskList1;
    TaskList taskList2;
    @BeforeAll
    public static void start() {
        System.out.println("Initiating Productivity tests");
    }

    @BeforeEach
    public void init() {
        user1 = new User("email1@email.com", "password1");
        taskList1 = new TaskList();
        task = new Task();
        taskList1.addTask(task);
        user1.addList(taskList1);
    }

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
