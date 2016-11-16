package data.dao;


import Business.Entities.Supplier;
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