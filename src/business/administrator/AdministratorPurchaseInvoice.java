package business.Administrator;

import business.entities.PurchaseDetails;
import business.entities.PurchaseInvoice;
import data.dao.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 16/11/2016.
 */
public class AdministratorPurchaseInvoice extends DataAdministrator<PurchaseInvoice>{

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

    public List<PurchaseDetails> getDetailPurchase( PurchaseInvoice invoice){
        List<PurchaseDetails> detailsList;
        PurchaseDetailDAO accesDetails=new PurchaseDetailDAO(  );

        detailsList=accesDetails.readAll();

        return filterDetailsList( invoice.getId(),detailsList );


    }
    private List<PurchaseDetails> filterDetailsList(int idInvoice,List<PurchaseDetails> detailsList){
        List<PurchaseDetails> detailsListFilter=new ArrayList<>(  );
        for( PurchaseDetails detail: detailsList ) {
            if(detail.getIdPurchaseInvoice()==idInvoice){
                detailsListFilter.add( detail );
            }
        }
        return detailsListFilter;
    }
}
