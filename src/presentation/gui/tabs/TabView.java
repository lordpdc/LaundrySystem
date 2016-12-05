package presentation.gui.tabs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.utilities.StringValuesMessage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;

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
    protected TextField searchField;

    protected JFrame frame;

    public TabView() {
        try {
            URL getingsmh = getClass().getResource("../gui/tabs/TabDesign.fxml");
            tab = (Tab) new FXMLLoader().load(getingsmh.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        table.setTable((TableView) tab.getContent().lookup("#dataTable"));
        registerActionHandlers();

        frame = new JFrame();
        frame.setSize(620,560);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void updateObsList(T p){
        getData().add(p);
    }

    public void cleanTable(){
        getData().removeAll();
    }

    public void updateTable(List<T> p){
        getData().addAll(p);
    }

    public JFrame getFrame(){
        if (frame ==null){
            frame = new JFrame();
        }
        return frame;
    }

    private void registerActionHandlers(){
        createButton = (Button) tab.getContent().lookup("#createButton");
        searchButton = (Button) tab.getContent().lookup("#searchButton");
        editButton = (Button) tab.getContent().lookup("#editButton");
        deleteButton = (Button) tab.getContent().lookup("#deleteButton");
        searchField = (TextField) tab.getContent().lookup("#searchField");

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

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deleteAction();
                JOptionPane.showMessageDialog(null,StringValuesMessage.deletedMessage,
                        StringValuesMessage.informationTitle,JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    protected abstract void createAction();

    protected abstract void editAction();

    protected abstract void deleteAction();

    protected abstract void searchAction();

    protected void warningMessage(){
        JOptionPane.showMessageDialog(null,StringValuesMessage.notSelectingMessage,
                StringValuesMessage.warningTitle,JOptionPane.WARNING_MESSAGE);
    }

    protected boolean isFieldEmpty(){
        if(searchField.getText().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    protected boolean isSearchFieldNumeric(){
        try{
            Integer.parseInt(searchField.getText());
            return true;
        }catch (NumberFormatException exception){
            return false;
        }
    }

    public ObservableList<T> getData() {
        return data;
    }

    public void setData(ObservableList<T> data) {
        this.data = data;
    }

}
