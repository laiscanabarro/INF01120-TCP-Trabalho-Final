import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TestCalender {

    public static void main(String args[]){

        ArrayList<Event> events = new ArrayList<>();
        Location location = new Location("Porto Alegre", "Brazil", "RS", "Maua", 123);

        LocalDate startDate = LocalDate.of(2023, 12, 13);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        LocalTime startTime = LocalTime.of(12, 0);
        LocalTime endTime = LocalTime.of(12, 30);
        Period time = new Period(startDate, endDate, startTime, endTime);

        Recurrence recurrence = new Recurrence();

        Event e1 = new Event("Viagem", location, time, recurrence);

        events.add(e1);

        Calender c1 = new Calender();

        c1.displayCalender(1964, 12);
    }

}