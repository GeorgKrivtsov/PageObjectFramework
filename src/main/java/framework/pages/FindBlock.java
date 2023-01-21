package framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class FindBlock extends BasePage {

    @FindBy(xpath = "//input[@class='presearch__input']")
    private WebElement searchLine;

    @FindBy(xpath = "//span[@class='presearch__icon-search']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(@class, 'cart-link-counter')]")
    private WebElement basket;

    @FindBy(xpath = "//a[contains(@class, 'cart-link-counter')]/span/span[contains(@class, 'cart-link-counter__price')]")
    private WebElement basketSummary;

    public FindBlock checkOpenPage(){
        Assertions.assertTrue(waitUtilElementToBeVisible(searchLine).isDisplayed(), "Страница не загрузилась");
        return pageManager.getFindBlock();
    }

    public void searchItem(String text){
        searchLine.sendKeys(text);
        searchButton.click();
    }

    public void clickOnBasket() {
        basket.click();
    }

    public int getBasketSummary(){
        return Integer.parseInt(basketSummary.getText().replaceAll("[^0-9]", ""));
    }


}
