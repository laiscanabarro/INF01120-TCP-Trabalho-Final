import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Productivity {


    private int goal;
    private Date start;
    private Date end;
    private double currentState;



    // Getters and setters
    public int getGoal(){
        return this.goal;
    }

    public void setGoal(int goal){
        this.goal = goal;
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

    public double getcurrentState(){
        return this.currentState;
    }

    public void setCurrentState(double currentState){
        this.currentState = currentState;
    }


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
        
    }
}
