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
    private List<PurchaseInvoice> purchaseBook;
    private List<SaleInvoice> salesBook;

    public Accountant( ) {
        SalesInvoiceAdministrator salesAdministrator = new SalesInvoiceAdministrator( );
        salesBook = salesAdministrator.getAllData( );
        PurchaseInvoiceAdministrator purchasAdministrator = new PurchaseInvoiceAdministrator( );
        purchaseBook = purchasAdministrator.getAllData( );
    }

    public List< PurchaseInvoice > getPurchaseBook( ) {
        return purchaseBook;
    }

    public List< SaleInvoice > getSalesBook( ) {
        return salesBook;
    }
    public Report getSalesReport(Period period){
        SalesReportGenerator generatorSalesReport=new SalesReportGenerator(period) ;
        return generatorSalesReport.createSalesReport();
    }
}

