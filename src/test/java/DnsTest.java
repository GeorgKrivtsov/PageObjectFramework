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



        //Проверка загрузки страницы
        findBlock.checkOpenPage();
        //Вбиваем в поиске айфоне
        findBlock.searchItem("iphone");
        //Находим в списке нужный
        searchPage.searchElementByVendorCode("5072935");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Запоминаем стоимость
        int priceFirstProduct = productPage.getPriceOfProduct();
        //Выбираем вкладку гарантии
        productPage.clickOnAdditionalSale();
        //Выбираем гарантию
        productPage.clickOnAdditionalCheckBox();
        //Запоминаем стоимость гарантии
        int countAdditional = productPage.getCountAdditional();
        //Нажимаем купить
        productPage.clickOnButtonBuy();
        //Ищем наушники
        findBlock.searchItem("Apple AirPods Pro 2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Запомниаем цену наушников
        int priceSecondProsuct = productPage.getPriceOfProduct();
        //Добавляем в карзину
        productPage.clickOnButtonBuy();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Проверяем сумму в карзине
        Assertions.assertEquals(findBlock.getBasketSummary(), priceFirstProduct+countAdditional+priceSecondProsuct, "неверная сумма покупки");
        //Переходим в карзину
        findBlock.clickOnBasket();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Проверка нужной гарантии
        basketPage.checkPhoneAdditional("5072935");
        //Проверка общей суммы товаров
        basketPage.checkSummaryPrice();
        //удаляем по имени
        basketPage.removeProduct("Apple AirPods Pro 2");
        //Проверяем удалился ли товар
        basketPage.checkRemoveProduct("Apple AirPods Pro 2");
        //Проверяем изменилась ли цена
        basketPage.checkSummaryPrice();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Проверить работает ли
        basketPage.addProduct("5072935", 2);
        //проверяем изменение цены
        basketPage.checkSummaryPrice();
        //Возвращаем удаленный товар
        basketPage.returnRemoveProduct();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //проверяем изменение цены
        basketPage.checkSummaryPrice();



    }

}
