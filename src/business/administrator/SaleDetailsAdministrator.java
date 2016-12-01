package business.administrator;

import business.entities.SaleDetails;
import data.dao.SaleDetailsDAO;

/**
 * Created by Luis on 01/12/2016.
 */
public class SaleDetailsAdministrator extends DataAdministrator<SaleDetails>{

    public SaleDetailsAdministrator(){
        this.setAccessData(new SaleDetailsDAO());
    }

}
