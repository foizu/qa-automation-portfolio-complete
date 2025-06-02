package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://example.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginShouldSucceed() {
        loginPage.enterUsername("admin");
        loginPage.enterPassword("password");
        loginPage.submit();
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
