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

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Luis on 03/12/2016.
 */
public class ConsumableWindow implements Initializable {
    JFrame frame;

    @FXML
    protected Button createButton;
    @FXML protected Button cancelButton;
    @FXML protected TextField nameField;
    @FXML protected TextArea descriptionField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Consumable consumable = getNewConsumable();

                ConsumableAdministrator admin = new ConsumableAdministrator();
                admin.addNew(consumable);
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                frame.setVisible(false);
            }
        });
    }

    public void setFrame(JFrame frame){
        this.frame = frame;
    }

    private Consumable getNewConsumable(){
        return new Consumable(nameField.getText(),descriptionField.getText());
    }
}
