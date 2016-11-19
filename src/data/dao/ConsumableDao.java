package data.dao;

import business.entities.Consumable;

/**
 * Created by cesar on 03/09/16.
 */
public class ConsumableDao extends GenericDao<Consumable> {
    private static final String entityClassName = "business.entities.Consumable";
    private static final String tableName = "consumable";

    public ConsumableDao(){
        super(entityClassName,tableName);
    }

}
