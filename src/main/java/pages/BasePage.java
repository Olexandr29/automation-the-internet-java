package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;
import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected void step(String description, Runnable action) {
        logger.info(description);
        Allure.step(description, action::run);
    }

    protected <T> T step(String description, Supplier<T> action) {
        logger.info(description);
        return Allure.step(description, action::get);
    }

    protected WebElement find(By locator) {
        logger.debug("Find element: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        logger.debug("Find elements: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected WebElement findElementByNumber(By locator, int number) {
        List<WebElement> elements = this.findElements(locator);
        return elements.get(number - 1);
    }

    protected void clickElement(By locator, String elementName) {
        String description = String.format("Click on the: '%s'", elementName);
        try {
                logger.debug(description);
                WebElement element = this.find(locator);
                element.click();
                logger.debug("'{}' clicked successfully", elementName);
        } catch (Exception e) {
            logger.error("Cannot click on the '{}'", elementName, e);
            throw e;
        }
    }

    protected void type(By locator, String text, String elementName) {
        String description = String.format("Enter value into: '%s'", elementName);
        step(description, () -> {
            WebElement element = this.find(locator);
            element.clear();
            element.sendKeys(text);
        });
    }

    protected String getElementText(By locator, String elementName) {
        String description = String.format("Get text from: '%s'", elementName);
        return step(description, () -> {
            WebElement element = this.find(locator);
            String text = element.getText();
            logger.info("{}: {}", elementName, text);
            return text;
        });
    }

    protected boolean isVisible(By locator, String elementName) {
        String description = String.format("Observe the visibility of the '%s'", elementName);
        try {
            return step(description, () -> {
                return this.find(locator).isDisplayed();
            });
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            logger.warn("Element is not visible: {}", locator);
            return false;
        }
    }

    protected boolean isVisible(WebElement element, String elementName) {
        String description = String.format("Observe the visibility of the '%s'", elementName);

        try {
            return step(description, () -> {
                return element.isDisplayed();
            });
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            logger.warn("Element is not visible: {}", elementName);
            return false;
        }
    }

    protected String getFieldAttribute(String attributeTitle, By locator) {
        String description = String.format("Get Attribute('%s')", attributeTitle);
        return step(description, () -> {
            WebElement element = find(locator);
            String specificAttributeProperty = element.getAttribute(attributeTitle);
            if ("value".equals(attributeTitle) && "password".equals(element.getAttribute("type"))) {
                String maskedValue = "*".repeat(specificAttributeProperty.length());
                logger.info("The Attribute('{}') = '{}'", attributeTitle, maskedValue);
            } else {
                logger.info("The Attribute('{}') = '{}'", attributeTitle, specificAttributeProperty);
            }
            return specificAttributeProperty;
        });
    }

    public void pressKey(Keys key, By locator) {
        String description = String.format("Pressing '" + key.name() + "' key on element: " + locator);
        step(description, () -> {
        find(locator).sendKeys(key);
        });
    }

    public void pressKey(Keys key, WebElement element) {
        element.sendKeys(key);
    }

    public void refreshPage() {
        String description = "Refresh the page";
        step(description, () -> {
            driver.navigate().refresh();
        });
    }

    public void navigateBack() {
        String description = "Click the browser Back button";
        step(description, () -> {
            driver.navigate().back();
        });
    }

    public void navigateForward() {
        String description = "Click the browser Forward button";
        step(description, () -> {
            driver.navigate().forward();
        });
    }

    public void focusElement(WebElement targetElement) {
        Actions actions = new Actions(driver);
        int attempts = 0;
        while (!driver.switchTo().activeElement().equals(targetElement)
                && attempts < 11) {
            actions.sendKeys(Keys.TAB).perform();
            attempts++;
        }
    }

    public boolean isElementActive(WebElement targetElement) {
        WebElement focused = driver.switchTo().activeElement();
        return focused.equals(targetElement);
    }

}


