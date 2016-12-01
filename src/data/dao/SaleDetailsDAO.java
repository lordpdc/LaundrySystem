package data.dao;

import business.entities.SaleDetails;

/**
 * Created by raoman on 01/12/2016.
 */
public class SaleDetailsDAO extends GenericDAO<SaleDetails> {
    private static final String entityClassName = "business.entities.SaleDetails";
    private static final String tableName = "saledetailstable";

    public SaleDetailsDAO(  ) {
        super( entityClassName, tableName );
    }
}
