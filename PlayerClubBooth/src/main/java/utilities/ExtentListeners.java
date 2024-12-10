package utilities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import basepack.BaseClass;
public class ExtentListeners implements ITestListener {
	public static ExtentTest test;
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
	static LocalDateTime now = LocalDateTime.now();  
	static String fileName = "Extentreport"+".html";
	static String fileName1 = "Extent_Logs_Report" + ".html";
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir") + "/test-output/Extentreport/" + fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		test = extent
				.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
		testReport.set(test);
	}
	
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
	    String passscreenshot=takeScreenShot();

		testReport.get().pass("<b>" + "<font color=" + "green>" + "Screenshot of success" + "</font>" + "</b>",
				MediaEntityBuilder.createScreenCaptureFromBase64String(passscreenshot).build());
		
		
	}
	public void onTestFailure(ITestResult result) {
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");
		 String failscreenshot=takeScreenShot();
		
		testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
				MediaEntityBuilder.createScreenCaptureFromBase64String(failscreenshot).build());
		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
	
	}
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);
	}
	
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}

	}

	
	public String takeScreenShot()
	{	
		String screenshot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BASE64);
		return screenshot;
	}
	
}
