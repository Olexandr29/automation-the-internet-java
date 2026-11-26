package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import testData.DynamicControlsData;
import static org.testng.Assert.*;

@Test(groups = {"smoke"})
@Feature("Dynamic Controls")
public class DynamicControlsTest extends BaseTest {

    private DynamicControlsPage dynamicControlsPage;

    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setUp")
    @Step("Open the Dynamic Controls page")
    public void openDynamicControlsPage() {
        dynamicControlsPage = homePage.openDynamicControlsPage();
    }

    @Test
    public void TC38VerifyPageContent() {
        assertEquals(driver.getCurrentUrl(), DynamicControlsData.DYNAMIC_CONTROLS_URL, "The Dynamic Controls page should be opened");
        assertEquals(dynamicControlsPage.isPageLoaded(), true, "The Dynamic Controls page should be loaded successfully and the document readyState should be complete");
        assertEquals(dynamicControlsPage.isCorrectHeaderDisplayed(DynamicControlsData.HEADER), true, String.format("The correct header '%s' should be displayed", DynamicControlsData.HEADER));
        assertEquals(dynamicControlsPage.isCorrectParagraphDisplayed(DynamicControlsData.PARAGRAPH), true, "The correct paragraph should be displayed");
        assertEquals(dynamicControlsPage.isCorrectCheckboxSubheaderDisplayed(DynamicControlsData.CHECKBOX_SUBHEADER), true,  String.format("The correct subheader '%s' should be displayed", DynamicControlsData.CHECKBOX_SUBHEADER));
        assertEquals(dynamicControlsPage.isCheckboxWithCorrectTitleDisplayed(DynamicControlsData.CHECKBOX_TITLE), true, String.format("The correct checkbox title '%s' should be displayed", DynamicControlsData.CHECKBOX_TITLE));
        assertEquals(dynamicControlsPage.isRemoveButtonDisplayed(DynamicControlsData.REMOVE_BUTTON_TITLE), true, String.format("The button '%s' should be displayed", DynamicControlsData.REMOVE_BUTTON_TITLE));
        assertEquals(dynamicControlsPage.isCorrectInputSubheaderDisplayed(DynamicControlsData.INPUT_SUBHEADER), true, String.format("The correct input subheader '%s' should be displayed", DynamicControlsData.INPUT_SUBHEADER));
        assertEquals(dynamicControlsPage.isInputDisplayed(), true, "The input field should be displayed");
        assertEquals(dynamicControlsPage.isEnableButtonDisplayed(DynamicControlsData.ENABLE_BUTTON_TITLE), true, String.format("The button '%s' should be displayed", DynamicControlsData.ENABLE_BUTTON_TITLE));
        assertEquals(dynamicControlsPage.isCorrectFooterDisplayed(DynamicControlsData.FOOTER), true, String.format("The correct header '%s' should be displayed", DynamicControlsData.FOOTER));
        assertEquals(dynamicControlsPage.isCorrectSeleniumLinkDisplayed(DynamicControlsData.SELENIUM_LINK_TITLE), true, String.format("The correct link '%s' should be displayed", DynamicControlsData.SELENIUM_LINK_TITLE));
        assertEquals(dynamicControlsPage.isCorrectSauceLabsLinkDisplayed(DynamicControlsData.SAUCE_LABS_LINK_TITLE), true, String.format("The correct link '%s' should be displayed",DynamicControlsData.SAUCE_LABS_LINK_TITLE));
    }

    @Test
    public void TC39VerifyCheckboxInitialStateAndChanges() {
        Allure.step("Observe the Checkbox initial state");
        assertEquals(dynamicControlsPage.isCheckboxChecked(), false, "The initial state of the checkbox should be unchecked");
        dynamicControlsPage.changeCheckboxState();
        assertEquals(dynamicControlsPage.isCheckboxChecked(), true, "The checkbox should be checked after first click");
        dynamicControlsPage.changeCheckboxState();
        assertEquals(dynamicControlsPage.isCheckboxChecked(), false, "The checkbox should be unchecked after second click");
    }

//    public void verificationAfterRemoveBtnClick() {
//        assertEquals(dynamicControlsPage.isWaitTextAndLoadIndicatorDisplayed(DynamicControlsData.LOADING_TEXT), true, String.format("The text '%s' and indeterminate progress bar should be displayed", DynamicControlsData.LOADING_TEXT));
//        assertEquals(dynamicControlsPage.waitUntilCheckboxAbsent(), true, "The checkbox should be removed and not displayed at the page");
//        assertEquals(dynamicControlsPage.isButtonTitleChangedFromRemoveToAdd(DynamicControlsData.ADD_BUTTON_TITLE), true, String.format("The button title '%s' should be changed to '%s'", DynamicControlsData.REMOVE_BUTTON_TITLE, DynamicControlsData.ADD_BUTTON_TITLE));
//        assertEquals(dynamicControlsPage.isCorrectTextDisplayed(DynamicControlsData.MESSAGE_AFTER_REMOVE), true, String.format("The text '%s' should be displayed", DynamicControlsData.MESSAGE_AFTER_REMOVE));
//    }

    //    public void verificationAfterAddBtnClick() {
//    assertEquals(dynamicControlsPage.isWaitTextAndLoadIndicatorDisplayed(DynamicControlsData.LOADING_TEXT), true, String.format("The text '%s' and indeterminate progress bar should be displayed", DynamicControlsData.LOADING_TEXT));
//    assertEquals(dynamicControlsPage.isCheckboxAppeared(DynamicControlsData.CHECKBOX_TITLE), true, String.format("The correct checkbox title '%s' should be displayed", DynamicControlsData.CHECKBOX_TITLE));
//    assertEquals(dynamicControlsPage.isCheckboxChecked(), false, "The checkbox should have unchecked state");
//    assertEquals(dynamicControlsPage.isButtonTitleChangedFromAddToRemove(DynamicControlsData.REMOVE_BUTTON_TITLE), true, String.format("The button title '%s' should be changed to '%s'", DynamicControlsData.ADD_BUTTON_TITLE, DynamicControlsData.REMOVE_BUTTON_TITLE));
//    assertEquals(dynamicControlsPage.isCorrectTextDisplayed(DynamicControlsData.MESSAGE_AFTER_ADD), true, String.format("The text '%s' should be displayed", DynamicControlsData.MESSAGE_AFTER_ADD));




    @Test
    public void TC40RemoveAndAddCheckbox() {
        Allure.step("Observe the Checkbox initial state");
        assertEquals(dynamicControlsPage.isCheckboxChecked(), false, "The initial state of the checkbox should be unchecked");
        dynamicControlsPage.clickOnRemoveButton();
        assertEquals(dynamicControlsPage.isWaitTextAndLoadIndicatorDisplayed(DynamicControlsData.LOADING_TEXT), true, String.format("The text '%s' and indeterminate progress bar should be displayed", DynamicControlsData.LOADING_TEXT));
        assertEquals(dynamicControlsPage.waitUntilCheckboxAbsent(), true, "The checkbox should be removed and not displayed at the page");
        assertEquals(dynamicControlsPage.isButtonTitleChangedFromRemoveToAdd(DynamicControlsData.ADD_BUTTON_TITLE), true, String.format("The button title '%s' should be changed to '%s'", DynamicControlsData.REMOVE_BUTTON_TITLE, DynamicControlsData.ADD_BUTTON_TITLE));
        assertEquals(dynamicControlsPage.isCorrectTextDisplayed(DynamicControlsData.MESSAGE_AFTER_REMOVE), true, String.format("The text '%s' should be displayed", DynamicControlsData.MESSAGE_AFTER_REMOVE));
        dynamicControlsPage.clickOnAddButton();
        assertEquals(dynamicControlsPage.isWaitTextAndLoadIndicatorDisplayed(DynamicControlsData.LOADING_TEXT), true, String.format("The text '%s' and indeterminate progress bar should be displayed", DynamicControlsData.LOADING_TEXT));
//        assertEquals(dynamicControlsPage.isCheckboxAppeared(DynamicControlsData.CHECKBOX_TITLE), true, String.format("The correct checkbox title '%s' should be displayed", DynamicControlsData.CHECKBOX_TITLE));
       dynamicControlsPage.waitUntilCheckboxClickable();
        assertEquals(dynamicControlsPage.isCheckboxDisplayed(), true, "where is your checkbox?");
        assertEquals(dynamicControlsPage.isCheckboxTitleCorrect(DynamicControlsData.CHECKBOX_TITLE), true, "your title for checkbox is wrong");

        assertEquals(dynamicControlsPage.isCheckboxChecked(), false, "The checkbox should have unchecked state");
        assertEquals(dynamicControlsPage.isButtonTitleChangedFromAddToRemove(DynamicControlsData.REMOVE_BUTTON_TITLE), true, String.format("The button title '%s' should be changed to '%s'", DynamicControlsData.ADD_BUTTON_TITLE, DynamicControlsData.REMOVE_BUTTON_TITLE));
        assertEquals(dynamicControlsPage.isCorrectTextDisplayed(DynamicControlsData.MESSAGE_AFTER_ADD), true, String.format("The text '%s' should be displayed", DynamicControlsData.MESSAGE_AFTER_ADD));
    }



}
