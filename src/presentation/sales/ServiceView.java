package presentation.sales;

import business.administrator.ServiceAdministrator;
import business.entities.Service;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import presentation.gui.tabs.TabView;
import presentation.utilities.StringValuesMessage;
import presentation.window.ServiceWindow;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

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
        getData().addAll(administrator.getAllData());

        table.addColumn("nombre","name",100);
        table.addColumn("descripción","description",100);
        table.addColumn("Precio por unidad","unitariPrice",100);

        table.setData(getData());

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
    public Service saveEntity(Service entity) {
        return null;
    }

    @Override
    protected void editAction() {
        if (table.getSelectedItem()!=null){
            int id = ((Service) table.getSelectedItem()).getId();
            ctrl.setWindowtoUpdate(id);
            frame.setVisible(true);
        }else{
            warningMessage();
        }
    }

    @Override
    protected void deleteAction() {
        if (table.getSelectedItem()!=null){
            int id = ((Service) table.getSelectedItem()).getId();
            administrator.remove(id);
        }else{
            warningMessage();
        }
    }

    @Override
    protected void searchAction() {
        if(isFieldEmpty()){
            if(isSearchFieldNumeric()){
                Service searchItem = administrator.searchById(Integer.parseInt(searchField.getText()));

                if(searchItem.getName().isEmpty()){
                    JOptionPane.showMessageDialog(null,StringValuesMessage.elementNotExistMessage,
                            StringValuesMessage.informationTitle,JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,StringValuesMessage.elementExistMessage,
                            StringValuesMessage.informationTitle,JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
                List<Service> searchItem = administrator.searchByAtribute(searchField.getText());
                if(searchItem.isEmpty()){
                    JOptionPane.showMessageDialog(null,StringValuesMessage.elementNotExistMessage,
                            StringValuesMessage.informationTitle,JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,StringValuesMessage.elementExistMessage,
                            StringValuesMessage.informationTitle,JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,StringValuesMessage.missingSearchFieldMessage,
                    StringValuesMessage.warningTitle,JOptionPane.WARNING_MESSAGE);
        }
    }
}
