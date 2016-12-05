package presentation.inventory;

import business.administrator.ConsumableAdministrator;
import business.entities.Consumable;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import presentation.gui.tabs.TabView;
import presentation.window.ConsumableWindow;
import presentation.window.SupplierWindow;

import java.io.IOException;

/**
 * Created by cesar on 04/12/16.
 */
public class InventoryView extends TabView<Consumable> {
    private ConsumableAdministrator administrator = new ConsumableAdministrator();
    private ConsumableWindow ctrl;

    public InventoryView(){
        super();
        this.tab.setText("Inventario");
        initComponents();
    }

    private void initComponents(){
        data.addAll(administrator.getAllData());

        table.addColumn("nombre","name",100);
        table.addColumn("descripción","description",100);

        table.setData(data);

        JFXPanel panel = new JFXPanel();
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResourceAsStream("../window/ConsumableWindow.fxml"));
            Scene scene = new Scene(root);
            panel.setScene(scene);
            ctrl = (ConsumableWindow)loader.getController();
            ctrl.setParent(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.add(panel);
    }

    @Override
    protected void createAction() {
        frame.setVisible(true);
    }

    @Override
    protected void editAction() {
        if (table.getSelectedItem()!=null){
            int id = ((Consumable) table.getSelectedItem()).getId();
            ctrl.setWindowtoUpdate(id);
            frame.setVisible(true);
        }else{
            message();
        }
    }

    @Override
    protected void deleteAction() {
        if (table.getSelectedItem()!=null){
            int id = ((Consumable) table.getSelectedItem()).getId();
            administrator.remove(id);
        }else{
            System.out.println("Debe seleccionar un proveedor");
        }
    }

    @Override
    protected void searchAction() {

    }

}
