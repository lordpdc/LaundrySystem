package presentation.gui.detailsViews;

import presentation.utilities.StringValuesInvoicePurchaseViewer;

import javax.swing.*;

/**
 * Created by raoman on 09/10/2016.
 */
public class ListInvoicePurchase extends JFrame{
    private JTable tbContent;
    private JLabel lbTitle;
    private JButton btAdd;
    private JButton btEdit;
    private JButton btDelete;

    public ListInvoicePurchase() {
        createUIComponents();
        setTextComponents();
        setCustomPropertyComponent();

    }

    private void createUIComponents() {

    }
    private void setTextComponents(){
        lbTitle.setText(StringValuesInvoicePurchaseViewer.TITLE);
        btAdd.setText(StringValuesInvoicePurchaseViewer.ADD);
        btEdit.setText(StringValuesInvoicePurchaseViewer.EDIT);
        btDelete.setText(StringValuesInvoicePurchaseViewer.DELETE);
    }
    private void setCustomPropertyComponent(){
        this.setVisible( true );

    }
}
