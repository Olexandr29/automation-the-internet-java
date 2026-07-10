package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class LoginPage extends BasePage {
    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By loginBtnLocator = By.className("radius");
    private final By alertLocator = By.id("flash");

   public LoginPage(WebDriver driver) {
       super(driver);
   }

   public SecurePage successfulLogin(String name, String pas) {
       type(usernameLocator, name, "Username field");
       type(passwordLocator, pas, "Password field");
       clickElement(loginBtnLocator, "Login button");
       wait.until(ExpectedConditions.urlContains("/secure"));
       return new SecurePage(driver);
   }

   public String unsuccessfulLogin(String name, String pas) {
       type(usernameLocator, name, "Username field");
       type(passwordLocator, pas, "Password field");
       clickElement(loginBtnLocator, "Login button");
       return getElementText(alertLocator, "Alert message");
   }

   public String getLogoutAlert() {
       return getElementText(alertLocator, "Logout alert message");
   }

   public boolean isLoginButtonDisplayed() {
       return isVisible(loginBtnLocator, "Login button");
   }

    public boolean isPasswordHidden() {
        String fieldAttributeType = getFieldAttribute("type", passwordLocator);
        return Objects.equals(fieldAttributeType, "password");
    }

    public boolean isHiddenValueSaved(String pas) {
        type(passwordLocator, pas, "Password field");
        String savedValue = getFieldAttribute("value", passwordLocator);
        boolean result = Objects.equals(savedValue, pas);
        logger.info("Saved value equals entered value: {}", result);
        return result;
    }

}
