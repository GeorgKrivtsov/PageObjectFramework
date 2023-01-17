package tests;

import framework.managers.DriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTests {

    private static DriverManager driverManager = DriverManager.getInstance();

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
