package data.dao;

import business.entities.PurchaseDetail;

/**
 * Created by raoman on 17/11/2016.
 */
public class PurchaseDetailDAO extends GenericDAO<PurchaseDetail> {
    private static final String entityClassName = "business.entities.PurchaseDetail";
    private static final String tableName = "purchasedetailstable";


    public PurchaseDetailDAO(  ) {
        super( entityClassName, tableName );
    }
}
