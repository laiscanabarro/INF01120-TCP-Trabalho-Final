package content;

import java.time.LocalDate;

public class Notification {
    private String name;
    private LocalDate date;
    private boolean ignore;

    public Notification(String name){
        this.name = name;
        this.date = LocalDate.now();
        this.ignore = false;
    }

    public Notification(String name, LocalDate date){
        this.name = name;
        this.date = date;
        this.ignore = false;
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public boolean getIgnore(){
        return this.ignore;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setIgnore(boolean value){
        this.ignore = value;
    }
}