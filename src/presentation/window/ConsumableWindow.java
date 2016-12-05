package presentation.window;

import business.administrator.ConsumableAdministrator;
import business.entities.Consumable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import presentation.inventory.InventoryView;
import presentation.utilities.StringValuesMessage;
import presentation.utilities.StringValuesWindow;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Luis on 03/12/2016.
 */
public class ConsumableWindow extends window {
    private InventoryView root;
    private Consumable consumable;
    private ConsumableAdministrator administrator = new ConsumableAdministrator();

    @FXML protected TextField nameField;
    @FXML protected TextArea descriptionField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isUpdate){
                    if (isFieldEmty()) {
                        Consumable consumablefromWindow = getConsumablefromWindow();
                        administrator.update(consumable.getId(),consumablefromWindow);

                        setIsUpdate(false);
                        cleanWindow();
                        root.getFrame().setVisible(false);
                    }else{
                        FieldEmptyMessage();
                    }
                }else {
                    if (isFieldEmty()) {
                        consumable = getConsumablefromWindow();
                        administrator.addNew(consumable);

                        root.updateObsList(consumable);
                        cleanWindow();
                        root.getFrame().setVisible(false);
                    }else {
                        FieldEmptyMessage();
                    }
                }
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cleanWindow();
                setIsUpdate(false);
                root.getFrame().setVisible(false);
            }
        });
    }

    public void setParent(InventoryView root){
        this.root = root;
    }


    public void setWindowtoUpdate(int id){
        consumable = administrator.searchById(id);

        nameField.setText(consumable.getName());
        descriptionField.setText(consumable.getDescription());
        createButton.setText(StringValuesWindow.updateButton);

        setIsUpdate(true);
    }

    private Consumable getConsumablefromWindow(){
        return new Consumable(nameField.getText(),descriptionField.getText());
    }

    protected void cleanWindow(){
        nameField.setText(null);
        descriptionField.setText(null);
        setText();
    }

    protected boolean isFieldEmty(){
        if(nameField.getText().isEmpty()){
            return false;
        }else if(descriptionField.getText().isEmpty()) {
            return false;
        }
        return true;
    }

}
