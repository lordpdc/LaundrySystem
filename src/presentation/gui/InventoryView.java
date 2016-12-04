package presentation.gui;

import business.entities.Supplier;
import data.dao.SupplierDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.gui.tabs.View;

/**
 * Created by cesar on 01/12/16.
 */
public class InventoryView extends View {
    private SupplierDAO dao = new SupplierDAO();

    public InventoryView(){
        super();
        this.tab.setText("Inventario");
        initComponents();
    }

    private void initComponents(){
        data.addAll(dao.readAll());


        TableColumn providerName = new TableColumn("nombre");
        TableColumn providerAddress = new TableColumn("dirección");
        TableColumn providerPhone = new TableColumn("telefono");
        TableColumn providerEmail = new TableColumn("mail");


        providerName.setCellValueFactory(new PropertyValueFactory<Supplier,String>("name"));
        providerAddress.setCellValueFactory(new PropertyValueFactory<Supplier,String>("address"));
        providerPhone.setCellValueFactory(new PropertyValueFactory<Supplier,String>("telephone"));
        providerEmail.setCellValueFactory(new PropertyValueFactory<Supplier,String>("mail"));

        table.getColumns().add(providerName);
        table.getColumns().add(providerAddress);
        table.getColumns().add(providerPhone);
        table.getColumns().add(providerEmail);

        table.setItems(data);



    }


}
