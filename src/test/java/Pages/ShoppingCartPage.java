package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage {
    WebDriver webDriver = null;
    public ShoppingCartPage(WebDriver driver){
        this.webDriver = driver;
    }
    public List<WebElement> skuElements()
    {
        return webDriver.findElements(By.cssSelector("span[class=\"sku-number\"]"));
    }
    public List<WebElement> compareList()
    {
        return webDriver.findElements(By.cssSelector("a[class=\"picture\"]"));
    }
    public WebElement checkoutBtn()
    {
        return webDriver.findElement(By.id("checkout"));
    }
    public WebElement acceptTerms()
    {
        return webDriver.findElement(By.id("termsofservice"));
    }
    public WebElement continueAsGuest()
    {
        return webDriver.findElement(By.cssSelector("button[class=\"button-1 checkout-as-guest-button\"]"));
    }
}
