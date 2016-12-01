package data.dao;

import business.entities.SaleInvoice;

/**
 * Created by raoman on 29/11/2016.
 */
public class SalesInvoiceDAO extends GenericDAO<SaleInvoice> {
    private static final String entityClassName = "business.entities.SaleInvoice";
    private static final String tableName = "saleinvoicetable";

    public SalesInvoiceDAO( ) {
        super(entityClassName,tableName);
    }

}
