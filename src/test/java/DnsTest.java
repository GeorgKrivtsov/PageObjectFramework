import framework.managers.DriverManager;
import framework.pages.FindBlock;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tests.BaseTests;

import java.util.List;

public class DnsTest extends BaseTests {

    FindBlock findBlock = new FindBlock();

    @Test
    public void testScenario(){

        WebElement search = DriverManager.getInstance().getDriver().findElement(By.xpath("//input[@class='presearch__input']"));
        search.sendKeys("iphone");
        search.sendKeys(Keys.ENTER);

        //WebElement catalog1 = DriverManager.getInstance().getDriver().findElement(By.xpath("//div[contains(@class, 'catalog-products')]"));
        //List<WebElement> listCatalog = (List<WebElement>) DriverManager.getInstance().getDriver().findElement(By.xpath("//div[contains(@class, 'catalog-products')]"));

//        WebElement productCard = DriverManager.getInstance().getDriver().findElement(By.xpath("//div[@data-code='5072935']"));

        WebElement productLink = DriverManager.getInstance().getDriver().findElement(By.xpath("//div[@data-code='5072935']/a[contains(@class, 'ui-link')]"));
        productLink.click();


        WebElement priceProduct1 = DriverManager.getInstance().getDriver().findElement(By.xpath("//div[@class='product-buy__price']"));
        String priceProduct = priceProduct1.getText();

        WebElement additionalSale = DriverManager.getInstance().getDriver().findElement(By.xpath("//div[@class='additional-sales-tabs__title' and contains(text(), '12 мес')]"));
        additionalSale.click();

        WebElement checkBox = DriverManager.getInstance().getDriver().findElement(By.xpath("//input[@class='ui-radio__input' and @value='0']/../span[@class='ui-radio__content']"));
        checkBox.click();

        WebElement buttonBuy = DriverManager.getInstance().getDriver().findElement(By.xpath("//button[@class='button-ui buy-btn button-ui_brand button-ui_passive']"));
        buttonBuy.click();




    }

}
