package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage {
    private WebDriver webDriver = null;

    public HomePage(WebDriver driver)
    {
        this.webDriver = driver;
    }

    public WebElement registerLink()
    {
        return webDriver.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\"]"));
    }
    public WebElement loginLink ()
    {

//        return webDriver.findElement(By.xpath("//a[@href=\"/login?returnUrl=%2F\"]"));
        return webDriver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
    }
    public List<WebElement> colorCheckBox()
    {
        return webDriver.findElements(By.className("item"));

    }
    public List<WebElement> addToCartBtns()
    {
//        return webDriver.findElements(By.className("button-2"));
return webDriver.findElements(By.cssSelector("button[class=\"button-2 product-box-add-to-cart-button\"]"));
    }
    public List<WebElement> addToWishListBtn()
    {
        return webDriver.findElements(By.cssSelector("button[title=\"Add to wishlist\"]"));
    }


    public List<WebElement> addToCompareListBtn()
    {
        return webDriver.findElements(By.cssSelector("button[title=\"Add to compare list\"]"));
    }
    public WebElement productAddMsgLink ()
    {
        return webDriver.findElement(By.xpath("//div//div//p//a[@href=\"/cart\"]"));
    }
    public WebElement productWishMsgLink()
    {
        return webDriver.findElement(By.xpath("//div//div//p//a[@href=\"/wishlist\"]"));

    }
    public WebElement productCompareMsgLink()
    {
        return webDriver.findElement(By.xpath("//div//div//p//a[@href=\"/compareproducts\"]"));

    }
    public WebElement shoppingCartLink()
    {
        return webDriver.findElement(By.cssSelector("A[class=\"ico-cart\"]"));
    }
    public WebElement productAddedMsg()
    {
        return webDriver.findElement(By.cssSelector("p[class=\"content\"]"));
    }
    public WebElement myAccountTab()
    {
        return webDriver.findElement(By.xpath("//a[@class=\"ico-account\"]"));
    }
    public By customerCurrency()
    {
        return By.id("customerCurrency");
    }
    public WebElement searchItemField()
    {
        return webDriver.findElement(By.id("small-searchterms"));
    }
    public WebElement searchBtn()
    {
        return webDriver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }
    public List<WebElement> productItems()
    {
        return webDriver.findElements(By.className("product-item"));
    }
    public WebElement noResultField ()
    {
        return webDriver.findElement(By.className("no-result"));
    }
    public WebElement selectCategory()
    {
        // hover on "Computers"
        return this.webDriver.findElement(
                By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/apparel\"]"));
    }

    public WebElement selectComputerCategory()
    {
        return this.webDriver.findElement(
                By.xpath("//ul[@class=\"top-menu notmobile\"]//li//a[@href=\"/computers\"]"));
    }
    public WebElement selectComputerSubCategory()
    {
        return this.webDriver.findElement(By.xpath(
                "//ul[@class=\"top-menu notmobile\"]//ul[@class=\"sublist first-level\"]//li//a[@href=\"/desktops\"]"));
    }
    public WebElement selectDigitalDownloadsCategory()
    {
        return this.webDriver.findElement(
                By.xpath("//ul[@class=\"top-menu notmobile\"]//li//a[@href=\"/digital-downloads\"]"));
    }
    public WebElement selectGiftCardCategory()
    {
        return this.webDriver.findElement(
                By.xpath("//ul[@class=\"top-menu notmobile\"]//li//a[@href=\"/gift-cards\"]"));
    }

    public WebElement selectJewelryCategory()
    {
        return this.webDriver.findElement(
                By.xpath("//ul[@class=\"top-menu notmobile\"]//li//a[@href=\"/jewelry\"]"));
    }
    public WebElement selectComputersCategory()
    {
        // hover on "Computers"
        return this.webDriver.findElement(
                By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]"));
    }
    public WebElement selectSubCategory()
    {
        return webDriver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/shoes\"]"));
    }
    public WebElement selectSoftwareSubCategory()
    {
        return webDriver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/software\"]"));
    }
    public void moveToSubCategory(WebElement selectcategory  , WebElement selectSubCategory) throws InterruptedException {

        Actions action = new Actions(this.webDriver);

        action.moveToElement(selectcategory).perform();
        Thread.sleep(2000);
action.contextClick(selectSubCategory);

    }
    public WebElement pageTitle()
    {
        return webDriver.findElement(By.className("page-title"));
    }
}
