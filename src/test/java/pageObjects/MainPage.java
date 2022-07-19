package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.jq.Main;

import java.time.Duration;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector(".icon-signout"));
    }

    public LoginPage logout() {
        getLogoutButton().click();
        return new LoginPage(driver);
    }

    public boolean isMainPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-signout")));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }

    }

}
