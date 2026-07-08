import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SecurePage;
import tests.BaseTest;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void TC1SuccessfulLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openLoginPage();
        SecurePage securePage = loginPage.successfulLogin("tomsmith", "SuperSecretPassword!");
        assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure", "User is not redirected to the Secure page");
        assertTrue(securePage.getAlertText().contains("You logged into a secure area!"), "The alert message is wrong");
        assertTrue(securePage.getWelcomeText().contains("Welcome to the Secure Area. When you are done click logout below."), "The welcome message is wrong");
        assertTrue(securePage.isLogoutBtnDisplayed(), "The Logout button is not displayed.");

    }

}
