package presentation.inventory;

import business.administrator.SupplierAdministrator;
import business.entities.Supplier;
import data.dao.SupplierDAO;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.gui.tabs.TabView;

import java.io.IOException;

/**
 * Created by cesar on 01/12/16.
 */
public class InventoryView extends TabView<Supplier> {
    private SupplierAdministrator admin = new SupplierAdministrator();

    public InventoryView(){
        super();
        this.tab.setText("Inventario");
        initComponents();
    }

    private void initComponents(){
        data.addAll(admin.getAllData());

        table.addColumn("nombre","name");
        table.addColumn("dirección","address");
        table.addColumn("telefono","telephone");
        table.addColumn("correo","mail");

        table.setData(data);

    }

    @Override
    protected void createAction(){
        System.out.println("Creating");

        JFXPanel panel = new JFXPanel();
        try {
            Parent root = new FXMLLoader().load(getClass().getResourceAsStream("../window/SupplierWindow.fxml"));
            Scene scene = new Scene(root);
            panel.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

        myMachine.add(panel);

        myMachine.setVisible(true);
    }

    @Override
    protected void editAction() {
        System.out.println("Editing");
    }

    @Override
    protected void deleteAction() {

    }

    @Override
    protected void searchAction() {

    }

}
