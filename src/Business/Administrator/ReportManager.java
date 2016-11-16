package Business.Administrator;

import Business.Entities.Report;
import Business.Utilities.DefaultValues;
import Business.Utilities.MsgErrorReport;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 11/11/2016.
 */
public abstract class ReportManager<T> {
    protected Date initialDate;
    protected Date finalDate;
    protected Report report;
    protected List< T > data;

    public void ReportManager() {
        initialDate = DefaultValues.DATE;
        finalDate = DefaultValues.DATE;
        report = DefaultValues.REPORT;
        data= DefaultValues.ARRAY_LIST;
    }

    public ReportManager( Date initialDate, Date finalDate ) throws Exception {
        setInitialDate( initialDate );
        setFinalDate( finalDate );
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) throws Exception {
        if (isValidInitialDate(initialDate)) {
            this.initialDate = initialDate;
        } else {
            throw new Exception(MsgErrorReport.msgInitialDateInvalid);
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

    public Report getReport() {
        return report;
    }

    public void generateReport() {
        fillData();
        filterData();
        fillReport();
    }
    abstract void fillData();
    abstract void filterData();
    abstract void fillReport();


    private boolean isValidInitialDate(Date date) {
        return date != null && date.before(finalDate);
    }

    private boolean isValidFinalDate(Date date) {
        return date != null && date.after(initialDate);
    }

    public boolean isDateWithinPeriod(Date date){
        return date.before( finalDate )&& date.after( initialDate );
    }
}
