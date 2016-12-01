package data.dao;

import business.entities.Customer;

/**
 * Created by raoman on 01/12/2016.
 */
public class CustomerDAO extends GenericDAO<Customer> {
    private static final String entityClassName = "business.entities.Customer";
    private static final String tableName = "customertable";

    public CustomerDAO(){
        super(entityClassName,tableName);
    }

}