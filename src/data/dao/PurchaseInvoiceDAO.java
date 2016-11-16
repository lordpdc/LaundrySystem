package data.dao;

import Business.Entities.PurchaseInvoice;

/**
 * Created by raoman on 02/10/2016.
 */

public class PurchaseInvoiceDAO extends GenericDao<PurchaseInvoice>{
    private static final String entityClassName = "Business.Entities.DetailsViews";
    private static final String tableName = "invoicepurchasetable";

    public PurchaseInvoiceDAO(){
        super(entityClassName,tableName);
    }
}
