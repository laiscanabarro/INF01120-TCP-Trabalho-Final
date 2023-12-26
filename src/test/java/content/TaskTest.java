package content;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    Task task;
    Subtask subtask1;
    Subtask subtask2;
    TaskList taskList1;
    TaskList taskList2;

    @BeforeAll
    public static void start() {
        System.out.println("Initiating Task tests");
    }

    @BeforeEach
    public void init() {
        task = new Task();
        subtask1 = new Subtask();
        subtask2 = new Subtask();
        taskList1 = new TaskList();
        taskList2 = new TaskList();
        ArrayList<Subtask> subtasks = new ArrayList<>();
        subtasks.add(subtask1);
        task.setSubtasks(subtasks);
        taskList1.addTask(task);
    }

    @Test
    @DisplayName("test adding subtask")
    void addSubtask(){
        int beforeSize = task.getSubtasks().size();
        task.addSubtask(subtask2);
        assertEquals(beforeSize + 1, task.getSubtasks().size());
    }

    @Test
    @DisplayName("test removing subtask")
    void removeSubtask(){
        int beforeSize = task.getSubtasks().size();
        task.removeSubtask(subtask1);
        assertEquals(beforeSize - 1, task.getSubtasks().size());
    }

    @Test
    @DisplayName("test changing tasks from lists")
    void changeList(){
        task.changeList(taskList2);
        assertEquals(0, taskList1.getTasks().size());
        assertEquals(1, taskList2.getTasks().size());
    }

    @AfterAll
    public static void close() {
        System.out.println("Finalizing Task tests");
    }
}
