package E2ETesting.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG
{
public static ExtentReports getReportObject()
{
    String path = System.getProperty("user.dir")+"//Reports//index.html";
    ExtentSparkReporter reporter = new ExtentSparkReporter(path);
    reporter.config().setReportName("Web Automation Testing");
    reporter.config().setDocumentTitle("Ecommerce Test Results");

    ExtentReports extent = new ExtentReports();
    extent.attachReporter(reporter);
    extent.setSystemInfo("Tester", "Surbhi S");
return extent;


}
}
