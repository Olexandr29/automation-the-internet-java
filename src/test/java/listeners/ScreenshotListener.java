package listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import tests.BaseTest;
import org.slf4j.Logger;


public class ScreenshotListener implements IInvokedMethodListener {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!method.isTestMethod() ) {
            return;
        }
        if (testResult.getStatus() != ITestResult.FAILURE) {
            return;
        }
        logger.debug(">>> ScreenshotListener.afterInvocation()");
        logger.debug(">>> Thread: " + Thread.currentThread().getName());

        BaseTest test = (BaseTest) testResult.getInstance();
        WebDriver driver = test.getDriver();

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        logger.debug(">>> Screenshot captured: " + screenshot.length + " bytes");

        Allure.addAttachment(
                "Screenshot on failure",
                "image/png",
                new java.io.ByteArrayInputStream(screenshot),
                ".png"
        );
        logger.debug(">>> Screenshot attached");
    }
}
