package presentation.gui;

import business.entities.PurchaseInvoice;
import data.dao.PurchaseDetailDAO;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.gui.tabs.TabView;

/**
 * Created by cesar on 03/12/16.
 */
public class PurchaseInvoiceView extends TabView {
    private PurchaseDetailDAO dao = new PurchaseDetailDAO();

    public PurchaseInvoiceView(){
        super();
        this.tab.setText("Facturas de Compras");
        initComponents();
    }

    private void initComponents(){
        data.addAll(dao.readAll());

        TableColumn providerName = new TableColumn("nombre");
        TableColumn providerAddress = new TableColumn("dirección");
        TableColumn providerPhone = new TableColumn("telefono");
        TableColumn providerEmail = new TableColumn("mail");


        providerName.setCellValueFactory(new PropertyValueFactory<PurchaseInvoice,String>("name"));
        providerAddress.setCellValueFactory(new PropertyValueFactory<PurchaseInvoice,String>("address"));
        providerPhone.setCellValueFactory(new PropertyValueFactory<PurchaseInvoice,String>("telephone"));
        providerEmail.setCellValueFactory(new PropertyValueFactory<PurchaseInvoice,String>("mail"));
    /*
        table.getColumns().add(providerName);
        table.getColumns().add(providerAddress);
        table.getColumns().add(providerPhone);
        table.getColumns().add(providerEmail);

        table.setItems(data);*/

    }

}
