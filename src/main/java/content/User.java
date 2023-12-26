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


    public void editProfile(){}
        //  TBD

    public boolean addFriend(User friend){
        //  TBD
        return true;
    }

    public boolean removeFriend(User friend){
        //  TBD
        return true;
    }

    public boolean inviteFriend(User friend){
        //  TBD
        return true;
    }

    public void createCommunity(){}
        //  TBD

    public void createList(){}
        //  TBD

    public boolean createUser(){}
        //  TBD
    
    // Create Report
    public Report generateProductivityReport(){
        return new Report(productivity);
    }
}
