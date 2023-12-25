import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import utils.TasksUtils;

public class DailyList extends TaskList {
    private static final DailyList dailyList;
    private static String dayOfWeek;
    private static Date currentDate;
    private DailyList(){
        changeDay();
    }

    static {
        dailyList = new DailyList();
    }
    public static DailyList getInstance() {
        return dailyList;
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
        setDayOfWeek(getCurrentDate(), TasksUtils.LOCALE);
        getInstance().setName("Today: " + getDayOfWeek());
    }
}
