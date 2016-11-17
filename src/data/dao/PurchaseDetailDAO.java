package data.dao;

import Business.Entities.PurchaseDetails;

/**
 * Created by raoman on 17/11/2016.
 */
public class PurchaseDetailDAO extends GenericDao<PurchaseDetails>{
    private static final String entityClassName = "Business.Entities.PurchaseDetails";
    private static final String tableName = "purchasedetailstable";


    public PurchaseDetailDAO(  ) {
        super( entityClassName, tableName );
    }
}
