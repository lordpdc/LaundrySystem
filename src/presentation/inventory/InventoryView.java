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
    private ConsumableAdministrator admin = new ConsumableAdministrator();

    public InventoryView(){
        super();
        this.tab.setText("Inventario");
        initComponents();
    }

    private void initComponents(){
        data.addAll(admin.getAllData());

        table.addColumn("nombre","name",100);
        table.addColumn("descripción","description",100);

        table.setData(data);

        JFXPanel panel = new JFXPanel();
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResourceAsStream("../window/ConsumableWindow.fxml"));
            Scene scene = new Scene(root);
            panel.setScene(scene);
            ConsumableWindow ctrl = (ConsumableWindow)loader.getController();
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

    }

    @Override
    protected void deleteAction() {

    }

    @Override
    protected void searchAction() {

    }

}
