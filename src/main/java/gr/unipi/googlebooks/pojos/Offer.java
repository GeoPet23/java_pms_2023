
package gr.unipi.googlebooks.pojos;


public class Offer {

    private long finskyOfferType;
    private ListPrice listPrice;
    private RetailPrice retailPrice;

    public long getFinskyOfferType() {
        return finskyOfferType;
    }

    public void setFinskyOfferType(long finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    public ListPrice getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice retailPrice) {
        this.retailPrice = retailPrice;
    }

}
