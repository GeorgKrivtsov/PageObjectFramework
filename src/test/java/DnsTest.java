import framework.managers.DriverManager;
import framework.pages.BasketPage;
import framework.pages.FindBlock;
import framework.pages.ProductPage;
import framework.pages.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTests;

import java.util.List;

public class DnsTest extends BaseTests {

    @Test
    public void testScenario(){

        pageManager.getFindBlock()
                .checkOpenPage()
                .searchItem("iphone")
                .searchElementByVendorCode("5072935")
                .checkOpenPage();

        //Запоминаем стоимость
        int priceFirstProduct = pageManager.getProductPage().getPriceOfProduct();

        pageManager.getProductPage()
                .clickOnAdditionalSale()
                .clickOnAdditionalCheckBox();

        //Запоминаем стоимость гарантии
        int countAdditional = pageManager.getProductPage().getCountAdditional();

        pageManager.getProductPage()
                .clickOnButtonBuy()
                .getFindBlock()
                .searchItem("Apple AirPods Pro 2")
                .goToProductPage()
                .checkOpenPage();

        //Запомниаем цену наушников
        int priceSecondProsuct = pageManager.getProductPage().getPriceOfProduct();

        pageManager.getProductPage()
                .clickOnButtonBuy();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Проверяем сумму в карзине
        Assertions.assertEquals(pageManager.getFindBlock().getBasketSummary(),
                priceFirstProduct+countAdditional+priceSecondProsuct, "неверная сумма покупки");

        pageManager.getFindBlock()
                .clickOnBasket()
                .checkPhoneAdditional("5072935")
                .checkSummaryPrice()
                .removeProduct("Apple AirPods Pro 2")
                .checkRemoveProduct("Apple AirPods Pro 2")
                .checkSummaryPrice()
                .addProduct("5072935", 2) //возможно нужна пауза
                .checkSummaryPrice()
                .returnRemoveProduct()
                .checkSummaryPrice();




//



    }

}
