import java.util.ArrayList;

public class Calender {
    private ArrayList<Event> events = new ArrayList<>();
    //private ArrayList<Task> tasks = new ArrayList<>();

    public boolean addEvent(Event event){
        events.add(event);

        return true; //precisa ser booleano?
    }

    //public boolean addTask(Task task){}

    //public void blockCalender(){}

    //public void displayCalender(){}

    //public Event searchEvent(String name){}

    //public void selectDay(){}

    //public void selectMonth(){}

    //public void selectEvent(Event event){}

    //public void selectTask(Task task){}

}