import java.util.ArrayList;
import java.util.Calendar;

public class Calender { //essa classe é estática?
    private ArrayList<Event> events = new ArrayList<>();
    //private ArrayList<Task> tasks = new ArrayList<>();

    public ArrayList<Event> getEvents(){
        return this.events;
    }

    /*
    public ArrayList<Task> getTasks(){
        return this.events;
    }
    */

    public void addEvent(Event event){
        events.add(event);
         //precisa ser booleano a saida?
    }

    public void remoreEvent(Event event){
        events.remove(event);
    }

    /* 
    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remore(task);
    }
    */

    //public void blockCalender(){}
    //O que faz aqui?
    //Não aparece mais o calenderio para o usuário?

    private int firstDayYear(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1); 
        return calendar.get(Calendar.DAY_OF_WEEK);
        /*
         * 1: sunday
         * 2: monday
         * 3: tuesday
         * 4: wednesday
         * 5: thursaday
         * 6: friday
         * 7: saturday
         */
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
        //months with 31 days
        int[] month31Days = {1,3,5,7,8,10,12};
        //months with 30 days
        int[] month30Days = {4,6,9,11};
        //month 2: february with 28 or 29 days


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
        int firstDay = firstDayYear(year, month);
        System.out.println(firstDay);

        //leap year = true (29 days in february); = false (28 days in february)
        boolean leapYear = leapYear(year);

        //number of days in the month
        int daysMonth = calculeDaysMonth(month, leapYear);
        System.out.println(daysMonth);

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

    }   
    

    //public Event searchEvent(String name){}
    //getName();

    //public Task searchTask(String name){}
    //getName();

    //public void selectDay(){}

    //public void selectMonth(){}

    //public void selectEvent(Event event){}

    //public void selectTask(Task task){}

}