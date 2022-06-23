package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AfterRegistrationPage {
    WebDriver webDriver = null;
    public AfterRegistrationPage(WebDriver driver)
    {
        this.webDriver = driver;
    }
    public WebElement resultMsg()
    {
        return webDriver.findElement(By.cssSelector("div[class=\"result\"]"));
    }
}
