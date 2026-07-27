package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;
import testData.DropdownData;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest {

    private DropdownPage dropdownPage;

    @Override
    @BeforeMethod
    public void setUp(Method method, Object[] testData) {
        super.setUp(method, testData);
        dropdownPage = homePage.openDropdownPage();
    }

    @Test
    public void TC21DropdownDefaultState() {
        assertEquals(driver.getCurrentUrl(), DropdownData.URL_DROPDOWN_PAGE, "The Dropdown page is not opened.");
        assertTrue(dropdownPage.isDropdownVisible(), "The dropdown is not visible.");
        assertEquals(dropdownPage.getSelectedDropdownText(), "Please select an option",
                "The default selected value should be 'Please select an option'");
    }

    @Test
    public void TC22VerifyDropdownOptionsDisplayed() {
        assertEquals(dropdownPage.amountOfAvailableDropdownOptions(), DropdownData.AMOUNT_OF_DROPDOWN_OPTIONS, "The dropdown should contain %d items and unexpected options should not be displayed.".formatted(DropdownData.AMOUNT_OF_DROPDOWN_OPTIONS));
        assertTrue(dropdownPage.isSpecificOptionDisplayed(DropdownData.OPTION_DEFAULT), String.format("The '%s' should be displayed", DropdownData.OPTION_DEFAULT) );
        assertTrue(dropdownPage.isSpecificOptionDisplayed(DropdownData.OPTION_1), String.format("The '%s' should be displayed", DropdownData.OPTION_1));
        assertTrue(dropdownPage.isSpecificOptionDisplayed(DropdownData.OPTION_2), String.format("The '%s' should be displayed", DropdownData.OPTION_2));
    }

    @Test
    public void TC23SelectOption1() {
        dropdownPage.selectSpecificOption(DropdownData.OPTION_1);
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_1, String.format("The %s should became the selected value.", DropdownData.OPTION_1) );
    }

    @Test
    public void TC24VerifyOptionRemainsSelectedAfterReopeningAndClosing() {
        dropdownPage.selectSpecificOption(DropdownData.OPTION_2);
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_2, String.format("The %s should became the selected value.", DropdownData.OPTION_2) );
        dropdownPage.pressEnter();
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_2, String.format("The %s should became the selected value.", DropdownData.OPTION_2) );
        dropdownPage.pressEscape();
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_2, String.format("The %s should became the selected value.", DropdownData.OPTION_2) );
}

    @Test
    public void TC25ChangeSelectedOptionUsingKeyboardArrowKeys() {
        dropdownPage.selectSpecificOption(DropdownData.OPTION_1);
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_1, String.format("The %s should became the selected value.", DropdownData.OPTION_1) );
        dropdownPage.pressArrowDown();
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_2, String.format("The %s should became the selected value.", DropdownData.OPTION_2) );
        dropdownPage.pressArrowUp();
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_1, String.format("The %s should became the selected value.", DropdownData.OPTION_1) );
    }

    @Test
    public void TC26NavigateSelectAndChangeDropdownOptionViaKeyboard() {
        dropdownPage.makeDropdownActive();
        assertTrue(dropdownPage.isDropdownActive(), "The Dropdown should be focused");

        assertEquals(dropdownPage.amountOfAvailableDropdownOptions(), DropdownData.AMOUNT_OF_DROPDOWN_OPTIONS, "The dropdown should contain %d items and unexpected options should not be displayed.".formatted(DropdownData.AMOUNT_OF_DROPDOWN_OPTIONS));
        assertTrue(dropdownPage.isSpecificOptionDisplayed(DropdownData.OPTION_DEFAULT), String.format("The '%s' should be displayed", DropdownData.OPTION_DEFAULT) );
        assertTrue(dropdownPage.isSpecificOptionDisplayed(DropdownData.OPTION_1), String.format("The '%s' should be displayed", DropdownData.OPTION_1));
        assertTrue(dropdownPage.isSpecificOptionDisplayed(DropdownData.OPTION_2), String.format("The '%s' should be displayed", DropdownData.OPTION_2));

        dropdownPage.pressArrowDown();
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_1, String.format("The %s should became the selected value.", DropdownData.OPTION_1) );
        dropdownPage.pressArrowDown();
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_2, String.format("The %s should became the selected value.", DropdownData.OPTION_2) );
        dropdownPage.pressArrowUp();
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_1, String.format("The %s should became the selected value.", DropdownData.OPTION_1) );
    }

    @Test
    public void TC27VerifyTheArrowUpAndDownOnTheFirstAndLastOptions() {
        dropdownPage.selectSpecificOption(DropdownData.OPTION_1);
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_1, String.format("The %s should became the selected value.", DropdownData.OPTION_1) );
        dropdownPage.pressArrowUp();
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_1, String.format("The selected value should not be changed and the %s should remains selected.", DropdownData.OPTION_1) );
        dropdownPage.selectSpecificOption(DropdownData.OPTION_2);
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_2, String.format("The %s should became the selected value.", DropdownData.OPTION_2) );
        dropdownPage.pressArrowDown();
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_2, String.format("The selected value should not be changed and the %s should remains selected.", DropdownData.OPTION_2) );
    }

    @Test
    public void TC28VerifyOnlyOneOptionCanBeSelectedAtaTime() {
        dropdownPage.selectSpecificOption(DropdownData.OPTION_1);
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_1, String.format("The %s should became the selected value.", DropdownData.OPTION_1) );
        dropdownPage.selectSpecificOption(DropdownData.OPTION_2);
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_2, String.format("Only one option should be selected at a time, and now it should be the %s", DropdownData.OPTION_2) );
    }

    @Test
    public void TC29VerifySelectedOptionAfterRefresh() {
        dropdownPage.selectSpecificOption(DropdownData.OPTION_1);
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_1, String.format("The %s should be selected", DropdownData.OPTION_1));
        driver.navigate().refresh();
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_DEFAULT, String.format("The default value %s should be selected", DropdownData.OPTION_DEFAULT));
    }

    @Test
    public void TC30VerifyBrowserBackAndForwardNavigationBehaviour() {
        dropdownPage.selectSpecificOption(DropdownData.OPTION_2);
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_2, String.format("The %s should be selected", DropdownData.OPTION_2));
        driver.navigate().back();
        assertEquals(driver.getCurrentUrl(), URL_HOME_PAGE, "The Home page should be opened" );
        assertTrue(homePage.isDropdownLinkVisible(), "The Dropdown link should be visible");
        driver.navigate().forward();
        assertEquals(driver.getCurrentUrl(), DropdownData.URL_DROPDOWN_PAGE, "The Dropdown page should be opened");
        assertEquals(dropdownPage.getSelectedDropdownText(), DropdownData.OPTION_2, String.format("- The %s should be displayed as selected", DropdownData.OPTION_2));
    }



















}