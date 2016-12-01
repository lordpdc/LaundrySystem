package business.Reports;

import business.administrator.PurchaseInvoiceAdministrator;
import business.administrator.SalesInvoiceAdministrator;

import java.util.List;

/**
 * Created by raoman on 19/11/2016.
 */
public class Accountant {
    private List salesBook;
    private List shoppingBook;

    public Accountant( ) {
        SalesInvoiceAdministrator salesAdministrator=new SalesInvoiceAdministrator();
        salesBook=salesAdministrator.getAllData();
        PurchaseInvoiceAdministrator purchasAdministrator=new PurchaseInvoiceAdministrator();
        shoppingBook=purchasAdministrator.getAllData();
         }

    public List getSalesBook( ) {

        return salesBook;
    }

    public List getShoppingBook( ) {
        return shoppingBook;
    }
    public Report getSalesReport(){
        return new Report();
    }



}
