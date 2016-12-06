package presentation.gui.tabs;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import presentation.inventory.InventoryView;
import presentation.inventory.SuppliersView;
import presentation.inventory.PurchaseInvoiceView;
import presentation.sales.CustomerView;
import presentation.sales.SaleInvoiceView;
import presentation.sales.ServiceView;

import java.io.IOException;

/**
 * Created by Luis on 12/11/2016.
 */
public class TabContainer {
    private Scene MainContanier;
    private final Tab supplierTab = new Tab();
    TabPane tabPane;

    public TabContainer(){
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent root = loader.load(getClass().getResourceAsStream("TabContainer.fxml"));
            MainContanier = new Scene(root);
            this.addTabs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene(){
        return MainContanier;
    }

    private void addTabs(){
        tabPane = (TabPane) MainContanier.lookup("#tabContainer");


        TabView suppliersTab = new SuppliersView();
        tabPane.getTabs().add(suppliersTab.tab);
        TabView inventoryTab = new InventoryView();
        tabPane.getTabs().add(inventoryTab.tab);
        TabView purchaseInvoiceTab = new PurchaseInvoiceView();
        tabPane.getTabs().add(purchaseInvoiceTab.tab);

        TabView customerTab = new CustomerView();
        tabPane.getTabs().add(customerTab.tab);
        TabView serviceTab = new ServiceView();
        tabPane.getTabs().add(serviceTab.tab);
        TabView saleInvoiceTab = new SaleInvoiceView();
        tabPane.getTabs().add(saleInvoiceTab.tab);


    }

}
