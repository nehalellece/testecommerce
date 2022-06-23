package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnePageCheckoutPage {
    WebDriver webDriver = null;

    public OnePageCheckoutPage(WebDriver driver)
    {
        this.webDriver = driver;
    }
    public WebElement firstName()
    {
        return webDriver.findElement(By.id("BillingNewAddress_FirstName"));
    }
    public WebElement lastName()
    {
        return webDriver.findElement(By.id("BillingNewAddress_LastName"));
    }public WebElement email()
    {
        return webDriver.findElement(By.id("BillingNewAddress_Email"));
    }public WebElement company()
    {
        return webDriver.findElement(By.id("BillingNewAddress_Company"));
    }public WebElement country()
    {
        return webDriver.findElement(By.id("BillingNewAddress_CountryId"));
    }public WebElement city()
    {
        return webDriver.findElement(By.id("BillingNewAddress_City"));
    }public WebElement address1()
    {
        return webDriver.findElement(By.id("BillingNewAddress_Address1"));
    }public WebElement address2()
    {
        return webDriver.findElement(By.id("BillingNewAddress_Address2"));
    }public WebElement zip()
    {
        return webDriver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
    }public WebElement phoneNumber()
    {
        return webDriver.findElement(By.id("BillingNewAddress_PhoneNumber"));
    }public WebElement faxNumber()
    {
        return webDriver.findElement(By.id("BillingNewAddress_FaxNumber"));
    }public WebElement contBtn()
    {
        return webDriver.findElement(By.cssSelector("button[onclick=\"Billing.save()\"]"));
    }
    public WebElement contBtn1()
    {
        return webDriver.findElement(By.cssSelector("button[onclick=\"ShippingMethod.save()\"]"));
    }
    public WebElement contBtn2()
    {
        return webDriver.findElement(By.cssSelector("button[onclick=\"PaymentMethod.save()\"]"));
    }
    public WebElement contBtn3()
    {
        return webDriver.findElement(By.cssSelector("button[onclick=\"PaymentInfo.save()\"]"));
    }
    public WebElement contBtn4()
    {
        return webDriver.findElement(By.cssSelector("button[onclick=\"ConfirmOrder.save()\"]"));
    }
    public WebElement succecMsg()
    {
        return webDriver.findElement(By.xpath("//div//div//div//div//div//div//div[@class=\"title\"]"));
    }

    public List<WebElement> fields()
    {
        return webDriver.findElements(By.cssSelector("div[class=\"inputs\"]"));
    }
    public void fillField(List<String> fieldText)
    {
        for (int i = 0 ; i<fieldText.size() ; i++)
        {
            fields().get(i).sendKeys(fieldText.get(i));
        }
    }
}
