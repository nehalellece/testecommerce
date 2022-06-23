import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

public class HomePageTest {
    WebDriver driver = null;
    HomePage homePage = null;
    SoftAssert softAssert = null;

    AddToCartPage addToCartPage = null;
    ShoppingCartPage shoppingCartPage = null;
    OnePageCheckoutPage onePageCheckoutPage = null;


    @BeforeMethod
    public void userOpenBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        addToCartPage = new AddToCartPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        onePageCheckoutPage = new OnePageCheckoutPage(driver);
        softAssert = new SoftAssert();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @Test
    public void selectCategoryTest() throws InterruptedException {

        homePage.moveToSubCategory(homePage.selectCategory(), homePage.selectSubCategory());
        String subCategoryName = homePage.selectSubCategory().getText().toLowerCase().trim();
        homePage.selectSubCategory().click();
        Thread.sleep(2000);
//        System.out.println("1 "+homePage.selectCategory().getText());
//        System.out.println("2 "+homePage.selectSubCategory().getText());
//        System.out.println("3 "+subCategoryName);
        softAssert.assertTrue(subCategoryName.equals(homePage.pageTitle().getText().toLowerCase().trim())
                            ,"Wrong Category");
        softAssert.assertAll();

    }
    @Test //sometimes fail
    public void addToCart() throws InterruptedException {
        homePage.moveToSubCategory(homePage.selectComputersCategory(), homePage.selectSoftwareSubCategory());
        homePage.selectSoftwareSubCategory().click();
        Thread.sleep(2000);
        int itemArraySize = homePage.addToCartBtns().size();
//        System.out.println(homePage.addToCartBtns().get(getRandomNumberInRange(0,itemArraySize)).getText());
        String expectedAddedMsg = "The product has been added to your shopping cart";
        System.out.println(expectedAddedMsg);
        /*try {
            homePage.addToCartBtns().get(getRandomNumberInRange(0, itemArraySize)).click();
        }catch (Exception In) {
            homePage.addToCartBtns().get(getRandomNumberInRange(0, itemArraySize)).click();
        }*/
        homePage.addToCartBtns().get(0).click();
        Thread.sleep(1000);
        String actualMsg = homePage.productAddedMsg().getText()/*+" "+homePage.productAddMsgLink().getText()*/;
        System.out.println("2   "+expectedAddedMsg);
        System.out.println("1  "+actualMsg);
        softAssert.assertTrue(actualMsg.contains(expectedAddedMsg),"Wrong add msg");
        Thread.sleep(1000);
        homePage.addToCartBtns().get(itemArraySize-1).click();
        actualMsg = homePage.productAddedMsg().getText();
        softAssert.assertTrue(actualMsg.contains(expectedAddedMsg),"Wrong add msg");
        homePage.productAddMsgLink().click();
        Thread.sleep(2000);
        System.out.println(shoppingCartPage.skuElements().size() +" "+ shoppingCartPage.skuElements().get(0).getText());
        softAssert.assertTrue(shoppingCartPage.skuElements().size()==2,"Not all products added to cart");
        softAssert.assertAll();
    }
    @Test
    public void makeAnOrder() throws InterruptedException {
        homePage.moveToSubCategory(homePage.selectComputersCategory(), homePage.selectSoftwareSubCategory());
        homePage.selectSoftwareSubCategory().click();
        Thread.sleep(2000);
        String expectedAddedMsg = "The product has been added to your shopping cart";
        System.out.println(expectedAddedMsg);
        homePage.addToCartBtns().get(0).click();
        Thread.sleep(1000);
        homePage.productAddMsgLink().click();
//      Thread.sleep(2000);
        shoppingCartPage.acceptTerms().click();
        shoppingCartPage.checkoutBtn().click();
        Thread.sleep(2000);
        shoppingCartPage.continueAsGuest().click();

        onePageCheckoutPage.firstName().sendKeys("Eyaad");
        onePageCheckoutPage.lastName().sendKeys("Eyad");
        onePageCheckoutPage.email().sendKeys("eyad@mail.com");
        onePageCheckoutPage.company().sendKeys("asd");
        onePageCheckoutPage.country().sendKeys("egypt");
        onePageCheckoutPage.city().sendKeys("cairo");
        onePageCheckoutPage.address1().sendKeys("asd");
        onePageCheckoutPage.address2().sendKeys("asd");
        onePageCheckoutPage.zip().sendKeys("5654");
        onePageCheckoutPage.phoneNumber().sendKeys("6546");
        onePageCheckoutPage.faxNumber().sendKeys("654");
        onePageCheckoutPage.contBtn().click();
        Thread.sleep(2000);
        onePageCheckoutPage.contBtn1().click();
        Thread.sleep(2000);
        onePageCheckoutPage.contBtn2().click();
        Thread.sleep(2000);
        onePageCheckoutPage.contBtn3().click();
        Thread.sleep(2000);
        onePageCheckoutPage.contBtn4().click();
        Thread.sleep(2000);
        String expectedMsg = "Your order has been successfully processed!";
        softAssert.assertTrue(onePageCheckoutPage.succecMsg().getText().contains(expectedMsg),"Error Success");
//        onePageCheckoutPage.fillField(fieldToFill);

    }
    @Test  // fail
    public void compareProductTest() throws InterruptedException {
        homePage.moveToSubCategory(homePage.selectComputersCategory(), homePage.selectSoftwareSubCategory());
        homePage.selectSoftwareSubCategory().click();
        Thread.sleep(2000);
        int itemArraySize = homePage.addToCompareListBtn().size();
        String expectedAddedMsg = "The product has been added to your product comparison";

        homePage.addToCompareListBtn().get(0).click();
        Thread.sleep(1000);
        String actualMsg = homePage.productAddedMsg().getText();

        softAssert.assertTrue(actualMsg.contains(expectedAddedMsg),"Wrong add msg");
        System.out.println("1 added  "+homePage.addToCompareListBtn().get(0).getText());
        Thread.sleep(1000);
        homePage.addToCompareListBtn().get(itemArraySize-1).click();
        actualMsg = homePage.productAddedMsg().getText();

        softAssert.assertTrue(actualMsg.contains(expectedAddedMsg),"Wrong add msg");
        System.out.println("2 added  "+homePage.addToCompareListBtn().get(itemArraySize-1).getText());
        homePage.productCompareMsgLink().click();
        System.out.println(shoppingCartPage.compareList().size() +" "+ shoppingCartPage.compareList().get(0).getText());
        softAssert.assertTrue(shoppingCartPage.compareList().size()==2,"Not all products added to cart");

        softAssert.assertAll();

    }
    @Test
    public void addToWishList() throws InterruptedException {
        homePage.moveToSubCategory(homePage.selectComputersCategory(), homePage.selectSoftwareSubCategory());
        homePage.selectSoftwareSubCategory().click();
        Thread.sleep(2000);
        int itemArraySize = homePage.addToWishListBtn().size();
        String expectedAddedMsg = "The product has been added to your wishlist";

        homePage.addToWishListBtn().get(0).click();
                Thread.sleep(1000);
        String actualMsg = homePage.productAddedMsg().getText();

        softAssert.assertTrue(actualMsg.contains(expectedAddedMsg),"Wrong add msg");
        Thread.sleep(1000);
        homePage.addToWishListBtn().get(itemArraySize-1).click();
        actualMsg = homePage.productAddedMsg().getText();

        softAssert.assertTrue(actualMsg.contains(expectedAddedMsg),"Wrong add msg");
        homePage.productWishMsgLink().click();
        System.out.println(shoppingCartPage.skuElements().size() +" "+ shoppingCartPage.skuElements().get(0).getText());
        softAssert.assertTrue(shoppingCartPage.skuElements().size()==2,"Not all products added to cart");

        softAssert.assertAll();

//        span[class="sku-number"]
    }
    @Test
    public void filterByColor() throws InterruptedException {
        homePage.moveToSubCategory(homePage.selectCategory(), homePage.selectSubCategory());
        homePage.selectSubCategory().click();
        Thread.sleep(2000);
        int colorArraySize = homePage.colorCheckBox().size();
//        System.out.println(homePage.colorCheckBox().get(getRandomNumberInRange(0,colorArraySize)).getText());
//        homePage.colorCheckBox().get(getRandomNumberInRange(0,colorArraySize)).click();
homePage.colorCheckBox().get(0).click();
        Thread.sleep(2000);

       /////////////////later
        /*
         I don not know homw to check
         where the data that ensure that i select the right color !!!
         */
        softAssert.assertAll();

    }
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    @Test
    public void existItemSearchTest() throws InterruptedException {
        String searchItem = "Apple";
        String pageURL = driver.getCurrentUrl();
        homePage.searchItemField().sendKeys(searchItem);
        homePage.searchBtn().click();
        Thread.sleep(3000);
        softAssert.assertTrue(driver.getCurrentUrl().equals(pageURL+"search?q="+searchItem),"Wrong URL");
        softAssert.assertTrue(homePage.productItems().size()>=0 ,"no results for search");
        softAssert.assertAll();

    }
    @Test
    public void existSerialSearchTest() throws InterruptedException {
        String searchItem = "AP_MBP_13";
        String pageURL = driver.getCurrentUrl();
        homePage.searchItemField().sendKeys(searchItem);
        homePage.searchBtn().click();
        Thread.sleep(3000);
        softAssert.assertTrue(driver.getCurrentUrl().equals(pageURL+"search?q="+searchItem),"Wrong URL");
        softAssert.assertTrue(homePage.productItems().size()>=0 ,"no results for search");
        softAssert.assertAll();

    }
    @Test
    public void nonExistItemSearchTest() throws InterruptedException {
        String searchItem = "Nehal";
        String pageURL = driver.getCurrentUrl();
        homePage.searchItemField().sendKeys(searchItem);
        homePage.searchBtn().click();
        Thread.sleep(3000);
        softAssert.assertTrue(driver.getCurrentUrl().equals(pageURL+"search?q="+searchItem),"Wrong URL");
        softAssert.assertTrue(homePage.productItems().size()==0 ,"no results for search");
        String expectedMsgNoResult = "No products were found that matched your criteria.";
        softAssert.assertTrue(homePage.noResultField().getText().contains(expectedMsgNoResult),"Wrong search result msg");
        softAssert.assertAll();

    }
    @Test
    public void changCurrency() throws InterruptedException {
        Select select = new Select(driver.findElement(homePage.customerCurrency()));
        select.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
        Thread.sleep(2000);
    }
    @AfterMethod
    public void closeBrowser () throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

}
