package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends BasePage {

    private final By dropdownLocator = By.tagName("select");
    private final By optionsLocator = By.tagName("option");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDropdownVisible() {

        return isVisible(dropdownLocator, "Dropdown");
    }

    public String getSelectedDropdownText() {
        Select dropdown = new Select(find(dropdownLocator));
        String selectedValue = dropdown.getFirstSelectedOption().getText();
        logger.info("Selected option: {}", selectedValue);
        Allure.step("Get the Selected value. Selected is:" + selectedValue);
        return selectedValue;
    }

    @Step("Get amount Of available value for selection")
    public int amountOfAvailableDropdownOptions() {
        List<WebElement> dropdownOptions = driver.findElements(optionsLocator);
        int dropdownSize = dropdownOptions.size();
        logger.info("amountOfAvailableDropdownOptions: {}", dropdownSize);
        Allure.step("Amount is: " + dropdownSize);
        return dropdownSize;
    }

    @Step("Is specific value displayed")
    public boolean isSpecificOptionDisplayed(String optionTitle) {
        boolean result = false;
        List<WebElement> optionsAr = driver.findElements(optionsLocator);
        for (WebElement el : optionsAr) {
            String optionText = el.getText();
            if (optionText.equals(optionTitle) ) {
                result = el.isDisplayed();
            }
        }
        return result;
    }

    @Step("select specific value: '{optionTitle}'")
    public void selectSpecificOption(String optionTitle) {
        Select dropdown = new Select(find(dropdownLocator));
        dropdown.selectByVisibleText(optionTitle);
    }

    public void pressArrowDown() {
        pressKey(Keys.ARROW_DOWN, dropdownLocator);
    }

    public void pressArrowUp() {
        pressKey(Keys.ARROW_UP, dropdownLocator);
    }

    @Step("Make dropdown active")
    public void makeDropdownActive() {
        Actions actions = new Actions(driver);
        int attempts = 0;
        while(!driver.switchTo().activeElement().equals(find(dropdownLocator))
                && attempts < 11) {
            actions.sendKeys(Keys.TAB).perform();
            attempts++;
        }
    }

    @Step("Is dropdown active")
    public boolean isDropdownActive() {
        WebElement focused = driver.switchTo().activeElement();
        WebElement dropdown = find(dropdownLocator);
        return focused.equals(dropdown);
    }

    public void pressEnter() {
        pressKey(Keys.ENTER, dropdownLocator);
    }

    public void pressEscape() {
        pressKey(Keys.ESCAPE, dropdownLocator);
    }



}
