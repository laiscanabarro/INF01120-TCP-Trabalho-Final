package content;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String email;
    private String password;
    private ArrayList<User> friends;
    private HabitsList habits;
    private Productivity productivity;

    // Constructor
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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


    public boolean addFriend(User friend) {
        // TBD
        return true;
    }

    public boolean removeFriend(User friend) {
        // TBD
        return true;
    }

    public boolean inviteFriend(User friend) {
        // TBD
        return true;
    }

    public void createCommunity(String communityName, String owner) {
        return new Community(communityName, this.name); 
    }


    public void createList() {
    }
    // TBD

    public boolean createUser() {
    }
    // TBD

    public Report generateProductivityReport() {
        return new Report(productivity);
    }
}
