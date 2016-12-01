package business.administrator;

import business.entities.PurchaseDetails;
import data.dao.PurchaseDetailDAO;

/**
 * Created by Luis on 01/12/2016.
 */
public class PurchaseDetailsAdministrator extends DataAdministrator<PurchaseDetails>{

    public PurchaseDetailsAdministrator(){
        this.setAccessData(new PurchaseDetailDAO());
    }

}
