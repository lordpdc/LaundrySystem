package tests;


import business.Email.EmailSenderService;
import business.Reports.*;
import business.administrator.*;
import business.entities.*;
import business.utilities.DefaultValues;
import data.dao.CustomerDAO;
import data.dao.SupplierDAO;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import presentation.window.ConsumableWindow;
import presentation.window.ReportWindow;
//import presentation.gui.ReportGeneratorWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by raoman on 09/10/2016.
 */
public class TestRoman extends Application {
    private static Scene MainContanier;
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent root = loader.load(getClass().getResourceAsStream("TabContainer.fxml"));
            MainContanier = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    /*
    public static void main( String[] args ) {
        EmailSenderService sender=new EmailSenderService();
        sender.sendEmail( "romanramirezmena@gmail.com","prueba","ay ta lo que querias" );
      /* TestRoman test=new TestRoman();
        try {
            test.makeFrame();
        }catch( IOException e ) {
            e.printStackTrace( );
        }

    }
    public void makeFrame() throws IOException {
        Period period=new Period();
        Report report=new Report();
        report.setPeriod( period );
        PurchaseInvoiceAdministrator ps=new PurchaseInvoiceAdministrator();
        report.addPurchase( new PurchaseInvoice( 01,01, DefaultValues.DATE,99.9 )  );
        report.addResult( "Total de ventas",1212.0 );

        report.addResult( "Total de compras",2121.0 );

        BuilderFileReport builder=BuilderFileReport.callBuilder();
        builder.setReport( report );
        /*JFrame frame;
        frame = new JFrame();
        frame.setSize(620,560);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JFXPanel panel = new JFXPanel();
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResourceAsStream("../window/ReportWindow.fxml"));
            Scene scene = new Scene(root);
            panel.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.add(panel);
        frame.setVisible( true );
        Desktop.getDesktop().open(builder.getFileReport().getAbsoluteFile());
    }
*/
