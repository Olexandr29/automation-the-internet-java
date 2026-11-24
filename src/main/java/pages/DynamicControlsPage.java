package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage extends BasePage {
    private final By headerLocator = By.tagName("h4");
    private final By paragraphLocator = By.tagName("p");
    private final By checkboxSubheaderLocator = By.className("subheader");


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







}
