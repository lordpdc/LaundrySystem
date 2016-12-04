package tests;

import business.entities.Supplier;
import data.dao.SupplierDAO;
import presentation.gui.WindowManager;


import presentation.gui.WindowManager;

public class SystemTest {

    public static void main(String[] args) {

        SupplierDAO dao = new SupplierDAO();

        dao.create(new Supplier("paquito","calle 123","123123123","awd@domain.com"));

        WindowManager windowManager = new WindowManager();
        windowManager.showInventory();

    }

}
