package business.Reports;

import business.utilities.DefaultValues;
import business.utilities.MsgErrorReport;

import java.sql.Date;
import java.util.List;

/**
 * Created by raoman on 11/11/2016.
 */
public abstract class ReportGenerator<T> {
    protected Period period;
    protected Report report;

    public ReportGenerator() {
        period=new Period();
        report = DefaultValues.REPORT;
    }

    public ReportGenerator( Period period ) {
        super();
        this.period=period;
    }

    public  Report getReport() {
        generateReport();
        return report;
    }

    private  void generateReport() {
        fillData();
        filterData();
        fillReport();
    }
    abstract void fillData();
    abstract void filterData();
    abstract void fillReport();



}
