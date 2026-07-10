package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SecurePage extends BasePage {

    private final By alertLocator = By.id("flash");
    private final By welcomeMsgLocator = By.className("subheader");
    private final By logoutBtnLocator = By.xpath("//a[@class=\"button secondary radius\"]");

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    public String getAlertText() {
        return getElementText(alertLocator, "Alert message");
    }

    public String getWelcomeText() {
        return getElementText(welcomeMsgLocator, "Welcome message");
    }

    public boolean isLogoutBtnDisplayed() {
        return isVisible(logoutBtnLocator, "Logout button");
    }

    public LoginPage logout() {
        clickElement(logoutBtnLocator, "Logout button");
        wait.until(ExpectedConditions.urlContains("/login"));
        return new LoginPage(driver);
    }

}