package content;

import java.time.LocalDate;
import java.util.ArrayList;
import utils.RecurrenceList;

public class Calendar { 
    private ArrayList<Event> events;  
    private ArrayList<Task> tasks;
    private ArrayList<TaskList> taskLists;
    private ArrayList<Schedule> schedules;
    private RecurrenceList recurrenceList;
    private TaskList undefinedList;

    public Calendar(ArrayList<TaskList> taskLists){
        this.events = new ArrayList<>();  
        this.taskLists = taskLists;
        this.schedules = new ArrayList<>();
        this.tasks = getTasks();
        this.recurrenceList = new RecurrenceList();
        this.undefinedList = new TaskList();
    }

    public ArrayList<Event> getEvents(){
        return this.events;
    }

    public ArrayList<Task> getTasks(){
        ArrayList<Task> allTasks = new ArrayList<>();
        int numLists = this.taskLists.size();
        for (int i = 0; i < numLists; i++){
            ArrayList<Task> newTasks = taskLists.get(i).getTasks();
            int numTasks = newTasks.size();
            for (int j = 0; j < numTasks; j++){
                allTasks.add(newTasks.get(j));
            }
        }
        return allTasks;
    }

    public ArrayList<Schedule> getSchedules(){
        return this.schedules;
    }

    public RecurrenceList getRecurrenceList() {
        return this.recurrenceList;
    }
    
    public TaskList getUndefinedList() {
        undefinedList.setName("Undefined");
        return this.undefinedList;
    }
    
    public void addSchedule(Schedule schedule){
        schedules.add(schedule);
    }

    public void addEvent(Event event){
        events.add(event);

        //filter the event date
        LocalDate start = event.getPeriod().getStartDate();
        long days = event.getPeriod().countDays();

        for (int i = 0; i <= days; i++){
            Schedule scheduleSearched = searchSchedule(start.plusDays(i));
            scheduleSearched.addEvent(event);
        }
    }

    public void addTask(Task task){
        if (task.getDeadline() != null) {
            tasks.add(task);
            Schedule schedule = searchSchedule(task.getDeadline());
            schedule.addTask(task);
        }
    }

    public void removeEvent(Event event){
        events.remove(event);
     
        int numSchedule = schedules.size();
        for (int i = 0; i < numSchedule; i++){
           schedules.get(i).removeEvent(event);
            
        }

    }

    public void removeTask(Task task){
        tasks.remove(task);
        Schedule schedule = searchSchedule(task.getDeadline());
        schedule.removeTask(task);
    }

    public void clearTaskList(TaskList taskList){
        int numTasks = taskList.getTasks().size();
        for(int i = 0; i < numTasks; i++){
            Task task = taskList.getTasks().get(i);
            removeTask(task);
        }
    }

    public Schedule searchSchedule(LocalDate date){
        for (Schedule schedule : schedules){
            if(schedule.getDate().equals(date)){
                recurrenceList.updateSchedule(schedule);
                return schedule;
            }
        }
        Schedule newSchedule = new Schedule(date);
        recurrenceList.updateSchedule(newSchedule);
        addSchedule(newSchedule);
        return newSchedule;
    }

    public Event searchEvent(Object event){
        if (events.isEmpty()){
            return null;
        }

        for (Event eventFound : events){
            if(eventFound.equals(event)){
                return eventFound;
            }
        }
        return null;
    }

    public Task searchTask(Object task){
        if (tasks.isEmpty()){
            return null;
        }

        for (Task taskFound : tasks){
            if(taskFound.equals(task)){
                return taskFound;
            }
        }
        return null;
    }
    
    public void blockCalendar(){
        LocalDate date = LocalDate.of(0, 0, 0);
        displayCalendar(date);
    }

    private int calculateFirstDayOfMonth(int year, int month) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);

        return firstDayOfMonth.getDayOfWeek().getValue();
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

    private int calculateDaysInMonth(int month, boolean leapYear){
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

    public Object[][] displayCalendar(LocalDate date) {
        int firstDay = calculateFirstDayOfMonth(date.getYear(), date.getMonthValue());

        boolean leapYear = leapYear(date.getYear()); //leap year = true (29 days in february); = false (28 days in february)
        int daysMonth = calculateDaysInMonth(date.getMonthValue(), leapYear);
        
        int numRows = 6;
        int numCols = 7;

        Object[][] calendarData = new Object[numRows][numCols];

        // Block calender
        if (date.getYear() == 0) {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    calendarData[i][j] = null;
                }
            }
            return calendarData;
        }
        
        int row = 0;
        int col = 0;

        for (int i = 1; i <= (daysMonth + firstDay); i++) {

            if (i >= firstDay + 1) {
                calendarData[row][col] = (i - firstDay);
            } else {
                calendarData[row][col] = null;
            }
            col++;
            
            if (i % 7 == 0) {
                col = 0;
                row++;
            }
        }

        return calendarData;
    }
    
    public int displayDay(int col, int row, Object[][] calendar){
        int numRows = calendar.length;
        int numCols = calendar[0].length;

        if (row >= 0 && row < numRows && col >= 0 && col < numCols) {
            Object value = calendar[row][col];

            if (value instanceof Integer integer) {
                return integer;
            }
                
        }  
        
        return -1;
        
    }  
    
    public int[] displaySelected(int day, Object[][] calendar) {
        int numRows = calendar.length;
        int numCols = calendar[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Object value = calendar[i][j];

                if (value instanceof Integer && (Integer) value == day) {
                    // Day value was found, return position (i, j)
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
    
    public String displayMonthYear(LocalDate date) {
        String monthYear = date.getMonth() + " " + date.getYear();
        
        return monthYear;
    }

}