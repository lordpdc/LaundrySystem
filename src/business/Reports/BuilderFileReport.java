package business.Reports;

import business.administrator.CustomerAdministrator;
import business.administrator.SupplierAdministrator;
import business.entities.PurchaseInvoice;
import business.entities.SaleInvoice;
import business.utilities.DefaultValues;
/*
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Label;
*/

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by raoman on 03/12/2016.
 */
public class BuilderFileReport {
    private static BuilderFileReport builderFile;
    private Report report;
    private final String EXTENCION = ".xls";
    private final String TEMPLETE_PATH = "src/plantilla.xls";
    private final String FIRST_PART_NAME_FILE = "Reporte_de_";
    private static final int INITIAL_COLUMN = 0;
    private static final int INITIAL_ROW = 2;
    private static final int INITIAL_ROW_RESULT = 5;
    private static final int PAGE_SHET_RESULT = 0;
    private static final int PAGE_SHET_SALES = 1;
    private static final int PAGE_SHET_PURCHASES = 2;

    private BuilderFileReport( ) {
    }

    public static BuilderFileReport callBuilder( ) {
        if( builderFile == null ) {
            builderFile = new BuilderFileReport( );
        }
        return builderFile;
    }

    public void setReport( Report report ) {
        this.report = report;
    }

    /*

    public File getFileReport( ) {
        File fileMaked = null;
        try {

            WritableWorkbook writableWorkbook = makeWorkbook( );
            setPurchaseInFile( writableWorkbook, report.getListPurchases( ) );


            setSalesInFile( writableWorkbook, report.getListSales( ) );
            setResultInFile( writableWorkbook, report.getResult( ) );

            writableWorkbook.write( );
            writableWorkbook.close( );
            fileMaked = new File( getPathFile( ) );
        }catch( IOException | WriteException | BiffException exception ) {
            exception.printStackTrace( );
        }
        return fileMaked;
    }

    private WritableWorkbook makeWorkbook( ) throws IOException, BiffException {
        Workbook workbookTemplete;
        File file = new File( TEMPLETE_PATH );
        workbookTemplete = Workbook.getWorkbook( file );

        WritableWorkbook writableWorkbook;
        String pathName = getPathFile( );
        file = new File( pathName );
        writableWorkbook = Workbook.createWorkbook( file, workbookTemplete );
        return writableWorkbook;

    }

    private String getPathFile( ) {
        String pathFile = FIRST_PART_NAME_FILE + report.getPeriod( ).toString( ) + EXTENCION;
        return pathFile;
    }

    private void setResultInFile( WritableWorkbook workbook, HashMap< String, Double > listResults ) throws WriteException {
        Label titleLabel;
        Label valueLabel;
        WritableSheet workSheet = workbook.getSheet( PAGE_SHET_RESULT );
        int resultCount = DefaultValues.INTEGER;

        for( Map.Entry< String, Double > result : listResults.entrySet( ) ) {
            titleLabel = new Label( INITIAL_COLUMN, INITIAL_ROW_RESULT + resultCount, result.getKey( ) );
            valueLabel = new Label( INITIAL_COLUMN + 2, INITIAL_ROW_RESULT + resultCount, result.getValue( ).toString( ) );
            workSheet.addCell( titleLabel );
            workSheet.addCell( valueLabel );
        }

    }

    private void setSalesInFile( WritableWorkbook workbook, List< SaleInvoice > salesList
    ) throws WriteException {
        WritableSheet workSheet = workbook.getSheet( PAGE_SHET_SALES );
        int row = INITIAL_ROW;
        Label customerLabel;
        Label dateLabel;
        Label totalPrice;
        for( SaleInvoice saleInvoice : salesList ) {
            int column = INITIAL_COLUMN;
            CustomerAdministrator customerAdmin = new CustomerAdministrator( );
            String customerName = customerAdmin.searchById( saleInvoice.getIdCustomer( ) ).getName( );
            customerLabel = new Label( column++, row, customerName );
            dateLabel = new Label( column++, row, saleInvoice.getDate( ).toString( ) );
            totalPrice = new Label( column++, row, String.valueOf( saleInvoice.getTotalPrice( ) ) );
            workSheet.addCell( customerLabel );
            workSheet.addCell( dateLabel );
            workSheet.addCell( totalPrice );
            row++;
        }

    }

    private void setPurchaseInFile( WritableWorkbook workbook, List< PurchaseInvoice > purchasesList
    ) throws WriteException {
        WritableSheet workSheet = workbook.getSheet( PAGE_SHET_PURCHASES );
        int row = INITIAL_ROW;
        Label supplierLabel;
        Label dateLabel;
        Label totalPrice;
        for( PurchaseInvoice purchaseInvoice : purchasesList ) {
            int column = INITIAL_COLUMN;
            SupplierAdministrator supplierAdmin = new SupplierAdministrator( );
            String supplierName = supplierAdmin.searchById( purchaseInvoice.getIdSupplier( ) ).getName( );
            supplierLabel = new Label( column++, row, supplierName );
            dateLabel = new Label( column++, row, purchaseInvoice.getDate( ).toString( ) );
            totalPrice = new Label( column++, row, String.valueOf( purchaseInvoice.getTotalPrice( ) ) );
            workSheet.addCell( supplierLabel );
            workSheet.addCell( dateLabel );
            workSheet.addCell( totalPrice );
            row++;
        }

    }
*/
}
