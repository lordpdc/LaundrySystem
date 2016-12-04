package presentation.window;

import business.administrator.SupplierAdministrator;
import business.entities.Supplier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Luis on 03/12/2016.
 */
public class SupplierWindow implements Initializable {
    private JFrame frame;

    @FXML protected Button createButton;
    @FXML protected Button cancelButton;
    @FXML protected TextField nameField;
    @FXML protected TextArea addressField;
    @FXML protected TextField telephoneField;
    @FXML protected TextField emailField;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Supplier supplier = getNewSupplier();

                if(supplier !=null) {
                    SupplierAdministrator admin = new SupplierAdministrator();
                    admin.addNew(supplier);
                    frame.setVisible(false);
                }
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

    private void setText(){

    }

    private Supplier getNewSupplier(){
        if(isFieldEmty()){
            return null;
        }
        return new Supplier(nameField.getText(),addressField.getText(),telephoneField.getText(),emailField.getText());
    }

    private boolean isFieldEmty(){
        if(nameField.getText().isEmpty()){
            return true;
        }
        if(addressField.getText().isEmpty()) {
            return true;
        }
        if(telephoneField.getText().isEmpty()){
            return true;
        }
        if(emailField.getText().isEmpty()){
            return true;
        }
        return false;
    }
}
