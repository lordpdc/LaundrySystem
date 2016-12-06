package data.dao;

import business.entities.Supplier;

/**
 * Created by cesar on 02/10/16.
 */
public class SupplierDAO extends GenericDAO<Supplier> {

    private static final String entityClassName = "business.entities.Supplier";
    private static final String tableName = "suppliertable";

    public SupplierDAO(){
        super(entityClassName,tableName);
    }

}
