package Business.Administrator;

import Business.Entities.PurchaseDetails;
import Business.Entities.PurchaseInvoice;
import data.dao.*;

import java.util.ArrayList;
import java.util.List;

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

    public List<PurchaseDetails> getDetailPurchase( PurchaseInvoice invoice){
        List<PurchaseDetails> detailsList;

        //**********************falta implementacion de DetailPurchaseDAO
        Dao accesDetails=new GenericDao("SaleDetails","SaleDetailsTable"  );
        //**********************falta implementacion de DetailPurchaseDAO

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
