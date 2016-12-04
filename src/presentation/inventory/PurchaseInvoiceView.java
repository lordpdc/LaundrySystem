package presentation.inventory;

import business.administrator.PurchaseInvoiceAdministrator;
import business.entities.PurchaseInvoice;
import data.dao.PurchaseDetailDAO;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.gui.tabs.TabView;
import presentation.window.PurchaseInvoiceWindow;
import presentation.window.SupplierWindow;

import java.io.IOException;

/**
 * Created by cesar on 03/12/16.
 */
public class PurchaseInvoiceView extends TabView<PurchaseInvoice> {
    private PurchaseInvoiceAdministrator admin = new PurchaseInvoiceAdministrator();

    public PurchaseInvoiceView(){
        super();
        this.tab.setText("Facturas de Compras");
        initComponents();
    }

    private void initComponents(){
        data.addAll(admin.getAllData());

        table.addColumn("proveedor","idSupplier");
        table.addColumn("fecha","date");
        table.addColumn("total","totalPrice");

        table.setData(data);

        JFXPanel panel = new JFXPanel();
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResourceAsStream("../window/PurchaseInvoiceWindow.fxml"));
            Scene scene = new Scene(root);
            panel.setScene(scene);
            PurchaseInvoiceWindow ctrl = (PurchaseInvoiceWindow)loader.getController();
            ctrl.setFrame(frame);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.add(panel);
    }

    @Override
    protected void createAction() {
        frame.setVisible(true);
        frame.pack();
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
