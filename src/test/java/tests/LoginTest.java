package tests;

import org.testng.annotations.*;
import pages.LoginPage;
import pages.SecurePage;
import testData.LoginData;

import java.lang.reflect.Method;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @Override
    @BeforeMethod
    public void setUp(Method method, Object[] testData) {
        super.setUp(method, testData);
        loginPage = homePage.openLoginPage();
    }

    @Test
    public void TC1SuccessfulLogin() {
        SecurePage securePage = loginPage.successfulLogin(LoginData.VALID_USERNAME, LoginData.VALID_PASSWORD);
        assertEquals(driver.getCurrentUrl(), LoginData.URL_SECURE_PAGE, "User is not redirected to the Secure page");
        assertTrue(securePage.getAlertText().contains(LoginData.ALERT_SUCCESSFUL_LOGIN), "The alert message is wrong");
        assertTrue(securePage.getWelcomeText().contains(LoginData.WELCOME_MESSAGE), "The welcome message is wrong");
        assertTrue(securePage.isLogoutBtnDisplayed(), "The Logout button is not displayed.");
    }

    @Test(dataProvider = "invalidLoginData")
    public void unsuccessfulLogin(String testName, String username, String password, String expectedAlertMessage) {
        assertTrue(loginPage.unsuccessfulLogin(username, password).contains(expectedAlertMessage), "the alert message is wrong");
        assertEquals(driver.getCurrentUrl(), LoginData.URL_LOGIN_PAGE, "User should be on Login page");
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"TC2 – Unsuccessful login with empty credentials", "", "", LoginData.ALERT_INVALID_USERNAME},
                {"TC3 – Unsuccessful login with empty Password", LoginData.VALID_USERNAME, "", LoginData.ALERT_INVALID_PASSWORD},
                {"TC4 – Unsuccessful login with empty Username", "", LoginData.VALID_PASSWORD, LoginData.ALERT_INVALID_USERNAME},
                {"TC5 – Unsuccessful login with invalid Password", LoginData.VALID_USERNAME, LoginData.INVALID_PASSWORD, LoginData.ALERT_INVALID_PASSWORD},
                {"TC6 – Unsuccessful login with invalid Username", LoginData.INVALID_USERNAME, LoginData.VALID_PASSWORD, LoginData.ALERT_INVALID_USERNAME},
                {"TC7 – Unsuccessful login with both Invalid Username and Password", LoginData.INVALID_USERNAME, LoginData.INVALID_PASSWORD, LoginData.ALERT_INVALID_USERNAME },
                {"TC10 – Login with Username that has leading spaces", " " + LoginData.VALID_USERNAME, LoginData.VALID_PASSWORD, LoginData.ALERT_INVALID_USERNAME},
                {"TC11 – Login with a Password that has leading spaces", LoginData.VALID_USERNAME, " " + LoginData.VALID_PASSWORD, LoginData.ALERT_INVALID_PASSWORD},
                {"TC12 – Login with a Username that has trailing spaces", LoginData.VALID_USERNAME + " ", LoginData.VALID_PASSWORD, LoginData.ALERT_INVALID_USERNAME},
                {"TC13 – Login with a Password that has trailing spaces", LoginData.VALID_USERNAME, LoginData.VALID_PASSWORD + " ", LoginData.ALERT_INVALID_PASSWORD},
                {"TC14 – Login with a Username that has a different case", LoginData.VALID_USERNAME.toUpperCase(), LoginData.VALID_PASSWORD, LoginData.ALERT_INVALID_USERNAME},
                {"TC15 – Login with a Password that has a different case", LoginData.VALID_USERNAME, LoginData.VALID_PASSWORD.toUpperCase(), LoginData.ALERT_INVALID_PASSWORD},
                {"TC16 – Login with SQL Injection in Username", LoginData.SQL_INJECTION, LoginData.INVALID_PASSWORD, LoginData.ALERT_INVALID_USERNAME},
                {"TC17 – Login with SQL Injection in Password", LoginData.VALID_USERNAME, LoginData.SQL_INJECTION, LoginData.ALERT_INVALID_PASSWORD},
                {"TC18 – Login with XSS in Username", LoginData.XSS_CROSS_SITE_SCRIPT, LoginData.VALID_PASSWORD, LoginData.ALERT_INVALID_USERNAME},
                {"TC19 – Login with XSS in Password", LoginData.VALID_USERNAME, LoginData.XSS_CROSS_SITE_SCRIPT, LoginData.ALERT_INVALID_PASSWORD}
        };
    }



}