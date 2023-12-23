import java.util.ArrayList;

public class HabitsList {
    private ArrayList<Habit> habits;
    private String category;

    public HabitsList(String category) {
        this.habits = new ArrayList<>();
        this.category = category;
    }

    public ArrayList<Habit> getHabits() {
        return habits;
    }

    public void setHabits(ArrayList<Habit> habits) {
        this.habits = habits;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean clearList() {
        try {
            habits.clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void displayHabits() {
        for(Habit habit : habits) {
            // display habits info
        }
    }

    public Habit searchHabit(String name) {
        for(Habit habit : habits) {
            if(habit.getName().equals(name)) {
                return habit;
            }
        }
        return null;
    }

    public boolean addHabit(Habit habit) {
        if (searchHabit(habit.getName()) == null) {
            habits.add(habit);
            return true;
        } 
        else {
            return false;
        }
    }

    public boolean removeHabit(String name) {
        Habit habitToRemove = searchHabit(name);
        
        if (habitToRemove != null) {
            habits.remove(habitToRemove);
            return true;
        }
        return false;
    }

    public void selectHabit(Habit habit) {

    }
}
