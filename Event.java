//import java.util.ArrayList;

public class Event {
    private String name;
    private Location location; 
    private Period period;
    private Recurrence recurrence;
    //private ArrayList<User> participants = new ArrayList<>()

    public Event(String name, Location location, Period period, Recurrence recurrence){
        this.name = name;
        this.location = location;
        this.period = period;
        this.recurrence = recurrence;
    }

    /*
    public Event(String name, Location location, Period period, Recurrence recurrence, ArrayList<User> participants){
        this.name = name;
        this.location = location;
        this.period = period;
        this.recurrence = recurrence;
        this.participants = participants;
    }
    */

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

    /* 
    public ArrayList<User> getParticipants(){
        return this.participants;
    }
    */

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

    /*
    public void setParticipants(ArrayList<User> participants){
        this.participants = participants;
    }
    */

    //public void shareWhithFriend(User friend){}

    //public void shareWhithCommunity(Community community){}

    public boolean creatRecurrence(Recurrence recurrence){
        setRecurrence(recurrence);

        return true; //precisa ser booleano? precisa dessa função?
    }

    
}