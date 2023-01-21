package framework.pages;

import framework.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'catalog-products')]/div")
    private List<WebElement> searchList;

    @FindBy(xpath = "//a[@class='pagination-widget__page-link pagination-widget__page-link_next ']")
    private WebElement buttonNextPage;

    @FindBy(xpath = "//div[@data-code='5072935']/a[contains(@class, 'ui-link')]")
    private WebElement productLink;

    public ProductPage searchElementByVendorCode(String code){
        for (WebElement itemProduct : searchList) {
            WebElement imageProduct = itemProduct.findElement(By.xpath("./div[@class='catalog-product__image']"));
            new Actions(DriverManager.getInstance().getDriver())
                    .moveToElement(imageProduct)
                    .pause(250)
                    .build()
                    .perform();

            //прописать отдельный див для артикля
            WebElement productVendorCode = itemProduct.findElement(By.xpath("//div[contains(@class, 'catalog-products')]/div/div/div[@class='catalog-product__code']"));

            if(productVendorCode.getText().contains(code)) {
                productLink.click();
                return pageManager.getProductPage();
            }

        }
        Assertions.fail("Продукт не найден");
        return pageManager.getProductPage();
    }

    public ProductPage goToProductPage() {
        return pageManager.getProductPage();
    }

}
