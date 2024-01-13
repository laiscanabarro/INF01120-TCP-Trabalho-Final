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
    private ArrayList<TaskList> tasks;
    private Calendar calendar; 
    private NotificationList notifications;
    private ArrayList<Community> communities;

    private int goal;
    private Productivity productivity;
    private Productivity weeklyProductivity;
    private Productivity dailyProductivity;
   

    // Constructor without parameters
    public User(){
        this.name = null;
        this.friends = new HashSet<>();
        this.pendingFriends = new HashSet<>();
        this.goal = 0;
        this.productivity = new Productivity(0, 0, 0.0);
    }
    // Constructor
    public User(String email, String password) {
        this.name = null;
        this.email = email;
        this.password = password;
        this.friends = new HashSet<>();
        this.pendingFriends = new HashSet<>();
        this.goal = 0;
        this.productivity = new Productivity(0, 0, 0.0);
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

    public ArrayList<TaskList> getTasks() {
        return tasks;
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

    public Productivity getDailyProductivity() {
        return dailyProductivity;
    }

    public Productivity getWeeklProductivity() {
        return weeklyProductivity;
    }


    public int getGoal() {
        return this.goal;
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



    public void createList() {
            // TBD
    }

    /* 
    public void updateWeeklyProductivity(ArrayList<TaskList> tasks, ArrayList<HabitList> habits){
        int tasksCompleted = 0;
        for(task in tasks){
            if task.status == 'done':{
                tasksCompleted += 1;    
            }
        }
    }

    public Report generateProductivityReport() {
        return new Report(this.productivity);
    }*/
}