package presentation.inventory;

import business.administrator.SupplierAdministrator;
import business.entities.Supplier;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import presentation.gui.tabs.TabView;
import presentation.window.SupplierWindow;

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
        table.addColumn("correo","email");

        table.setData(data);

        JFXPanel panel = new JFXPanel();
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResourceAsStream("../window/SupplierWindow.fxml"));
            Scene scene = new Scene(root);
            panel.setScene(scene);
            SupplierWindow ctrl = (SupplierWindow)loader.getController();
            ctrl.setFrame(frame);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.add(panel);

    }

    @Override
    protected void createAction(){
        frame.setVisible(true);
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

    public void awdawd(String i, String s, String o, String g){
        admin.addNew(i,s,o,g);
    }

}
