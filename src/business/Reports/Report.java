package business.Reports;

import business.entities.PurchaseInvoice;
import business.entities.SaleInvoice;
import business.utilities.DefaultValues;

import java.util.*;

/**
 * Created by raoman on 11/11/2016.
 */
public class Report {
    private List< PurchaseInvoice > listPurchases;
    private List< SaleInvoice > listSales;
    private HashMap< String, Double > result;
    private Period period;

    public Report( ) {
        listPurchases = new ArrayList<>(  );
        listSales = new ArrayList<>(  );
        result = new HashMap< String, Double >( );
    }

    public void addPurchase( PurchaseInvoice purchase ) {
        listPurchases.add( purchase );
    }

    public void addSales( SaleInvoice sale ) {
        listSales.add( sale );
    }

    public void addResult( String key, Double value ) {
        result.put( key, value );
    }

    public Period getPeriod( ) {
        return period;
    }

    public void setPeriod( Period period ) {
        this.period = period;
    }

    public HashMap< String, Double > getResult( ) {
        return result;
    }

    public List< PurchaseInvoice > getListPurchases( ) {
        return listPurchases;
    }

    public List< SaleInvoice > getListSales( ) {
        return listSales;
    }
}
