package data.dao;


import business.entities.Supplier;
import data.db.Table;

/**
 *
 * @author Luis
 */
public class SupplierDao extends GenericDao<Supplier>{
    private Table supplierTable;
    
    public SupplierDao(){
        super("","");
        supplierTable = new Table("supplier");
    }
    

}