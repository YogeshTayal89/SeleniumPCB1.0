package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class EnrollContactsPage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public EnrollContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Phone ']")
	WebElement redirectToContactsPage;

	@FindBy(xpath = "(//*[contains(text(),'Home')])[2]")
	WebElement phoneArrow;

	@FindBy(xpath = "//*[text()=' Home ']")
	WebElement mobileNumber;

	@FindBy(xpath = "(//*[@class='contact-phone']//div)[22]/input")
	WebElement number;

	@FindBy(xpath = "//*[contains(text(),'Primary Email')]")
	WebElement emailArrow;

	@FindBy(xpath = "//*[text()=' Work Email ']")
	WebElement workEmail;


	@FindBy(xpath = "(//input[@type='text'][@id='igt_input_search'])[1]")
	WebElement email;

	@FindBy(xpath = "(//*[@class='right-next-prev'])[4]/button[3]")
	WebElement next;

	@FindBy(xpath = "//*[text()=' Please enter \"Phone Number\". ']")
	WebElement errorOfPhone;

   //  Method for entering Contact page details 
	public EnrollMarketingPage contactsPageDetailsEntered(String phoneNumber, String emailId) {
		action.waitElementToBeClickable();
		action.click(driver, phoneArrow);
		action.explicitWait(driver, mobileNumber);
		action.click(driver, mobileNumber);
		action.type(number, phoneNumber);
		action.click(driver, emailArrow);
		action.click(driver, workEmail);
		action.type(email, emailId);
		action.explicitWait(driver, next);
		action.click(driver, next);
		return new EnrollMarketingPage(driver);
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

	// Method for redirect to Contact page 
	public boolean isUserRedirectToContactsPage() {
		action.explicitWait(driver, redirectToContactsPage);
		return action.isDisplayed(driver, redirectToContactsPage);
	}

	// Method for getting error message of Phone field
	public String errorTextOfPhone() {
		action.explicitWait(driver, next);
		action.waitElementTillNotVisible(next).click();

		String data = errorOfPhone.getText();
		System.out.println(data);
		return data;
	}
}
