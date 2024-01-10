package user;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    private Productivity dailyProductivity; 
    private Productivity weeklyProductivity;
   

    // Constructor
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.friends = new HashSet<>();
        this.pendingFriends = new HashSet<>();
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public Set<User> getPendingFriends() {
        return pendingFriends;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void editProfile() {
        // TBD
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