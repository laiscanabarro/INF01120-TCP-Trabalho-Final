package content;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtaskTest {
    TaskList taskList;
    Task task;
    Subtask subtask;
    @BeforeAll
    public static void start() {
        System.out.println("Initiating Subtask tests");
    }

    @BeforeEach
    public void init() {
        task = new Task();
        subtask = new Subtask();
        taskList = new TaskList();
        task.addSubtask(subtask);
        taskList.addTask(task);
    }

    @Test
    @DisplayName("test promoting subtask to task")
    void promoteToTask(){
        int beforeSize = taskList.getTasks().size();
        int beforeSizeTask = task.getSubtasks().size();
        subtask.promoteToTask();
        assertEquals(beforeSize + 1, taskList.getTasks().size());
        assertEquals(beforeSizeTask - 1, task.getSubtasks().size());
    }

    @AfterAll
    public static void close() {
        System.out.println("Finalizing Subtask tests");
    }
}
