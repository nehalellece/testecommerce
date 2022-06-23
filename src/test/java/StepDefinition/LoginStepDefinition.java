package StepDefinition;

import Pages.AfterRegistrationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {
    WebDriver driver = null ;
    HomePage homePage = null;
    LoginPage loginPage = null;

    /*@Before
    public void userOpenBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);



        driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(2000);
//        homePage.registerLink().click();

    }*/

    /*@Given("user open login Page")
    public void user_open_login_page() {
        // Write code here that turns the phrase above into concrete actions
        homePage.registerLink().click();
        throw new io.cucumber.java.PendingException();
    }*/

    @Given("user open login Page")
    public void openLoginTab()   {

//        driver.findElement(By.cssSelector("a[class=\"ico-login\"]")).click();
        homePage.loginLink().click();
//        homePage.registerLink().click();
    }
    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void enterData(String email , String password)
    {

        loginPage.enterData(email, password);
    }
    @And("user click on LOG IN Button")
    public void userClickLoginBtn()
    {

        loginPage.loginBtn().click();
    }

    @And("\"My account\" tab is displayed")
    public void myAccountTabDisplayed()
    {
        Assert.assertTrue("account tab does not displayed",homePage.myAccountTab().isDisplayed());
    }


    @Then("^browser go to \"(.*)\"$")
    public void goToHomePage(String expectedURL) {
//        expectedURL = "https://demo.nopcommerce.com/";
        Assert.assertEquals("Wrong URL",expectedURL,driver.getCurrentUrl());
    }

    @Then("^Error Msg Displayed \"(.*)\"$")
    public void errorMsgDisplayed(String expectedMsg)
    {

        Assert.assertTrue("Error Msg Wrong",loginPage.errorMsg().getText().contains(expectedMsg));
    }
    @And("Error Msg in red color")
    public void errorMsgRed()
    {

    }
    /*@After
    public void closeBrowser ()
    {
        driver.quit();
    }*/
}
