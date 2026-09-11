package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        logger.info("Selected option is: {}", selectedValue);
        return selectedValue;
    }

    public int amountOfAvailableDropdownOptions() {
        List<WebElement> dropdownOptions = this.findElements(optionsLocator);
        int dropdownSize = dropdownOptions.size();
        logger.info("amountOfAvailableDropdownOptions are: {}", dropdownSize);
        return dropdownSize;
    }

    public boolean isSpecificOptionDisplayed(String optionTitle) {
        String description = String.format("Observe the '%s' is displayed", optionTitle);
        return step(description, () -> {
            boolean result = false;
            List<WebElement> optionsAr = this.findElements(optionsLocator);
            for (WebElement el : optionsAr) {
                String optionText = el.getText();
                if (optionText.equals(optionTitle) ) {
                    result = el.isDisplayed();
                }
            }
        return result;
        });
    }

    public void selectSpecificOption(String optionTitle) {
        String description = String.format("Select the: '%s'", optionTitle);
        step(description, () -> {
            Select dropdown = new Select(find(dropdownLocator));
            dropdown.selectByVisibleText(optionTitle);
        });
    }

    public void pressArrowDown() {
        pressKey(Keys.ARROW_DOWN, dropdownLocator);
    }

    public void pressArrowUp() {
        pressKey(Keys.ARROW_UP, dropdownLocator);
    }

    public void makeDropdownActive() {
        String description = "Make the 'Dropdown' active";
        step(description, () -> {
            WebElement targetDropdown = this.find(dropdownLocator);
            this.focusElement(targetDropdown);
        });
        }

    public boolean isDropdownActive() {
        WebElement targetDropdown = find(dropdownLocator);
        return this.isElementActive(targetDropdown);
    }

    public void pressEnter() {
        pressKey(Keys.ENTER, dropdownLocator);
    }

    public void pressEscape() {
        pressKey(Keys.ESCAPE, dropdownLocator);
    }


}