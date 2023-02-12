/*
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
*/

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class loginStepDefinition {
    WebDriver driver;
    @Given("^navigate to saucedemo page$")
    public void navigate(){
        var options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver=new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        System.out.println("Navigated to saucedemo page successfully");
    }
    @When("^user logs in$")
    public void login(){

        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ; //Deprecated

        driver.findElement(By.id("login-button")).click();
        System.out.println("User logged in successfully");

    }
    @Then("^home page should be displayed$")
    public void verifySuccessful(){
        String expectedText="Swag Labs";
        String actualText = driver.getTitle();
        assertEquals(actualText, expectedText);
        System.out.println("Home page loaded successfully");
        driver.quit();
    }
}