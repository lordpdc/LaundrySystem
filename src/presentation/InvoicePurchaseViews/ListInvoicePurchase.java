package presentation.InvoicePurchaseViews;

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
        // TODO: place custom component creation code here
    }
    private void setTextComponents(){
        lbTitle.setText(StringInvoicePurchase.TITLE);
        btAdd.setText(StringInvoicePurchase.ADD);
        btEdit.setText(StringInvoicePurchase.EDIT);
        btDelete.setText(StringInvoicePurchase.DELETE);
    }
    private void setCustomPropertyComponent(){

    }
}
