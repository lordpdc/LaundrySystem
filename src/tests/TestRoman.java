package tests;


import business.Reports.*;
import business.administrator.*;
import business.entities.*;
import business.utilities.DefaultValues;
import data.dao.CustomerDAO;
import data.dao.SupplierDAO;
//import presentation.gui.ReportGeneratorWindow;

import java.awt.*;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by raoman on 09/10/2016.
 */
public class TestRoman {
    public static void main( String[] args ) throws IOException {
    Period period=new Period();
    Report report=new Report();
    report.setPeriod( period );
        PurchaseInvoiceAdministrator ps=new PurchaseInvoiceAdministrator();
        report.addPurchase( new PurchaseInvoice( 01,01, DefaultValues.DATE,99.9 )  );
        report.addResult( "yolisimo",2121.0 );
        BuilderFileReport builder=BuilderFileReport.callBuilder();
        builder.setReport( report );
        Desktop.getDesktop().open(builder.getFileReport().getAbsoluteFile());
    }

}