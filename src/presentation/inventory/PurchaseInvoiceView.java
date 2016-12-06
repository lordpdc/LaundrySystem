package presentation.inventory;

import business.administrator.PurchaseInvoiceAdministrator;
import business.entities.PurchaseInvoice;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import presentation.gui.tabs.TabView;
import presentation.window.PurchaseInvoiceCtrl;

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
        getData().addAll(admin.getAllData());

        table.addColumn("proveedor","idSupplier");
        table.addColumn("fecha","date");
        table.addColumn("total","totalPrice");

        table.setData(getData());

        JFXPanel panel = new JFXPanel();
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResourceAsStream("../window/PurchaseInvoiceWindow.fxml"));
            Scene scene = new Scene(root);
            panel.setScene(scene);
            PurchaseInvoiceCtrl ctrl = (PurchaseInvoiceCtrl)loader.getController();
            ctrl.setFrame(frame);
            ctrl.setPrimaryView(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setTitle("Factura de Compras");
        frame.add(panel);
    }


    @Override
    public PurchaseInvoice saveEntity(PurchaseInvoice entity) {
        PurchaseInvoice savedEntity = admin.addNew(entity);
        updateObsList(savedEntity);
        return savedEntity;
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
