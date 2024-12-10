package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class EnrollPossibleMatchesPage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public EnrollPossibleMatchesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'Possible Matches')]")
	WebElement redirectToPossibleMatchesPage;
	
	@FindBy(xpath = "//*[text()='Print Card']")
	WebElement printCard;

	@FindBy(xpath = "//span[text()=' YES ']")
	WebElement overridePopup;

	@FindBy(xpath = "//*[@placeholder='Enter user name'][@id='igt_input_'][@data-placeholder='Enter user name'][@name='igt_input_']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Enter password'][@id='igt_input_Enter Password'][@name='igt_input_Enter Password']")
	WebElement userPassword;

	@FindBy(xpath = "//span[text()=' OK ']")
	WebElement clickOnOk;
	@FindBy(xpath = "//*[text()='SAVE']")
	WebElement saveButton;

	// Method for redirect to Possiblematches page
	public boolean isUserRedirectToPossibleMatchesPage() {
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, redirectToPossibleMatchesPage);
	}
	
	// Method for displaying next page element
	public boolean nextPageElementDisplay() {
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, printCard);
	}

	// Method for clicking on Save button
	public PrintCardPage savebtn() {
		action.jsClick(driver, saveButton);
		action.jsClick(driver, overridePopup);
		return new PrintCardPage(driver);
		
	}
	// Method for entering the credentials for authorization 
	public  void clickOnSaveButton(String username, String password) {
		driver.manage().deleteAllCookies();
		action.type(userName, username);
		action.type(userPassword, password);
		userName.clear();
		userPassword.clear();
		action.type(userName, username);
		action.type(userPassword, password);
		action.waitElementToBeClickable();
     	action.jsClick(driver, clickOnOk);     
	}
}
