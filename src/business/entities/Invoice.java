package business.entities;

import business.utilities.DefaultValues;

import java.sql.Date;

/**
 * Created by raoman on 03/12/2016.
 */
public class Invoice {
    protected int id;
    protected Date date;
    protected double totalPrice;

    public Invoice( ) {
        this.id = DefaultValues.INTEGER;
        this.date = DefaultValues.DATE;
        this.totalPrice = DefaultValues.DOUBLE;    }

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
