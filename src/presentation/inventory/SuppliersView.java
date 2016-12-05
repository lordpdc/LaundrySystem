package presentation.inventory;

import business.administrator.SupplierAdministrator;
import business.entities.Supplier;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import presentation.gui.tabs.TabView;
import presentation.window.SupplierWindow;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by cesar on 01/12/16.
 */
public class SuppliersView extends TabView<Supplier> {
    private SupplierAdministrator administrator = new SupplierAdministrator();
    private SupplierWindow ctrl;

    public SuppliersView(){
        super();
        this.tab.setText("Proveedores");
        initComponents();
    }

    private void initComponents(){
        data.addAll(administrator.getAllData());

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
            ctrl = (SupplierWindow)loader.getController();
            ctrl.setParent(this);
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
        if (table.getSelectedItem()!=null){
            int id = ((Supplier) table.getSelectedItem()).getId();
            ctrl.setWindowtoUpdate(id);
            frame.setVisible(true);
        }else{
            warningMessage();
        }
    }

    @Override
    protected void deleteAction() {
        if (table.getSelectedItem()!=null){
            int id = ((Supplier) table.getSelectedItem()).getId();
            administrator.remove(id);
        }else{
            warningMessage();
        }
    }

    @Override
    protected void searchAction() {
        if(isFieldEmpty()){
            if(isSearchFieldNumeric()){
                Supplier searchItem = administrator.searchById(Integer.parseInt(searchField.getText()));
                if(searchItem != null){
                    JOptionPane.showMessageDialog(null,"Elemento elemento encontrado",
                            "Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,"Elemento no existente",
                            "Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
                List<Supplier> searchItem = administrator.searchByAtribute(searchField.getText());
                if(searchItem != null){
                    JOptionPane.showMessageDialog(null,"Elemento elemento encontrado",
                            "Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,"Elemento no existente",
                            "Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"No a introducido nada para buscar.",
                    "Mensaje de Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }


}
