package framework.product;

import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ProductList  {


    private List<Product> productList;

//    public List<Product> getProductList() {
//        return productList;
//    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public Product getProductFromListForVendorCode(String code){
        for (Product product : productList){
            if(product.getVendorCode().equalsIgnoreCase(code)){
                return product;
            }
        }
        Assertions.fail("нет такого продукта");
        return null;
    }

    public Product getProductFromListForName(String name){
        for (Product product : productList){
            if(product.getName().contains(name)){
                return product;
            }
        }
        Assertions.fail("нет такого продукта");
        return null;
    }

}
