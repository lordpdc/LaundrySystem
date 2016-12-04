package presentation.inventory;

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

    @Override
    protected void createAction() {

    }

    private void initComponents(){

    }

}
