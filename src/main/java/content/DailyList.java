package content;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DailyList extends TaskList {
    private static final DailyList DAILY_LIST;
    private static String dayOfWeek;
    private static Date currentDate;
    private static final Locale LOCALE = new Locale("pt_BR");

    private DailyList(){
        super();
        changeDay();
        super.setName("Today: " + getDayOfWeek());
    }

    static {
        DAILY_LIST = new DailyList();
    }
    public static DailyList getInstance() {
        return DAILY_LIST;
    }
    public static void setDayOfWeek(Date date, Locale locale) {
        DateFormat formatter = new SimpleDateFormat("EEEE", locale);
        dayOfWeek = formatter.format(date);
    }
    public static void setCurrentDate(){
        currentDate = new Date();
    }
    public static String getDayOfWeek(){ return dayOfWeek; }
    public static Date getCurrentDate() { return currentDate; }
    public static void changeDay(){
        setCurrentDate();
        setDayOfWeek(getCurrentDate(), LOCALE);
    }
}
