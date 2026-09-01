package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends  BasePage {

    private final By loginLink = By.linkText("Form Authentication");
    private final By dropdownLink = By.linkText("Dropdown");
    private final By checkboxLink = By.linkText("Checkboxes");

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public LoginPage openLoginPage() {
        clickElement(loginLink, "LoginLink");
        return new LoginPage(driver);
    }

    public DropdownPage openDropdownPage() {
        clickElement(dropdownLink, "DropdownLink");
        return new DropdownPage(driver);
    }

    public CheckboxPage openCheckboxPage() {
        clickElement(checkboxLink, "checkboxLink");
        return new CheckboxPage(driver);
    }

    public boolean isDropdownLinkVisible() {
        return isVisible(dropdownLink, "the Dropdown link");
    }

}
