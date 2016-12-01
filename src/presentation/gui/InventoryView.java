package presentation.gui;

import javafx.collections.FXCollections;
import presentation.gui.tabs.View;

/**
 * Created by cesar on 01/12/16.
 */
public class InventoryView extends View {

    public InventoryView(){
        super();
        this.tab.setText("Inventario");
    }


    private void initComponents(){
        table.setItems(data);
    }


}
