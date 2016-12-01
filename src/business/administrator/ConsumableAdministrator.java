package business.administrator;

import business.entities.Consumable;
import data.dao.ConsumableDAO;

/**
 * Created by Luis on 01/12/2016.
 */
public class ConsumableAdministrator extends DataAdministrator<Consumable> {

    public ConsumableAdministrator(){
        this.setAccessData(new ConsumableDAO());
    }

}
