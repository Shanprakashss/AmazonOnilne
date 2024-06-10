package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;
    public static ExtentTest test;

    public static void setup() {
        htmlReporter = new ExtentHtmlReporter("extentReport.html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Extent Reports");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static void flush() {
        extent.flush();
    }
}
