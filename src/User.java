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

    // Other methods
    public void editProfile(){}

    public boolean addFriend(User friend){
        return true;
    }

    public boolean removeFriend(User friend){
        return true;
    }

    public boolean inviteFriend(User friend){
        return true;
    }

    public void createCommunity(){}

    public void createList(){}

    public boolean createUser(){}


}
