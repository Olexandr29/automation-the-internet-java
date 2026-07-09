package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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


}
