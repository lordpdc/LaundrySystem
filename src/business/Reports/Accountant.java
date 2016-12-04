package business.Reports;

import business.administrator.PurchaseInvoiceAdministrator;
import business.administrator.SalesInvoiceAdministrator;
import business.utilities.DefaultValues;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 19/11/2016.
 */
public class Accountant {/*
    private List salesBook;
    private List purchasesBook;

    public Accountant( ) {
        SalesInvoiceAdministrator salesAdministrator=new SalesInvoiceAdministrator();
        salesBook=salesAdministrator.getAllData();
        PurchaseInvoiceAdministrator purchasAdministrator=new PurchaseInvoiceAdministrator();
        purchasesBook =purchasAdministrator.getAllData();
         }

    public List getSalesBook( ) {
        return salesBook;
    }

    public List getPurchasesBook(Period period ) {
        return purchasesBook;
    }

    public Report getSalesReport(Period period){
        List salesForReport=filterBook( period,salesBook );
        double totalOfReport=calculeTotals( salesForReport );
        //ReportGenerator reportGenerator=new ReportGenerator( );

        return new Report();
    }

    private List filterBook(Period period,List<Invoice> contableBook){
        List bookFiltered=new ArrayList(  );
        for(Invoice invoice: contableBook ){
            Date dateInvoice=invoice.getDate();
            if(period.isDateIntoPeriod( dateInvoice )){
                bookFiltered.add( invoice );
            }
        }
        return bookFiltered;
    }
    private double calculeTotals(List<Invoice> listInvoiceForReport){
        Double totalCalculated= DefaultValues.DOUBLE;
        for( Invoice invoice:listInvoiceForReport ){
            totalCalculated+=totalCalculated+invoice.getTotalPrice();
        }
        return totalCalculated;
    }
*/


}
