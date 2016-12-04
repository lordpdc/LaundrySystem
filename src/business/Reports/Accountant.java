package business.Reports;

import business.administrator.PurchaseInvoiceAdministrator;
import business.administrator.SaleInvoiceAdministrator;
import business.entities.PurchaseInvoice;
import business.entities.SaleInvoice;
import business.utilities.DefaultValues;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoman on 11/11/2016.
 */
public abstract class Accountant {
    private Report generalBalanceReport;
    private Period periodForReport;
    private final String SALES_RESULT="Total de ventas";
    private final String PURCHASE_RESULT="Total de compras";

    public Accountant() {
        generalBalanceReport=new Report();
    }
    public void setPeriodForReport(Period period){
        this.periodForReport=period;
    }

    public void makeGeneralBalance(){
        generalBalanceReport.setPeriod( periodForReport );
        fillSalesInformation();
        fillPurchasesInformation();

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


}
