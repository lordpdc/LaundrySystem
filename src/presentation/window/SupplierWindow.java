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
import presentation.inventory.SuppliersView;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Luis on 03/12/2016.
 */
public class SupplierWindow implements Initializable {
    private SuppliersView root;
    private boolean isUpdate = false;
    private Supplier supplier;
    private SupplierAdministrator admin = new SupplierAdministrator();

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
                if(isUpdate){
                    Supplier supplierfromWindow = getSupplierfromWindow();

                    if (supplier != null) {
                        admin.update(supplier.getId(),supplierfromWindow);
                        root.updateObsList(supplierfromWindow);

                        setIsUpdate(false);
                        root.getFrame().setVisible(false);
                    }
                }else {
                    supplier = getSupplierfromWindow();

                    if (supplier != null) {
                        admin.addNew(supplier);
                        root.updateObsList(supplier);
                        root.getFrame().setVisible(false);
                    }
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

    public void setParent(SuppliersView root){
        this.root = root;
    }


    private void setIsUpdate(boolean isUpdate){
        this.isUpdate = isUpdate;
    }

    public void setWindowtoUpdate(int id){
        supplier = admin.searchById(id);

        nameField.setText(supplier.getName());
        addressField.setText(supplier.getAddress());
        telephoneField.setText(supplier.getTelephone());
        emailField.setText(supplier.getEmail());

        setIsUpdate(true);
    }

    private Supplier getSupplierfromWindow(){
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
