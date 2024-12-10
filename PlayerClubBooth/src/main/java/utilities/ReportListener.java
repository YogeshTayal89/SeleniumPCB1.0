package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

//import com.igt.listener.LoggingUtils;

import basepack.BaseClass;


public class ReportListener implements ITestListener {
	
	/**
	 * This class implements ITestListener. Used to  take the screen-shot when test fails
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("TestFail");
		LoggingUtils.log(result.getName()+" Failed due to "+ result.getThrowable());
		takeScreenShot();
		
      
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TestPass");
		LoggingUtils.log("Passed "+ result.getName());
		takeScreenShot();
		System.out.println("ScreenshotsPass_took");
	}
    
	
	public void takeScreenShot()
	{	
		String screenshot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BASE64);
		LoggingUtils.logBase64(screenshot, "Screenshot");
		
	}
	
	
}
