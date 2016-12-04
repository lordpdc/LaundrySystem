package business.entities;

import business.utilities.DefaultValues;
import java.sql.Date;

/**
 * Created by raoman on 01/10/2016.
 */
public class PurchaseInvoice{
    private int idSupplier;
    private int id;
    private Date date;
    private double totalPrice;

    public PurchaseInvoice(){
        this.id = DefaultValues.INTEGER;
        this.date = DefaultValues.DATE;
        this.totalPrice = DefaultValues.DOUBLE;
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

    public PurchaseInvoice(int idSupplier, double totalPrice) {
        this.idSupplier = idSupplier;
        this.totalPrice = totalPrice;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public int getId() {
        return id;
    }

    public void setId( int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate( Date date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice( double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
