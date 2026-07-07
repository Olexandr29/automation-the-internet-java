package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    private final WebDriver driver;

    private final By loginLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public LoginPage openLoginPage() {
        logger.info("Opening Login page");
        WebElement el = driver.findElement(loginLink);
        el.click();
        return new LoginPage(driver);
    }
}
