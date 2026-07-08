package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement find(By locator) {
        logger.debug("Find element: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void clickElement(By locator, String elementName){
        logger.info("Click on: {}", elementName);
        try {
            WebElement element = this.find(locator);
            element.click();
            logger.debug("'{}' clicked successfully", elementName);
        } catch (Exception e) {
            logger.error("Cannot click on '{}'", elementName, e);
            throw e;
        }
    }

    protected void type(By locator, String text, String elementName) {
        logger.info("Enter value into: {}", elementName);
        WebElement element = this.find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getElementText(By locator, String elementName) {
        logger.info("Get text from: {}", elementName);
        WebElement element = this.find(locator);
        String text = element.getText();
        logger.info("{}: {}", elementName, text);
        return text;
    }

    protected boolean isVisible(By locator, String elementName) {
        logger.info("Checking visibility of {}", elementName);

        try {
            return this.find(locator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e){
            logger.warn("Element is not visible: {}", locator);
            return false;
        }
    }

}
