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

        TabView tab1 = new SuppliersView();
        TabView tab2 = new PurchaseInvoiceView();
        TabView tab3 = new InventoryView();
        TabView tab4 = new CustomerView();
        TabView tab5 = new SaleInvoiceView();
        TabView tab6 = new ServiceView();

        tabPane.getTabs().add(tab1.tab);
        tabPane.getTabs().add(tab2.tab);
        tabPane.getTabs().add(tab3.tab);
        tabPane.getTabs().add(tab4.tab);
        tabPane.getTabs().add(tab5.tab);
        tabPane.getTabs().add(tab6.tab);
    }

}
