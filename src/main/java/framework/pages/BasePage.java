package framework.pages;

import framework.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getInstance();
    //protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 10, 1000);

    public BasePage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }


//    protected WebElement waitUntilElementToBeClickable(WebElement element){
//        return wait.until(ExpectedConditions.elementToBeClickable(element));
//    }

}
