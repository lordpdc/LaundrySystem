package presentation.gui.tabs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesar on 03/12/16.
 */
public class Table<T> {
    private TableView<T> tableView;
    protected ObservableList data = FXCollections.observableArrayList();
    private List<TableColumn> columns = new ArrayList<TableColumn>();

    public Table(){
        tableView = new TableView();
    }

    public void setTable(TableView tableView){
        this.tableView = tableView;
    }

    public List<TableColumn> getColumnList(){
        return columns;
    }

    public void addColumn(String name, String value){
        TableColumn<T, String> column = new TableColumn<T, String>(name);
        column.setCellValueFactory(new PropertyValueFactory<T,String>(value));
        tableView.getColumns().add(column);
    }

    public void setData(ObservableList items){
        tableView.setItems(items);
    }

}
