package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage extends BasePage {
    private final By headerLocator = By.tagName("h4");
    private final By paragraphLocator = By.tagName("p");
    private final By checkboxSubheaderLocator = By.className("subheader");
    private final By checkboxLocator = By.id("checkbox");
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

    public boolean isHeaderVisible() {
        return isVisible(headerLocator, "Header");
    }

    public boolean isHeaderCorrect(String expectedHeader) {
        String actualHeader = getElementText(headerLocator, "Header");
        return actualHeader.equals(expectedHeader);
    }

    public boolean isCorrectHeaderDisplayed(String expectedHeader) {
        return (isHeaderVisible() && isHeaderCorrect(expectedHeader) );
    }

    public boolean isCorrectParagraphDisplayed(String expectedParagraph) {
        return (isVisible(paragraphLocator, "Paragraph"))
                && (getElementText(paragraphLocator, "Paragraph").equals(expectedParagraph));
    }

    public boolean isCorrectCheckboxSubheaderDisplayed(String expectedSubheader) {
        return (isVisible(checkboxSubheaderLocator, "Checkbox subheader"))
                && (getElementText(checkboxSubheaderLocator, "Checkbox subheader").equals(expectedSubheader));
    }

    public boolean isCorrectCheckboxTitleDisplayed(String expectedCheckboxTitle) {
        return (isVisible(checkboxLocator, "Checkbox title"))
                && (getElementText(checkboxLocator, "Checkbox title").equals(expectedCheckboxTitle));
    }

    public boolean isRemoveButtonDisplayed(String expectedButtonTitle) {
        String titleforAllure = "Remove button";
        return (isVisible(removeBtnLocator, titleforAllure))
                && (getElementText(removeBtnLocator, titleforAllure).equals(expectedButtonTitle));
    }

    public boolean isCorrectInputSubheaderDisplayed(String expectedSubheader) {
        String titleforAllure = "Input Subheader";
        return (isVisible(inputSubheaderLocator, titleforAllure))
                && (getElementText(inputSubheaderLocator, titleforAllure).equals(expectedSubheader));
    }

    public boolean isInputDisplayed() {
        return isVisible(inputLocator, "Input Field");
    }


    public boolean isEnableButtonDisplayed(String expectedButtonTitle) {
        String titleforAllure = "Enable button";
        return (isVisible(enableBtnLocator, titleforAllure))
                && (getElementText(enableBtnLocator, titleforAllure).equals(expectedButtonTitle));
    }

    public boolean isCorrectFooterDisplayed(String expectedFooter) {
        String titleforAllure = "Footer";
        return (isVisible(footerLocator, titleforAllure))
                && (getElementText(footerLocator, titleforAllure).equals(expectedFooter));
    }

    public boolean isCorrectSeleniumLinkDisplayed(String expectedLink) {
        String titleforAllure = "Elemental Selenium";
        return (isVisible(seleniumLinkLocator, titleforAllure))
                && (getElementText(seleniumLinkLocator, titleforAllure).equals(expectedLink));
    }

    public boolean isCorrectSauceLabsLinkDisplayed(String expectedLink) {
        String titleforAllure = "Sauce Labs link";
        return (isVisible(sauceLabsLinkLocator, titleforAllure))
                && (getElementText(sauceLabsLinkLocator, titleforAllure).equals(expectedLink));
    }


}
