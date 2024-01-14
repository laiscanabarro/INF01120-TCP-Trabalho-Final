package content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class HabitsList implements Serializable{
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

    private void habitOrderByLetter(){
        habits.sort(Comparator.comparing(Habit::getName));
    }

    private void habitOrderByCategory(){
        habits.sort(Comparator.comparing(Habit::getCategory));
    }

    private void habitOrderByGoal(boolean isAsc){
        if (isAsc){
            habits.sort(Comparator.comparingInt(Habit::getGoal));
        } else {
            habits.sort(Comparator.comparingInt(Habit::getGoal).reversed());
        }
    }

    public void habitChangeOrder(String orderBy) {
        switch (orderBy) {
            case "goalAscending":
                habitOrderByGoal(true);
                break;
            case "goalDescending":
                habitOrderByGoal(false);
                break;
            case "name":
                habitOrderByLetter();
                break;
            case "category":
                habitOrderByCategory();
                break;
            default:
                setHabits(habits);
                break;
        }
    }
}
