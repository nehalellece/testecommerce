import Pages.HomePage;
import Pages.LoginPage;
import Pages.PasswordRecovery;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.Key;

public class PasswordTest {
    WebDriver driver = null;
    HomePage homePage = null;
    PasswordRecovery passwordRecovery = null;
    LoginPage loginPage = null ;
    SoftAssert softAssert = null ;


    @BeforeMethod
    public void userOpenBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        passwordRecovery = new PasswordRecovery(driver);
        softAssert = new SoftAssert();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @Test
    public void validRecoverTest() throws InterruptedException {
        /*homePage.loginLink().click();
        Thread.sleep(2000);
        loginPage.forgetPasswordLink().click();
        Thread.sleep(2000);
        passwordRecovery.email().sendKeys("test3@mail.com");
        passwordRecovery.email().sendKeys(Keys.ENTER);
        Thread.sleep(2000);*/

        passwordRecover("test3@mail.com");
        String expectedMsg = "Email with instructions has been sent to you.";
        softAssert.assertTrue(passwordRecovery.passwordRecoveryMsg().getText().contains(expectedMsg),"Password Recover Msg Error");
        softAssert.assertAll();
    }
    @Test
    public void invalidRecoverTest() throws InterruptedException {
        /*homePage.loginLink().click();
        Thread.sleep(2000);
        loginPage.forgetPasswordLink().click();
        Thread.sleep(2000);
        passwordRecovery.email().sendKeys("eyad@mail.com");
        passwordRecovery.email().sendKeys(Keys.ENTER);
        Thread.sleep(2000);*/

        passwordRecover("eyad@mail.com");
        String expectedMsg = "Email not found..";
        softAssert.assertTrue(passwordRecovery.emailNotfound().getText().contains(expectedMsg),"Password Recover Msg Error");
        softAssert.assertAll();
    }
    public void passwordRecover(String emailTest) throws InterruptedException {
        homePage.loginLink().click();
        Thread.sleep(2000);
        loginPage.forgetPasswordLink().click();
        Thread.sleep(2000);
        passwordRecovery.email().sendKeys(emailTest);
        passwordRecovery.email().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    @AfterMethod
    public void closeBrowser ()
    {
        driver.quit();
    }
}
