package business.administrator;

import business.entities.Service;
import data.dao.ServiceDAO;

/**
 * Created by Luis on 01/12/2016.
 */
public class ServiceAdministrator extends DataAdministrator<Service>{

    public ServiceAdministrator(){
        this.setAccessData(new ServiceDAO());
    }

}
