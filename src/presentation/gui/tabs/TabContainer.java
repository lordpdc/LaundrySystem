package presentation.gui.tabs;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import presentation.gui.InventoryView;
import presentation.inventory.Inventory;

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
            Parent root = loader.load(getClass().getResource("TabContainer.fxml").openStream());
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

        View view1 = new InventoryView();


        tabPane.getTabs().add(view1.tab);
    }

    /*
    private Tab generateEmptyTab(){
        Tab newTab = null;
        try {
            newTab = (Tab) new FXMLLoader().load(getClass().getResource("TabDesign.fxml").openStream());
            //tabPane.getTabs().add(newTab);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newTab;
    }*/
}
