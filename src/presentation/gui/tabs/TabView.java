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
public class TabView<T> {
    protected Tab tab;
    protected Table table = new Table<T>();
    protected ObservableList<T> data = FXCollections.observableArrayList();

    public TabView() {
        try {
            URL getingsmh = getClass().getResource("resources/layout/TabDesign.fxml");
            tab = (Tab) new FXMLLoader().load(getingsmh.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        table.setTable((TableView) tab.getContent().lookup("#dataTable"));
    }

    public void updateObsList(T p){
        data.add(p);
    }

}
