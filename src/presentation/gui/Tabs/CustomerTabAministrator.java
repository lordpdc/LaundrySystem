package presentation.gui.Tabs;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import presentation.Utilities.StringValuesCustomerViewer;

/**
 * Created by raoman on 12/11/2016.
 */
public class CustomerTabAministrator extends TabAdministrator{
    public void CustomerTabAministrator(){
        System.out.println("CREANDO CUSTOMERTAB");
        setTextComponents();
    }

   public Tab getTab(){
        return genericTab;
    }


    @Override
    void setTextComponents() {
        genericTab.setText(StringValuesCustomerViewer.title);
        createButton.setText(StringValuesCustomerViewer.newCustomer);
        editButton.setText(StringValuesCustomerViewer.editCustomer);
        deleteButton.setText(StringValuesCustomerViewer.deleteCustomer);
        searchButton.setText(StringValuesCustomerViewer.searchCustomer);
        searchField.setText(StringValuesCustomerViewer.searchValues);
    }

}
