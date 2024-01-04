package content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.*;
import utils.TasksUtils;

import java.util.ArrayList;

public class ImportantListTest {
    TaskList taskList;
    Task task1;
    Task task2;
    Task task3;
    @BeforeAll
    public static void start() {
        System.out.println("Initiating ImportantList tests");
    }

    @BeforeEach
    public void init() {
        ImportantList.getInstance().getTasks().clear();

        taskList = new TaskList();
        task1 = new Task();
        task1.setCurrentList(taskList);
        task2 = new Task();
        task2.setCurrentList(taskList);
        task3 = new Task();
        task3.setCurrentList(taskList);
    }

    @Test
    @DisplayName("test removing importance of task")
    void removeImportance() {
        task1.setImportanceScale(3);
        ImportantList.removeImportance(task1);
        assertEquals(0, task1.getImportanceScale());
        assertNotEquals(ImportantList.getInstance(), task1.getCurrentList());

        task2.setImportanceScale(0);
        ImportantList.removeImportance(task2);
        assertEquals(0, task2.getImportanceScale());
        assertNotEquals(ImportantList.getInstance(), task2.getCurrentList());
    }

    @Test
    @DisplayName("test increasing importance of task")
    void increasePriority() {
        task1.setImportanceScale(0);
        ImportantList.increasePriority(task1);
        assertEquals(1, task1.getImportanceScale());
        assertEquals(ImportantList.getInstance(), task1.getCurrentList());

        task2.setImportanceScale(5);
        ImportantList.increasePriority(task2);
        assertEquals(5, task2.getImportanceScale());
        assertEquals(ImportantList.getInstance(), task2.getCurrentList());
    }

    @Test
    @DisplayName("test decreasing importance of task")
    void decreasePriority() {
        task1.setImportanceScale(3);
        ImportantList.decreasePriority(task1);
        assertEquals(2, task1.getImportanceScale());
        assertEquals(ImportantList.getInstance(), task1.getCurrentList());

        task2.setImportanceScale(0);
        ImportantList.decreasePriority(task2);
        assertEquals(0, task2.getImportanceScale());
        assertNotEquals(ImportantList.getInstance(), task2.getCurrentList());
    }

    @Test
    @DisplayName("test changing order of list")
    void changeOrder() {
        task1.setImportanceScale(2);
        task2.setImportanceScale(1);
        task3.setImportanceScale(3);
        ImportantList.getInstance().changeOrder(TasksUtils.ORDER_IMPORTANCE_ASC);
        ArrayList<Task> checkArray = new ArrayList<>();
        checkArray.add(task2);
        checkArray.add(task1);
        checkArray.add(task3);
        assertEquals(checkArray, ImportantList.getInstance().getTasks());

        ImportantList.getInstance().changeOrder(TasksUtils.ORDER_IMPORTANCE_DESC);
        checkArray.clear();
        checkArray.add(task3);
        checkArray.add(task1);
        checkArray.add(task2);
        assertEquals(checkArray, ImportantList.getInstance().getTasks());
    }

    @AfterAll
    public static void close() {
        System.out.println("Finalizing ImportantList tests");
    }
}
