package business.Reports;

import business.utilities.DefaultValues;
import business.utilities.MsgErrorReport;

import java.sql.Date;

/**
 * Created by raoman on 01/12/2016.
 */
public class Period {
    protected Date initialDate;
    protected Date finalDate;

    public Period( ) {
        initialDate = DefaultValues.DATE;
        finalDate = DefaultValues.DATE;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) throws Exception {
        if (isValidInitialDate(initialDate)) {
            this.initialDate = initialDate;
        } else {
            throw new Exception( MsgErrorReport.msgInitialDateInvalid);
        }
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) throws Exception {
        if (isValidFinalDate(finalDate)) {
            this.finalDate = finalDate;
        } else {
            throw new Exception(MsgErrorReport.msgFinalDateInvalid);
        }
    }
    private boolean isValidInitialDate(Date date) {
        return date != null && date.before(finalDate);
    }

    private boolean isValidFinalDate(Date date) {
        return date != null && date.after(initialDate);
    }

    public boolean isDateIntoPeriod(Date date){
        return date.before( finalDate )&& date.after( initialDate );
    }
}