package presentation.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;

/**
 * Created by Luis on 12/11/2016.
 */
public class TabContainer {
    private Scene MainContanier;
    private final Tab supplierTab = new Tab();
    Parent root;
    TabPane tabPane;

    public TabContainer(){
        FXMLLoader loader = new FXMLLoader();
        try {
            root = loader.load(getClass().getResource("TabContainer.fxml").openStream());
            MainContanier = new Scene(root);
            tabPane = (TabPane) MainContanier.lookup("#mainTabContainer");
            this.addTabs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getMainContanier(){
        return MainContanier;
    }

    private void addTabs(){
        //tabPane.getTabs().add();
    }
}
