package data.dao;

import business.entities.Supplier;

/**
 * Created by cesar on 02/10/16.
 */
public class SupplierDao extends GenericDao<Supplier> {
    private static final String entityClassName = "Business.entities.Supplier";
    private static final String tableName = "Provider";

    public SupplierDao(){
        super(entityClassName,tableName);
        System.out.println(this.toString());
    }

}
