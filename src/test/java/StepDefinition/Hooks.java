package StepDefinition;

import Pages.AfterRegistrationPage;
import Pages.HomePage;
import Pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    @Before
    public void openBrowser(WebDriver driver ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(2000);
    }
    @After
    public void closeBrowser(WebDriver driver)
    {
        driver.close();
        driver.quit();
    }
}
