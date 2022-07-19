package pageObjectTests;

import com.beust.jcommander.Parameter;
import enums.BrowserType;
import helper.BrowserFactory;
import helper.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.MainPage;

public class BaseTest {
    protected WebDriver driver;
    public static final String USERNAME = "tomsmith";
    public static final String PASSWORD = "SuperSecretPassword!";

    @Parameters({"browser"})
    @BeforeMethod
    public void startUp(String browser) {

       BrowserType browserType = browser.equals("chrome") ? BrowserType.CHROME : BrowserType.FIREFOX;
       driver = BrowserFactory.getDriver(browserType);

    }


    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {

        if (iTestResult.getStatus() == iTestResult.FAILURE) {
            Screenshot.capture(driver, iTestResult.getName());
        }
        driver.quit();
    }

}
