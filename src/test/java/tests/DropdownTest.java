package tests;

import org.testng.annotations.Test;
import pages.DropdownPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest {

    private DropdownPage dropdownPage;


    @Test
    public void TC21DropdownDefaultState() {
        dropdownPage = homePage.openDropdownPage();
        assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/dropdown", "The Dropdown page is not opened.");
        assertTrue(dropdownPage.isDropdownVisible(), "The dropdown is not visible.");
        assertEquals(dropdownPage.getSelectedDropdownText(), "Please select an option",
                "The default selected value should be 'Please select an option'");
    }




}