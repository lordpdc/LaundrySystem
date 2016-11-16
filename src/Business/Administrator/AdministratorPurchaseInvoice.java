package Business.Administrator;

import Business.Entities.PurchaseInvoice;
import data.dao.PurchaseInvoiceDAO;

/**
 * Created by raoman on 16/11/2016.
 */
public class AdministratorPurchaseInvoice extends Administrator<PurchaseInvoice>{

    public AdministratorPurchaseInvoice( ) {
        super();
        accessData=new PurchaseInvoiceDAO();
    }

    @Override
    public void addNew( PurchaseInvoice invoice ) {
        accessData.create( invoice );
    }

    @Override
    public void update( int id, PurchaseInvoice invoice ) {
        accessData.update( id,invoice );
    }
}
