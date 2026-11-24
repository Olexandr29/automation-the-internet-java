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
//        assertEquals(dynamicControlsPage.isHeaderVisible(), true, "The header should be displayed");
//        assertEquals(dynamicControlsPage.isHeaderCorrect("Dynamic Controls"), true, "The correct header should be 'Dynamic Controls'");
        assertEquals(dynamicControlsPage.isCorrectHeaderDisplayed("Dynamic Controls"), true, "The correct header 'Dynamic Controls' should be displayed");
        assertEquals(dynamicControlsPage.isCorrectParagraphDisplayed("This example demonstrates when elements (e.g., checkbox, input field, etc.) are changed asynchronously."), true, "The correct paragraph should be displayed");
        assertEquals(dynamicControlsPage.isCorrectCheckboxSubheaderDisplayed("Remove/add"), true, "The correct header 'Remove/add' should be displayed");

    }
}
