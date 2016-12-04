package presentation.window;

import business.administrator.ServiceAdministrator;
import business.entities.Service;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Luis on 03/12/2016.
 */
public class ServiceWindow implements Initializable {

    @FXML protected Button createButton;
    @FXML protected Button cancelButton;
    @FXML protected TextField nameField;
    @FXML protected TextArea descriptionField;
    @FXML protected TextField unitariPriceField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Service service = getNewService();

                ServiceAdministrator admin = new ServiceAdministrator();
                admin.addNew(service);
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    private Service getNewService(){
        return new Service(nameField.getText(),descriptionField.getText(),Double.parseDouble(unitariPriceField.getText()));
    }
}
