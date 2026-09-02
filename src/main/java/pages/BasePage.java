package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected WebElement find(By locator) {
        logger.debug("Find element: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step("Click on: '{elementName}'")
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

    @Step("Enter value into: '{elementName}'")
    protected void type(By locator, String text, String elementName) {
        logger.info("Enter value into: {}", elementName);
        WebElement element = this.find(locator);
        element.clear();
        element.sendKeys(text);
    }

    @Step("Get text from: '{elementName}'")
    protected String getElementText(By locator, String elementName) {
        logger.info("Get text from: {}", elementName);
        WebElement element = this.find(locator);
        String text = element.getText();
        logger.info("{}: {}", elementName, text);
        return text;
    }

    @Step("Observe the visibility of '{elementName}'")
    protected boolean isVisible(By locator, String elementName) {
        logger.info("Observe the visibility of {}", elementName);

        try {
            return this.find(locator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e){
            logger.warn("Element is not visible: {}", locator);
            return false;
        }
    }

    @Step("Observe the visibility of '{elementName}'")
    protected boolean isVisible(WebElement element, String elementName) {
        logger.info("Observe the visibility of {}", elementName);

        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e){
            logger.warn("Element is not visible: {}", elementName);
            return false;
        }
    }

    @Step("Get Attribute '{attributeTitle}'")
    protected String getFieldAttribute(String attributeTitle, By locator) {
        logger.info("Get Attribute('{}')",attributeTitle );
        WebElement element = find(locator);
        String specificAttributeProperty = element.getAttribute(attributeTitle);
        if ("value".equals(attributeTitle) && "password".equals(element.getAttribute("type")) )  {
            String maskedValue = "*".repeat(specificAttributeProperty.length());
            logger.info("The Attribute('{}') = '{}'", attributeTitle, maskedValue);
        } else {
            logger.info("The Attribute('{}') = '{}'", attributeTitle, specificAttributeProperty);
        }
        return specificAttributeProperty;
    }

    public void pressKey(Keys key, By locator) {
        Allure.step("Pressing '" + key.name() + "' key on element: " + locator);
        logger.info("Pressing '{}' key on element: {}", key.name(), locator);
        find(locator).sendKeys(key);
    }

}
