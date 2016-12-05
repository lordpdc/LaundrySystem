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
import presentation.sales.ServiceView;
import presentation.utilities.StringValuesMessage;
import presentation.utilities.StringValuesWindow;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Luis on 03/12/2016.
 */
public class ServiceWindow extends window {
    private ServiceView root;
    private Service service;
    private ServiceAdministrator administrator = new ServiceAdministrator();


    @FXML protected TextField nameField;
    @FXML protected TextArea descriptionField;
    @FXML protected TextField unitariPriceField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isUpdate){
                    if (isFieldEmty() || isUnitariPriceNumeric()) {
                        Service servicefromWindow = getServicefromWindow();
                        administrator.update(service.getId(),servicefromWindow);

                        setIsUpdate(false);
                        cleanWindow();
                        root.getFrame().setVisible(false);
                    }else{
                        FieldEmptyMessage();
                    }
                }else {
                    if (isFieldEmty() || isUnitariPriceNumeric()) {
                        service = getServicefromWindow();
                        administrator.addNew(service);

                        root.updateObsList(service);
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

    public void setParent(ServiceView root){
        this.root = root;
    }


    public void setWindowtoUpdate(int id){
        service = administrator.searchById(id);

        nameField.setText(service.getName());
        descriptionField.setText(service.getDescription());
        unitariPriceField.setText(Double.toString(service.getUnitariPrice()));
        createButton.setText(StringValuesWindow.updateButton);

        setIsUpdate(true);
    }

    protected void cleanWindow(){
        nameField.setText(null);
        descriptionField.setText(null);
        unitariPriceField.setText(null);
        setText();
    }

    private Service getServicefromWindow(){
            return new Service(nameField.getText(), descriptionField.getText(), Double.parseDouble(unitariPriceField.getText()));

    }

    protected boolean isFieldEmty(){
        if(nameField.getText().isEmpty()){
            return false;
        }else if(descriptionField.getText().isEmpty()) {
            return false;
        }else if(unitariPriceField.getText().isEmpty()){
            return false;
        }
        return true;
    }

    private boolean isUnitariPriceNumeric(){
        try{
            Integer.parseInt(unitariPriceField.getText());
            return true;
        }catch (NumberFormatException exception){
            return false;
        }
    }


}
