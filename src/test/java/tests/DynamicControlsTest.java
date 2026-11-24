package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest {
    private DynamicControlsPage dynamicControlsPage;

    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setUp")
    public void openDynamicControlsPage() {
        dynamicControlsPage = homePage.openDynamicControlsPage();
    }

    @Test
    public void TC38VerifyPageContent() {
        assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/dynamic_controls", "The Dynamic Controls page should be opened");
        assertEquals(dynamicControlsPage.isPageLoaded(), true, "The Dynamic Controls page should be loaded successfully and the document readyState should be complete");
        assertEquals(dynamicControlsPage.isCorrectHeaderDisplayed("Dynamic Controls"), true, "The correct header 'Dynamic Controls' should be displayed");
        assertEquals(dynamicControlsPage.isCorrectParagraphDisplayed("This example demonstrates when elements (e.g., checkbox, input field, etc.) are changed asynchronously."), true, "The correct paragraph should be displayed");
        assertEquals(dynamicControlsPage.isCorrectCheckboxSubheaderDisplayed("Remove/add"), true, "The correct subheader 'Remove/add' should be displayed");
        assertEquals(dynamicControlsPage.isCorrectCheckboxTitleDisplayed("A checkbox"), true, "The correct checkbox title 'A checkbox' should be displayed");
        assertEquals(dynamicControlsPage.isRemoveButtonDisplayed("Remove"), true, "The button 'Remove' should be displayed");
        assertEquals(dynamicControlsPage.isCorrectInputSubheaderDisplayed("Enable/disable"), true, "The correct input subheader 'Enable/disable' should be displayed");
        assertEquals(dynamicControlsPage.isInputDisplayed(), true, "The input field should be displayed");
        assertEquals(dynamicControlsPage.isEnableButtonDisplayed("Enable"), true, "The button 'Enable' should be displayed");
        assertEquals(dynamicControlsPage.isCorrectFooterDisplayed("Powered by Elemental Selenium and Sauce Labs"), true, "The correct header 'Powered by Elemental Selenium and Sauce Labs' should be displayed");
        assertEquals(dynamicControlsPage.isCorrectSeleniumLinkDisplayed("Elemental Selenium"), true, "The correct link 'Elemental Selenium' should be displayed");
        assertEquals(dynamicControlsPage.isCorrectSauceLabsLinkDisplayed("Sauce Labs"), true, "The correct link 'Sauce Labs' should be displayed");
    }
}
