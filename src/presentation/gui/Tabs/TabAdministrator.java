package presentation.gui.Tabs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import presentation.Utilities.StringValuesCustomerViewer;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by raoman on 12/11/2016.
 */
public abstract class TabAdministrator implements Initializable{

    @FXML protected Tab genericTab;
    @FXML protected Button createButton;
    @FXML protected Button editButton;
    @FXML protected Button deleteButton;
    @FXML protected Button searchButton;
    @FXML protected TextField searchField;
    @FXML protected TableView dataTable;



    public void TabAdministrator(){

    }

     abstract void setTextComponents();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTextComponents();

    }

}
