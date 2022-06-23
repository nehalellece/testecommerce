import Pages.HomePage;
import Pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {
    WebDriver driver = null ;
    HomePage homePage = null;
    LoginPage loginPage = null;
    SoftAssert softAssert = null;

    @BeforeMethod
    public void userOpenBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        softAssert = new SoftAssert();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @Test
    public void loginValidTest() throws InterruptedException {
        homePage.loginLink().click();
        loginPage.enterData("test3@mail.com","as123sa54");
        loginPage.loginBtn().click();
        Thread.sleep(2000);
        String expectedURL = "https://demo.nopcommerce.com/";
        System.out.println("Nehal "+driver.getCurrentUrl());

        softAssert.assertEquals( driver.getCurrentUrl(), expectedURL,"Wrong URL");
        softAssert.assertTrue(homePage.myAccountTab().isDisplayed(),"account tab does not displayed");
//        String expectedMsg = "Login was unsuccessful. Please correct the errors and try again.";
//        softAssert.assertFalse(loginPage.errorMsg().getText().contains(expectedMsg),"Error Msg Wrong");
        softAssert.assertAll();
    }
    @Test
    public void loginInvalidTest() throws InterruptedException {
        homePage.loginLink().click();
        loginPage.enterData("test11@gmail.com","as123sa54");
        loginPage.loginBtn().click();
        Thread.sleep(2000);

        String expectedMsg = "Login was unsuccessful. Please correct the errors and try again.";
        softAssert.assertTrue(loginPage.errorMsg().getText().contains(expectedMsg),"Error Msg Wrong");
        softAssert.assertAll();
    }

    @AfterMethod
    public void closeBrowser ()
    {
        driver.quit();
    }
}
