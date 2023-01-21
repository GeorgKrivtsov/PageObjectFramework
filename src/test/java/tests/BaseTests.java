package tests;

import framework.managers.DriverManager;
import framework.managers.PageManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTests {

    private static DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();


    @BeforeAll
    public static void berfore(){

        //Переходим на сайт
        driverManager.getDriver().get("http://www.dns-shop.ru");

    }

//    @AfterAll
//    public static void after() {
//        driverManager.quitDriver();
//    }

}
