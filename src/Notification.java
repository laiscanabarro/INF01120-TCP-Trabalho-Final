package src;

import java.util.Date;

public class Notification {
    private String name;
    private Date date;
    private boolean ignore;

    public Notification(String name, Date date){
        this.name = name;
        this.date = date;
        this.ignore = false;
    }

    public String getName(){
        return this.name;
    }

    public Date getDate(){
        return this.date;
    }

    public boolean getIgnore(){
        return this.ignore;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setIgnore(boolean value){
        this.ignore = value;
    }

}