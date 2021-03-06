/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.entities;

import business.utilities.DefaultValues;
import java.sql.Date;

/**
 *
 * @author Luis
 */
public class SaleInvoice {
    private int id;
    private int idCustomer;
    private Date date;
    private double totalPrice;
    
    public SaleInvoice(){
        this.id = DefaultValues.INTEGER;
        this.idCustomer = DefaultValues.INTEGER;
        this.date = DefaultValues.DATE;
        this.totalPrice = DefaultValues.DOUBLE;
    }

    public SaleInvoice(Date date, double totalPrice) {
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public SaleInvoice(int id, int idCustomer, Date date, double totalPrice) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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
