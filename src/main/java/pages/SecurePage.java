package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurePage {
    private static final Logger logger =
            LoggerFactory.getLogger(SecurePage.class);
    private final WebDriver driver;
    private final By alertLocator = By.id("flash");
    private final By welcomeMsgLocator = By.className("subheader");
    private final By logoutBtnLocator = By.xpath("//a[@class=\"button secondary radius\"]");

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        logger.info("Getting alert message");
        WebElement alertEl = driver.findElement(alertLocator);
        String text = alertEl.getText();
        logger.info("Alert message: {}", text);
        return text;
    }

    public String getWelcomeText() {
        logger.info("Getting welcome message");
        WebElement welcomeMsgEl = driver.findElement(welcomeMsgLocator);
        String text = welcomeMsgEl.getText();
        logger.info("Welcome message: {}", text);
        return text;
    }

    public boolean isLogoutBtnDisplayed() {
        logger.info("Checking Logout button visibility");
        List<WebElement> buttons = driver.findElements(logoutBtnLocator);
        if (buttons.isEmpty()) {
            logger.warn("Logout button not found");
            return false;
        }
        for (WebElement button : buttons) {
            if (button.isDisplayed()) {
                logger.info("Logout button is displayed");
                return true;
            }
        }
        logger.warn("Logout button exists but is not visible");
        return false;
    }



}