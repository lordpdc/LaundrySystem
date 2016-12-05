package presentation.window;

/**
 * Created by cesar on 04/12/16.
 */
public class PurchaseDetailObj {
    private String idPurchaseInvoice;
    private String idConsumable;
    private String priceConsumable;
    private String quantityConsumable;


    public PurchaseDetailObj(String s, String a, String b){
        this.idPurchaseInvoice = "0";
        this.idConsumable = s;
        this.priceConsumable = a;
        this.quantityConsumable = b;
    }

    public String getIdPurchaseInvoice() {
        return idPurchaseInvoice;
    }

    public void setIdPurchaseInvoice(String idPurchaseInvoice) {
        this.idPurchaseInvoice = idPurchaseInvoice;
    }

    public String getIdConsumable() {
        return idConsumable;
    }

    public void setIdConsumable(String idConsumable) {
        this.idConsumable = idConsumable;
    }

    public String getPriceConsumable() {
        return priceConsumable;
    }

    public void setPriceConsumable(String priceConsumable) {
        this.priceConsumable = priceConsumable;
    }

    public String getQuantityConsumable() {
        return quantityConsumable;
    }

    public void setQuantityConsumable(String quantityConsumable) {
        this.quantityConsumable = quantityConsumable;
    }
}
