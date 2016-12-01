package business.Reports;

import business.administrator.SaleInvoiceAdministrator;
import business.administrator.SalesInvoiceAdministrator;
import business.entities.Report;

import java.util.List;

/**
 * Created by raoman on 19/11/2016.
 */
public class Accountant {
    private List salesBook;
    private List shoppingBook;

    public Accountant( ) {
        SaleInvoiceAdministrator salesAdministrator=new SaleInvoiceAdministrator();

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
