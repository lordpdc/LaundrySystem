package tests;


import business.entities.Customer;
import business.entities.Supplier;
import data.dao.CustomerDAO;
import data.dao.SupplierDAO;
import presentation.gui.ReportGeneratorWindow;

import java.sql.Date;

/**
 * Created by raoman on 09/10/2016.
 */
public class TestRoman {
    public static void main( String[] args ) {
        ReportGeneratorWindow rs=new ReportGeneratorWindow();
        rs.setVisible( true );
    }

}