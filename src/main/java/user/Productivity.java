package user;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Productivity {


    private int goal;
    private int completed;
    private double progress;

    // Constructor
    public Productivity(int goal, int completed, double progress){
        this.goal = goal;
        this.completed = completed;
        this.progress = progress;
    }

    // Getters and setters
    public int getGoal(){
        return this.goal;
    }

    public void setGoal(int goal){
        this.goal = goal;
        this.calculateProgress();
    }

    public void completed(int completed){
        this.completed = completed;
        this.calculateProgress();
    }

    public int getCompleted(){ return this.completed; }

    public double getProgress(){ return this.progress; }


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
        this.calculateProgress();
        return true;
    }

    public boolean increaseGoal(){
        this.setGoal(this.goal + 1);
        this.calculateProgress();
        return true;
    }

    public boolean decreaseGoal(int value){
        if(this.goal > 0){
            this.goal = this.goal - value;
            this.calculateProgress();
            return true; 
        }else{
            return false;
        }
        
    }

    public boolean decreaseGoal(){
        if(this.goal > 0){
            this.setGoal(this.goal--);
            this.calculateProgress();
            return true;
        }else{
            this.goal = this.goal--; 
            return false;
        }
    }

    public void calculateProgress(){
        this.progress = (double) completed /goal;
    }
}