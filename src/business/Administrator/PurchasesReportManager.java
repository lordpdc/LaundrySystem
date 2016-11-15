package business.Administrator;

import business.entities.PurchaseInvoice;
import data.dao.PurchaseInvoiceDAO;

import java.util.ArrayList;

/**
 * Created by raoman on 15/11/2016.
 */
public class PurchasesReportManager extends ReportManager<PurchaseInvoice> {
    PurchaseInvoiceDAO accesData;

    public PurchasesReportManager( ) {
        super();
        accesData=new PurchaseInvoiceDAO();
    }

    @Override
    void fillData( ) {
        data= ( ArrayList< PurchaseInvoice > ) accesData.readAll();
    }

    @Override
    void filterData( ) {

    }

    @Override
    void fillReport( ) {

    }
}
