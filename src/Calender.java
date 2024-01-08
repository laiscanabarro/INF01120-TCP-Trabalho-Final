package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import content.Event;

public class Calender { 
    private ArrayList<Event> events; 
    private ArrayList<Task> tasks;
    private ArrayList<Schedule> schedules;

    public void addEvent(Event event){
        events.add(event);

        //filter the event date
        LocalDate start = event.getPeriod().getStartDate();
        LocalDate end = event.getPeriod().getEndDate();
        long days = event.getPeriod().countDays(start, end);

        for (int i = 0; i < days; i++){
            Schedule scheduleSearched = searchSchedule(start.plusDays(i));
            if (scheduleSearched != null){
                scheduleSearched.addEvent(event);
            }
            else{
                Schedule schedule = new Schedule(start.plusDays(i));
                schedule.addEvent(event);
            }
        }
    }

    public void removeEvent(Event event){
        events.remove(event);

        //filter the event date
        LocalDate start = event.getPeriod().getStartDate();
        LocalDate end = event.getPeriod().getEndDate();
        long days = event.getPeriod().countDays(start, end);

        for (int i = 0; i < days; i++){
            Schedule schedule = searchSchedule(start.plusDays(i));
            if (schedule != null){
                schedule.getEvents().remove(event);
            }
        }

    }

    public void addTask(Task task){
        tasks.add(task);

        Schedule schedule = searchSchedule(task.getDeadline());
        if (schedule != null){
            schedule.addTask(task);
        }
        else {
            Schedule schedule = new Schedule(start.plusDays(i));
            schedule.addTask(task);
        }

    }

    public void removeTask(Task task){
        tasks.remore(task);

        Schedule schedule = searchSchedule(task.getDeadline());
        if (schedule != null){
            schedule.removeTask(task);
        }
        
    }
    
    public void blockCalender(){
        displayCalender(0, 0);
    }

    private int calculeFirstDayMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1); 

        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    private boolean leapYear(int year){
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        } else {
            return false;
        }
    }

    private boolean contains(int[] array, int value){
        for (int item : array) {
            if (item == value) {
                return true;
            }
        }
        return false;
    }

    private int calculeDaysMonth(int month, boolean leapYear){
        int daysMonth;
        int[] month31Days = {1,3,5,7,8,10,12};
        int[] month30Days = {4,6,9,11};

        if (contains(month31Days, month)){
            daysMonth = 31;
        } 
        else if (contains(month30Days, month)){
            daysMonth = 30;
        }
        else if (leapYear){
            daysMonth = 29;
        }
        else {
            daysMonth = 28;
        }

        return daysMonth;
    }

    public void displayCalender(int year, int month){
        //first day of the year
        int firstDay = calculeFirstDayMonth(year, month);
        //System.out.println(firstDay);

        //leap year = true (29 days in february); = false (28 days in february)
        boolean leapYear = leapYear(year);

        //number of days in the month
        int daysMonth = calculeDaysMonth(month, leapYear);
        //System.out.println(daysMonth);

        if (year == 0){ //block calender
            return;
        }

        System.out.printf("        %d/%d \n", month, year);
        System.out.println(" S  M  T  W  T  F  S");

        for (int i = 1; i <= (daysMonth + firstDay - 1); i++){
            if (i >= firstDay){
                System.out.printf("%2d ", (i - firstDay + 1));
            } 
            else {
                System.out.print("   ");
            }

            if (i % 7 == 0){
                System.out.println();
            }
        }
        System.out.println();

    }   

    public Schedule searchSchedule(LocalDate date){
        for (Schedule schedule : schedules){
            if(schedule.getDate().equals(date)){
                return schedule;
            }
        }
        return null;
    }
    
    public Event searchEvent(String name){
        for (Event event : events){
            if(event.getName().equals(name)){
                return event;
            }
        }
        return null;
    }

    
    public Task searchTask(String name){
        for (Task task : tasks){
            if(task.getName().equals(name)){
                return task;
            }
        }
        return null;
    }
    

    //public void selectDay(){}

    //public void selectMonth(){}

    //public void selectEvent(Event event){}

    //public void selectTask(Task task){}

}