package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import basepack.BaseClass;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
		htmlReporter.config().thumbnailForBase64(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// extent.setSystemInfo("Author", "Droisys");
		extent.setSystemInfo("Automation Tester", "QA tester");
		extent.setSystemInfo("Organization", "IGT");
//	        extent.setSystemInfo("BUILD", " PlayersClub-UI : PR-125 #31\r\n"
//	        		+ "ACERest : Feature/PCB Branch #18.");

		return extent;
	}


	public static String screenshotPath;
	public static String screenshotName;

	// Method for capture the Screenshot
	public static void captureScreenshot() {
		try {
			File scrFile = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
			Date d = new Date();
			screenshotName = d.toString().replace(":", "").replace(" ", "") + ".jpg";
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Screenshot/" + screenshotName));
			System.out.println("Screenshot captured: " + screenshotName);
		} catch (ClassCastException e) {
			System.out.println("Driver does not support taking screenshots.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Failed to save screenshot.");
			e.printStackTrace();
		}
	}

}
