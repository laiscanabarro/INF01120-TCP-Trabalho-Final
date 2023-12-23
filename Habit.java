public class Habit {
    private String name;
    private String category;
    private Recurrence recurrence;
    private int minGoal;
    private int maxGoal;
    private boolean complete;
    
    public Habit(String name, String category, Recurrence recurrence, int minGoal, int maxGoal) {
        this.name = name;
        this.category = category;
        this.recurrence = recurrence;
        this.minGoal = minGoal;
        this.maxGoal = maxGoal;
        this.complete = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
    }

    public int getMinGoal() {
        return minGoal;
    }

    public void setMinGoal(int minGoal) {
        this.minGoal = minGoal;
    }

    public int getMaxGoal() {
        return maxGoal;
    }

    public void setMaxGoal(int maxGoal) {
        this.maxGoal = maxGoal;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void markComplete() {
        this.complete = true;
    }
}