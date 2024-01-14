package user;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import content.*;

public class User {

    private String name;
    private String email;
    private String password;
    private Set<User> friends;
    private Set<User> pendingFriends;
    private ArrayList<HabitsList> habits;
    private ArrayList<TaskList> taskLists;
    private Calendar calendar;
    private NotificationList notifications;
    private ArrayList<Community> communities;
    private Productivity productivity;

    // Constructor without parameters
    public User(){
        this.name = null;
        this.friends = new HashSet<>();
        this.pendingFriends = new HashSet<>();
        this.productivity = new Productivity();
        this.habits = new ArrayList<>();
        this.taskLists = new ArrayList<>();

    }
    // Constructor
    public User(String email, String password) {
        this.name = null;
        this.email = email;
        this.password = password;
        this.friends = new HashSet<>();
        this.pendingFriends = new HashSet<>();
        this.productivity = new Productivity();
        this.habits = new ArrayList<>();
        this.taskLists = new ArrayList<>();
    }


    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public ArrayList<Community> getCommunities() {
        return communities;
    }

    public Set<User> getPendingFriends() {
        return pendingFriends;
    }

    public ArrayList<HabitsList> getHabits() {
        return habits;
    }

    public ArrayList<TaskList> getTaskLists() {
        return taskLists;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public NotificationList getNotifications() {
        return notifications;
    }

    public Productivity getProductivity() {
        return productivity;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTaskLists(ArrayList<TaskList> list) { this.taskLists = list; }

    public void addFriend(User user) {
        if (!this.friends.contains(user)){
            this.friends.add(user);
        }
    }

    public boolean inviteFriend(User user) {
        if(friends.contains(user) || pendingFriends.contains(user)) { // Check if user is already a friend
            return false;
        }
        this.pendingFriends.add(user);
        return true;
    }

    public void acceptFriendInvite(User user) {
        if(this.pendingFriends.contains(user)) {
            this.pendingFriends.remove(user);
            this.addFriend(user);
            user.addFriend(this); // Adds to both users
        }
    }

    public void removeFriend(User user) {
        if(this.friends.contains(user)) {
            this.friends.remove(user);
            user.getFriends().remove(this); // Removes friendship from both users
        }
    }



    public void createCommunity(String communityName) {
        Community newCommunity = new Community(communityName, this.name);
        this.communities.add(newCommunity);
    }

    public void addList(TaskList list) {
        taskLists.add(list);
    }

    public void removeList(TaskList list) {
        taskLists.remove(list);
    }

    public void updateProductivity() {
        //int completedTasks = 0;
        int tasksCompletedToday = 0;
        int habitsCompletedToday = 0;

        if(this.habits != null && !this.habits.isEmpty()){
            for (HabitsList habitList : this.habits){
                //completedHabits = completedHabits + habitList.getCompletedCount();
                habitsCompletedToday = habitsCompletedToday + habitList.getCompletedTodayCount();
            }
            this.productivity.setHabitsCompletedToday(habitsCompletedToday);
        }

        if(this.taskLists != null && !this.taskLists.isEmpty()){
            for (TaskList taskList: this.taskLists) {
                //completedTasks = completedTasks + taskList.getCompletedCount();
                tasksCompletedToday = tasksCompletedToday + taskList.getCompletedTodayCount();
            }
        }

        tasksCompletedToday = tasksCompletedToday + ImportantList.getInstance().getCompletedTodayCount() + DailyList.getInstance().getCompletedTodayCount();
        this.productivity.setTasksCompletedToday(tasksCompletedToday);
        this.productivity.setHabitsCompletedToday(5);
    }



}