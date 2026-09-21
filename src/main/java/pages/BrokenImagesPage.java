package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenImagesPage extends BasePage {
    private final By headerLocator = By.tagName("h3");
    private final By imagesLocator = By.xpath("//div[@class='example']//img");
    private final By footerLocator = By.xpath("//div[@style]");
    private final By linkLocator = By.linkText("Elemental Selenium");

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBrokenImagesPageLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.readyState").equals("complete");
    }

    public boolean isHeaderVisible() {
        return isVisible(headerLocator, "Header");
    }

    public int getImagesAmount() {
        List<WebElement> images = findElements(imagesLocator);
        logger.info("The amount of images are = {}", images.size() );
        return images.size();
        }

    public boolean isImageVisible(int imageNumber) {
        WebElement targetImage = this.findElementByNumber(imagesLocator, imageNumber);
        return isVisible(targetImage,  String.format("Image %d", imageNumber) );
    }

    public boolean isFooterVisible() {
        WebElement footerEl = find(footerLocator);
        String footerText = footerEl.getText();
        logger.info("Footer text is {}", footerText );
        return isVisible(footerLocator, "Footer");
    }

    public boolean isLinkVisible(){
        return isVisible(linkLocator, "Footer Link");
    }

    public boolean isImageLoadedCorrectly(int imageNumber) {
        WebElement targetElement = this.findElementByNumber(imagesLocator, imageNumber);
        return isElementLoadedCorrectly(String.format("Image %d", imageNumber), targetElement);
    }


    }