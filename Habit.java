import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Habit {
    private String name;
    private String category;
    private Recurrence recurrence;
    private int minGoal;
    private int maxGoal;
    private boolean complete;
    private LocalDate lastCompletionDate;

    public Habit(String name, String category, Recurrence recurrence, int minGoal, int maxGoal) {
        this.name = name;
        this.category = category;
        this.recurrence = recurrence;
        this.minGoal = minGoal;
        this.maxGoal = maxGoal;
        this.complete = false;
        this.lastCompletionDate = null;
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
        this.lastCompletionDate = LocalDate.now();
    }

    public LocalDate getLastCompletionDate() {
        return lastCompletionDate;
    }

    public void setLastCompletionDate(LocalDate lastCompletionDate) {
        this.lastCompletionDate = lastCompletionDate;
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
}