package business.entities;

import business.utilities.DefaultValues;
import data.dao.DataField;

/**
 * Created by raoman on 01/10/2016.
 */
public class PurchaseDetail {
    @DataField private int id;
    @DataField private int idInvoicePurchase;
    @DataField private int idConsumable;
    @DataField private double priceConsumable;
    @DataField private double quantityConsumable;

    private String consumableName;

    public PurchaseDetail(){
        this.id = DefaultValues.INTEGER;
        this.idInvoicePurchase = DefaultValues.INTEGER;
        this.idConsumable = DefaultValues.INTEGER;
        this.priceConsumable = DefaultValues.DOUBLE;
        this.quantityConsumable = DefaultValues.DOUBLE;
    }
    
    public PurchaseDetail(double priceConsumable, double quantityConsumable){
        this.priceConsumable = priceConsumable;
        this.quantityConsumable = quantityConsumable;
    }
    
    public PurchaseDetail(int id, int idPurchaseInvoice, int idConsumable,
                          double priceConsumable, double quantityConsumable){
        this.id = id;
        this.idInvoicePurchase = idPurchaseInvoice;
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

    public int getIdInvoicePurchase() {
        return idInvoicePurchase;
    }

    public void setIdInvoicePurchase(int idInvoicePurchase) {
        this.idInvoicePurchase = idInvoicePurchase;
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

    public String getConsumableName(){
        return consumableName;
    }

    public void setConsumableName(String name){
        this.consumableName = name;
    }
}
