package pageObjectTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.*;
import pageObjects.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void logInToAccount() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainpage = loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(mainpage.isMainPage());
    }

    @Test
    public void logInToAccount_wrongUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainpage = loginPage.login("wrongUser", PASSWORD);
        Assert.assertTrue(loginPage.isError());
    }

    @Test
    public void logInToAccount_wrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainpage = loginPage.login(USERNAME, "wrongPassword");
        Assert.assertTrue(loginPage.isError());

    }


}
