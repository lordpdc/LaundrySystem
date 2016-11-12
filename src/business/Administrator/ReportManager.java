package business.Administrator;

import business.entities.Report;
import business.utilities.DefaultValues;
import business.utilities.MsgErrorReport;

import java.sql.Date;

/**
 * Created by raoman on 11/11/2016.
 */
public class ReportManager {
    private Date initialDate;
    private Date finalDate;
    private Report report;

    private static ReportManager reportManager;

    public static ReportManager presentManager(){
        if(reportManager==null){
            reportManager=new ReportManager();
        }
        return reportManager;
    }

    private void ReportManager(){
        initialDate= DefaultValues.date();
        finalDate=DefaultValues.date();
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) throws Exception {

        if(isValidInitialDate(initialDate)){
            this.initialDate = initialDate;
        }
        else{
            throw new Exception(MsgErrorReport.msgInitialDateInvalid);
        }

    }
    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate)  throws Exception{
        if(isValidFinalDate(finalDate)){
            this.finalDate = finalDate;
        }
        else{
            throw new Exception(MsgErrorReport.msgFinalDateInvalid);
        }

    }
    public Report getReport(){
        return report;
    }
    public void generateReport(){


    }




    private boolean isValidInitialDate(Date date){
        return date!=null && date.before(finalDate);
    }
    private boolean isValidFinalDate(Date date){
        return date!=null && date.after(initialDate);
    }
}
