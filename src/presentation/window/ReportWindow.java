package presentation.window;

import business.Reports.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import presentation.inventory.SuppliersView;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * Created by raoman on 04/12/2016.
 */
public class ReportWindow implements Initializable {

    @FXML
    protected Pane reportPane;
    @FXML
    protected Button createReportButton;
    @FXML
    protected Button cancelReportButton;
    @FXML
    protected DatePicker initialDatePicker;
    @FXML
    protected DatePicker finalDatePicker;

    private Period period;

    @Override
    public void initialize( URL location, ResourceBundle resources ) {
        period=new Period();
        setCustomValues();
        finalDatePicker.setOnAction( ( new EventHandler< ActionEvent >( ) {
            @Override
            public void handle( ActionEvent event ) {
                LocalDate maxInitialDateAvailable=finalDatePicker.getValue();
                if(initialDatePicker.getValue().isAfter( maxInitialDateAvailable )) {
                    initialDatePicker.setValue( maxInitialDateAvailable );
                }
            }
        } ) );
        initialDatePicker.setOnAction( ( new EventHandler< ActionEvent >( ) {
            @Override
            public void handle( ActionEvent event ) {
                LocalDate minFinalDateAvailable=initialDatePicker.getValue();
                if(finalDatePicker.getValue().isBefore( minFinalDateAvailable )) {
                    finalDatePicker.setValue( minFinalDateAvailable );
                }
            }
        } ) );


        createReportButton.setOnAction( ( new EventHandler< ActionEvent >( ) {
            @Override
            public void handle( ActionEvent event ) {
                try {
                    period.setInitialDate( initialDatePicker.getValue() );
                    period.setFinalDate( finalDatePicker.getValue() );
                    Accountant accountant=new Accountant( );
                    accountant.setPeriodForReport( period );
                    BuilderFileReport builderFile=BuilderFileReport.callBuilder();
                    builderFile.setReport(accountant.makeGeneralBalance());
                   Desktop.getDesktop().open(builderFile.getFileReport());


                }catch( Exception e ) {
                    e.printStackTrace( );
                }

            }
        } ) );
        cancelReportButton.setOnAction( ( new EventHandler< ActionEvent >( ) {
            @Override
            public void handle( ActionEvent event ) {
                //cerrar esta ventana es la de Reportes

            }
        } ) );


    }

    private void setCustomValues(){
        LocalDate maxInitialDateAvailable=LocalDate.now();
        LocalDate maxFinalDateAvailable=LocalDate.now();
        initialDatePicker.setValue( maxInitialDateAvailable );
        finalDatePicker.setValue( maxFinalDateAvailable );

    }
}
