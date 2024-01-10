package content;

import org.junit.jupiter.api.*;
import utils.TasksUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    TaskList taskList;
    ArrayList<Task> array;
    Task task1;
    Task task2;
    Task task3;
    @BeforeAll
    public static void start() {
        System.out.println("Initiating TaskList tests");
    }

    @BeforeEach
    public void init() {
        taskList = new TaskList();
        array = new ArrayList<>();
        task1 = new Task();
        task2 = new Task();
        task3 = new Task();
        array.add(task1);
        array.add(task2);
        taskList.setTasks(array);
    }

    @Test
    @DisplayName("test clearing task list")
    void clear() {
        taskList.clear();
        assertEquals(0, taskList.getTasks().size());
    }

    @Test
    @DisplayName("test adding task to list")
    void addTask() {
        int beforeSize = taskList.getTasks().size();
        taskList.addTask(task3);
        assertEquals(beforeSize + 1, taskList.getTasks().size());
    }

    @Test
    @DisplayName("test removing task from list")
    void removeTask() {
        int beforeSize = taskList.getTasks().size();
        taskList.removeTask(task2);
        assertEquals(beforeSize - 1, taskList.getTasks().size());
    }

    @Test
    @DisplayName("test changing order of list")
    void changeOrder() {
        task1.setName("C");
        Date d1 = new Date(123, Calendar.DECEMBER, 25);
        task1.setDeadline(d1);
        task2.setName("B");
        Date d2 = new Date(123, Calendar.DECEMBER, 28);
        task2.setDeadline(d2);
        task3.setName("A");
        Date d3 = new Date(123, Calendar.DECEMBER, 29);
        task3.setDeadline(d3);
        taskList.addTask(task3);

        taskList.changeOrder(TasksUtils.ORDER_ALPHABET);
        ArrayList<Task> checkArray = new ArrayList<>();
        checkArray.add(task3);
        checkArray.add(task2);
        checkArray.add(task1);
        assertEquals(checkArray, taskList.getTasks());

        taskList.changeOrder(TasksUtils.ORDER_END_DATE_ASC);
        checkArray.clear();
        checkArray.add(task1);
        checkArray.add(task2);
        checkArray.add(task3);
        assertEquals(checkArray, taskList.getTasks());

        taskList.changeOrder(TasksUtils.ORDER_END_DATE_DESC);
        checkArray.clear();
        checkArray.add(task3);
        checkArray.add(task2);
        checkArray.add(task1);
        assertEquals(checkArray, taskList.getTasks());
    }

    @AfterAll
    public static void close() {
        System.out.println("Finalizing TaskList tests");
    }
}