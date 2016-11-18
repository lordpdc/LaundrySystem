/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entities;

import Business.Utilities.DefaultValues;

/**
 *
 * @author Luis
 */
public class SaleDetails {
    private int id;
    private int idSaleInvoice;
    private int idService;
    private double amount;
    private double price;
    
    public SaleDetails(){
        this.id = DefaultValues.INTEGER;
        this.idSaleInvoice = DefaultValues.INTEGER;
        this.idService = DefaultValues.INTEGER;
        this.amount = DefaultValues.DOUBLE;
        this.price = DefaultValues.DOUBLE;
    }

    public SaleDetails(double amount, double price) {
        this.amount = amount;
        this.price = price;
    }

    public SaleDetails(int id, int idSaleInvoice, int idService, 
            double amount, double price) {
        this.id = id;
        this.idSaleInvoice = idSaleInvoice;
        this.idService = idService;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSaleInvoice() {
        return idSaleInvoice;
    }

    public void setIdSaleInvoice(int idSaleInvoice) {
        this.idSaleInvoice = idSaleInvoice;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    
}
