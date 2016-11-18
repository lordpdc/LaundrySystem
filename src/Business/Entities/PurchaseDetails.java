package business.entities;

import business.utilities.DefaultValues;

/**
 * Created by raoman on 01/10/2016.
 */
public class PurchaseDetails {
    private int id;
    private int idPurchaseInvoice;
    private int idConsumable;
    private double priceConsumable;
    private double quantityConsumable;

    public PurchaseDetails(){
        this.id = DefaultValues.INTEGER;
        this.idPurchaseInvoice = DefaultValues.INTEGER;
        this.idConsumable = DefaultValues.INTEGER;
        this.priceConsumable = DefaultValues.DOUBLE;
        this.quantityConsumable = DefaultValues.DOUBLE;
    }
    
    public PurchaseDetails(double priceConsumable, double quantityConsumable){
        this.priceConsumable = priceConsumable;
        this.quantityConsumable = quantityConsumable;
    }
    
    public PurchaseDetails(int id, int idPurchaseInvoice, int idConsumable, 
            double priceConsumable, double quantityConsumable){
        this.id = id;
        this.idPurchaseInvoice = idPurchaseInvoice;
        this.idConsumable = idConsumable;
        this.priceConsumable = priceConsumable;
        this.quantityConsumable = quantityConsumable;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPurchaseInvoice() {
        return idPurchaseInvoice;
    }

    public void setIdPurchaseInvoice(int idPurchaseInvoice) {
        this.idPurchaseInvoice = idPurchaseInvoice;
    }

    public int getIdConsumable() {
        return idConsumable;
    }

    public void setIdConsumable(int idConsumable) {
        this.idConsumable = idConsumable;
    }

    public double getPriceConsumable() {
        return priceConsumable;
    }

    public void setPriceConsumable(double priceConsumable) {
        this.priceConsumable = priceConsumable;
    }

    public double getQuantityConsumable() {
        return quantityConsumable;
    }

    public void setQuantityConsumable(double quantityConsumable) {
        this.quantityConsumable = quantityConsumable;
    }

}
