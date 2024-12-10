package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import basepack.BaseClass;

public class HomePage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "searchPlayerIcon")
	WebElement searchIcon;

	@FindBy(id = "enrollmentIcon")
	WebElement enrollIcon;

	// Method for getting current URL
	public String currentURLOfHomePage() {
		String Currenturl = driver.getCurrentUrl();
		return Currenturl;
	}

	// Method for clicking on Search of home page
	public SearchPage clickOnSearch() {
		action.waitElementToBeClickable();
		action.waitElementTillNotVisible(searchIcon);
		//action.explicitWait(driver, searchIcon);
		action.jsClick(driver, searchIcon);
		action.waitElementToBeClickable();
		return new SearchPage(driver);

	}

	// Method for clicking on Enroll of home page
	public EnrollBasicPage clickOnEnroll() {
		action.waitElementToBeClickable();
		action.waitElementTillNotVisible(enrollIcon);
		action.jsClick(driver, enrollIcon);
		action.waitElementToBeClickable();
		return new EnrollBasicPage(driver);
	}
}
