package data.dao;

import Business.Entities.Consumable;

/**
 * Created by cesar on 03/09/16.
 */
public class ConsumableDao extends GenericDao<Consumable> {
    private static final String entityClassName = "Business.Entities.Consumable";
    private static final String tableName = "consumable";

    public ConsumableDao(){
        super(entityClassName,tableName);
    }

}
