package presentation.gui.tabs;

import data.dao.SupplierDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;

/**
 * Created by cesar on 01/12/16.
 */
public class View {
    protected Tab tab;
    protected TableView table;
    private SupplierDAO dao = new SupplierDAO();
    protected ObservableList<Object> data = FXCollections.observableArrayList(dao.readAll());

    public View() {
        try {
            URL getingsmh = getClass().getResource("tabs/TabDesign.fxml");
            tab = (Tab) new FXMLLoader().load(getingsmh.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        table = (TableView) tab.getContent().lookup("#dataTable");

        table.getColumns().add(new TableColumn("hola"));
    }

    public void updateObsList(Object p){
        data.add(p);
    }
}
