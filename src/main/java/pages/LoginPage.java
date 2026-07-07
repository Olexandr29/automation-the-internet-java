package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private final WebDriver driver;
    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By loginBtnLocator = By.className("radius");

   public LoginPage(WebDriver driver) {
       this.driver = driver;
   }

   public SecurePage successfulLogin(String name, String pas) {
       logger.info("Entering username");
       WebElement usernameEl = driver.findElement(usernameLocator);
       usernameEl.sendKeys(name);
       logger.info("Entering password");
       WebElement passwordEl = driver.findElement(passwordLocator);
       passwordEl.sendKeys(pas);
       logger.info("Clicking Login button");
       WebElement loginBtnEl = driver.findElement(loginBtnLocator);
       loginBtnEl.click();
       return new SecurePage(driver);
   }
}
