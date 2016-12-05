package presentation.sales;

import business.administrator.PurchaseInvoiceAdministrator;
import business.administrator.SaleInvoiceAdministrator;
import business.entities.SaleInvoice;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import presentation.gui.tabs.TabView;
import presentation.window.PurchaseInvoiceWindow;

import java.io.IOException;

/**
 * Created by cesar on 04/12/16.
 */
public class SaleInvoiceView extends TabView<SaleInvoice> {
    private SaleInvoiceAdministrator admin = new SaleInvoiceAdministrator();

    public SaleInvoiceView(){
        super();
        this.tab.setText("Facturas de Ventas");
        initComponents();
    }

    private void initComponents(){
        getData().addAll(admin.getAllData());

        table.addColumn("cliente","idClient");
        table.addColumn("fecha","date");
        table.addColumn("total","totalPrice");

        table.setData(getData());

        JFXPanel panel = new JFXPanel();
        /*
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResourceAsStream("../window/PurchaseInvoiceWindow.fxml"));
            Scene scene = new Scene(root);
            panel.setScene(scene);
            PurchaseInvoiceWindow ctrl = (PurchaseInvoiceWindow)loader.getController();
            ctrl.setFrame(frame);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        frame.add(panel);
    }

    @Override
    protected void editAction() {

    }

    @Override
    protected void deleteAction() {

    }

    @Override
    protected void searchAction() {

    }


}
