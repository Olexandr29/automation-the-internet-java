package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SecurePage {
    private final WebDriver driver;
    private final By alertLocator = By.id("flash");
    private final By welcomeMsgLocator = By.className("subheader");
    private final By logoutBtnLocator = By.xpath("//a[@class=\"button secondary radius\"]");

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        WebElement alertEl = driver.findElement(alertLocator);
        return alertEl.getText();
    }

    public String getWelcomeText() {
        WebElement welcomeMsgEl = driver.findElement(welcomeMsgLocator);
        return welcomeMsgEl.getText();
    }

    public boolean isLogoutBtnDisplayed() {
        List<WebElement> buttons = driver.findElements(logoutBtnLocator);
        if (buttons.size() == 0) {
            return false;
        }
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isDisplayed()) {
                return true;
            }
        }
        return false;
    }



}