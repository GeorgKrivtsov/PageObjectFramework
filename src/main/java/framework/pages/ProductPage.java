package framework.pages;

import framework.managers.PageManager;
import framework.product.Product;
import framework.product.ProductList;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//div[@class='product-buy__price']")
    private WebElement priceProduct;
    @FindBy(xpath = "//div[@class='additional-sales-tabs__title' and contains(text(), 'Гарантия')]")
    private WebElement additionalSale;
    @FindBy(xpath = "//input[@class='ui-radio__input' and @value='0']/../span[contains(text(), 'гарантия')]")
    private WebElement checkBox;
    @FindBy(xpath = "//div[@class='product-buy product-buy_one-line']/..//button[contains(@class,'buy-btn')]")
    private WebElement buttonBuy;
    @FindBy(xpath = "//label[contains(@class, 'product-warranty__item_hit')]/span[@class='product-warranty__price']")
    private WebElement countAdditional;
    @FindBy(xpath = "//h1[contains(@class, 'title')]")
    private WebElement nameProduct;
    @FindBy(xpath = "//div[@class='product-card-top__code']")
    private WebElement vendorCode;


    public ProductPage checkOpenPage() {
        WebElement header = driverManager.getDriver().findElement(By.xpath("//h1"));
        waitUtilElementToBeVisible(header);
        Assertions.assertTrue(header.isDisplayed(), "страница не загрузилась");
        return pageManager.getProductPage();
    }



    public int getPriceOfProduct() {
        return Integer.parseInt(priceProduct.getText().replaceAll("[^0-9]", ""));
    }

    public ProductPage clickOnAdditionalSale() {
        additionalSale.click();
        return pageManager.getProductPage();
    }

    public ProductPage clickOnAdditionalCheckBox(){
        checkBox.click();
        return pageManager.getProductPage();
    }

    public PageManager clickOnButtonBuy(){
        buttonBuy.click();
        return pageManager;
    }

    public int getCountAdditional(){
        return Integer.parseInt(countAdditional.getText().replaceAll("[^0-9]", ""));
    }



    // Методы для получения продукта


    public void createAndAddProductForProductList(){
        Product product = new Product(getNameProduct(), getVendorCode(), getPriceProduct(), getCountAdditional());
        pageManager.getProductList().addProduct(product);
    }
    public String getNameProduct(){
        return nameProduct.getText();
    }

    public String getVendorCode(){
        return vendorCode.getText().replaceAll("[^0-9]", "");
    }

    public int getPriceProduct(){
        return Integer.parseInt(buttonBuy.findElement(By.xpath("./../div/div[contains(@class, 'price')]")).getText().replaceAll("[^0-9]", "")) - Integer.parseInt(countAdditional.getText().replaceAll("[^0-9]", ""));
    }

}
