package presentation.window;

import business.administrator.CustomerAdministrator;
import business.entities.Customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Luis on 03/12/2016.
 */
public class CustomerWindow implements Initializable {

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
                Customer customer = getNewCustomer();

                CustomerAdministrator admin = new CustomerAdministrator();
                admin.addNew(customer);
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    private Customer getNewCustomer(){
        return new Customer(nameField.getText(),telephoneField.getText(),emailField.getText());
    }
}
