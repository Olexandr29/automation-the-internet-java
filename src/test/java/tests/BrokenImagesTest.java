package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;

import static org.testng.Assert.*;

public class BrokenImagesTest extends BaseTest {
    private BrokenImagesPage brokenImagesPage;

    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setUp")
    public void openBrokenImagesPage() {
        brokenImagesPage = homePage.openBrokenImagesPage();
    }

    @Test
    public void TC36VerifyPageContent() {
        assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/broken_images", "The Broken Images page URL is wrong");
        assertTrue(brokenImagesPage.isBrokenImagesPageLoaded(), "The \"Broken Images\" page is not loaded");
        assertTrue(brokenImagesPage.isHeaderVisible(), "The \"Broken Images\" header is not displayed");
        assertEquals(brokenImagesPage.getImagesAmount(), 3, "the amount of Images are not 3");
        assertTrue(brokenImagesPage.isImageVisible(1), String.format("The Image %d is not displayed on the page", 1));
        assertTrue(brokenImagesPage.isImageVisible(2), String.format("The Image %d is not displayed on the page", 2));
        assertTrue(brokenImagesPage.isImageVisible(3), String.format("The Image %d is not displayed on the page", 3));
        assertTrue(brokenImagesPage.isFooterVisible(), "The footer text \"Powered by Elemental Selenium\" is not displayed");
        assertTrue(brokenImagesPage.isLinkVisible(), "The \"Elemental Selenium\" link is not displayed");
    }




    }