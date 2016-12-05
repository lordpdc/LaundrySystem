package presentation.window;

import business.administrator.CustomerAdministrator;
import business.entities.Customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.sales.CustomerView;
import presentation.utilities.StringValuesMessage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Luis on 03/12/2016.
 */
public class CustomerWindow implements Initializable {
    private CustomerView root;
    private boolean isUpdate = false;
    private Customer customer;
    private CustomerAdministrator administrator = new CustomerAdministrator();

    @FXML protected Button createButton;
    @FXML protected Button cancelButton;
    @FXML protected TextField nameField;
    @FXML protected TextField telephoneField;
    @FXML protected TextField emailField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isUpdate){
                    if (isFieldEmty()) {
                        Customer customerfromWindow = getCustomerfromWindow();
                        administrator.update(customer.getId(),customerfromWindow);

                        setIsUpdate(false);
                        cleanWindow();
                        root.getFrame().setVisible(false);
                    }else{
                        FieldEmptyMessage();
                    }
                }else {
                    if (isFieldEmty()) {
                        customer = getCustomerfromWindow();
                        administrator.addNew(customer);

                        root.updateObsList(customer);
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

    public void setParent(CustomerView root){
        this.root = root;
    }

    public void setIsUpdate(boolean isUpdate){
        this.isUpdate = isUpdate;
    }

    public void setWindowtoUpdate(int id){
        customer = administrator.searchById(id);

        nameField.setText(customer.getName());
        telephoneField.setText(customer.getTelephone());
        emailField.setText(customer.getEmail());

        setIsUpdate(true);
    }

    private Customer getCustomerfromWindow(){
        return new Customer(nameField.getText(),telephoneField.getText(),emailField.getText());
    }

    private void cleanWindow(){
        nameField.setText(null);
        telephoneField.setText(null);
        emailField.setText(null);
    }

    private boolean isFieldEmty(){
        if(nameField.getText().isEmpty()){
            return false;
        } else if(telephoneField.getText().isEmpty()){
            return false;
        }else if(emailField.getText().isEmpty()){
            return false;
        }
        return true;
    }

    private void FieldEmptyMessage(){
        JOptionPane.showMessageDialog(null, StringValuesMessage.missingFieldMessage,
                StringValuesMessage.warningTitle,JOptionPane.WARNING_MESSAGE);
    }
}
