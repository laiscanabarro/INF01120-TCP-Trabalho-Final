import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {

    private User user;
    private Date start;
    private Date end; 



    // Getters and setters
    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Date getStart(){
        return this.start;
    }

    public void setStart(Date start){
        this.start = start;
    }


    public Date getEnd(){
        return this.end;
    }

    public void setEnd(Date end){
        this.end = end;
    }

    // Other methods
    public Productivity checkProductivity(){

        return this.user.productivity;
    }

    public state generateProductivityReport(){
        float state = this.user.productivity.getCurrentState(); 
        return state;
    }

    public void getUserInfo(){
        System.out.println("Name: " + this.user.name); 
        // return other attributes, lists, etc 
    }
}

