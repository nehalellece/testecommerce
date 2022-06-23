import Pages.AfterRegistrationPage;
import Pages.HomePage;
import Pages.RegisterPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTest {
    WebDriver driver = null;
    HomePage homePage = null;
    RegisterPage registerPage = null;
    AfterRegistrationPage afterRegistrationPage = null;

    SoftAssert softAssert = null;

    @BeforeMethod
    public void userOpenBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        afterRegistrationPage = new AfterRegistrationPage(driver);
        softAssert = new SoftAssert();
        driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(2000);
    }
    @Test
    public void validRegisteration() throws InterruptedException {
        homePage.registerLink().click();
        Thread.sleep(2000);
        registerPage.femaleGender().click();
        ////////////////////////////////////
        String firstName = "Nehal";
        String lastName = "Ellece";
        String birthDay = "3";
        String birthMonth = "May";
        String birthYear = "1987";
        String email = "test3@mail.com";
        String company = "ABC";
        String password = "as123sa54";
        String confirmPassword = "as123sa54";
        registerPage.registerTestData(firstName,lastName,birthDay,birthMonth,birthYear,email,
                company,password,confirmPassword);
        ////////////////////////////////////////////
        registerPage.registerButton().click();
        Thread.sleep(2000);
        String registerationCompMsg = "Your registration completed";
        softAssert.assertTrue(afterRegistrationPage.resultMsg().getText().contains(registerationCompMsg),"Msg does not exist");
        softAssert.assertTrue(afterRegistrationPage.resultMsg().getCssValue("color").equals("rgba(76, 177, 124, 1)"),"Successfull msg color wrong");
        softAssert.assertAll();



    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
