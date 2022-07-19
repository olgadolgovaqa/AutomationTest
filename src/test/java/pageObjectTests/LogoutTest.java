package pageObjectTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;


public class LogoutTest extends BaseTest {

    @Test
    public void logOutOfAccount() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(USERNAME, PASSWORD);
        mainPage.logout();
        Assert.assertTrue(loginPage.isLoginPage());


    }


}
