package tests;

import business.administrator.PurchasesReportManager;

import java.sql.Date;

/**
 * Created by raoman on 09/10/2016.
 */
public class InvoicePurchaseTest {
    public static void main(String[] args) throws Exception {
        PurchasesReportManager report= new PurchasesReportManager(  );
        Date d = report.getInitialDate();
        d.setDate( 16 );
        //d.setMonth( 11 );
        report.setInitialDate( d );
        System.out.println(report.getInitialDate()+"\n"+report.getFinalDate() );
        //report.setInitialDate(  );

    }
}
