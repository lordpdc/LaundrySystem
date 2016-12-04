package business.Reports;

import business.utilities.DefaultValues;
import business.utilities.MsgErrorReport;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 11/11/2016.
 */
public abstract class ReportGenerator<T> {
    protected List<T> dataForReport;
    private Period period;

    public ReportGenerator() {
        dataForReport=new ArrayList< T >(  );
        period=new Period();
    }

    public Period getPeriod( ) {
        return period;
    }

    public void setPeriod( Period period ) {
        this.period = period;
        //updateData();
    }


}
