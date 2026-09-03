package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CheckboxPage extends BasePage {
    private final By checkboxLocator = By.tagName("input");
    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckboxVisible(int checkboxNumber) {
        List<WebElement> checkboxes = driver.findElements(checkboxLocator);
        WebElement targetCheckbox = checkboxes.get(checkboxNumber - 1);
        return isVisible(targetCheckbox,  String.format("The Checkbox'%d'", checkboxNumber) );
    }

    public boolean isCheckboxChecked(int checkboxNumber) {
        List <WebElement> checkboxes = driver.findElements(checkboxLocator);
        WebElement targetCheckbox = checkboxes.get(checkboxNumber - 1);
        return targetCheckbox.isSelected();
    }


    public void changeCheckboxState(int checkboxNumber) {
        Allure.step(String.format("Change checkbox %d state", checkboxNumber));
        List <WebElement> checkboxes = driver.findElements(checkboxLocator);
        WebElement targetCheckbox = checkboxes.get(checkboxNumber - 1);
        targetCheckbox.click();
    }


    @Step("Make Checkbox {checkboxNumber} active")
    public void makeCheckboxActive(int checkboxNumber) {
        List <WebElement> checkboxes = driver.findElements(checkboxLocator);
        WebElement targetCheckbox = checkboxes.get(checkboxNumber - 1);
        Actions actions = new Actions(driver);
        int attempts = 0;
        while(!driver.switchTo().activeElement().equals(targetCheckbox)
                && attempts < 11) {
            actions.sendKeys(Keys.TAB).perform();
            attempts++;
        }
    }

    public boolean isCheckboxActive(int checkboxNumber) {
        List <WebElement> checkboxes = driver.findElements(checkboxLocator);
        WebElement targetCheckbox = checkboxes.get(checkboxNumber - 1);
        WebElement focused = driver.switchTo().activeElement();
        return focused.equals(targetCheckbox);
    }

    @Step("Change Checkbox {checkboxNumber} state via keyboard key Space")
    public void changeCheckboxStateViaKeyboardKeySpace(int checkboxNumber) {
        List <WebElement> checkboxes = driver.findElements(checkboxLocator);
        WebElement targetCheckbox = checkboxes.get(checkboxNumber - 1);
        pressKey(Keys.SPACE, targetCheckbox);
    }





}
