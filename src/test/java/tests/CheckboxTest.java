package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import testData.CheckboxData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Feature("Checkbox")
@Test(groups = {"regression"})
public class CheckboxTest extends BaseTest {
    private CheckboxPage checkboxPage;

    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setUp")
    public void openCheckboxPage() {
        checkboxPage = homePage.openCheckboxPage();
    }
    @Test(groups = {"smoke"})
    public void TC31VerifyCheckboxesAreVisible() {
        assertEquals(driver.getCurrentUrl(), CheckboxData.CheckboxPageURL, "The Checkbox page is not opened");
        assertTrue(checkboxPage.isCheckboxVisible(1), String.format("The '%s' is not visible", CheckboxData.CHECKBOX_1) );
        assertTrue(checkboxPage.isCheckboxVisible(2), String.format("The %s is not visible", CheckboxData.CHECKBOX_2) );

    }






}
