package content;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Habit {
    private String name;
    private String category;
    private Recurrence recurrence;
    private int goal;
    private int completionCount;
    private boolean complete;
    private LocalDate lastCompletionDate;
    private LocalDate prevLastCompletionDate;

    public Habit(String name, String category, Recurrence recurrence, int goal) {
        this.name = name;
        this.category = category;
        this.recurrence = recurrence;
        this.goal = goal;
        this.complete = false;
        this.lastCompletionDate = null;
        this.prevLastCompletionDate = null;
        this.completionCount = 0;
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

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }

    public void markComplete() {
        if(!complete){
            complete = true;
            prevLastCompletionDate = lastCompletionDate;
            lastCompletionDate = LocalDate.now();
            completionCount++;
        }
    }

    public void markIncomplete() {
        if(complete){
            complete = false;
            lastCompletionDate = prevLastCompletionDate;
            if(completionCount > 0){
                completionCount--;
            }
        }
    }

    public LocalDate getLastCompletionDate() {
        return lastCompletionDate;
    }

    public void setLastCompletionDate(LocalDate lastCompletionDate) {
        this.lastCompletionDate = lastCompletionDate;
    }

    public int getCompletionCount() {
        return completionCount;
    }

    public void setCompletionCount(int completionCount) {
        this.completionCount = completionCount;
    }

    public LocalDate getPrevLastCompletionDate() {
        return prevLastCompletionDate;
    }

    public void setPrevLastCompletionDate(LocalDate prevLastCompletionDate) {
        this.prevLastCompletionDate = prevLastCompletionDate;
    }

    public void checkCompletion() {
        if (lastCompletionDate != null) {
            LocalDate currentDate = LocalDate.now();
            boolean shouldUnmark = false;
    
            switch (recurrence.getRecurrenceType()) {
                case DAILY:
                    shouldUnmark = !currentDate.isEqual(lastCompletionDate);
                    break;
                case WEEKDAY:
                    int dayOfWeek = currentDate.getDayOfWeek().getValue();
                    shouldUnmark = !currentDate.isEqual(lastCompletionDate) && dayOfWeek >= 1 && dayOfWeek <= 5;
                    break;
                case WEEKLY:
                    long daysBetween = ChronoUnit.DAYS.between(lastCompletionDate, currentDate);
                    shouldUnmark = daysBetween >= 7;
                    break;
                case MONTHLY:
                    long daysBetweenMonthly = ChronoUnit.DAYS.between(lastCompletionDate, currentDate);
                    shouldUnmark = daysBetweenMonthly >= 30;
                    break;
                case ANNUALLY:
                    long daysBetweenAnnually = ChronoUnit.DAYS.between(lastCompletionDate, currentDate);
                    shouldUnmark = daysBetweenAnnually >= 365;
                    break;
            }
    
            if (shouldUnmark) {
                setComplete(false);
            }
        }
    }

    public double getProgress() {
        if (goal > 0) {
            return ((double) completionCount / goal) * 100;
        } 
        else {
            return 0;
        }
    }
}