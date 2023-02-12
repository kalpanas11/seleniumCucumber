package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testFactory.DriverFactory;

public class ProductsPage {

    private By burgerButton = By.xpath("//button[@id='react-burger-menu-btn']");
    private By productsPAge =By.xpath("//span[@class='title']");

    private By sideMenu =By.xpath("//button[@id='react-burger-menu-btn']");

    private By logoutLink = By.xpath("//*[@id='logout_sidebar_link']");    //By.id("logout_sidebar_link");

    public LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private WebDriver driver;
    public ProductsPage(WebDriver driver) {
        this.driver = driver;

    }

    public String getProductPAgeName(){
        return ((WebElement) driver.findElement(productsPAge)).getText();
    }

    public void openSideMenu(){
        driver.findElement(burgerButton).click();
    }

    public void logout(){
      //  driver.findElement(logoutLink).click();;
     //   System.out.println(driver.findElement(sideMenu).isDisplayed()+"");

        //hover and click logout */
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(logoutLink)).click().build().perform();
       // wait(1000);
    }
}
