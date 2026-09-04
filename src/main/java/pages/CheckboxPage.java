package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
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
        return isVisible(targetCheckbox,  String.format("The Checkbox'%d'", checkboxNumber) );
    }

    public boolean isCheckboxChecked(int checkboxNumber) {
        WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
        return targetCheckbox.isSelected();
    }

    public void changeCheckboxState(int checkboxNumber) {
        Allure.step(String.format("Change checkbox %d state", checkboxNumber));
        WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
        targetCheckbox.click();
    }

    @Step("Make Checkbox {checkboxNumber} active")
    public void makeCheckboxActive(int checkboxNumber) {
        WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
        this.focusElement(targetCheckbox);
    }

    public boolean isCheckboxActive(int checkboxNumber) {
        WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
        return this.isElementActive(targetCheckbox);
        }

    @Step("Change Checkbox {checkboxNumber} state via keyboard key Space")
    public void changeCheckboxStateViaKeyboardKeySpace(int checkboxNumber) {
        WebElement targetCheckbox = this.findElementByNumber(checkboxLocator, checkboxNumber);
        pressKey(Keys.SPACE, targetCheckbox);
    }

}