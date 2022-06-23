package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordRecovery {
    WebDriver webDriver = null;

    public PasswordRecovery(WebDriver driver)
    {
    this.webDriver=driver;
    }
    public WebElement email()
    {
        return webDriver.findElement(By.id("Email"));
    }
    public WebElement passwordRecoveryMsg()
    {
        return webDriver.findElement(By.cssSelector("div[class=\"bar-notification success\""));
    }
    public WebElement emailNotfound()
    {
        return webDriver.findElement(By.cssSelector("p[class=\"content\"]"));
    }
}
