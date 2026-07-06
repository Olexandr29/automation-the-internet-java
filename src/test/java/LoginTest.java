import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecurePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    @Test
    public void testCase1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openLoginPage();
        SecurePage securePage = loginPage.successfulLogin("tomsmith", "SuperSecretPassword!");
        assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure", "User is not redirected to the Secure page");
        assertTrue(securePage.getAlertText().contains("You logged into a secure area!"), "The alert message is wrong");
        assertTrue(securePage.getWelcomeText().contains("Welcome to the Secure Area. When you are done click logout below."), "The welcome message is wrong");
        assertTrue(securePage.isLogoutBtnDisplayed(), "The Logout button is not displayed.");

    }
}
