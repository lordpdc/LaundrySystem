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

    public void addNew(String name, String address, String phone, String email){
        super.addNew(new Supplier(name,address,phone,email));
    }

}
