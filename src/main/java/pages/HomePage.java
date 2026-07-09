package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends  BasePage {

    private final By loginLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        clickElement(loginLink, "LoginLink");
        return new LoginPage(driver);
    }
}
