package utils;

import content.Calendar;
import content.Event;
import content.Schedule;
import java.io.Serializable;
import java.time.LocalDate;

public class Recurrence implements Serializable{
    private boolean daily;
    private boolean weekday;
    private boolean weekly;
    private boolean monthly;
    private boolean annually;
    private boolean custom;

    public Recurrence(){
        this.daily = false;
        this.weekday = false;
        this.weekly = false;
        this.monthly = false;
        this.annually = false;
        this.custom = false;
    }

    public Recurrence(RecurrenceType recurrenceType) {
        this();
        switch (recurrenceType) {
            case DAILY:
                setDaily(true);
                break;
            case WEEKDAY:
                setWeekday(true);
                break;
            case WEEKLY:
                setWeekly(true);
                break;
            case MONTHLY:
                setMonthly(true);
                break;
            case ANNUALLY:
                setAnnually(true);
                break;
        }
    }

    public boolean getDaily(){
        return this.daily;
    }
    
    public boolean getWeekday(){
        return this.weekday;
    }

    public boolean getWeekly(){
        return this.weekly;
    }

    public boolean getMonthly(){
        return this.monthly;
    }

    public boolean getAnnualy(){
        return this.annually;
    }

    public boolean getCustom(){
        return this.custom;
    }

    public void setDaily(boolean daily){
        this.daily = daily;
    }

    public void setWeekday(boolean weekday){
        this.weekday = weekday;
    }

    public void setWeekly(boolean weekly){
        this.weekly = weekly;
    }

    public void setMonthly(boolean monthly){
        this.monthly = monthly;
    }

    public void setAnnually(boolean annually){
        this.annually = annually;
    }

    public void setCustom(boolean custom){
        this.custom = custom;
    }

    public RecurrenceType getRecurrenceType() {
        if (getDaily()) {
            return RecurrenceType.DAILY;
        } 
        else if (getWeekday()) {
            return RecurrenceType.WEEKDAY;
        } 
        else if (getWeekly()) {
            return RecurrenceType.WEEKLY;
        } 
        else if (getMonthly()) {
            return RecurrenceType.MONTHLY;
        } 
        else if (getAnnualy()) {
            return RecurrenceType.ANNUALLY;
        }

        return RecurrenceType.DAILY;
    }
    
    public boolean verifyRecurrence() {
        if (getDaily() || getWeekday() || getWeekly() || getMonthly() || getAnnualy()) {
            return true;
        }
        return false;
    }

    public enum RecurrenceType {
        DAILY, WEEKDAY, WEEKLY, MONTHLY, ANNUALLY;
    }

    public String toString() {
        if (getDaily()) {
            return "Daily";
        } else if (getWeekday()) {
            return "Weekday";
        } else if (getWeekly()) {
            return "Weekly";
        } else if (getMonthly()) {
            return "Monthly";
        } else if (getAnnualy()) {
            return "Annually";
        } else {
            return "Custom";
        }
    }
    
    public void changeRecurrence(RecurrenceType recurrence, Calendar calendar, Event event) {
        // Sets the selected recurrence to true and the others to false
        switch (recurrence) {
            case DAILY:
                setDaily(true); 
                calendar.getRecurrenceList().addDaily(event);
                setOthersFalse(RecurrenceType.DAILY, calendar, event);
                break;
            case WEEKDAY:
                setWeekday(true);
                calendar.getRecurrenceList().addWeekday(event);
                setOthersFalse(RecurrenceType.WEEKDAY, calendar, event);
                break;
            case WEEKLY:
                setWeekly(true);
                calendar.getRecurrenceList().addWeekly(event);
                setOthersFalse(RecurrenceType.WEEKLY, calendar, event);
                break;
            case MONTHLY:
                setMonthly(true);
                calendar.getRecurrenceList().addMonthly(event);
                setOthersFalse(RecurrenceType.MONTHLY, calendar, event);
                break;
            case ANNUALLY:
                setAnnually(true);
                calendar.getRecurrenceList().addAnnually(event);
                setOthersFalse(RecurrenceType.ANNUALLY, calendar, event);
                break;
        }
    }

    private void setOthersFalse(RecurrenceType excludeRecurrence, Calendar calendar, Event event) {
        // Sets all other recurrences to false
        for (RecurrenceType recurrenceType : RecurrenceType.values()) {
            if (recurrenceType != excludeRecurrence) {
                changeToFalse(recurrenceType, calendar, event);
            }
        }
    }

    private void changeToFalse(RecurrenceType recurrence, Calendar calendar, Event event) {
        switch (recurrence) {
            case DAILY:
                setDaily(false);
                calendar.getRecurrenceList().removeDaily(event);
                break;
            case WEEKDAY:
                setWeekday(false);
                calendar.getRecurrenceList().removeWeekday(event);
                break;
            case WEEKLY:
                setWeekly(false);
                calendar.getRecurrenceList().removeWeekly(event);
                break;
            case MONTHLY:
                setMonthly(false);
                calendar.getRecurrenceList().removeMonthly(event);
                break;
            case ANNUALLY:
                setAnnually(false);
                calendar.getRecurrenceList().removeAnnually(event);
                break;
               
        }
    }
    
    public void clear(Calendar calendar, Event event) {
        changeToFalse(RecurrenceType.DAILY, calendar, event);
        changeToFalse(RecurrenceType.WEEKDAY, calendar, event);
        changeToFalse(RecurrenceType.WEEKLY, calendar, event);
        changeToFalse(RecurrenceType.MONTHLY, calendar, event);
        changeToFalse(RecurrenceType.ANNUALLY, calendar, event);    
    }   
}
