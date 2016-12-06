package business.utilities;

import business.Reports.Report;

import java.sql.Date;
import java.util.*;

/**
 * Created by raoman on 21/09/2016.
 */
public class DefaultValues {
    public static final int INTEGER = 0;
    public static final String STRING = "";
    public static final double DOUBLE = 0;
    public static final Date DATE = today();


    private static Date today(){
        Calendar currentDay=Calendar.getInstance();
        Date today= new Date(currentDay.getTimeInMillis());
        return today;
    }

    
}
