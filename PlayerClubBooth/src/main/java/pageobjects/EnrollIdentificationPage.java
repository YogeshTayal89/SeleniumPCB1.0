package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class EnrollIdentificationPage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public EnrollIdentificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//label[contains(text(),'Type')])[1]")
	private WebElement redirectToIdentificationPage;

	@FindBy(xpath = "//span[contains(text(),'Drivers License')]")
	private WebElement clickOnTypes;

	@FindBy(xpath = "//*[text()=' Drivers License ']")
	private WebElement driversLicenseType;

	@FindBy(xpath = "//*[@data-placeholder='Enter ID#']")
	private WebElement enterID;

	@FindBy(xpath = "//*[@id='country']//mat-form-field[@appearance='outline']/div/div/div/mat-select")
	private WebElement countryArrow;

	@FindBy(xpath = "//mat-option[@role='option']/span[@class='mat-option-text'][text()=' United States of America ']")
	private WebElement countrySelect;

	@FindBy(xpath = "(//*[@class='enroll-form ident-fixed']/ul[@class='primary-text ng-star-inserted']/li)[7]/igt-input-select[@class='formControl ng-star-inserted']//mat-form-field/div/div/div/mat-select")
	private WebElement stateArrow;

	@FindBy(xpath = "//mat-option[@role='option']/span[@class='mat-option-text'][text()=' Armed Forces Americas ']")
	private WebElement stateSelect;

	@FindBy(xpath = "(//*[@data-placeholder='MM/DD/YYYY'])[2]")
	private WebElement expDateCalender;

	@FindBy(xpath = "//*[@aria-label='Choose month and year']")
	private WebElement monthAndYear;

	@FindBy(xpath = "(//*[@class='mat-calendar-body-cell-container ng-star-inserted']/button)[7]")
	private WebElement selectedExpiryYear;

	@FindBy(xpath = "(//*[@class='mat-calendar-body-cell-container ng-star-inserted']/button)[12]")
	private WebElement selectedExpiryMonth;

	@FindBy(xpath = "(//*[@class='mat-calendar-body-cell-container ng-star-inserted']/button)[31]")
	private WebElement selectedExpiryDate;

	@FindBy(xpath = "(//*[@class='nav-next-prev-bottom bottomnav']//following::button[3]/span[contains(text(),'NEXT')])[1]")
	private WebElement next;

	@FindBy(xpath = "//*[@class='primary-text fixed-row']/li/div/span")
	private WebElement idValidate;

	@FindBy(xpath = "//label[@class='mat-checkbox-layout']/span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
	private WebElement refuseIdCheckBox;

	@FindBy(xpath = "(//label[contains(text(),'Type')]/following-sibling::*)[1]//span")
	private static WebElement dropdownIds;
	@FindBy(xpath = "//mat-option/span")
	private static List<WebElement> allOptions;

	@FindBy(xpath = "//*[contains(text(),'Please enter \"ID\". ')]")
	private static WebElement errorMsgOfId;

	@FindBy(xpath = "//*[contains(text(),'Please select “State”. ')]")
	private static WebElement errorMsgOfState;

	@FindBy(xpath = "//*[contains(text(),'Please enter \"Expiry Date\". ')]")
	private static WebElement errorMsgOfExpiryDate;

	@FindBy(xpath = "//*[contains(text(),'Please enter \"Verified Date\". ')]")
	private static WebElement errorMsgOfVerifyDate;

	@FindBy(xpath = "(//*[text()=' add '])[1]")
	private static WebElement addId;

	@FindBy(xpath = "//*[text()=' Passport ']")
	private WebElement passportType;
	
	@FindBy(xpath = "//*[text()=' State License ']")
	private WebElement stateLicenseType;

	@FindBy(xpath = "(//*[text()=' delete '])[1]")
	private WebElement deleteButton;

	@FindBy(xpath = "(//*[text()=' edit '])[1]")
	private WebElement editButton;

	@FindBy(xpath = "//*[@class='mat-button-wrapper'][text()=' UPDATE ']")
	private WebElement updateButton;

	// Method for entering Indentification page details
	public EnrollAddressPage identificationPageDetailsEntered(String id) {
		
		action.waitElementToBeClickable();
		action.type(enterID, id);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, countryArrow);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, countrySelect);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, stateArrow);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, stateSelect);
		
		action.explicitWait(driver, expDateCalender);
		action.click(driver, expDateCalender);
		
		action.explicitWait(driver, monthAndYear);
		action.click(driver, monthAndYear);
		
		action.explicitWait(driver, selectedExpiryYear);
		action.click(driver, selectedExpiryYear);
		
		action.explicitWait(driver, selectedExpiryMonth);
		action.click(driver, selectedExpiryMonth);
		
		action.explicitWait(driver, selectedExpiryDate);
		action.click(driver, selectedExpiryDate);
		
		action.jsClick(driver, next);
		return new EnrollAddressPage(driver);
	}

	// Method for clicking next button
	public void clickOnNextButton() {
		action.waitElementToBeClickable();
		action.jsClick(driver, next);
	}

	// Method for getting Id
	public String identificationPageData() {
		String data = idValidate.getText();
		System.out.println(data);
		return data;
	}

	// Method for redirect to Identification page
	public boolean isUserRedirectToIdentificationPage() {
		action.explicitWait(driver, redirectToIdentificationPage);
		return action.isDisplayed(driver, redirectToIdentificationPage);
	}

	// Method for clicking Refused button
	public boolean refusedIdButtonClickable() {
		if (action.waitElementTillNotVisible(refuseIdCheckBox) != null) {
			action.waitElementTillNotVisible(refuseIdCheckBox).click();
			return true;
		} else {
			// Log or handle the case where the element is not clickable
			return false;
		}
	}

	// Method for select the type value of Identification page
	public boolean typesDropDownValuesSelected() {
		action.explicitWait(driver, dropdownIds);
		action.click(driver, dropdownIds);

		List<String> expectedElement = new ArrayList<String>();
		List<String> actualElement = new ArrayList<String>();
		expectedElement.add("Drivers License");
		action.waitElementToBeClickable();
		for (WebElement webElement : allOptions) {
			String name = webElement.getText();
			actualElement.add(name);
			if (name.equals("SSN"))
				action.click(driver, webElement);
			else {
				System.out.println("element not found");
			}
		}
		return actualElement.containsAll(expectedElement);
	}

	// Method for getting error message of ID field
	public String errorTextOfId() {
		clickOnNextButton();

		String data = errorMsgOfId.getText();
		System.out.println(data);
		return data;
	}

	// Method for getting error message of State field
	public String errorTextOfState() {
		clickOnNextButton();

		String data = errorMsgOfState.getText();
		System.out.println(data);
		return data;
	}

	// Method for getting error message of Expiry date field
	public String errorTextOfExpiryDate() {
		clickOnNextButton();

		String data = errorMsgOfExpiryDate.getText();
		System.out.println(data);
		return data;
	}

	// Method for getting error message of Verify date field
	public String errorTextOfVerifyDate() {
		clickOnNextButton();

		String data = errorMsgOfVerifyDate.getText();
		System.out.println(data);
		return data;
	}

	// Method for Add the ID
	public boolean clickOnId(String id) {
		action.explicitWait(driver, clickOnTypes);
		action.click(driver, clickOnTypes);
		
		action.explicitWait(driver, passportType);
		action.click(driver, passportType);
		
		action.explicitWait(driver, enterID);
		action.type(enterID, id);
		
		action.explicitWait(driver, expDateCalender);
		action.click(driver, expDateCalender);
		
		action.explicitWait(driver, monthAndYear);
		action.click(driver, monthAndYear);
		
		action.explicitWait(driver, selectedExpiryYear);
		action.click(driver, selectedExpiryYear);
		
		action.explicitWait(driver, selectedExpiryMonth);
		action.click(driver, selectedExpiryMonth);
		
		action.explicitWait(driver, selectedExpiryDate);
		action.click(driver, selectedExpiryDate);
		
		action.jsClick(driver, addId);
		return true;
	}

	// Method for Delete the ID
	public boolean clickOnDelete(String id) {
		action.explicitWait(driver, clickOnTypes);
		action.click(driver, clickOnTypes);
		
		action.explicitWait(driver, stateLicenseType);
		action.click(driver, stateLicenseType);
		
		action.waitElementToBeClickable();
		action.type(enterID, id);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, countryArrow);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, countrySelect);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, stateArrow);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, stateSelect);
		
		action.explicitWait(driver, expDateCalender);
		action.jsClick(driver, expDateCalender);
		
		action.explicitWait(driver, monthAndYear);
		action.jsClick(driver, monthAndYear);
		
		action.explicitWait(driver, selectedExpiryYear);
		action.click(driver, selectedExpiryYear);
		
		action.explicitWait(driver, selectedExpiryMonth);
		action.click(driver, selectedExpiryMonth);
		
		action.explicitWait(driver, selectedExpiryDate);
		action.click(driver, selectedExpiryDate);
		
		action.jsClick(driver, addId);
		action.jsClick(driver, deleteButton);
		return true;
	}

	// Method for Edit the ID
	public boolean clickOnEdit(String id) {
		
		action.explicitWait(driver, clickOnTypes);
		action.click(driver, clickOnTypes);
		
		action.explicitWait(driver,driversLicenseType );
		action.click(driver, driversLicenseType);
		
		action.waitElementToBeClickable();
		action.type(enterID, id);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, countryArrow);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, countrySelect);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, stateArrow);
		
		action.waitElementToBeClickable();
		action.jsClick(driver, stateSelect);
		
		action.explicitWait(driver, expDateCalender);
		action.jsClick(driver, expDateCalender);
		
		action.explicitWait(driver, monthAndYear);
		action.jsClick(driver, monthAndYear);
		
		action.explicitWait(driver, selectedExpiryYear);
		action.click(driver, selectedExpiryYear);
		
		action.explicitWait(driver, selectedExpiryMonth);
		action.click(driver, selectedExpiryMonth);
		
		action.explicitWait(driver, selectedExpiryDate);
		action.click(driver, selectedExpiryDate);
		
		action.jsClick(driver, addId);
		action.jsClick(driver, editButton);
		
		action.explicitWait(driver, clickOnTypes);
		action.click(driver, clickOnTypes);
		
		action.explicitWait(driver, stateLicenseType);
		action.click(driver, stateLicenseType);
		
		action.jsClick(driver, updateButton);		
		return true;
	}
}
