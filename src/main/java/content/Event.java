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
    private ArrayList<User> participants;

    public Event(String name, LocalDate date){
        this.name = name;
        this.period = new Period(date);
        this.participants = new ArrayList<>();
        this.recurrence = new Recurrence();
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

    public void setParticipants(ArrayList<User> participants){
        this.participants = participants;
    }

    public void addParticipant(User user){
        if (!(searchParticipant(user))) {
            participants.add(user);
        }
    }

    public void removeParticipant(User user){
        if (searchParticipant(user)) {
            participants.remove(user);
        }
    }

    public boolean searchParticipant(User user){
        if (participants.isEmpty()) {
            return false;
        }

        
        for (User participant : participants) {
            if(participant.equals(user)) {
                return true;
            }
        }
        return false;
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
    
}