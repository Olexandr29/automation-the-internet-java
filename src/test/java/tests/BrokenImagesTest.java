package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;
import testData.BrokenImagesData;

import static org.testng.Assert.*;
import org.testng.asserts.SoftAssert;

public class BrokenImagesTest extends BaseTest {
    private BrokenImagesPage brokenImagesPage;

    @BeforeMethod(alwaysRun = true, dependsOnMethods = "setUp")
    public void openBrokenImagesPage() {
        brokenImagesPage = homePage.openBrokenImagesPage();
    }

    @Test
    public void TC36VerifyPageContent() {
        assertEquals(driver.getCurrentUrl(), BrokenImagesData.BROKEN_IMAGES_URL, "The Broken Images page URL is wrong");
        assertTrue(brokenImagesPage.isBrokenImagesPageLoaded(), "The \"Broken Images\" page is not loaded");
        assertTrue(brokenImagesPage.isHeaderVisible(), String.format("The '%s' header is not displayed", BrokenImagesData.HEADER));
        assertEquals(brokenImagesPage.getImagesAmount(), BrokenImagesData.IMAGES_AMOUNT, String.format("the amount of Images are not %d", BrokenImagesData.IMAGES_AMOUNT));
        assertTrue(brokenImagesPage.isImageVisible(1), String.format("The Image %d is not displayed on the page", 1));
        assertTrue(brokenImagesPage.isImageVisible(2), String.format("The Image %d is not displayed on the page", 2));
        assertTrue(brokenImagesPage.isImageVisible(3), String.format("The Image %d is not displayed on the page", 3));
        assertTrue(brokenImagesPage.isFooterVisible(), String.format("The footer text '%s' is not displayed", BrokenImagesData.FOOTER));
        assertTrue(brokenImagesPage.isLinkVisible(), String.format("The '%s' link is not displayed", BrokenImagesData.LINK));
    }

    @Test
    public void TC37VerifyImageLoading() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(brokenImagesPage.isImageLoaded(3), "The third image is broken or not loaded.");
        softAssert.assertTrue(brokenImagesPage.isImageLoaded(1), "The first image is broken or not loaded.");
        softAssert.assertTrue(brokenImagesPage.isImageLoaded(2), "The second image is broken or not loaded.");
        softAssert.assertAll();
    }


    }