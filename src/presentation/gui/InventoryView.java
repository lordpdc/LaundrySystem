package presentation.gui;

import business.entities.Supplier;
import com.sun.deploy.util.FXLoader;
import data.dao.SupplierDAO;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.gui.tabs.TabView;

import javax.swing.*;

/**
 * Created by cesar on 01/12/16.
 */
public class InventoryView extends TabView<Supplier> {
    private SupplierDAO dao = new SupplierDAO();
    private JFXPanel panel = new JFXPanel();

    public InventoryView(){
        super();
        this.tab.setText("Inventario");
        initComponents();
        JFrame ventana = new JFrame();
        ventana.add(panel);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                panel.setScene(new FXLoader().loadFX(););
            }
        }unnable);
    }

    private void initComponents(){
        data.addAll(dao.readAll());

        table.addColumn("nombre","name");
        table.addColumn("dirección","address");
        table.addColumn("telefono","telephone");
        table.addColumn("correo","mail");

        table.setData(data);

    }

}
