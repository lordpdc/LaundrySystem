package presentation.sales;

import business.administrator.ServiceAdministrator;
import business.entities.Service;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import presentation.gui.tabs.TabView;
import presentation.window.ConsumableWindow;
import presentation.window.ServiceWindow;

import java.io.IOException;

/**
 * Created by cesar on 04/12/16.
 */
public class ServiceView extends TabView<Service>{
    private ServiceAdministrator administrator = new ServiceAdministrator();
    private ServiceWindow ctrl;

    public ServiceView(){
        super();
        this.tab.setText("Servicios");
        initComponents();
    }

    private void initComponents(){
        data.addAll(administrator.getAllData());

        table.addColumn("nombre","name",100);
        table.addColumn("descripción","description",100);
        table.addColumn("Precio por unidad","unitariPrice",100);

        table.setData(data);

        JFXPanel panel = new JFXPanel();
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResourceAsStream("../window/ServiceWindow.fxml"));
            Scene scene = new Scene(root);
            panel.setScene(scene);
            ctrl = (ServiceWindow)loader.getController();
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
            int id = ((Service) table.getSelectedItem()).getId();
            ctrl.setWindowtoUpdate(id);
            frame.setVisible(true);
        }else{
            message();
        }
    }

    @Override
    protected void deleteAction() {
        if (table.getSelectedItem()!=null){
            int id = ((Service) table.getSelectedItem()).getId();
            administrator.remove(id);
        }else{
            System.out.println("Debe seleccionar un proveedor");
        }
    }

    @Override
    protected void searchAction() {

    }
}
