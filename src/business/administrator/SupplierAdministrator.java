package business.administrator;

import business.entities.Supplier;
import data.dao.SupplierDAO;

/**
 * Created by Luis on 01/12/2016.
 */
public class SupplierAdministrator extends DataAdministrator<Supplier>{

    public SupplierAdministrator(){
        this.setAccessData(new SupplierDAO());
    }

}
