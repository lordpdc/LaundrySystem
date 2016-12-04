package business.Reports;

import business.administrator.PurchaseInvoiceAdministrator;
import business.administrator.SalesInvoiceAdministrator;
import business.entities.PurchaseInvoice;
import business.entities.SaleInvoice;

import java.util.List;

/**
 * Created by raoman on 19/11/2016.
 */
public class Accountant {

    public Accountant( ) {
       }

    public Report getSalesReport(Period period){
        SalesReportGenerator generatorSalesReport=new SalesReportGenerator(period) ;
        return generatorSalesReport.createSalesReport();
    }

}

