package business.entities;

import business.utilities.DefaultValues;
import java.sql.Date;

/**
 * Created by raoman on 01/10/2016.
 */
public class PurchaseInvoice extends Invoice {
    private int idSupplier;

    public PurchaseInvoice(){
        super();
        this.idSupplier = DefaultValues.INTEGER;
    }
    
    public PurchaseInvoice(Date date, double totalPrice){
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public PurchaseInvoice(int id, int idSupplier, Date date, double totalPrice) {
        this.id = id;
        this.idSupplier = idSupplier;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

}
