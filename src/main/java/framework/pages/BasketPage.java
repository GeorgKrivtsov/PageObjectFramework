package framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends  BasePage{

    @FindBy(xpath = "//div[@class='cart-items__product']")
    private List<WebElement> productsForBuy;

    @FindBy(xpath = "/button[@class='count-buttons__button count-buttons__button_plus']")
    private WebElement addProductButton;

    @FindBy(xpath = "//div[contains(@class,'additional-warranties-row__hit-warranty')]/div")
    private WebElement additionalSaleCheck;

    @FindBy(xpath = "//div[@class='price summary__price']/div/span[@class='price__current']")
    private WebElement summaryPrice;

    @FindBy(xpath = "//span[contains(@class, 'cart-tab-menu__item')]/span")
    private WebElement returnRemoveProduct;

//    @FindBy(xpath = "//div[@class='cart-items__product-code']/div")
//    private WebElement productCode;

    public void removeProduct(String name){
        for (WebElement itemProduct : productsForBuy) {
            if(itemProduct.getText().contains(name)) {
                WebElement removeButton = itemProduct.findElement(By.xpath("./div/div/div/div/div/div/div/div/div/button[contains(@class, 'remove-button')]"));
                removeButton.click();
                break;
            }
        }
    }


    public void addProduct(String code) {
        for (WebElement itemProduct : productsForBuy) {
            if(itemProduct.getText().contains(code)) {
                WebElement addButton = itemProduct.findElement(By.xpath("./div/div/div/div/div/button[@class='count-buttons__button count-buttons__button_plus']"));
                addButton.click();
                break;
            }
        }
    }

    public void addProduct(String code, int count) {
        for (WebElement itemProduct : productsForBuy) {
            if(itemProduct.getText().contains(code)) {
                WebElement addButton = itemProduct.findElement(By.xpath("./div/div/div/div/div/button[@class='count-buttons__button count-buttons__button_plus']"));
                for (int i = 0; i < count; i++){
                    addButton.click();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            }
        }
    }

    public void returnRemoveProduct(){
        returnRemoveProduct.click();
    }


    public void checkPhoneAdditional(String code){
        for (WebElement itemProduct : productsForBuy) {
            if (itemProduct.getText().contains(code)) {
                WebElement additionalyCheckBox = itemProduct.findElement(By.xpath("./div/div/div/div/div/div/div/div/div[contains(@class, 'base-ui-radio-button') and contains(text(), '12')]"));
                Assertions.assertTrue(additionalyCheckBox.getAttribute("class").contains("checked"), "Гарантия не выбрана");
                break;
            }
        }
    }

    public void checkSummaryPrice(){
        int temp1 = 0;
        int temp2 = Integer.parseInt(summaryPrice.getText().replaceAll("[^0-9]", ""));

        for (WebElement itemProduct : productsForBuy) {
            WebElement itemPrice = itemProduct.findElement(By.xpath("./div/div/div/div/div/div/div/span[@class='price__current']"));
            temp1 += Integer.parseInt(itemPrice.getText().replaceAll("[^0-9]", ""));

            WebElement additionalyCheckBox = itemProduct.findElement(By.xpath("./div/div/div/div/div/div/div/div/div[contains(@class, 'base-ui-radio-button') and contains(text(), '12')]"));

            if (additionalyCheckBox.getAttribute("class").contains("checked")) {
                WebElement count = itemProduct.findElement(By.xpath("./div/div/div/div/div/input[contains(@class, 'button')]"));
                temp1 += (Integer.parseInt(additionalyCheckBox.findElement(By.xpath("./../span")).getText().replaceAll("[^0-9]", ""))
                        * Integer.parseInt(count.getAttribute("value").replaceAll("[^0-9]", "")));
            }
        }

        Assertions.assertTrue(temp1 == temp2, "суммы продуктов и карзины не равны");

    }

    public void checkRemoveProduct(String name) {
        for(WebElement item : productsForBuy) {
            if(item.getText().equalsIgnoreCase(name)) {
                Assertions.fail("Товар не удалился");
            }
        }

    }

    public int getSummaryPrice(){
        return Integer.parseInt(summaryPrice.getText().replaceAll("[^0-9]", ""));
    }



}
