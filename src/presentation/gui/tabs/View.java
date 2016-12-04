package presentation.gui.tabs;

import business.entities.Supplier;
import data.dao.SupplierDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;

/**
 * Created by cesar on 01/12/16.
 */
public class View<T> {
    protected Tab tab;
    protected TableView table;
    protected ObservableList<T> data = FXCollections.observableArrayList();

    public View() {
        try {
            URL getingsmh = getClass().getResource("tabs/TabDesign.fxml");
            tab = (Tab) new FXMLLoader().load(getingsmh.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        table = (TableView) tab.getContent().lookup("#dataTable");
    }



    public void updateObsList(T p){
        data.add(p);
    }
}
