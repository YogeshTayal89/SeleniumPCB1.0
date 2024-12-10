package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class SearchResultPage extends BaseClass {
	Action action = new Action();

	WebDriver driver = null;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(@class,'detail-col')]")
	List<WebElement> playerList;

	@FindBy(xpath = "//span[text()='Player ID']/..")
	WebElement playerId;

	@FindBy(xpath = "//span[text()='DOB']/..")
	WebElement playerDob;

	@FindBy(xpath = "//span[text()='Card']/..")
	WebElement playerCardNumber;

	@FindBy(xpath = " //div[@class='mat-sort-header-content ng-tns-c136-1'] ")
	WebElement playerName;

	@FindBy(xpath = "//*[@class='mat-select-min-line ng-tns-c91-16 ng-star-inserted']")
	WebElement residenee;

	@FindBy(xpath = "//span[starts-with(@class,'mat-select-value-text ng-tns-c91-14 ng-star-inserted')]")
	WebElement phonenumber;

	@FindBy(xpath = "//div[@class='igt-w player-details']/ul/li/span[@class='identi-popup ng-star-inserted']")
	WebElement licenseIdnumber;

	@FindBy(xpath = "//div[@class='igt-w player-details']/ul/li/span[@class='identi-popup ng-star-inserted']")
	WebElement ssnIdNumber;

	@FindBy(xpath = "//div[@class='igt-w player-details']/ul/li/span[@class='identi-popup ng-star-inserted']")
	WebElement passportIdNumber;
	
	@FindBy(xpath = "//*[@class='igt-w player-details']/h3")
	WebElement fullName;

	@FindBy(xpath = "//div[@class='mat-step-label mat-step-label-active mat-step-label-selected']")
	WebElement enrollBasicInformation;

	// Method for getting player Id
	public boolean getPlayerId() {
		return action.isDisplayed(getDriver(), playerId);
	}

	// Method for getting Full name
	public boolean playerFullName() {
		return action.isDisplayed(driver, fullName) ;
	
	}

	// Method for getting Player DOB
	public boolean getPlayerDob() {
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, playerDob);
	}

	// Method for getting Player Phone number
	public boolean verifyPlayerPhoneNumber() {
		return action.isDisplayed(driver, phonenumber);

	}

	// Method for getting Player card number
	public boolean getPlayerCardNumber() {
		return action.isDisplayed(driver, playerCardNumber);
	}

	// Method for getting Player SSN Id
	public boolean getPlayerSsnIdBox() {
		return action.isDisplayed(driver, ssnIdNumber);

	}

	// Method for getting Player DL Id
	public boolean playerDlId() {
		return action.isDisplayed(driver, licenseIdnumber);
	}

	// Method for getting Player Passport ID
	public String playerPassportId() {
		return passportIdNumber.getText();
	}

	// Method for getting Player First name
	public String getFirstName() {
		String arr[] = fullName.getText().split(" ");
		String firstname = "";
		firstname = arr[1];
		return firstname;
	}

	// Method for getting Player Middle Name
	public String getMiddleName() {
		String arr[] = fullName.getText().split(" ");
		String Middlename = "";
		Middlename = arr[2];
		return Middlename;
	}

	// Method for getting Player Last name
	public String getLastName() {
		String arr[] = fullName.getText().split(" ");
		String LastName = "";
		LastName = arr[3];
		return LastName;
	}

	// Method for getting basic page information
	public String enrollBasicInfo() {
		return enrollBasicInformation.getText();
	}
}
