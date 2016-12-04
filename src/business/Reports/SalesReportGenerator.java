package business.Reports;

import business.administrator.PurchaseInvoiceAdministrator;
import business.administrator.SaleInvoiceAdministrator;
import business.entities.SaleInvoice;
import business.utilities.DefaultValues;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by raoman on 03/12/2016.
 */
public class SalesReportGenerator  {
    private List<SaleInvoice> salesForReport;
    private Period period;
    private Double totalSales;

    public SalesReportGenerator( ) {
        salesForReport=DefaultValues.ARRAY_LIST;
        period=new Period();
        totalSales= DefaultValues.DOUBLE;
    }
    public SalesReportGenerator(Period period){
        super();
        setPeriod( period );
    }

    public void setPeriod( Period period ) {
        this.period = period;
        updateSales();
    }

    public Period getPeriod( ) {
        return period;
    }

    public Double getTotalSales( ) {
        return totalSales;
    }
    public Report createSalesReport(){
        Report report=fillSalesReport();
        return report;
    }
    private Report fillSalesReport(){
        Report reporteFilled=new Report();
        for( SaleInvoice currentSaleInvoice:salesForReport ) {
            reporteFilled.addData( currentSaleInvoice );
        }
        totalSales=calculateTotalSales();
        reporteFilled.addResult( DefaultValues.TOTAL_SALES ,totalSales);
        return reporteFilled;
    }

    private void updateSales( ) {
        SaleInvoiceAdministrator salesAdmin=new SaleInvoiceAdministrator();
        List<SaleInvoice> listAllSales=salesAdmin.getAllData();
        salesForReport=filterSales(listAllSales);
    }

    private List<SaleInvoice> filterSales( List<SaleInvoice> listAllSales ) {
        List<SaleInvoice> salesFiltered=DefaultValues.ARRAY_LIST;
        for( SaleInvoice currentSaleInvoice:listAllSales ) {
            Date dateOfCurrentInvoice = currentSaleInvoice.getDate( );
            if( period.isDateIntoPeriod( dateOfCurrentInvoice ) ) {
                salesFiltered.add( currentSaleInvoice );
            }
        }
        return salesFiltered;
    }
    private Double calculateTotalSales(){
        Double totalCalculated=DefaultValues.DOUBLE;
        for( SaleInvoice currentSaleInvoice:salesForReport ) {
            Double totalOfCurrentInvoice = currentSaleInvoice.getTotalPrice( );
            totalCalculated+=totalCalculated+totalOfCurrentInvoice;
        }
        return totalCalculated;
    }

}
