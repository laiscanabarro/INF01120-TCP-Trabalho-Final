package content;

public class Recurrence {
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

        return RecurrenceType.UNDEFINED;
    }

    public enum RecurrenceType {
        UNDEFINED, DAILY, WEEKDAY, WEEKLY, MONTHLY, ANNUALLY;
    }
    
    public void changeRecurrence(RecurrenceType recurrence) {
        // Sets the selected recurrence to true and the others to false
        switch (recurrence) {
            case DAILY:
                setDaily(true);
                setOthersFalse(RecurrenceType.DAILY);
                break;
            case WEEKDAY:
                setWeekday(true);
                setOthersFalse(RecurrenceType.WEEKDAY);
                break;
            case WEEKLY:
                setWeekly(true);
                setOthersFalse(RecurrenceType.WEEKLY);
                break;
            case MONTHLY:
                setMonthly(true);
                setOthersFalse(RecurrenceType.MONTHLY);
                break;
            case ANNUALLY:
                setAnnually(true);
                setOthersFalse(RecurrenceType.ANNUALLY);
                break;
        }
    }

    private void setOthersFalse(RecurrenceType excludeRecurrence) {
        // Sets all other recurrences to false
        for (RecurrenceType recurrenceType : RecurrenceType.values()) {
            if (recurrenceType != excludeRecurrence) {
                changeToFalse(recurrenceType);
            }
        }
    }

    private void changeToFalse(RecurrenceType recurrence) {
        switch (recurrence) {
            case DAILY:
                setDaily(false);
                break;
            case WEEKDAY:
                setWeekday(false);
                break;
            case WEEKLY:
                setWeekly(false);
                break;
            case MONTHLY:
                setMonthly(false);
                break;
            case ANNUALLY:
                setAnnually(false);
                break;
            case UNDEFINED:
                break;
               
        }
    }

}
