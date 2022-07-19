package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getEmailField() {
        return driver.findElement(By.id("username"));
    }

    private WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    private WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("[type='submit']"));
    }

    public void open() {
        driver.get("http://the-internet.herokuapp.com/login");
    }

    public MainPage login(String username, String password) {
        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);
    }

    public boolean isError() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flash.error")));
            return true;
        } catch (TimeoutException ex) {

            return false;
        }
    }

    public boolean isLoginPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }

    }


}
