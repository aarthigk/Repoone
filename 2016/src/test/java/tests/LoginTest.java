package tests;

import drivers.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
    @BeforeMethod
    public void setUp() {
        DriverManager.getDriver().get("http://validurl:8008/arts");
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login("validname", "validname");

        HomePage homePage = new HomePage(DriverManager.getDriver());
        String welcomeMessage = homePage.getWelcomeMessage();
        Assert.assertEquals(welcomeMessage, "Welcome, testuser");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}