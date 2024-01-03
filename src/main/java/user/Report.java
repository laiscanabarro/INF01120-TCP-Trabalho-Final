package user;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {

    private Productivity productivity;
    private Date startDate;
    private Date endDate; 


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

    public Date getStartDate(){
        return this.startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }


    public Date getEndDate(){
        return this.endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    // Other methods
    public void displayProductivityReport (){
        System.out.println("Goal: " + productivity.getGoal());
        System.out.println("Current State:" + productivity.getCurrentState());
        // maybe: days passed, days left, etc 
    }
}

