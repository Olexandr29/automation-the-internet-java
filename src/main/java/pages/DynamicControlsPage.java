package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DynamicControlsPage extends BasePage {
    private final By headerLocator = By.tagName("h4");
    private final By paragraphLocator = By.tagName("p");
    private final By checkboxSubheaderLocator = By.className("subheader");
    private final By checkboxLocator = By.id("checkbox");
    private final By checkboxInputTypeLocator = By.xpath("//input[@type='checkbox']");

    private final By checkboxAfterAddLocator = By.xpath("//div/input[@type='checkbox']");
    private final By checkboxTitleLocator = By.xpath("//div[text()=' A checkbox']");

    private final By removeBtnLocator = By.xpath("//button[text()='Remove']");
    private final By addBtnLocator = By.xpath("//button[text()='Add']");
    private final By inputSubheaderLocator = By.xpath("//h4[text()='Enable/disable']");
    private final By inputLocator = By.xpath("//input[@type='text']");
    private final By enableBtnLocator = By.xpath("//button[text()='Enable']");
    private final By footerLocator = By.xpath("//div[@style='text-align: center;']");
    private final By seleniumLinkLocator = By.linkText("Elemental Selenium");
    private final By sauceLabsLinkLocator = By.linkText("Sauce Labs");
    private final By waitTextLocator = By.id("loading");
    private final By loadIndicator = By.xpath("//img[@src='/img/ajax-loader.gif']");
    private final By messageLocator = By.xpath("//p[@id='message']");

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

    public boolean isCheckboxWithCorrectTitleDisplayed(String expectedCheckboxTitle) {
        return isCorrectElementDisplayed(checkboxTitleLocator, "Checkbox title", expectedCheckboxTitle);
//        checkboxLocator
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
        clickElement(checkboxInputTypeLocator, "Checkbox to change checkbox state");
    }

    public void clickOnRemoveButton() {
        clickElement(removeBtnLocator, "Remove button");
    }

    public void clickOnAddButton() {
        clickElement(addBtnLocator, "Add button");
    }

    public boolean isWaitTextAndLoadIndicatorDisplayed(String expectedWaitText) {
        WebElement loadingText = find(waitTextLocator);
        WebElement loadingProgressBar = find(loadIndicator);
        return loadingText.isDisplayed()
                && loadingText.getText().equals(expectedWaitText)
                && loadingProgressBar.isDisplayed();
    }

    public boolean waitUntilCheckboxAbsent() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(checkboxTitleLocator));
//        checkboxLocator
    }

    public WebElement waitUntilCheckboxClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(checkboxTitleLocator));
//        checkboxLocator
    }

    public boolean isCheckboxDisplayed() {
        return isVisible(checkboxTitleLocator);
//        checkboxLocator
    }

    public boolean isCheckboxTitleCorrect(String expectedCheckboxTitle) {
        return getElementText(checkboxTitleLocator, "Checkbox title").equals(expectedCheckboxTitle);
//        checkboxInputTypeLocator
    }




    public String getCheckboxTitleWith4checkboxTitleLocator() {
        return getElementText(checkboxTitleLocator, "getCheckboxTitleWith4checkboxTitleLocator after click Add button");
    }






    public boolean isCheckboxAppeared(String expectedCheckboxTitle) {
        waitUntilCheckboxClickable();
        return isCheckboxWithCorrectTitleDisplayed(expectedCheckboxTitle);
    }

    public WebElement waitUntilAddButtonPresent() {
        return wait.until(ExpectedConditions.elementToBeClickable(addBtnLocator));
    }

    public WebElement waitUntilRemoveButtonPresent() {
        return wait.until(ExpectedConditions.elementToBeClickable(removeBtnLocator));
    }

    public boolean isButtonTitleChangedFromRemoveToAdd(String expectedButtonTitle) {
        waitUntilAddButtonPresent();
        return isCorrectElementDisplayed(addBtnLocator, expectedButtonTitle);
    }

    public boolean isButtonTitleChangedFromAddToRemove(String expectedButtonTitle) {
        waitUntilRemoveButtonPresent();
        return isCorrectElementDisplayed(removeBtnLocator, expectedButtonTitle);
    }

    public boolean isCorrectTextDisplayed(String expectedResult) {
        return isCorrectElementDisplayed(messageLocator, expectedResult);
    }





}
