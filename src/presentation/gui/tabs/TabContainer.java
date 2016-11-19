package presentation.gui.tabs;

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

    public Scene getMainContanier(){
        return MainContanier;
    }

    private void addTabs(){
        CustomerTabAministrator customerTabAministrator=new CustomerTabAministrator();

        tabPane.getTabs().addAll(customerTabAministrator.getTab());
        /*tabPane = (TabPane) MainContanier.lookup("#tabPanel");

        Tab genTab = null;
        try {
            genTab = (Tab) new FXMLLoader().load(getClass().getResource("TabDesign.fxml").openStream());

            tabPane.getTabs().add(genTab);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }
}
