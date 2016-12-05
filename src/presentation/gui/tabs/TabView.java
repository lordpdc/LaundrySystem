package presentation.gui.tabs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;

import javax.swing.*;
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
        data.add(p);
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
                JOptionPane.showMessageDialog(null,"Elemento eliminado","Mensaje Informativo",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    protected abstract void createAction();

    protected abstract void editAction();

    protected abstract void deleteAction();

    protected abstract void searchAction();

    protected void message(){
        JOptionPane.showMessageDialog(null,"Debe seleccionar un elemento",
                "Mensaje de Advertencia",JOptionPane.WARNING_MESSAGE);
    }
}
