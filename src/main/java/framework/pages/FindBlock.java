package framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class FindBlock {

    @FindBy(xpath = "//input[@class='presearch__input']")
    private WebElement search;

    @FindBy(xpath = "//a[contains(@class, 'cart-link-counter')]")
    private WebElement basket;

    public void searchItem(String text){
        search.sendKeys(text);
        search.sendKeys(Keys.ENTER);
    }

    public void clickOnBasket() {
        basket.click();
    }


}
