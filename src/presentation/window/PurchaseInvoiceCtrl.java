package presentation.window;

import business.administrator.ConsumableAdministrator;
import business.administrator.PurchaseDetailsAdministrator;
import business.administrator.PurchaseInvoiceAdministrator;
import business.administrator.SupplierAdministrator;
import business.entities.Consumable;
import business.entities.PurchaseDetail;
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
import presentation.gui.elements.SecondaryWindow;
import presentation.inventory.PurchaseInvoiceView;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

/**
 * Created by cesar on 04/12/16.
 */
public class PurchaseInvoiceCtrl extends SecondaryWindow<PurchaseInvoiceView> implements Initializable {
    private PurchaseInvoiceAdministrator admin = new PurchaseInvoiceAdministrator();
    private SupplierAdministrator admin2 = new SupplierAdministrator();
    private ConsumableAdministrator admin3 = new ConsumableAdministrator();
    private PurchaseDetailsAdministrator admin4 = new PurchaseDetailsAdministrator();

    private ObservableList<PurchaseDetail> data;
    private PurchaseInvoice invoice = new PurchaseInvoice();

    @FXML private MenuButton supplierSelect;
    @FXML private Button newConsumableBtn;
    @FXML private DatePicker dateSelect;
    @FXML private TableView<PurchaseDetail> detailsTable;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn quantityColumn;
    @FXML private TableColumn priceColumn;

    @FXML private Button invoiceSaveBtn;
    @FXML private Button invoiceCancelBtn;

    @FXML private MenuButton consumableSelect;
    @FXML private TextField quantityInput;
    @FXML private TextField priceInput;

    @FXML private TextField ivaInput;
    @FXML private Label subtotalLabel;
    @FXML private Label ivaLabel;
    @FXML private Label totalLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = FXCollections.observableArrayList();

        nameColumn.setCellValueFactory(new PropertyValueFactory<PurchaseDetail,String>("consumableName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<PurchaseDetail,String>("quantityConsumable"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<PurchaseDetail,String>("priceConsumable"));

        detailsTable.setItems(data);

        newConsumableBtn.setOnAction(detailSaveEvent());
        invoiceSaveBtn.setOnAction(invoiceSaveEvent());

        quantityInput.addEventFilter(KeyEvent.KEY_TYPED , numericValidation(4));
        priceInput.addEventFilter(KeyEvent.KEY_TYPED , numericValidation(10));
        ivaInput.addEventFilter(KeyEvent.KEY_RELEASED, recalculateTotal());
        ivaInput.addEventFilter(KeyEvent.KEY_TYPED, numericValidation(4));

        loadMenuSelectors();
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
                    consumableSelect.setId(Integer.toString(c.getId()));
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

    private EventHandler<KeyEvent> recalculateTotal() {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                calculateInvoicTotal();
            }
        };
    }

    private EventHandler<ActionEvent> detailSaveEvent(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(consumableSelect.getText()+", "+priceInput.getText()+", "+quantityInput.getText());
                PurchaseDetail pdobj = new PurchaseDetail(new Double(priceInput.getText()),new Double(quantityInput.getText()));
                pdobj.setConsumableName(consumableSelect.getText());
                pdobj.setIdConsumable(parseInt(consumableSelect.getId()));
                data.add(pdobj);
                calculateInvoicTotal();
            }
        };
    }

    private EventHandler<ActionEvent> invoiceSaveEvent(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Ima save....");

                if(dateSelect.getValue()!=null){
                    invoice.setDate(Date.valueOf(dateSelect.getValue()));
                }

                invoice = primaryView.saveEntity(invoice);

                for(PurchaseDetail detail: data){
                    detail.setIdInvoicePurchase(invoice.getId());
                    admin4.addNew(detail);
                }
                frame.setVisible(false);
            }
        };
    }

    private void calculateInvoicTotal(){
        BigDecimal sum = new BigDecimal(0);
        for (PurchaseDetail item: data){
            BigDecimal currentQuantity = new BigDecimal(item.getQuantityConsumable());
            BigDecimal currentPrice = new BigDecimal(item.getPriceConsumable());
            sum = sum.add(currentQuantity.multiply(currentPrice));
        }

        BigDecimal ivaPercent = new BigDecimal(0);
        if (!ivaInput.getText().equals("")){
            ivaPercent = new BigDecimal(ivaInput.getText());
        }

        BigDecimal totalIva = sum.multiply(ivaPercent.divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP));
        BigDecimal total = sum.add(totalIva);

        subtotalLabel.setText(sum.toString());
        ivaLabel.setText(totalIva.toString());
        totalLabel.setText(total.toString());

        invoice.setTotalPrice(total.doubleValue());
    }

}
