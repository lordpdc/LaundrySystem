package business.administrator;

import business.entities.Customer;
import data.dao.CustomerDAO;

/**
 * Created by Luis on 01/12/2016.
 */
public class CustomerAdministrator extends DataAdministrator<Customer> {

    public CustomerAdministrator(){
        this.setAccessData(new CustomerDAO());
    }

}
