package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver webDriver = null;

    public LoginPage(WebDriver driver)
    {
        this.webDriver = driver;
    }
    public WebElement email()
    {
        return webDriver.findElement(By.id("Email"));
    }
    public WebElement password()
    {
        return webDriver.findElement(By.id("Password"));
    }
    public WebElement loginBtn()
    {
        return webDriver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]"));
    }
    public WebElement forgetPasswordLink ()
    {
        return webDriver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"]")) ;
    }
    public void enterData(String email , String password)
    {
        email().sendKeys(email);
        password().sendKeys(password);
    }
    public WebElement errorMsg()
    {
        return webDriver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"));
    }
}
