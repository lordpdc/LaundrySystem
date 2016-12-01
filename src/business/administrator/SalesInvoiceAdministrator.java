package business.administrator;

import business.entities.SaleInvoice;
import data.dao.SalesInvoiceDAO;

/**
 * Created by raoman on 29/11/2016.
 */
public class SalesInvoiceAdministrator extends DataAdministrator<SaleInvoice> {

    public SalesInvoiceAdministrator( ) {
        super();
        setAccessData( new SalesInvoiceDAO( ) );
    }

    @Override
    public void addNew( SaleInvoice saleInvoice ) {

    }

    @Override
    public void update( int id, SaleInvoice saleInvoice ) {

    }

    @Override
    public SaleInvoice search( String name ) {
        return null;
    }
}
