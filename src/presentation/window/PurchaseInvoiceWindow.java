package presentation.window;

import business.administrator.PurchaseInvoiceAdministrator;
import business.administrator.SupplierAdministrator;
import business.entities.PurchaseDetail;
import business.entities.PurchaseInvoice;
import business.entities.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.gui.tabs.Table;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

/**
 * Created by cesar on 04/12/16.
 */
public class PurchaseInvoiceWindow implements Initializable {
    PurchaseInvoiceAdministrator admin = new PurchaseInvoiceAdministrator();
    private SupplierAdministrator admin2 = new SupplierAdministrator();
    private JFrame frame;
    private Table<PurchaseDetailObj> table = new Table<>();
    private ObservableList<PurchaseDetailObj> data = FXCollections.observableArrayList();

    @FXML private MenuButton supplierSelect;
    @FXML private Button newConsumableBtn;
    @FXML private DatePicker dateSelect;
    @FXML private TableView detailsTable;
    @FXML private TableColumn<PurchaseDetailObj, String> nameColumn;
    @FXML private TableColumn<PurchaseDetailObj, String> quantityColumn;
    @FXML private TableColumn<PurchaseDetailObj, String> priceColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data.add(new PurchaseDetailObj("bnm","iop"));

        table.setColumnValue(nameColumn,"idConsumable");

        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        /*
        nameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<PurchaseDetail, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<PurchaseDetail, String> t) {
                        ((PurchaseDetail) t.getTableView().getItems().get(t.getTablePosition().getRow())).setIdConsumable(parseInt(t.getNewValue()));
                    }
                }
        );
        */

        table.setTable(detailsTable);
        table.setColumnValue(quantityColumn,"quantityConsumable");
        table.setColumnValue(priceColumn,"priceConsumable");

        table.setData(data);
        table.toggleEditable();

        for (Supplier s: admin2.getAllData()){
            MenuItem menu = new MenuItem(s.getName());
            menu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(s.getId());
                    supplierSelect.setText("Proveedor: "+s.getName());
                }
            });
            supplierSelect.getItems().add(menu);
        }

        newConsumableBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("awdij");
                data.add(new PurchaseDetailObj("",""));
            }
        });

    }

    public void setFrame(JFrame frame){
        this.frame = frame;
    }
}
