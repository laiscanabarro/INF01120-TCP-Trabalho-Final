package user;

import content.Alarm;
import content.Task;
import content.TaskList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;



import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CommunityTest {
    Alarm alarmCurrent;
    Alarm alarmFuture;
    LocalDate testDate;
    LocalDate futureDate;
    User testUser;
    User testUser2;
    Community testCommunity;
    TaskList taskList;
    ArrayList<Task> tasks;

    @BeforeAll
    public static void start(){
        System.out.println("Initiating Community tests");
    }

    @BeforeEach
    public void init(){
        testDate = LocalDate.now();
        futureDate = LocalDate.of(2024, 12, 13);
        alarmCurrent = new Alarm(testDate, "Today");
        alarmFuture = new Alarm(futureDate, "Future");
        testUser = new User();
        testUser.setName("Test User");
        testUser2 = new User();
        testUser2.setName("Test User 2");
        testCommunity = new Community("Community 1", "Test User");
        tasks = new ArrayList<>();
        taskList = new TaskList("TaskList", tasks);
    }

    @Test
    public void addMember(){
        // first addition returns true
        assertTrue(testCommunity.addMember(testUser));
        // attempt to add an existing user returns false
        assertFalse(testCommunity.addMember(testUser));
    }

    @Test
    public void searchMember(){
        testCommunity.addMember(testUser2);

        assertEquals(testUser2, testCommunity.searchMember("Test User 2"));
        assertNull(testCommunity.searchMember("Test User 3"));
    }

    @Test
    public void removeMember(){
        assertTrue(testCommunity.addMember(testUser2));
        assertTrue(testCommunity.removeMember("Test User 2"));
        assertFalse(testCommunity.removeMember("Test User 3"));
    }

    @Test
    public void addList(){
        assertTrue(testCommunity.addList(taskList));
        // attempt to add existing list returns false
        assertFalse(testCommunity.addList(taskList));
    }

    @Test
    public void searchList(){
        testCommunity.addList(taskList);

        // attempt to add existing list returns false
        assertEquals(taskList, testCommunity.searchList("TaskList"));
        assertNull(testCommunity.searchList("newList"));
    }

    @Test
    public void removeList(){
        testCommunity.addList(taskList);

        assertTrue(testCommunity.removeList("TaskList"));
        assertFalse(testCommunity.removeList("newList"));
    }

    @AfterAll
    public static void close(){
        System.out.println("Finalizing Community tests");
    }
}