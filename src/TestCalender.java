package src;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestCalender {

    public static void main(String args[]){

        Location location = new Location("Porto Alegre", "Brazil", "RS", "Maua", 123);

        LocalDate startDate = LocalDate.of(2023, 12, 13);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        LocalTime startTime = LocalTime.of(12, 0);
        LocalTime endTime = LocalTime.of(12, 30);
        Period time = new Period(startDate, endDate, startTime, endTime);

        Recurrence recurrence = new Recurrence();

        Event e1 = new Event("Viagem", location, time, recurrence);

        Calender c1 = new Calender();
        c1.addEvent(e1);

        c1.blockCalender();
        c1.displayCalender(2002,12);
        System.out.println(c1.searchEvent("Viagem").getLocation().getCity());

    }
}