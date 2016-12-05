package business.Reports;

import business.entities.*;
import business.utilities.DefaultValues;

import java.util.*;

/**
 * Created by raoman on 11/11/2016.
 */
public class Report {
    private List< PurchaseInvoice > listPurchases;
    private List< SaleInvoice > listSales;
    private List< PurchaseDetail > listPurchasesDetails;
    private List< SaleDetails > listSalesDetails;

    private HashMap< String, Double > result;
    private Period period;

    public Report( ) {
        listPurchases = new ArrayList<>(  );
        listSales = new ArrayList<>(  );
        listPurchasesDetails= new ArrayList<>(  );
        listSalesDetails= new ArrayList<>(  );
        result = new HashMap< String, Double >( );
    }

    public void addPurchase( PurchaseInvoice purchase ) {
        listPurchases.add( purchase );
    }

    public void addSales( SaleInvoice sale ) {
        listSales.add( sale );
    }

    public void addSaleDetails(SaleDetails saleDetails){ listSalesDetails.add( saleDetails );}

    public void addPurchaseDetails(PurchaseDetail purchaseDetail){
        listPurchasesDetails.add( purchaseDetail );
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

    public Double getValueOfResult(String resultName){ return result.get( resultName ); }

    public List< PurchaseInvoice > getListPurchases( ) {
        return listPurchases;
    }

    public List< SaleInvoice > getListSales( ) {
        return listSales;
    }

    public List< PurchaseDetail > getListPurchasesDetails( ) {
        return listPurchasesDetails;
    }

    public List< SaleDetails > getListSalesDetails( ) {
        return listSalesDetails;
    }
}
