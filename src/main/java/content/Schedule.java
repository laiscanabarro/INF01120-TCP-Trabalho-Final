package content;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * Schedule
 * Class that stores a day's events and tasks
 */
public class Schedule {
    private ArrayList<Event> events;
    private ArrayList<Task> tasks;
    private LocalDate date;

    public Schedule (LocalDate date){
        this.date = date;
        this.events = new ArrayList<Event>();
        this.tasks = new ArrayList<Task>();
    }

    public LocalDate getDate(){
        return this.date;
    }
    
    public ArrayList<Event> getEvents(){
        return this.events;
    }

    public ArrayList<Task> getTasks(){
        return this.tasks;
    } 

    public void addEvent(Event event){
        events.add(event);
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeEvent(Event event){
        events.remove(event);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public boolean searchEvent(Event event){
        LocalDate start = event.getPeriod().getStartDate();
        long days = event.getPeriod().countDays();
        System.out.println(days);

        for (long i = 0; i <= days; i++){
             System.out.println(start.plusDays(i) + " " + this.date);
            if (start.plusDays(i).compareTo(this.date) == 0){
                return true;
            }
        }
        return false;
    } 

    public Object[][] displaySchedule(){
        int numEvents = events.size();
        int numTasks = tasks.size();
        int numRows = Math.max(numEvents, numTasks);

        Object[][] scheduleArray = new Object[numRows][2];

        for (int i = 0; i < numRows; i++) {
            if (i < numTasks) {
                scheduleArray[i][0] = tasks.get(i).getName();
            } else {
                scheduleArray[i][0] = null;  // Fill with null if there is no task
            }

            if (i < numEvents) {
                scheduleArray[i][1] = events.get(i).getName();
            } else {
                scheduleArray[i][1] = null;  // Fill with null if there is no event
            }
        }

        return scheduleArray;
    }
    
}