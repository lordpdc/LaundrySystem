package data.dao;

import business.entities.PurchaseInvoice;

/**
 * Created by raoman on 02/10/2016.
 */

public class PurchaseInvoiceDAO extends GenericDao<PurchaseInvoice>{
    private static final String entityClassName = "business.entities.detailsViews";
    private static final String tableName = "invoicepurchasetable";

    public PurchaseInvoiceDAO(){
        super(entityClassName,tableName);
    }
}
