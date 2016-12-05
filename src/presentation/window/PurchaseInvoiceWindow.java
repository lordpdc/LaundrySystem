package presentation.window;

import business.administrator.ConsumableAdministrator;
import business.administrator.PurchaseInvoiceAdministrator;
import business.administrator.SupplierAdministrator;
import business.entities.Consumable;
import business.entities.PurchaseInvoice;
import business.entities.Supplier;
import business.utilities.DefaultValues;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

/**
 * Created by cesar on 04/12/16.
 */
public class PurchaseInvoiceWindow implements Initializable {

    private PurchaseInvoiceAdministrator admin = new PurchaseInvoiceAdministrator();
    private SupplierAdministrator admin2 = new SupplierAdministrator();
    private ConsumableAdministrator admin3 = new ConsumableAdministrator();

    private JFrame frame;

    private ObservableList<PurchaseDetailObj> data;
    private PurchaseInvoice invoice = new PurchaseInvoice();

    @FXML private MenuButton supplierSelect;
    @FXML private Button newConsumableBtn;
    @FXML private DatePicker dateSelect;
    @FXML private TableView<PurchaseDetailObj> detailsTable;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn quantityColumn;
    @FXML private TableColumn priceColumn;

    @FXML private MenuButton consumableSelect;
    @FXML private TextField quantityInput;
    @FXML private TextField priceInput;
    @FXML private Button invoiceSaveBtn;
    @FXML private Button invoiceCanceBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = FXCollections.observableArrayList();

        nameColumn.setCellValueFactory(new PropertyValueFactory<PurchaseDetailObj,String>("idConsumable"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<PurchaseDetailObj,String>("quantityConsumable"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<PurchaseDetailObj,String>("priceConsumable"));

        detailsTable.setItems(data);

        newConsumableBtn.setOnAction(detailSaveEvent());
        invoiceSaveBtn.setOnAction(invoiceSaveEvent());

        quantityInput.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(4));
        priceInput.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(10));

        loadMenuSelectors();
    }

    public void setFrame(JFrame frame){
        this.frame = frame;
    }

    private void loadMenuSelectors(){
        for (Supplier s: admin2.getAllData()) {
            MenuItem menu = new MenuItem(s.getName());
            menu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(s.getId());
                    invoice.setIdSupplier(s.getId());
                    supplierSelect.setText("Proveedor: "+s.getName());
                }
            });
            supplierSelect.getItems().add(menu);
        }

        for (Consumable c: admin3.getAllData()) {
            MenuItem menu = new MenuItem(c.getName());
            menu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(c.getId());
                    consumableSelect.setText(c.getName());
                }
            });
            consumableSelect.getItems().add(menu);
        }
    }

    private boolean validateInvoice(){
        boolean supplierIdSet = invoice.getIdSupplier()!=DefaultValues.INTEGER;
        boolean totalPriceSet = invoice.getTotalPrice()!=DefaultValues.DOUBLE;
        return (supplierIdSet && totalPriceSet);
    }

    private EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if(e.getCharacter().matches("[0-9.]")){
                    if(txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")){
                        e.consume();
                    }else if(txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")){
                        e.consume();
                    }
                }else{
                    e.consume();
                }
            }
        };
    }

    private EventHandler<ActionEvent> detailSaveEvent(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(consumableSelect.getText()+", "+priceInput.getText()+", "+quantityInput.getText());
                PurchaseDetailObj pdobj = new PurchaseDetailObj(consumableSelect.getText(),"$"+priceInput.getText(),quantityInput.getText());
                data.add(pdobj);
            }
        };
    }

    private EventHandler<ActionEvent> invoiceSaveEvent(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Ama save....");

                for(PurchaseDetailObj detail: data){
                    System.out.println(detail.toString());
                }
            }
        };
    }

}
