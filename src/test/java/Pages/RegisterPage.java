package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    WebDriver webDriver = null;

    public RegisterPage(WebDriver driver)
    {
        this.webDriver = driver;
    }
    public WebElement femaleGender()
    {
        return webDriver.findElement(By.id("gender-female"));
    }
    public WebElement maleGender()
    {
        return webDriver.findElement(By.id("gender-male"));
    }

    public WebElement firstName()
    {
        return webDriver.findElement(By.id("FirstName"));
    }

    public WebElement lastName()
    {
        return webDriver.findElement(By.id("LastName"));
    }
    public WebElement dateOfBirthDay()
    {
        return webDriver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]"));
    }
    public WebElement dateOfBirthMonth()
    {
        return webDriver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]"));
    }
    public WebElement dateOfBirthYear()
    {
        return webDriver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]"));
    }
    public WebElement email()
    {
        return webDriver.findElement(By.id("Email"));
    }
    public WebElement companny()
    {
        return webDriver.findElement(By.id("Company"));
    }

    public WebElement password()
    {
        return webDriver.findElement(By.id("Password"));
    }
    public WebElement confirmPassword()
    {
        return webDriver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement registerButton()
    {
        return webDriver.findElement(By.id("register-button"));
    }
    public void registerTestData(String firstName ,String lastName , String birthDay ,
                                 String birthMonth , String birthYear , String email , String company ,
                                 String password , String confirmPassword)
    {
        firstName().sendKeys(firstName);
        lastName().sendKeys(lastName);
        dateOfBirthDay().sendKeys(birthDay);
        dateOfBirthMonth().sendKeys(birthMonth);
        dateOfBirthYear().sendKeys(birthYear);
        email().sendKeys(email);
        companny().sendKeys(company);
        password().sendKeys(password);
        confirmPassword().sendKeys(confirmPassword);
    }
}
