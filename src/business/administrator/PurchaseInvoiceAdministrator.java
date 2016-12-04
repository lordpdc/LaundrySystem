package business.administrator;

import business.entities.*;
import data.dao.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 16/11/2016.
 */

public class PurchaseInvoiceAdministrator extends DataAdministrator<PurchaseInvoice > {

    public PurchaseInvoiceAdministrator( ) {
        this.setAccessData(new PurchaseInvoiceDAO());
    }




    public List<PurchaseDetail> getPurchaseDetails(int idInvoice){
        List<PurchaseDetail> detailsList;
        PurchaseDetailsAdministrator accesDetails=new PurchaseDetailsAdministrator(  );
        detailsList=accesDetails.getAllData();
        return filterAllDetailsList( idInvoice,detailsList );


    }
    private List<PurchaseDetail> filterAllDetailsList( int idInvoice, List<PurchaseDetail> allDetails){
        List<PurchaseDetail> detailsListFiltered=new ArrayList<>(  );
        for( PurchaseDetail detail: allDetails ) {
            if(detail.getIdPurchaseInvoice()==idInvoice){
                detailsListFiltered.add( detail );
            }
        }
        return detailsListFiltered;
    }
}
