package content;

import java.time.LocalDate;
import java.util.ArrayList;
import utils.Period;

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
        this.events = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }
    
    public Schedule (LocalDate date, Event event){
        this.date = date;
        this.events = new ArrayList<>();
        this.events.add(event);
        this.tasks = new ArrayList<>();
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
        if (searchEvent(event)) {
            System.out.println(event.getName());
            events.remove(event);
        }
    }

    public void removeTask(Task task){
        if (searchTask(task)) {
           tasks.remove(task); 
        }
    }

    public boolean searchEvent(Event eventSearched){
        if (events.isEmpty()){
            return false;
        }
        
        for (Event event : events){
            if(eventSearched.equals(event)){
                return true;
            }
        }
        return false;
    } 
    
    public boolean searchTask(Task taskSearched){
        if (tasks.isEmpty()){
            return false;
        }
        
        for (Task task : tasks){
            if(taskSearched.equals(task)){
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

    public Object[][] scheduleObjects(){
        int numEvents = events.size();
        int numTasks = tasks.size();
        int numRows = Math.max(numEvents, numTasks);

        Object[][] scheduleArray = new Object[numRows][2];

        for (int i = 0; i < numRows; i++) {
            if (i < numTasks) {
                scheduleArray[i][0] = tasks.get(i);
            } else {
                scheduleArray[i][0] = null;  
            }

            if (i < numEvents) {
                scheduleArray[i][1] = events.get(i);
            } else {
                scheduleArray[i][1] = null; 
            }
        }

        return scheduleArray;
    }
    
}