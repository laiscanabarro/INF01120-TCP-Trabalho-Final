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

        return RecurrenceType.DAILY;
    }

    enum RecurrenceType {
        DAILY, WEEKDAY, WEEKLY, MONTHLY, ANNUALLY;
    }
}
