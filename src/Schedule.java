package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import content.Event;

public class Schedule {
    private ArrayList<Event> events;
    private ArrayList<Task> tasks;
    private LocalDate date;

    public Schedule (LocalDate date){
        this.date = date;
        this. events = new ArrayList<Event>();
        this.tasks = new ArrayList<Task>();
    }

    public LocalDate getDate(){
        return this.date;
    }
    
    public ArrayList<Event> getEvents(){
        return this.events;
    }

    public Array<Task> getTasks(){
        return this.tasks;
    } 

    public void addEvent(Event event){
        events.add(event);
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public boolean searchEvent(Event event){
        LocalDate start = event.getPeriod().getStartDate();
        LocalDate end = event.getPeriod().getEndDate();
        long days = event.getPeriod().countDays(start, end);
        System.out.println(days);

        for (long i = 0; i <= days; i++){
             System.out.println(start.plusDays(i) + " " + this.date);
            if (start.plusDays(i).compareTo(this.date) == 0){
                return true;
            }
        }
        return false;
    }

    public void displaySchedule(){
        int numEvents = events.size();
        for (int i = 0; i < numEvents; i++){
            System.out.println(events.get(i));
        }

        int numTasks = tasks.size();
        for (int i = 0; i < numTasks; i++){
            System.out.println(tasks.get(i));
        }
    }


    
    





    


}