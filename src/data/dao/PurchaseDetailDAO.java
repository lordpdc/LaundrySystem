package data.dao;

import business.entities.PurchaseDetails;

/**
 * Created by raoman on 17/11/2016.
 */
public class PurchaseDetailDAO extends GenericDAO<PurchaseDetails> {
    private static final String entityClassName = "business.entities.PurchaseDetails";
    private static final String tableName = "purchasedetailstable";


    public PurchaseDetailDAO(  ) {
        super( entityClassName, tableName );
    }
}
