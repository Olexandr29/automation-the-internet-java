package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By loginBtnLocator = By.className("radius");

   public LoginPage(WebDriver driver) {
       this.driver = driver;
   }

   public SecurePage successfulLogin(String name, String pas) {
       WebElement usernameEl = driver.findElement(usernameLocator);
       usernameEl.sendKeys(name);
       WebElement passwordEl = driver.findElement(passwordLocator);
       passwordEl.sendKeys(pas);
       WebElement loginBtnEl = driver.findElement(loginBtnLocator);
       loginBtnEl.click();
       return new SecurePage(driver);
   }
}
