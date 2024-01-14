package user;

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

    public int getCompleted(){ return this.completed; }

    public double getProgress(){ return this.progress; }

    public void setGoal(int goal){
        this.goal = goal;
    }
    public void setCompleted(int completed){
        this.completed = completed;
    }

    public void setProgress(double progress){
        this.progress = progress;
    }

    public void calculateProgress() {
        if(goal > 0){
            if(goal > this.completed){
                this.progress = 100.00 * (double) this.completed / this.goal;
            }else{
                this.progress = 100.0;
            }
        } else{
            this.progress = 0.0;
        }

    }

    public void increaseGoal(){
        this.setGoal(this.goal + 1);
        this.calculateProgress();
    }

    public void decreaseGoal(){
        if(this.goal > 0){
            this.setGoal(this.goal - 1);
            this.calculateProgress();
        }

    }}