package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
