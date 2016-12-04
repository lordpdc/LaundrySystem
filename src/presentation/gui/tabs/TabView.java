package presentation.gui.tabs;

import business.entities.Supplier;
import data.dao.SupplierDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;

/**
 * Created by cesar on 01/12/16.
 */
public abstract class TabView<T> {
    protected Tab tab;
    protected Table table = new Table<T>();
    protected ObservableList<T> data = FXCollections.observableArrayList();

    protected Button createButton;
    protected Button searchButton;
    protected Button editButton;
    protected Button deleteButton;


    public TabView() {
        try {
            URL getingsmh = getClass().getResource("../gui/tabs/TabDesign.fxml");
            tab = (Tab) new FXMLLoader().load(getingsmh.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        table.setTable((TableView) tab.getContent().lookup("#dataTable"));
        registerActionHandlers();
    }

    public void updateObsList(T p){
        data.add(p);
    }

    private void registerActionHandlers(){
        createButton = (Button) tab.getContent().lookup("#createButton");
        searchButton = (Button) tab.getContent().lookup("#searchButton");

        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createAction();
            }
        });

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                searchAction();
            }
        });

        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                editAction();
            }
        });

    }

    protected abstract void createAction();

    protected abstract void editAction();

    protected abstract void deleteAction();

    protected abstract void searchAction();

}
