package StepDefinition;

import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePageStepDefinition {


    WebDriver driver = null;
    HomePage homePage = null;
    Hooks hooks = null;
    String expectedText = null;
    String pageURL = null;
    SoftAssert softAssert = null;

    @Before
    public void setHomePage() throws InterruptedException {
        hooks = new Hooks();
        hooks.openBrowser(driver);
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
        pageURL = driver.getCurrentUrl();
 }

    @When("user click on digital category")
    public void selectDigitalCategory() throws InterruptedException {
        homePage.selectDigitalDownloadsCategory().click();
        expectedText = homePage.selectDigitalDownloadsCategory().getText();
        Thread.sleep(2000);
    }
    @When("user click on desktop sub category")
    public void selectComputerSubCategory() throws InterruptedException {
        homePage.moveToSubCategory(homePage.selectComputerCategory(), homePage.selectComputerSubCategory());
        expectedText = homePage.selectComputerSubCategory().getText().toLowerCase().trim();
        homePage.selectComputerSubCategory().click();
        Thread.sleep(2000);
    }

    @When("user click on jewelry category")
    public void selectJewelryCategory() throws InterruptedException {
        homePage.selectJewelryCategory().click();
        expectedText = homePage.selectJewelryCategory().getText();
        Thread.sleep(2000);
    }
    @When("user click on gift category")
    public void selectGiftCategory() throws InterruptedException {
        homePage.selectGiftCardCategory().click();
        expectedText = homePage.selectGiftCardCategory().getText();
        Thread.sleep(2000);
    }
    @And("click on sub category")
    public void selectSubCategory() throws InterruptedException {
        homePage.moveToSubCategory(homePage.selectCategory(), homePage.selectSubCategory());
        expectedText = homePage.selectSubCategory().getText().toLowerCase().trim();
        homePage.selectSubCategory().click();
        Thread.sleep(2000);
    }

    @Then("browser go to page category")
    public void pageCategory()
    {
        softAssert.assertTrue(expectedText.equals(homePage.pageTitle().getText().toLowerCase().trim())
                ,"Wrong Category");
        softAssert.assertAll();

    }
    /**************************************************************************************/
    /*Given user click in  search field
    When user write text to search
    And user click search button
    Then current URl changed
    And list of results appear*/
    /************************************************************************************/
    String searchItem = "Apple";



    @Given("user click in  search field")
    public void userClickOnSearchField()
    {
        homePage.searchItemField().click();
    }

    @When("^user write \"(.*)\" to search$")
    public void userWriteTextInSearch(String searchText)
    {
        homePage.searchItemField().sendKeys(searchText);
    }
    @And("user click search button")
    public void userClickSearchBtn() throws InterruptedException {
        homePage.searchBtn().click();
        Thread.sleep(3000);
    }
    @Then("current URl changed")
    public void checkSearchURL()
    {
        Assert.assertTrue(driver.getCurrentUrl().equals(pageURL+"search?q="+searchItem),"Wrong URL");
    }



    @And("list of results appear")
    public void searchResultList()
    {
        Assert.assertTrue(homePage.productItems().size()>=0 ,"no results for search");
    }
    @And("result list size equal zero")
    public void noResultList()
    {
        Assert.assertEquals(homePage.productItems().size(), 0, "no results for search");
    }
    @And("message no_result appear")
    public void noResultMsg()
    {
        String expectedMsgNoResult = "No products were found that matched your criteria.";
        softAssert.assertTrue(homePage.noResultField().getText().contains(expectedMsgNoResult),"Wrong search result msg");

    }



    @After
    public void closeBrowser()
    {
        hooks.closeBrowser(this.driver);
    }

}
