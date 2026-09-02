package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import testData.CheckboxData;

import static org.testng.Assert.*;

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
        assertEquals(driver.getCurrentUrl(), CheckboxData.CHECKBOX_PAGE_URL, "The Checkbox page is not opened");
        assertTrue(checkboxPage.isCheckboxVisible(1), String.format("The '%s' is not visible", CheckboxData.CHECKBOX_1) );
        assertTrue(checkboxPage.isCheckboxVisible(2), String.format("The %s is not visible", CheckboxData.CHECKBOX_2) );
    }

    @Test
    public void TC32VerifyCheckboxesInitialState() {
        Allure.step("Observe the initial state of Checkbox 1");
        assertEquals(checkboxPage.isCheckboxChecked(1), CheckboxData.CHECKBOX_1_DEFAULT_CHECKED_STATE, String.format("The %s is not unchecked", CheckboxData.CHECKBOX_1));
        Allure.step("Observe the initial state of Checkbox 2");
        assertEquals(checkboxPage.isCheckboxChecked(2), CheckboxData.CHECKBOX_2_DEFAULT_CHECKED_STATE, String.format("The %s is not checked", CheckboxData.CHECKBOX_2));
    }

    @Test(groups = {"smoke"})
    public void TC33VerifyCheckboxesStateChangesCorrectly() {
        checkboxPage.changeCheckboxState(1);
        assertNotEquals(checkboxPage.isCheckboxChecked(1), CheckboxData.CHECKBOX_1_DEFAULT_CHECKED_STATE, String.format("The %s is not checked after first click", CheckboxData.CHECKBOX_1));
        checkboxPage.changeCheckboxState(1);
        assertEquals(checkboxPage.isCheckboxChecked(1), CheckboxData.CHECKBOX_1_DEFAULT_CHECKED_STATE, String.format("The %s is not unchecked after second click", CheckboxData.CHECKBOX_1));
        checkboxPage.changeCheckboxState(2);
        assertNotEquals(checkboxPage.isCheckboxChecked(2), CheckboxData.CHECKBOX_2_DEFAULT_CHECKED_STATE, String.format("The %s is not unchecked after first click", CheckboxData.CHECKBOX_2));
        checkboxPage.changeCheckboxState(2);
        assertEquals(checkboxPage.isCheckboxChecked(2), CheckboxData.CHECKBOX_2_DEFAULT_CHECKED_STATE, String.format("The %s is not checked after second click", CheckboxData.CHECKBOX_2));
    }

    @Test
    public void TC34VerifyCheckboxesStateAfterRefresh() {
        checkboxPage.changeCheckboxState(1);
        assertTrue(checkboxPage.isCheckboxChecked(1), String.format("The %s is not checked", CheckboxData.CHECKBOX_1));
        assertTrue(checkboxPage.isCheckboxChecked(2), String.format("The %s is not checked", CheckboxData.CHECKBOX_2));
        Allure.step("Click the browser Refresh button");
        driver.navigate().refresh();
        assertEquals(checkboxPage.isCheckboxChecked(1), CheckboxData.CHECKBOX_1_DEFAULT_CHECKED_STATE, String.format("The is not unchecked after refresh", CheckboxData.CHECKBOX_1));
        assertEquals(checkboxPage.isCheckboxChecked(2), CheckboxData.CHECKBOX_2_DEFAULT_CHECKED_STATE, String.format("The is not checked after refresh", CheckboxData.CHECKBOX_2));
    }

    @Test(groups = {"keyboard"})
    public void TC35VerifyCheckboxStateChangesUsingKeyboard() {
        checkboxPage.makeCheckboxActive(1);
        assertTrue(checkboxPage.isCheckboxActive(1), String.format("The focus indicator for %s is not visible", CheckboxData.CHECKBOX_1));
        checkboxPage.changeCheckboxStateViaKeyboardKeySpace(1);
        assertNotEquals(checkboxPage.isCheckboxChecked(1), CheckboxData.CHECKBOX_1_DEFAULT_CHECKED_STATE, String.format("The %s is not checked", CheckboxData.CHECKBOX_1));
        checkboxPage.makeCheckboxActive(2);
        assertTrue(checkboxPage.isCheckboxActive(2), String.format("The focus indicator for %s is not visible", CheckboxData.CHECKBOX_2));
        checkboxPage.changeCheckboxStateViaKeyboardKeySpace(2);
        assertNotEquals(checkboxPage.isCheckboxChecked(2), CheckboxData.CHECKBOX_2_DEFAULT_CHECKED_STATE, String.format("The is not unchecked", CheckboxData.CHECKBOX_2));
    }


}