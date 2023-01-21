package framework.product;

public class Product {

    private String name;
    private String vendorCode;
    private int price;

    public Product(String name, String vendorCode, int price) {
        this.name = name;
        this.vendorCode = vendorCode;
        this.price = price;
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
}
