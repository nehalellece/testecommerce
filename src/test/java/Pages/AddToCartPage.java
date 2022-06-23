package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {
    WebDriver webDriver = null;
    public AddToCartPage(WebDriver driver)
    {
        this.webDriver = driver;
    }
    public WebElement addToCartBtn ()
    {
        return webDriver.findElement(By.id("add-to-cart-button-25"));
    }
}
