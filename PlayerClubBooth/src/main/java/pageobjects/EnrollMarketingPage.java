package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import basepack.BaseClass;

public class EnrollMarketingPage extends BaseClass {

	Action action = new Action();
	EnrollIdentificationPage enrollIdentifiaction;
	EnrollBasicPage enrollBasic;

	WebDriver driver = null;

	public EnrollMarketingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Attraction Type ']")
	private WebElement redirectToMarketingPage;

	@FindBy(xpath = "//*[contains(text(),'Select Attraction')]")
	WebElement attractionTypeArrow;

	@FindBy(xpath = "//*[text()=' Movies ']")
	WebElement movie;

	@FindBy(xpath = "//*[contains(text(),'Select Language')]")
	WebElement selectLanguageArrow;

	@FindBy(xpath = "//*[text()=' Afrikaans ']")
	WebElement language;

	@FindBy(xpath = "(//*[@data-placeholder='MM/DD/YYYY'])[4]")
	WebElement calander;

	@FindBy(xpath = "//*[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']")
	WebElement date;

	@FindBy(xpath = "//*[contains(text(),'Select Affiliation')]")
	WebElement affliation;

	@FindBy(xpath = "//*[text()=' Diners Club ']")
	WebElement selectedAffliation;

	@FindBy(xpath = "//*[contains(text(),'Delta')]")
	WebElement flyerInfoArrow;

	@FindBy(xpath = "//*[text()=' American Air Lines ']")
	WebElement selctedFlyerInfoArrow;

	@FindBy(xpath = "//*[@id='igt_input_search'][@name='igt_input_search'][@type='text']")
	WebElement selctedFlyerInfoInput;

	@FindBy(xpath = "//*[@id='igt_input_companyName']")
	WebElement companyName;

	@FindBy(xpath = "//*[@placeholder='Enter Position']")
	WebElement positionName;

	@FindBy(xpath = "(//*[@class='nav-next-prev-bottom bottomnav']/div//button[3]/span[contains(text(),'NEXT')])[3]")
	WebElement next;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private static List<WebElement> allOptions;

   //  Method for entering Marketing page details 
	public EnrollPreviewPage marketingPageDetailsEntered(String flyerInput, String cName, String companyPosition) {
		action.explicitWait(driver, attractionTypeArrow);
		action.click(driver, attractionTypeArrow);
		action.explicitWait(driver, movie);
		action.click(driver, movie);
		action.explicitWait(driver, selectLanguageArrow);
		action.click(driver, selectLanguageArrow);
		action.explicitWait(driver, language);
		action.click(driver, language);
		action.explicitWait(driver, calander);
		action.click(driver, calander);
		action.explicitWait(driver, date);
		action.click(driver, date);
		action.explicitWait(driver, affliation);
		action.click(driver, affliation);
		action.click(driver, selectedAffliation);
		action.click(driver, flyerInfoArrow);
		action.click(driver, selctedFlyerInfoArrow);
		action.type(selctedFlyerInfoInput, flyerInput);
		action.type(companyName, cName);
		action.type(positionName, companyPosition);
		action.click(driver, next);
		return new EnrollPreviewPage(driver);
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
	
	// Method for redirect to Marketing page
	public boolean isUserRedirectToMarketingPage() {
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, redirectToMarketingPage);
	}

	// Method for select the Attraction type value of Marketing page 
	public boolean attractionTypeDropDownValuesSelected() {
		action.explicitWait(driver, attractionTypeArrow);
		action.click(driver, attractionTypeArrow);

		List<String> expectedElement = new ArrayList<String>();
		List<String> actualElement = new ArrayList<String>();
		expectedElement.add("Games");
		action.waitElementToBeClickable();
		for (WebElement webElement : allOptions) {
			String name = webElement.getText();
			actualElement.add(name);
			if (name.equals("Games"))
				action.click(driver, webElement);
			else {
				System.out.println("element not found");
			}
		}
		return actualElement.containsAll(expectedElement);
	}
}
