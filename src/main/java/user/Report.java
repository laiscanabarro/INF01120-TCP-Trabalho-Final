package user;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Report {

    private Productivity productivity;

    // Constructor 
    public Report(Productivity productivity){
        this.productivity = productivity; 
    }


    // Getters and setters
    public Productivity getProductivity(){
        return this.productivity;
    }

    public void setProductivity(Productivity productivity){
        this.productivity = productivity;
    }


    // Other methods
    public void displayProductivityReport (){
        System.out.println("Goal: " + productivity.getGoal());
        System.out.println("Current State:" + productivity.getCurrentState());
        // maybe: days passed, days left, etc 
    }
}

