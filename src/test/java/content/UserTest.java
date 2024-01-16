package content;

import org.junit.jupiter.api.*;

import user.User;

import static org.junit.jupiter.api.Assertions.*;


public class UserTest {
    User user1;
    User user2;
    Task task;
    TaskList taskList1;
    TaskList taskList2;
    HabitsList habitList1;
    HabitsList habitList2;

    @BeforeAll
    public static void start() {
        System.out.println("Initiating User tests");
    }

    @BeforeEach
    public void init() {
        user1 = new User("email1@email.com", "password1");
        user2 = new User("email2@email.com", "password2");
        taskList1 = new TaskList();
        taskList2 = new TaskList();
        habitList1 = new HabitsList("Exercise");
        habitList2 = new HabitsList("Sleep");
        task = new Task();
        taskList1.addTask(task);
        user1.addList(taskList1);
        user1.addHabitList(habitList1);
    }

    @Test
    @DisplayName("test adding list to user's list of TaskLists")
    void addList(){
        user1.addList(taskList2);
        assertEquals(2, user1.getTaskLists().size());
        assertTrue(user1.getTaskLists().contains(taskList2));
    }

    @Test
    @DisplayName("test removing list from user's list of TaskLists")
    void removeList(){
        user1.removeList(taskList1);
        assertEquals(0, user1.getTaskLists().size());
        assertFalse(user1.getTaskLists().contains(taskList1));
    }

    @Test
    @DisplayName("test adding list to user's list of HabitLists")
    void addHabitList(){
        user1.addHabitList(habitList2);
        assertEquals(2, user1.getHabitLists().size());
        assertTrue(user1.getHabitLists().contains(habitList2));
    }

    @Test
    @DisplayName("test removing list from user's list of HabitLists")
    void removeHabitList(){
        user1.removeHabitList(habitList1);
        assertEquals(0, user1.getHabitLists().size());
        assertFalse(user1.getHabitLists().contains(habitList1));
    }

    @Test
    @DisplayName("test updating Productivity")
    void updateProductivity(){
        task.setStatus(true);
        user1.updateProductivity();
        assertEquals(1, user1.getProductivity().getTasksCompletedToday());
        assertEquals(0, user1.getProductivity().getHabitsCompletedToday());
    }

    @Test
    @DisplayName("test friendship request")
    void addFriend() {
        // User1 sends a friend request to User2
        user1.inviteFriend(user2);

        // Check if User2 has received friend request from User1
        assertTrue(user2.getPendingFriends().contains(user1));
        assertTrue(user1.getPendingFriends().contains(user2));

        // User2 accepts the friend request
        user2.acceptFriendInvite(user1);

        // Check if User1 and User2 are now friends
        assertTrue(user1.getFriends().contains(user2));
        assertTrue(user2.getFriends().contains(user1));
    }

    @Test
    @DisplayName("test friendship removal")
    void removeFriend() {
        // User1 sends a friend request to User2
        user1.inviteFriend(user2);

        // Check if User2 has received friend request from User1
        assertTrue(user2.getPendingFriends().contains(user1));

        // User2 accepts the friend request
        user2.acceptFriendInvite(user1);

        // Check if User1 and User2 are now friends
        assertTrue(user1.getFriends().contains(user2));
        assertTrue(user2.getFriends().contains(user1));

        // Test removal
        user1.removeFriend(user2);

        // User is not listed
        assertFalse(user1.getFriends().contains(user2));

        // User is not listed
        assertFalse(user2.getFriends().contains(user1));
    }

    @Test
    @DisplayName("test friendship rejection")
    void rejectFriend() {
        // User1 sends a friend request to User2
        user1.inviteFriend(user2);

        // Check if User2 has received friend request from User1
        assertTrue(user2.getPendingFriends().contains(user1));

        // User2 rejects the friend request
        user2.rejectFriendRequest(user1);

        // Check if User2 no longer has pending friend request from User1
        assertFalse(user2.getPendingFriends().contains(user1));

        // User is not listed as friend
        assertFalse(user1.getFriends().contains(user2));

        // User is not listed as friend
        assertFalse(user2.getFriends().contains(user1));
    }


    @AfterAll
    public static void close() {
        System.out.println("Finalizing User tests");
    }
}