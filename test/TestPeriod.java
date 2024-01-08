package test;

import java.time.LocalDate;

import content.Period;

public class TestPeriod {

    public static void main(String args[]){

        LocalDate start = LocalDate.of(2023, 12, 13);
        LocalDate end = LocalDate.of(2023, 12, 18);
        Period p1 = new Period(start, end);

        System.out.println(p1.countDays(start, end));

    }
}