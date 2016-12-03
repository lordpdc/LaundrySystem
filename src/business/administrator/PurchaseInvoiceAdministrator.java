package business.administrator;

import business.entities.*;
import data.dao.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 16/11/2016.
 */

public class PurchaseInvoiceAdministrator extends DataAdministrator<PurchaseInvoice > {
    private List listDetailPurchase;

    public List getListDetailPurchase( ) {
        return listDetailPurchase;
    }

    public void setListDetailPurchase( List listDetailPurchase ) {
        this.listDetailPurchase = listDetailPurchase;
    }

    public PurchaseInvoiceAdministrator( ) {
        this.setAccessData(new PurchaseInvoiceDAO());
    }

    @Override
    public void addNew( PurchaseInvoice invoice ) {
        accessData.create( invoice );
    }

    @Override
    public void update( int id, PurchaseInvoice invoice ) {
        accessData.update( id,invoice );
    }


    public Invoice search( String name ) {
        return null;
    }

    public List<PurchaseDetails> getDetailPurchase( Invoice invoice){
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
