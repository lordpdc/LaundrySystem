package presentation.inventory;

import business.administrator.SupplierAdministrator;
import business.entities.Supplier;
import data.dao.SupplierDAO;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.gui.tabs.TabView;

/**
 * Created by cesar on 01/12/16.
 */
public class InventoryView extends TabView<Supplier> {
    private SupplierAdministrator admin = new SupplierAdministrator();

    public InventoryView(){
        super();
        this.tab.setText("Inventario");
        initComponents();
    }

    private void initComponents(){
        data.addAll(admin.getAllData());

        table.addColumn("nombre","name");
        table.addColumn("dirección","address");
        table.addColumn("telefono","telephone");
        table.addColumn("correo","mail");

        table.setData(data);

    }

    @Override
    protected void createAction(){
        System.out.println("Creating");



    }

    @Override
    protected void editAction() {
        System.out.println("Editing");
    }

    @Override
    protected void deleteAction() {

    }

    @Override
    protected void searchAction() {

    }

}
