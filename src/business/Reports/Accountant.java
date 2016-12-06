package business.Reports;

import business.administrator.*;
import business.entities.*;
import business.utilities.DefaultValues;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 11/11/2016.
 */
public  class Accountant {
    private Report generalBalanceReport;
    private Period periodForReport;
    private final String PURCHASE_RESULT="Total de compras";
    private final String SALES_RESULT="Total de ventas";


    public Accountant() {
        generalBalanceReport=new Report();
    }
    public void setPeriodForReport(Period period){
        this.periodForReport=period;
    }

    public Report makeGeneralBalance(){
        generalBalanceReport.setPeriod( periodForReport );
        fillSalesInformation();
        fillPurchasesInformation();
        return generalBalanceReport;

    }
    private void fillSalesInformation(){
        SaleInvoiceAdministrator saleAdministrator=new SaleInvoiceAdministrator();
        List<SaleInvoice> allSales=saleAdministrator.getAllData();
        Double totalSales=DefaultValues.DOUBLE;
        for( SaleInvoice sale: allSales) {
            if(periodForReport.isDateIntoPeriod( sale.getDate() )){
                generalBalanceReport.addSales( sale );
                totalSales+=sale.getTotalPrice();
            }
        }
        generalBalanceReport.addResult( SALES_RESULT,totalSales );
    }
    private void fillPurchasesInformation(){
        PurchaseInvoiceAdministrator purchaseAdministrator=new PurchaseInvoiceAdministrator();
        List<PurchaseInvoice> allPurchases=purchaseAdministrator.getAllData();
        Double totalPurchases=DefaultValues.DOUBLE;
        for( PurchaseInvoice purchase: allPurchases) {
            if(periodForReport.isDateIntoPeriod( purchase.getDate() )){
                generalBalanceReport.addPurchase( purchase );
                totalPurchases+=purchase.getTotalPrice();
            }
        }
        generalBalanceReport.addResult( PURCHASE_RESULT,totalPurchases );
    }
    private void fillPurchaseDetailsInformation(List<PurchaseDetail> details){
       List<PurchaseDetail> detailForFill=details;

    }


}
