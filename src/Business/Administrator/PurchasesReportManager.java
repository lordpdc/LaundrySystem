package Business.Administrator;

import Business.Entities.PurchaseInvoice;
import data.dao.PurchaseInvoiceDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 15/11/2016.
 */
public class PurchasesReportManager extends ReportManager<PurchaseInvoice> {
    AdministratorPurchaseInvoice accesData;

    public PurchasesReportManager( Date initialDate, Date finalDate) throws Exception {
        super(initialDate,finalDate);
        accesData=new AdministratorPurchaseInvoice();
    }

    @Override
    void fillData( ) {
         data=accesData.readAll();
    }

    @Override
    void filterData( ) {
        List<PurchaseInvoice> dataFilter=new ArrayList<>();

        for( PurchaseInvoice invoice: data) {
            if(isDateWithinPeriod( invoice.getDate())){
                dataFilter.add( invoice );
            }
        }
        data=dataFilter;
    }

    @Override
    void fillReport( ) {

    }
}
