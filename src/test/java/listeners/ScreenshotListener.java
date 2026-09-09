package listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(">>> ScreenshotListener.onTestFailure()");

        BaseTest test = (BaseTest) result.getInstance();
        WebDriver driver = test.getDriver();

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                "Screenshot on failure",
                "image/png",
                new java.io.ByteArrayInputStream(screenshot),
                ".png"
        );
    }
}
