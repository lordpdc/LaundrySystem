package presentation.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * Created by raoman on 12/11/2016.
 */
public class CustomerTab {
    @FXML private Tab genericTab;
    @FXML private Button createButton;
    @FXML private Button editButton;
    @FXML private Button deleteButton;
    @FXML private Button serchButton;
    @FXML private TextField searchField;
    @FXML private TableView dataTable;



    public void CustomerTab(){
        System.out.println("CREANDO CUSTOMERTAB");
        setText();
    }

    private void setText(){
        genericTab.setText(CustomerStringViewer.title);
        createButton.setText(CustomerStringViewer.newCustomer);
        editButton.setText(CustomerStringViewer.editCustomer);
        deleteButton.setText(CustomerStringViewer.deleteCustomer);
        serchButton.setText(CustomerStringViewer.searchCustomer);
        searchField.setText(CustomerStringViewer.searchValues);
    }

    public Tab getTab(){
        return genericTab;
    }


}
