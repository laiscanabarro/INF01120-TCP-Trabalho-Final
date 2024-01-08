package test;

import src.*;
import java.time.LocalDate;
import java.time.LocalTime;

import content.Event;
import content.Location;
import content.Period;
import content.Recurrence;

public class TestSchedule {
    public static void main(String args[]){

        Location location = new Location("Porto Alegre", "Brazil", "RS", "Maua", 123);

        LocalDate startDate = LocalDate.of(2023, 12, 13);
        LocalDate endDate = LocalDate.now();
        LocalTime startTime = LocalTime.of(12, 0);
        LocalTime endTime = LocalTime.of(12, 30);
        Period time = new Period(startDate, endDate, startTime, endTime);

        Recurrence recurrence = new Recurrence();

        Event e1 = new Event("Viagem", location, time, recurrence);
        LocalDate date = LocalDate.now();

        Schedule today = new Schedule(date);

        if (today.searchEvent(e1)){
            System.out.println("oi");
        }
        else {
            System.out.println("tchau");
        }





    }
}