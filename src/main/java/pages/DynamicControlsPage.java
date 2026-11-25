package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DynamicControlsPage extends BasePage {
    private final By headerLocator = By.tagName("h4");
    private final By paragraphLocator = By.tagName("p");
    private final By checkboxSubheaderLocator = By.className("subheader");
    private final By checkboxLocator = By.id("checkbox");
    private final By checkboxInputTypeLocator = By.xpath("//input[@type='checkbox']");
    private final By removeBtnLocator = By.xpath("//button[text()='Remove']");
    private final By inputSubheaderLocator = By.xpath("//h4[text()='Enable/disable']");
    private final By inputLocator = By.xpath("//input[@type='text']");
    private final By enableBtnLocator = By.xpath("//button[text()='Enable']");
    private final By footerLocator = By.xpath("//div[@style='text-align: center;']");
    private final By seleniumLinkLocator = By.linkText("Elemental Selenium");
    private final By sauceLabsLinkLocator = By.linkText("Sauce Labs");

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCorrectHeaderDisplayed(String expectedHeader) {
        return isCorrectElementDisplayed(headerLocator, "Header", expectedHeader);
    }

    public boolean isCorrectParagraphDisplayed(String expectedParagraph) {
        return isCorrectElementDisplayed(paragraphLocator, "Paragraph", expectedParagraph);
    }

    public boolean isCorrectCheckboxSubheaderDisplayed(String expectedSubheader) {
        return isCorrectElementDisplayed(checkboxSubheaderLocator, "Checkbox subheader",  expectedSubheader);
    }

    public boolean isCorrectCheckboxTitleDisplayed(String expectedCheckboxTitle) {
        return isCorrectElementDisplayed(checkboxLocator, "Checkbox title", expectedCheckboxTitle);
    }

    public boolean isRemoveButtonDisplayed(String expectedButtonTitle) {
        return isCorrectElementDisplayed(removeBtnLocator, "Remove button", expectedButtonTitle);
                }

    public boolean isCorrectInputSubheaderDisplayed(String expectedSubheader) {
        return isCorrectElementDisplayed(inputSubheaderLocator, "Input subheader", expectedSubheader);
    }

    public boolean isInputDisplayed() {
        return isVisible(inputLocator, "Input field");
    }

    public boolean isEnableButtonDisplayed(String expectedButtonTitle) {
        return isCorrectElementDisplayed(enableBtnLocator, "Enable button", expectedButtonTitle);
    }

    public boolean isCorrectFooterDisplayed(String expectedFooter) {
        return isCorrectElementDisplayed(footerLocator, "Footer", expectedFooter);
    }

    public boolean isCorrectSeleniumLinkDisplayed(String expectedLink) {
        return isCorrectElementDisplayed(seleniumLinkLocator, "Elemental Selenium link", expectedLink);
    }

    public boolean isCorrectSauceLabsLinkDisplayed(String expectedLink) {
       return isCorrectElementDisplayed(sauceLabsLinkLocator, "Sauce Labs link", expectedLink);
    }

    public boolean isCheckboxChecked() {
        WebElement checkbox = find(checkboxInputTypeLocator);
        return checkbox.isSelected();
    }

    public void changeCheckboxState() {
        String description = String.format("Change the Checkbox state");
        step(description, () -> {
            WebElement targetCheckbox = find(checkboxInputTypeLocator);
            targetCheckbox.click();
        });
    }


}
