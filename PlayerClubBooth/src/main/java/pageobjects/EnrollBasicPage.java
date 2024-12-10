package pageobjects;

//import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class EnrollBasicPage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public EnrollBasicPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[contains(text(),'Title')]")
	WebElement enrollmentPageTitleText;

	@FindBy(xpath = "//div[contains(text(),'Basic Information')]")
	WebElement enrollBasicBtn;

	@FindBy(xpath = "//*[contains(text(),'Select Title')]")
	WebElement selectTitle;

	@FindBy(xpath = "//*[contains(text(),' Madam ')]")
	WebElement madam;

	@FindBy(id = "igt_input_First Name")
	WebElement firstname;

	@FindBy(id = "igt_input_Middle Name")
	WebElement midname;

	@FindBy(id = "igt_input_Last Name")
	WebElement lastname;

	@FindBy(xpath = "//span[contains(text(),'Select Suffix')]")
	WebElement suffix;

	@FindBy(xpath = "//span[normalize-space()='PhD']")
	WebElement selectvalue;

	@FindBy(id = "igt_input_Preferred Name")
	WebElement preferredname;

	@FindBy(xpath = "//span[contains(text(),'Select Gender')]")
	WebElement gender;

	@FindBy(xpath = "//*[contains(text(),' Female ')]")
	WebElement genderName;

	@FindBy(xpath = "//*[@data-placeholder='MM/DD/YYYY'][1]")
	WebElement dobCalender;

	@FindBy(xpath = "//*[@aria-live='polite']/span[@class='mat-button-wrapper']")
	WebElement cYear;

	@FindBy(xpath = "//*[@aria-label='Previous 24 years']")
	WebElement preYear;

	@FindBy(xpath = "(//*[@class='mat-calendar-body-cell']/div[@class='mat-calendar-body-cell-content mat-focus-indicator'])[1]")
	WebElement year;

	@FindBy(xpath = "(//*[@class='mat-calendar-body-cell']/div)[1]")
	WebElement month;

	@FindBy(xpath = "(//*[@class='mat-calendar-body-cell']/div)[1]")
	WebElement date;
	@FindBy(xpath = "(//mat-select[@role='combobox'][@aria-autocomplete='none']/div/div)[8]")
	WebElement nationalityArrow;
	
	@FindBy(xpath = "//mat-option[@role='option']/span[@class='mat-option-text'][text()=' United States of America ']")
	WebElement nationalitySelect;

	@FindBy(xpath = "//input[@class='formControl formControl-dash-custom taxId-input ng-untouched ng-pristine ng-valid']")
	WebElement taxID;

	@FindBy(xpath = "(//input[@type='text'][@id='igt_input_'][@name='igt_input_'])[1]")
	WebElement crossRef;
	@FindBy(xpath = "//*[text()='Select']")
	WebElement selectPip;

	@FindBy(xpath = "//*[text()=' Yes ']")
	WebElement pipYes;

	@FindBy(id = "basicNext")
	WebElement next;

	@FindBy(xpath = "//div[@class='right-next-prev']/button[2]/span[text()='CANCEL']")
	WebElement cancelBtn;

	@FindBy(xpath = "//div[contains(text(),'Recent Searches')]")
	WebElement recentSearchText;

	@FindBy(xpath = "//*[text()='Please Select Title']")
	WebElement errorMsgOfTitleField;

	@FindBy(xpath = "//p[text()='Please enter \"First Name\". ']")
	WebElement errorMsgOfFirstNameField;

	@FindBy(xpath = "//p[text()='Please enter \"Last Name\". ']")
	WebElement errorMsgOfLastNameField;

	@FindBy(xpath = "//*[text()='Please select \"Gender\". ']")
	WebElement errorMsgOfGenderField;

	@FindBy(xpath = "(//*[@class='enroll-form']//li)[15]/p")
	WebElement errorMsgOfDobField;

    //  Method for entering Basic page details
	public EnrollIdentificationPage nextClickableAfterDetailsEntered(String firstName, String midName, String lastName,
			String preferredName, String texNumber, String crossRefValue) {
		// String randomString = RandomStringUtils.randomAlphabetic(5).toLowerCase();
		action.implicitWait(driver);
		action.waitElementTillNotVisible(selectTitle).click();
		action.explicitWait(driver, madam);
		action.click(driver, madam);
		action.type(firstname, firstName);
		// action.type(firstname, firstName + randomString ); to enter random name
		// please uncomment String randomString and this statement.
		action.type(midname, midName);
		action.type(lastname, lastName);
		action.click(driver, suffix);
		action.click(driver, selectvalue);
		action.type(preferredname, preferredName);
		action.explicitWait(driver, gender);
		action.click(driver, gender);
		action.explicitWait(driver, genderName);
		action.click(driver, genderName);
		action.explicitWait(driver, dobCalender);
		action.click(driver, dobCalender);
		action.explicitWait(driver, cYear);
		action.click(driver, cYear);
		action.explicitWait(driver, preYear);
		action.click(driver, preYear);
		action.explicitWait(driver, year);
		action.click(driver, year);
		action.explicitWait(driver, month);
		action.click(driver, month);
		action.explicitWait(driver, date);
		action.click(driver, date);
		action.click(driver, nationalityArrow);
		action.click(driver, nationalitySelect);
		action.type(taxID, texNumber);

		action.type(crossRef, crossRefValue);

		action.jsClick(driver, selectPip);
		action.jsClick(driver, pipYes);
		action.jsClick(driver, next);

		return new EnrollIdentificationPage(driver);
	}
	
	// Method for next button clickable
	public boolean ableToClickNext() {
		if (action.waitElementTillNotVisible(next) != null) {
			action.waitElementTillNotVisible(next).click();
			return true;
		} else {
			// Log or handle the case where the element is not clickable
			return false;
		}
	}
	
	// Method for clicking next button
	public void clickOnNextbutton() {
		action.jsClick(driver, next);
	}

	// Method for redirect to Enrollment page
	public boolean isUserRedirectToEnrollmentPage() {
		return action.isDisplayed(driver, enrollmentPageTitleText);
	}

	// Method for clicking Cancel button of Basic page
	public String cancelBtnOfBasicPage() {
		action.jsClick(driver, cancelBtn);

		String textData = recentSearchText.getText();
		System.out.println(textData);
		return textData;
	}

	// Method for getting error message of First name field 
	public String errorTextOfFirstName() {
		clickOnNextbutton();

		String data = errorMsgOfFirstNameField.getText();
		System.out.println(data);
		return data;
	}

	// Method for getting error message of Last name field 
	public String errorTextOfLastName() {
		clickOnNextbutton();

		String data = errorMsgOfLastNameField.getText();
		System.out.println(data);
		return data;
	}

	// Method for getting error message of DOB field 
	public String errorTextOfDOB() {
		clickOnNextbutton();

		String data = errorMsgOfDobField.getText();
		System.out.println(data);
		return data;
	}
}
