package business.administrator;

import business.entities.PurchaseDetail;
import data.dao.PurchaseDetailDAO;

/**
 * Created by Luis on 01/12/2016.
 */
public class PurchaseDetailsAdministrator extends DataAdministrator<PurchaseDetail>{

    public PurchaseDetailsAdministrator(){
        this.setAccessData(new PurchaseDetailDAO());
    }

}
