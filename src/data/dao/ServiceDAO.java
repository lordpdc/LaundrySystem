package data.dao;

import business.entities.Service;

/**
 * Created by raoman on 01/12/2016.
 */
public class ServiceDAO extends GenericDAO<Service> {
    private static final String entityClassName = "business.entities.Service";
    private static final String tableName = "servicetable";

    public ServiceDAO( ) {
        super(entityClassName,tableName);
    }

}
