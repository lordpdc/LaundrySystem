package business.administrator;

import business.entities.*;
import data.dao.PurchaseDetailDAO;
import data.dao.SalesInvoiceDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 29/11/2016.
 */
public class SaleInvoiceAdministrator extends DataAdministrator<SaleInvoice> {

    public SaleInvoiceAdministrator( ) {
        setAccessData( new SalesInvoiceDAO( ) );
    }

    public List<SaleDetails> getSaleDetails( int idInvoice){
        List<SaleDetails> detailsList;
        SaleDetailsAdministrator accesDetails=new SaleDetailsAdministrator(  );
        detailsList=accesDetails.getAllData();
        return filterAllDetailsList( idInvoice,detailsList );


    }
    private List<SaleDetails> filterAllDetailsList( int idInvoice, List<SaleDetails> allDetails){
        List<SaleDetails> detailsListFiltered=new ArrayList<>(  );
        for( SaleDetails detail: allDetails ) {
            if(detail.getIdSaleInvoice()==idInvoice){
                detailsListFiltered.add( detail );
            }
        }
        return detailsListFiltered;
    }

}
