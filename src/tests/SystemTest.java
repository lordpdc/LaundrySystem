package tests;

import business.entities.PurchaseInvoice;
import business.entities.Supplier;
import data.dao.PurchaseDetailDAO;
import data.dao.PurchaseInvoiceDAO;
import data.dao.SupplierDAO;
import presentation.gui.WindowManager;


import presentation.gui.WindowManager;

import java.sql.Date;

public class SystemTest {

    public static void main(String[] args) {

        PurchaseInvoiceDAO dao = new PurchaseInvoiceDAO();
        PurchaseDetailDAO dao2 = new PurchaseDetailDAO();

        PurchaseInvoice pi = new PurchaseInvoice(1, 123);

        //dao.create(pi);

        //dao.create(new Supplier("paquito","calle 123","123123123","awd@domain.com"));

        WindowManager windowManager = new WindowManager();
        windowManager.showInventory();

    }

}
