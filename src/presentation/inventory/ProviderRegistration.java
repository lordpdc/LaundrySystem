package presentation.inventory;

import business.entities.Supplier;
import data.dao.SupplierDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by cesar on 01/10/16.
 */
public class ProviderRegistration implements Initializable {
    private JFrame frame;
    private SupplierDAO supplierDao;
    private Inventory mainCtrl;

    @FXML private TextField nameField;
    @FXML private TextField addressField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;
    @FXML private Label warningLabel;
    @FXML private Button saveButton;
    @FXML private Button cancelButton;

    public ProviderRegistration(){
        System.out.println(this.toString());
        supplierDao = new SupplierDAO();
    }

    void setFrame(JFrame frame){
        this.frame = frame;
    }

    void setMainCtrl(Inventory main){
        this.mainCtrl = main;
    }

    private void save(String name, String address, String phone, String email){
        Supplier provider = new Supplier(name,address,phone,email);
        System.out.println( supplierDao.create(provider));
        mainCtrl.updateObsList(provider);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!(addressField.getText().equals("")||nameField.getText().equals("")
                        ||phoneField.getText().equals("")||emailField.getText().equals(""))){
                    System.out.println("saving...");
                    save(nameField.getText(),addressField.getText(),phoneField.getText(),emailField.getText());
                    warningLabel.setText("");
                    addressField.setText("");
                    nameField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                    if (frame!=null){
                        frame.setVisible(false);
                    }
                }else{
                    warningLabel.setText("Se necesita llenar todos los campos");
                }
            }
        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(frame!=null){
                    frame.setVisible(false);
                    warningLabel.setText("");
                    addressField.setText("");
                    nameField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                }
            }
        });
    }

}
