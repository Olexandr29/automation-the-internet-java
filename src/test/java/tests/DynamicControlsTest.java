package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

import static org.testng.Assert.*;
import testData.DynamicControlsData;

public class DynamicControlsTest extends BaseTest {
    private DynamicControlsPage dynamicControlsPage;

    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setUp")
    public void openDynamicControlsPage() {
        dynamicControlsPage = homePage.openDynamicControlsPage();
    }

    @Test
    public void TC38VerifyPageContent() {
        assertEquals(driver.getCurrentUrl(), DynamicControlsData.DYNAMIC_CONTROLS_URL, "The Dynamic Controls page should be opened");
        assertEquals(dynamicControlsPage.isPageLoaded(), true, "The Dynamic Controls page should be loaded successfully and the document readyState should be complete");
        assertEquals(dynamicControlsPage.isCorrectHeaderDisplayed(DynamicControlsData.HEADER), true, String.format("The correct header '%s' should be displayed", DynamicControlsData.HEADER));
        assertEquals(dynamicControlsPage.isCorrectParagraphDisplayed(DynamicControlsData.PARAGRAPH), true, "The correct paragraph should be displayed");
        assertEquals(dynamicControlsPage.isCorrectCheckboxSubheaderDisplayed(DynamicControlsData.CHECKBOX_SUBHEADER), true,  String.format("The correct subheader 's' should be displayed", DynamicControlsData.CHECKBOX_SUBHEADER));
        assertEquals(dynamicControlsPage.isCorrectCheckboxTitleDisplayed(DynamicControlsData.CHECKBOX_TITLE), true, String.format("The correct checkbox title 's' should be displayed", DynamicControlsData.CHECKBOX_TITLE));
        assertEquals(dynamicControlsPage.isRemoveButtonDisplayed(DynamicControlsData.REMOVE_BUTTON_TITLE), true, String.format("The button 's' should be displayed", DynamicControlsData.REMOVE_BUTTON_TITLE));
        assertEquals(dynamicControlsPage.isCorrectInputSubheaderDisplayed(DynamicControlsData.INPUT_SUBHEADER), true, String.format("The correct input subheader 's' should be displayed", DynamicControlsData.INPUT_SUBHEADER));
        assertEquals(dynamicControlsPage.isInputDisplayed(), true, "The input field should be displayed");
        assertEquals(dynamicControlsPage.isEnableButtonDisplayed(DynamicControlsData.ENABLE_BUTTON_TITLE), true, String.format("The button 's' should be displayed", DynamicControlsData.ENABLE_BUTTON_TITLE));
        assertEquals(dynamicControlsPage.isCorrectFooterDisplayed(DynamicControlsData.FOOTER), true, String.format("The correct header 's' should be displayed", DynamicControlsData.FOOTER));
        assertEquals(dynamicControlsPage.isCorrectSeleniumLinkDisplayed(DynamicControlsData.SELENIUM_LINK_TITLE), true, String.format("The correct link 's' should be displayed", DynamicControlsData.SELENIUM_LINK_TITLE));
        assertEquals(dynamicControlsPage.isCorrectSauceLabsLinkDisplayed(DynamicControlsData.SAUCE_LABS_LINK_TITLE), true, String.format("The correct link 's' should be displayed",DynamicControlsData.SAUCE_LABS_LINK_TITLE));
    }
}
