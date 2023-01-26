package framework.product;

public class Product {

    private String name;
    private String vendorCode;
    private int price;
    private int additionalPrice;



    public Product(String name, String vendorCode, int price, int additionalPrice) {
        this.name = name;
        this.vendorCode = vendorCode;
        this.price = price;
        this.additionalPrice = additionalPrice;


    }
    public String getName() {
        return name;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public int getPrice() {
        return price;
    }

    public int getAdditionalPrice(){
        return additionalPrice;
    }
}
