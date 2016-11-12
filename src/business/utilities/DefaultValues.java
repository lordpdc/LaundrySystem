package business.utilities;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by raoman on 21/09/2016.
 */
public class DefaultValues {
    public static final int INTEGER = 0;
    public static final String STRING = "";
    public static final double DOUBLE = 0;
    public static final Date DATE = null;
    public static final Object OBJECT = null;
    public static Date date(){
        return today();
    }
    private static Date today(){
        Calendar currentDay=Calendar.getInstance();
        Date today= new Date(currentDay.getTimeInMillis());
        return today;
    }

    
}
