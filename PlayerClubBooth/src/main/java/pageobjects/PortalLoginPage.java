package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class PortalLoginPage extends BaseClass {
	// Portal login page - All the webElements of page
	Action action = new Action();

	@FindBy(xpath = "//i[normalize-space()='arrow_drop_down']")
	WebElement arrowClick;

	@FindBy(xpath = "//div[contains(text(),'Main')]")
	WebElement siteMain;

	@FindBy(xpath = "//div[contains(text(),'SiteOne')]")
	WebElement siteone;

	@FindBy(id = "txtUserName")
	WebElement portUserId;

	@FindBy(id = "txtPwd")
	WebElement portPassword;

	@FindBy(xpath = "//button[@type ='submit']")
	WebElement portSubmit;

	WebDriver driver = null;

	public PortalLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// To get the Title of portal
	public String portalGetTitle() {
		String title = driver.getTitle();
		return title;
	}

	// Login to portal
	public PortalLandingPage igtPortalLogin(String userId, String pswrd) {
		action.explicitWait(driver, arrowClick);
		action.click(driver, arrowClick);
		action.explicitWait(driver, siteMain);
		action.click(driver, siteMain);
		action.type(portUserId, userId);
		action.type(portPassword, pswrd);
		action.explicitWait(driver, portSubmit);
		action.click(driver, portSubmit);
		return new PortalLandingPage(driver);
	}

}
