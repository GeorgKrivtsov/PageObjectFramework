package framework.pages;

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

    public int getPriceOfProduct() {
        return Integer.parseInt(priceProduct.getText().replaceAll("[^0-9]", ""));
    }

    public void clickOnAdditionalSale() {
        additionalSale.click();
    }

    public void clickOnAdditionalCheckBox(){
        checkBox.click();
    }

    public void clickOnButtonBuy(){
        buttonBuy.click();
    }

    public int getCountAdditional(){
        return Integer.parseInt(countAdditional.getText().replaceAll("[^0-9]", ""));
    }


}
