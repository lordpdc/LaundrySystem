package presentation.gui.tabs;

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
    protected ObservableList<T> data;
    private List<TableColumn> columns = new ArrayList<TableColumn>();

    public Table(){
        tableView = new TableView<T>();
    }

    public void setTable(TableView tableView){
        this.tableView = tableView;

        // TODO if table has cols load 'em
    }

    public List<TableColumn> getColumnList(){
        return columns;
    }

    public void addToData(T item){
        data.add(item);
    }

    public void addColumn(String name, String value){
        TableColumn<T, String> column = new TableColumn<T, String>(name);
        column.setCellValueFactory(new PropertyValueFactory<T,String>(value));
        tableView.getColumns().add(column);
    }

    public void addColumn(String name, String value, double d){
        TableColumn<T, String> column = new TableColumn<T, String>(name);
        column.setPrefWidth(d);
        column.setCellValueFactory(new PropertyValueFactory<T,String>(value));
        tableView.getColumns().add(column);
    }

    public void setColumnValue(TableColumn<T, String> column, String value){
        column.setCellValueFactory(new PropertyValueFactory<T,String>(value));
    }

    public void setData(ObservableList<T> items){
        //this.data = items;
        tableView.setItems(items);
    }

    public ObservableList<T> getData(){
        return data;
    }

    public void updateData(T item){
        this.data.add(item);
    }

    public void toggleEditable(){
        tableView.setEditable(!tableView.isEditable());
    }
}
