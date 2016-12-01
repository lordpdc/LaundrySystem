package tests;


import business.entities.Customer;
import business.entities.Supplier;
import data.dao.CustomerDAO;
import data.dao.SupplierDAO;

import java.sql.Date;

/**
 * Created by raoman on 09/10/2016.
 */
public class TestRoman {
    public static void main( String[] args ) {
        SupplierDAO spd=new SupplierDAO();
        Supplier ssp=new Supplier(  );

        for(Supplier sp: spd.readByAtrr( "o" )){
            System.out.println(sp.getName()+"**"+sp.getId() );
        }
    }

}