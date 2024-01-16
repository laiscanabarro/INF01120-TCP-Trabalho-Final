package content;

import java.time.LocalDate;
import java.util.ArrayList;

import user.User;
import utils.Period;
import utils.Recurrence;
import utils.Location;

public class Event {
    private String name;
    private Location location; 
    private Period period;
    private Recurrence recurrence;
    private ArrayList<User> participants = new ArrayList<>();

    public Event(String name, LocalDate date){
        this.name = name;
        this.period = new Period(date);
        this.participants = null;
    }

    public String getName(){
        return this.name;
    }

    public Location getLocation(){
        return this.location;
    }

    public Period getPeriod(){
        return this.period;
    }

    public Recurrence getRecurrence(){
        return this.recurrence;
    }

    public ArrayList<User> getParticipants(){
        return this.participants;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public void setPeriod(Period period){
        this.period = period;
    }

    public void setRecurrence(Recurrence recurrence){
        this.recurrence = recurrence;
    }

    public void setParticipants(ArrayList<User> participants){
        this.participants = participants;
    }
    
    public String displayParticipants() {
        StringBuilder resultBuilder = new StringBuilder();

        int numParticipants = participants.size();
        for (int i = 0; i < numParticipants; i++) {
            resultBuilder.append(participants.get(i));

            // Add a comma only if you are not the last participant
            if (i < numParticipants - 1) {
                resultBuilder.append(", ");
            }
        }

        return resultBuilder.toString();
    }   
    
    
    public void changeRecurrence(Recurrence recurrence, Period period) {
        switch(recurrence.toString()) {
            case "daily":
                dailyRecurrence(period);
                break;
            case "Weekday":
                weekdayRecurrence(period);
                break;
            case "Weekly":
                weeklyRecurrence(period);
                break;
            case "Monthly":
                monthlyRecurrence(period);
                break;
            case "Annually":
                annuallyRecurrence(period);
                break;

        }
    }
    
    private void dailyRecurrence(Period period) {
        long days = period.countDays();
        Schedule schedule;
        //só é possivel com eventos com duração 0
    }
    
    private void weekdayRecurrence(Period period) {
        Schedule schedule;
        //só é possivel com eventos com duração 0
    }
    
    private void weeklyRecurrence(Period period) {
        Schedule schedule;
    }
    
    private void monthlyRecurrence(Period period) {
        Schedule schedule;
    }
    
    private void annuallyRecurrence(Period period) {
        Schedule schedule;
    }
    
}