package data.dao;

import business.entities.Consumable;

/**
 * Created by cesar on 03/09/16.
 */
public class ConsumableDAO extends GenericDAO<Consumable> {
    private static final String entityClassName = "business.entities.Consumable";
    private static final String tableName = "consumable";

    public ConsumableDAO(){
        super(entityClassName,tableName);
    }

}
