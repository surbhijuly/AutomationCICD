package TestComponent;

import E2ETesting.resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener
{
    ExtentTest test;
   ExtentReports extent = ExtentReporterNG.getReportObject();
   ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        // Code to execute before a test starts
       test = extent.createTest(result.getMethod().getMethodName());
       extentTest.set(test); //uniqie thread id(error validations -> test
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        extentTest.get().log(Status.PASS,"Test Passed");
        // Code to execute on test success
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
        // Code to execute on test failure
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to execute on test skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional: rarely used
    }

    @Override
    public void onStart(ITestContext context) {
        // Code before <test> tag of XML starts
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        // Code after all tests of <test> tag finish
    }
}
