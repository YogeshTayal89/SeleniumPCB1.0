package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import basepack.BaseClass;

public class EnrollAddressPage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public EnrollAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Address Type ']")
	private static WebElement redirectToAddressPage;

	@FindBy(xpath = "(//*[@role='combobox'][@aria-haspopup='true']/div/div)[16]")
	WebElement adressType;

	@FindBy(xpath = "//*[text()=' Work ']")
	WebElement work;

	@FindBy(xpath = "//*[@placeholder='Enter Street Address']")
	WebElement adress;

	@FindBy(css = "li:nth-child(6) > .formControl > .igt-input-select > .mat-form-field > .mat-form-field-wrapper > .mat-form-field-flex")
	WebElement countryArrow;
	
	@FindBy(xpath = "//mat-option[@role='option']/span[@class='mat-option-text'][text()=' United States of America ']")
	WebElement countrySelect;
	
	@FindBy(xpath= "//*[@class='formControl formControl-dash-custom ng-untouched ng-pristine ng-valid']")
	WebElement zipcode;

	@FindBy(xpath = "//*[text()='ZIP Code ']")
	WebElement screenClick;

	@FindBy(xpath = "(//*[text()='NEXT'])[3]")
	WebElement nextBtn;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private static List<WebElement> allOptionsofAddressType;

	@FindBy(xpath = "//*[text()='Please enter \"Address Line1\". ']")
	WebElement errorMsgOfAddress1;

	@FindBy(xpath = "//*[text()='Please enter \"ZIP Code\". ']")
	WebElement errorMsgOfZipCode;

	@FindBy(xpath = "//*[text()='Please select \"State\". ']")
	WebElement errorMsgOfState;

	@FindBy(xpath = "//*[text()='Please enter \"City\". ']")
	WebElement errorMsgOfCity;

	@FindBy(xpath = "//*[@class='add-name-section ng-star-inserted']/span")
	WebElement addressDetails;

	@FindBy(xpath = "//*[@class='formControl alignRight']/button[@class='mat-focus-indicator btn-common-custom mat-button mat-flat-button mat-button-base mat-primary']")
	WebElement addressBtn;

	// Method for Clicking on Next button
	public void clickOnNextButton() {
		action.waitElementToBeClickable();
		action.jsClick(driver, nextBtn);
	}

	// Method for entering address page details
	public EnrollContactsPage addressPageDetailsEntered(String cadress, String pincode) {
                action.waitElementToBeClickable();
		action.type(adress, cadress);
                action.waitElementToBeClickable();
		action.click(driver, countryArrow);
		action.waitElementToBeClickable();
		action.click(driver, countrySelect);
		
		action.waitElementToBeClickable();
		action.type(zipcode, pincode);
		action.explicitWait(driver, screenClick);
		action.click(driver, screenClick);
		clickOnNextButton();
		return new EnrollContactsPage(driver);
	}

	// Method for get address data
	public String addressPageData() {
		String[] value = addressDetails.getText().split(",");
		String firstValue = value[0];
		return firstValue;
	}

	// Method for redirect to Address page
	public boolean isUserRedirectToAddresPage() {
		action.explicitWait(driver, redirectToAddressPage);
		return action.isDisplayed(driver, redirectToAddressPage);
	}

	// Method for select the Address type value of address page
	public boolean addressTypeDropDownValuesSelected() {
		action.waitElementToBeClickable();
		action.click(driver, adressType);

		List<String> expectedElement = new ArrayList<String>();
		List<String> actualElement = new ArrayList<String>();
		expectedElement.add("Work");
		action.waitElementToBeClickable();
		for (WebElement webElement : allOptionsofAddressType) {
			String name = webElement.getText();
			actualElement.add(name);
			if (name.equals("Credit"))
				action.click(driver, webElement);
			else {
				System.out.println("element not found");
			}
		}
		return actualElement.containsAll(expectedElement);
	}

	// Method for getting error message of Address field
	public String errorTextOfAddress() {
		action.waitElementToBeClickable();
		clickOnNextButton();

		String data = errorMsgOfAddress1.getText();
		System.out.println(data);
		return data;
	}

	// Method for getting error message of Zip code  
	public String errorTextOfZipCode() {
		clickOnNextButton();

		String data = errorMsgOfZipCode.getText();
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

	// Method for getting error message of City field 
	public String errorTextOfCity() {
		clickOnNextButton();

		String data = errorMsgOfCity.getText();
		System.out.println(data);
		return data;
	}
}
