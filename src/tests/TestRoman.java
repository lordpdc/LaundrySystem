package tests;
import business.entities.Supplier;
import data.dao.SupplierDAO;
import presentation.gui.ReportGeneratorWindow;
import presentation.gui.detailsViews.ListInvoicePurchase;
import presentation.gui.tabs.TabManager;

import java.sql.Date;

/**
 * Created by raoman on 09/10/2016.
 */
public class TestRoman {
    public static void main(String[] args) throws Exception {
        Supplier sp=new Supplier(  );
        sp.setName( "modificiado" );
        sp.setId( 2 );
        SupplierDAO spD=new SupplierDAO();
        for(Supplier sptemp:spD.readAll()) {
            System.out.println( sptemp.getAddress( )+"-"+sptemp.getName()+"-"+sptemp.getId() );
        }
        System.out.println("despues de actualizacion" );
        spD.update(1, sp );
        for(Supplier sptemp:spD.readAll()) {
            System.out.println( sptemp.getAddress( )+"-"+sptemp.getName()+"-"+sptemp.getId() );
        }
    }
}