package basepack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import actiondriver.Action;

public class BaseClass {

	public static Properties prop;
	// public static WebDriver driver;
	// Declare ThreadLocal Driver
	public static ThreadLocal<WebDriver> drivertl = new ThreadLocal<WebDriver>();

	public static final String IMAGES_PATH = "./Screenshot";
	
	public static String baseURL;
	
	public static String browserName;

	@BeforeSuite(alwaysRun = true)
	@Parameters({"BaseURL","BrowserName"})
	// Method for load configuration file
	public void loadConfig(String baseurl,String browser) throws IOException {
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop = new Properties();
			prop.load(ip);
			
			this.baseURL=baseurl;
			this.browserName=browser;
			
			
		} catch (IOException e) {
			// Handle IOException while closing FileInputStream
			e.printStackTrace();
		} finally {
			if (ip != null) {
				try {
					ip.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Get Driver from threadLocalmap
	public static WebDriver getDriver() {
		
		return drivertl.get();
	}

	// To launch  the Web browser
	public void launchWeb() {

		//if (browserName.equalsIgnoreCase("Chrome")) {
		if (browserName.toLowerCase().contains("chrome")) {
			ChromeOptions option = new ChromeOptions();
			if (browserName.toLowerCase().endsWith("headless")) {
				option.addArguments("headless");
				option.addArguments("window-size=1920,1080");
 
			}
			//option.addArguments("headless");
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.addArguments("--remote-allow-origins=*");

			option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

			drivertl.set(new ChromeDriver(option));

			Action action = new Action();
			action.implicitWait(getDriver());

		} else if (browserName.equalsIgnoreCase("FireFox")) {
			FirefoxOptions option = new FirefoxOptions();
			drivertl.set(new FirefoxDriver(option));

			Action action = new Action();
			action.implicitWait(getDriver());
		}

		getDriver().manage().window().maximize();
		
		getDriver().get(baseURL);
	}

	// Method for the code cleanup
	@BeforeTest
	public void codeCleanUp() {

		// Create a file object for the images folder
		File imagesFolder = new File(IMAGES_PATH);

		// Check if the folder exists and is not empty
		if (imagesFolder.exists() && imagesFolder.list().length > 0) {

			// Delete all the files in the folder
			try {
				FileUtils.cleanDirectory(imagesFolder);
				// System.out.println("Code cleanup");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		launchWeb();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		getDriver().quit();
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {

	}

}
