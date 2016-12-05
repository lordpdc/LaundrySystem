package presentation.sales;

import business.administrator.CustomerAdministrator;
import business.entities.Customer;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import presentation.gui.tabs.TabView;
import presentation.window.ConsumableWindow;
import presentation.window.CustomerWindow;

import java.io.IOException;

/**
 * Created by cesar on 04/12/16.
 */
public class CustomerView extends TabView<Customer>{
    private CustomerAdministrator administrator = new CustomerAdministrator();
    private CustomerWindow ctrl;

    public CustomerView(){
        super();
        this.tab.setText("Clientes");
        initComponents();
    }

    private void initComponents(){
        data.addAll(administrator.getAllData());

        table.addColumn("nombre","name");
        table.addColumn("telefono","telephone");
        table.addColumn("correo","email");

        table.setData(data);

        JFXPanel panel = new JFXPanel();
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResourceAsStream("../window/CustomerWindow.fxml"));
            Scene scene = new Scene(root);
            panel.setScene(scene);
            ctrl = (CustomerWindow)loader.getController();
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
            int id = ((Customer) table.getSelectedItem()).getId();
            ctrl.setWindowtoUpdate(id);
            frame.setVisible(true);
        }else{
            message();
        }
    }

    @Override
    protected void deleteAction() {
        if (table.getSelectedItem()!=null){
            int id = ((Customer) table.getSelectedItem()).getId();
            administrator.remove(id);
        }else{
            System.out.println("Debe seleccionar un proveedor");
        }
    }

    @Override
    protected void searchAction() {

    }
}
