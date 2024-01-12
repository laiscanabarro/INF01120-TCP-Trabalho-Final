package user;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Productivity {


    private int goal;
    private int completed; 

    // Constructor
    public Productivity(int goal, int completed){
        this.goal = goal; 
    }

    // Getters and setters
    public int getGoal(){
        return this.goal;
    }

    public void setGoal(int goal){
        this.goal = goal;
    }

    public int getCompleted(){ return this.completed; }


    /*
    public Date getStart(){
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

    public double getCurrentState(){
        return this.currentState;
    }

    public void setCurrentState(double currentState){
        this.currentState = currentState;
    }
     */


    // Other methods
    public boolean increaseGoal(int value){
        this.goal = this.goal + value; 
        return true;
    }

    public boolean increaseGoal(){
        this.goal = this.goal++; 
        return true;
    }

    public boolean decreaseGoal(int value){
        if(this.goal > 0){
            this.goal = this.goal - value;
            return true; 
        }else{
            return false;
        }
        
    }

    public boolean decreaseGoal(){
        if(this.goal > 0){
            this.goal = this.goal--; 
            return true;
        }else{
            this.goal = this.goal--; 
            return false;
        }
    }

    public void calculateCurrentState(){
        // TBD 
        // get the startDate and end date and check how many tasks were completed?
        // = tasks done / goal 
    }
}