package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckboxPage extends BasePage {
    private final By checkboxLocator = By.tagName("input");
    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckboxVisible(int checkboxNumber) {
        WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
        return isVisible(targetCheckbox,  String.format("Checkbox %d", checkboxNumber) );
    }

    public boolean isCheckboxChecked(int checkboxNumber) {
        WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
        return targetCheckbox.isSelected();
    }

    public void changeCheckboxState(int checkboxNumber) {
        String description = String.format("Change the 'Checkbox %d' state", checkboxNumber);
        step(description, () -> {
            WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
            targetCheckbox.click();
        });
    }

    public void makeCheckboxActive(int checkboxNumber) {
        String description = String.format("Make the 'Checkbox %s' active", checkboxNumber);
        step(description, () -> {
            WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
            this.focusElement(targetCheckbox);
        });
    }

    public boolean isCheckboxActive(int checkboxNumber) {
        WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
        return this.isElementActive(targetCheckbox);
        }

    public void changeCheckboxStateViaKeyboardKeySpace(int checkboxNumber) {
        String description = String.format("Change the 'Checkbox %s' state via keyboard key Space", checkboxNumber);
        step(description, () -> {
            WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
            pressKey(Keys.SPACE, targetCheckbox);
        });
    }

}