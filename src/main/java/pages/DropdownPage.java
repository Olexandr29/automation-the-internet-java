package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    private final By dropdownLocator = By.tagName("select");

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
        return selectedValue;
    }




}
