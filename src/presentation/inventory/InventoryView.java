package presentation.inventory;

import business.administrator.ConsumableAdministrator;
import business.entities.Consumable;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import presentation.gui.tabs.TabView;
import presentation.window.ConsumableWindow;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

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
        getData().addAll(administrator.getAllData());

        table.addColumn("nombre","name",100);
        table.addColumn("descripción","description",100);

        table.setData(getData());

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
    public Consumable saveEntity(Consumable entity) {
        Consumable savedEntity = administrator.addNew(entity);
        updateObsList(savedEntity);
        return savedEntity;
    }

    @Override
    protected void editAction() {
        if (table.getSelectedItem()!=null){
            int id = ((Consumable) table.getSelectedItem()).getId();
            ctrl.setWindowtoUpdate(id);
            frame.setVisible(true);
        }else{
            warningMessage();
        }
    }

    @Override
    protected void deleteAction() {
        if (table.getSelectedItem()!=null){
            int id = ((Consumable) table.getSelectedItem()).getId();
            administrator.remove(id);
        }else{
            warningMessage();
        }
    }

    @Override
    protected void searchAction() {
        if(isFieldEmpty()){
            if(isSearchFieldNumeric()){
                Consumable searchItem = administrator.searchById(Integer.parseInt(searchField.getText()));

                if(searchItem.getName().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Elemento no existente",
                            "Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,"Elemento encontrado",
                            "Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
                List<Consumable> searchItem = administrator.searchByAtribute(searchField.getText());
                if(searchItem.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Elemento no existente",
                            "Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,"Elemento encontrado",
                            "Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"No a introducido nada para buscar.",
                    "Mensaje de Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }

}
