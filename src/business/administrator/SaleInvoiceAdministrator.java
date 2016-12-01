package business.administrator;

import business.entities.SaleInvoice;
import data.dao.SalesInvoiceDAO;

/**
 * Created by raoman on 29/11/2016.
 */
public class SaleInvoiceAdministrator extends DataAdministrator<SaleInvoice> {

    public SaleInvoiceAdministrator( ) {
        setAccessData( new SalesInvoiceDAO( ) );
    }

}
