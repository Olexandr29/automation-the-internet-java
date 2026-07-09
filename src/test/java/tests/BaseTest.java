package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    protected static final Logger logger =
            LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp(Method method, Object[] testData) {
        if (testData.length > 0) {
            logger.info("==================== {} ====================", testData[0]);
        } else {
            logger.info("==================== {} ====================", method.getName() );
        }

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
