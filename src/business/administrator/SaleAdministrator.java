package business.administrator;

import business.entities.Customer;
import business.entities.Service;
import business.entities.SaleDetails;
import business.entities.SaleInvoice;
import business.utilities.DefaultValues;

/**
 * Created by Luis on 19/11/2016.
 */
public class SaleAdministrator {

    private SaleDetails sale;
    private SaleInvoice bill;

    public SaleAdministrator(){
        sale = new SaleDetails();
        bill = new SaleInvoice();
    }

    public void recordSale(Service service, Customer customer, double aumont,double price){

    }

    public double getPrice(double aumont, double unitariPrice){
        return aumont*unitariPrice;
    }

    private void recordSaleInvoice(int idCustomer, double price){
        bill.setIdCustomer(idCustomer);
        bill.setDate(DefaultValues.DATE);
        bill.setTotalPrice(price);
    }

    private void recordSaleDetails(){
 /*       sale.setAmount();
        sale.setIdService();
        sale.setPrice();
        sale.setIdSaleInvoice();*/
    }
}
