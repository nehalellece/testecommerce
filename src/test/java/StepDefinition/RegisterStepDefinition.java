package StepDefinition;

import Pages.AfterRegistrationPage;
import Pages.HomePage;
import Pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterStepDefinition {
    WebDriver driver = null;
    HomePage homePage = null;
    RegisterPage registerPage = null;
    AfterRegistrationPage afterRegistrationPage = null;



    /**/@Before
    public void userOpenBrowser() throws InterruptedException {
        /*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();*/
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        afterRegistrationPage = new AfterRegistrationPage(driver);

        /*driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(2000);*/
    }

    @Given("user open Register Page")
    public void userOpenRegisterPage()

    {
        homePage = new HomePage(driver);
        homePage.registerLink().click();
    }

    @When("user select Gender")
    public void userSelectGender()
    {

        registerPage.femaleGender().click();
    }

    @And("user enter valid Data")
    public void userEnterValidData ()
    {
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
    }
    @And("user click on register button")
    public void userClickRegisterBtn()
    {

        registerPage.registerButton().click();
    }
    @Then("Browser displayes \"Your registration completed\" Msg")
    public void successRegisteration()
    {
        String registerationCompMsg = "Your registration completed";
        Assert.assertTrue("Msg does not exist",afterRegistrationPage.resultMsg().getText().contains(registerationCompMsg));
    }

    @And("\"Your registration completed\" Msg in Green color")
    public void ContBtnAppear ()
    {

        Assert.assertTrue("Successfull msg color wrong",afterRegistrationPage.resultMsg().getCssValue("color").equals("rgba(76, 177, 124, 1)"));
    }

    /*@After
    public void closeBrowser()
    {
        driver.quit();
    }*/
}
