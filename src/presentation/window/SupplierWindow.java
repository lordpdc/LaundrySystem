package presentation.window;

import business.administrator.DataAdministrator;
import business.administrator.SupplierAdministrator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import presentation.inventory.Inventory;
import presentation.inventory.InventoryView;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Luis on 03/12/2016.
 */
public class SupplierWindow implements Initializable {
    InventoryView view;

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
                String name = nameField.getText();
                String adddress = addressField.getText();
                String telephone = telephoneField.getText();
                String email = emailField.getText();

                if (!name.equals("")&&!adddress.equals("")&&!telephone.equals("")&&!email.equals("")){
                    if (view!=null){

                        //view.addNew(name,adddress,telephone,email);
                    }else{
                        System.out.println("Nah dawg...");
                    }
                }else{
                    System.out.println("Nahhh");
                }
            }
        });
    }

    public void setAdmin(InventoryView view){
        this.view = view;
    }

    public void setData(){

    }

}
