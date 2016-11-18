package Business.Entities;

import Business.Utilities.DefaultValues;
import java.sql.Date;

/**
 * Created by raoman on 01/10/2016.
 */
public class PurchaseInvoice {
    private int id;
    private int idSupplier;
    private Date date;
    private double totalPrice;

    public PurchaseInvoice(){
        this.id = DefaultValues.INTEGER;
        this.idSupplier = DefaultValues.INTEGER;
        this.date = DefaultValues.DATE;
        this.totalPrice = DefaultValues.DOUBLE;
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
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
