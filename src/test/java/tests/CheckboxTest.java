package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class CheckboxTest extends BaseTest {
    private CheckboxPage checkboxPage;

    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setUp")
    public void openCheckboxPage() {
        checkboxPage = homePage.openCheckboxPage();
    }
    @Test
    public void TC31VerifyCheckboxesAreVisible() {
        assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/checkboxes", "The Checkboxes page is not opened");
        assertTrue(checkboxPage.isCheckboxVisible(1), "The checkbox 1 is not visible");
        assertTrue(checkboxPage.isCheckboxVisible(2), "The checkbox 2 is not visible");

    }






}
