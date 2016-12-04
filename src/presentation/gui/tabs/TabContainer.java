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

        TabView view1 = new SuppliersView();
        TabView view2 = new PurchaseInvoiceView();
        TabView tab3 = new InventoryView();

        tabPane.getTabs().add(view1.tab);
        tabPane.getTabs().add(view2.tab);
        tabPane.getTabs().add(tab3.tab);
    }

}
