package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;

    private final By loginLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public LoginPage openLoginPage() {
        WebElement el = driver.findElement(loginLink);
        el.click();
        return new LoginPage(driver);
    }
}
