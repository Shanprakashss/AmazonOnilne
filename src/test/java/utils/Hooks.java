package utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        ExtentReportManager.setup();
        driver = new ChromeDriver();
        ExtentReportManager.test = ExtentReportManager.getExtent().createTest("Test Scenario");
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, scenario.getName());
            ExtentReportManager.test.fail("Screenshot captured on failure", 
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        driver.quit();
        ExtentReportManager.flush();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
