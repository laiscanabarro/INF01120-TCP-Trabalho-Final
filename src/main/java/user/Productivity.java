package user;

public class Productivity {
    private int dailyTaskGoal;
    private int dailyHabitGoal;
    private double dailyHabitProgress;
    private double dailyTaskProgress;
    private int tasksCompletedToday;
    private int habitsCompletedToday;

    // Constructor
    public Productivity(){
        this.dailyTaskGoal = 0;
        this.dailyHabitGoal = 0;
        this.tasksCompletedToday = 0;
        this.habitsCompletedToday = 0;
        this.dailyTaskProgress = 0.0;
        this.dailyHabitProgress = 0.0;
    }

    // Getters and setters
    public int getDailyTaskGoal(){
        return this.dailyTaskGoal;
    }

    public int getDailyHabitGoal(){ return this.dailyHabitGoal; }

    public int getTasksCompletedToday(){
        return this.tasksCompletedToday;
    }

    public int getHabitsCompletedToday(){ return this.habitsCompletedToday; }

    public double getDailyTaskProgress(){ return this.dailyTaskProgress; }

    public double getDailyHabitProgress(){ return this.dailyHabitProgress; }

    public void setDailyTaskGoal(int goal){
        this.dailyTaskGoal = goal;
    }
    public void setDailyHabitGoal(int goal){
        this.dailyHabitGoal = goal;
    }

    // Main methods
    public void setTasksCompletedToday(int tasksCompletedToday){
        this.tasksCompletedToday = tasksCompletedToday;
        this.calculateDailyTaskProgress();
    }

    public void setHabitsCompletedToday(int habitsCompletedToday){
        this.habitsCompletedToday = habitsCompletedToday;
        this.calculateDailyHabitProgress();
    }
    public void setDailyTaskProgress(double dailyTaskProgress){this.dailyTaskProgress = dailyTaskProgress;}
    public void setDailyHabitProgress(double dailyHabitProgress){this.dailyHabitProgress = dailyHabitProgress;}


    public void calculateDailyTaskProgress() {
        if(this.dailyTaskGoal > 0){
            this.setDailyTaskProgress(100.00 * (double) this.tasksCompletedToday / this.dailyTaskGoal);
        } else {
            this.setDailyTaskProgress(100.00);
        }
    }

    public void calculateDailyHabitProgress() {
        if(this.dailyHabitGoal > 0){
            this.setDailyHabitProgress(100.00 * (double) this.habitsCompletedToday / this.dailyHabitGoal);
        } else {
            this.setDailyHabitProgress(100.00);
        }
    }

    public void increaseDailyTaskGoal(){
        this.setDailyTaskGoal(this.dailyTaskGoal + 1);
        this.calculateDailyTaskProgress();
    }

    public void decreaseDailyTaskGoal(){
        if(this.dailyTaskGoal > 0){
            this.setDailyTaskGoal(this.dailyTaskGoal - 1);
            this.calculateDailyTaskProgress();
        }
    }

    public void increaseDailyHabitGoal(){
        this.setDailyHabitGoal(this.dailyHabitGoal + 1);
        this.calculateDailyHabitProgress();
    }

    public void decreaseDailyHabitGoal(){
        if(this.dailyHabitGoal > 0){
            this.setDailyHabitGoal(this.dailyHabitGoal - 1);
            this.calculateDailyHabitProgress();
        }
    }

}