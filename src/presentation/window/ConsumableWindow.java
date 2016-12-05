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

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Luis on 03/12/2016.
 */
public class ConsumableWindow implements Initializable {
    private InventoryView root;

    @FXML protected Button createButton;
    @FXML protected Button cancelButton;
    @FXML protected TextField nameField;
    @FXML protected TextArea descriptionField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Consumable consumable = getNewConsumable();

                if(consumable != null) {
                    ConsumableAdministrator admin = new ConsumableAdministrator();
                    admin.addNew(consumable);
                    root.getFrame().setVisible(false);
                }
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getFrame().setVisible(false);
            }
        });
    }

    public void setParent(InventoryView root){
        this.root = root;
    }

    private Consumable getNewConsumable(){
        if(isFieldEmty()){
            return null;
        }
        return new Consumable(nameField.getText(),descriptionField.getText());
    }

    private boolean isFieldEmty(){
        if(nameField.getText().isEmpty()){
            return true;
        }
        if(descriptionField.getText().isEmpty()){
            return true;
        }
        return false;
    }
}
