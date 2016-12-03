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
public class SaleInvoice extends Invoice {
    private int idCustomer;

    public SaleInvoice() {
        super( );
        this.idCustomer = DefaultValues.INTEGER;
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


    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }


}
