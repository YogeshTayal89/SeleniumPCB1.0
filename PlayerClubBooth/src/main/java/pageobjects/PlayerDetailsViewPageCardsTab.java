package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class PlayerDetailsViewPageCardsTab extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public PlayerDetailsViewPageCardsTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='mat-tab-labels']/div[4]")
	WebElement cardTab;

	@FindBy(xpath = "(//*[text()='Cards'])[2]")
	WebElement cardText;

	@FindBy(xpath = "//span[@class='badge badge-success']")
	WebElement active;

	@FindBy(xpath = "//div[starts-with(@class,'popup-header mb-3 ng-star-inserted')]//child::h2")
	WebElement setCardPin;

	@FindBy(xpath = "//p[@class='errormsg']")
	WebElement errorMessageFourDigits;

	@FindBy(xpath = "//span[contains(text(),'edit')]")
	WebElement editButton;

	@FindBy(xpath = "//input[@placeholder='Enter PIN']")
	WebElement enterPin;

	@FindBy(id = "igt_input_re-enterPin")
	WebElement reEnterPin;

	@FindBy(xpath = "//span[contains(text(),'SAVE')]")
	WebElement saveButton;

	@FindBy(xpath = "//span[contains(text(), ' OK ')]")
	WebElement okButton;

	@FindBy(xpath = "//*[@class='common-popup-content change-account-pin']/div[@class='enroll-form igt-w-100']/ul/li/p")
	WebElement errorMessage;

	@FindBy(xpath = "//span[contains(text(),'CANCEL')]")
	WebElement cancelButton;

	@FindBy(xpath = "//div[@class='common-popup-content print-inprogress']")
	WebElement successfullMessage;

	@FindBy(id = "igt_input_oldPin")
	WebElement oldPin;

	@FindBy(xpath = "//span[contains(text(),'UPDATE')]")
	WebElement updateButton;

	@FindBy(xpath = "//p[text()='Old PIN is incorrect.']")
	WebElement updateError;

	@FindBy(xpath = "//*[text()='RESET PIN']")
	WebElement resetPin;

	@FindBy(xpath = "//span[contains(text(), ' OK ')]")
	WebElement okOverride;

	@FindBy(xpath = "//igt-button[@class='btn-common']")
	WebElement cancelOverride;

	@FindBy(id = "igt_input_")
	WebElement overrideUserInput;

	@FindBy(id = "igt_input_Enter Password")
	WebElement overridePasswordInput;

	@FindBy(xpath = "//*[@class='mat-list-item-content']//span/button")
	WebElement printCard;
	@FindBy(xpath = "//*[@class='mat-radio-button mat-accent ng-star-inserted']//span/span[@class='mat-radio-outer-circle']")
	WebElement newPrintCard;

	@FindBy(xpath = "//*[@class='mat-dialog-actions common-popup-bottom ng-star-inserted']/div//span[@class='ng-star-inserted']//span[text()=' PRINT CARD ']")
	WebElement printCardDone;

	@FindBy(xpath = "//*[@class='common-popup-content print-inprogress']/p")
	WebElement printCardMessage;

	@FindBy(xpath = "//*[@class='btn-common']/span/button")
	WebElement okAfterMessage;

	@FindBy(id = "igt_input_search")
	WebElement searchInput;

	@FindBy(xpath = "//span[text()='SEARCH']")
	WebElement searchBtn;

        @FindBy(xpath = "//*[@class='common-popup-content change-account-pin']/div[@class='enroll-form igt-w-100']/ul/li/p")
	WebElement invalidPin;

	@FindBy(xpath = "(//*[@class='mat-radio-button mat-accent']/label/span)[1]")
	WebElement duplicatePrintCheckbox;
	
	@FindBy(xpath = "//*[text()=' OK ']")
	WebElement clickOnOK;

	public void clickOnOk() {
		action.waitElementToBeClickable();
		action.jsClick(driver, clickOnOK);
	}
	// Validate that user are able to redirect to Card tab
	public boolean isPlayerRedirectToCardTab() {
		action.click(driver, cardTab);
		return action.isDisplayed(driver, cardText);
	}

	// Method for clicking on Card tab
	public boolean clickOnCardTab() {
		if (action.waitElementTillNotVisible(cardTab) != null) {
			action.jsClick(driver, cardTab);
			return true;
		} else {
			// Log or handle the case where the element is not clickable
			return false;
		}
	}

	// Method for clicking on Active card
	public void validateActiveCard() {
		String text = active.getText();
		if (text.contains("Active")) {
		}
		editButton.click();
	}

	// Method for set the Pin
	public String validateSetPinPopUp() {
		action.explicitWait(driver, setCardPin);
		return setCardPin.getText();
	}

	// Method for getting error message of Pin 
	public String validateErrorPinMessage() {
		return errorMessageFourDigits.getText();
	}

	// Method for getting error message of State field 
	public String errorMessage() {
		return errorMessage.getText();
	}

	// Method for clicking on Cancel button
	public void cancelButton() {
		cancelButton.click();
	}

	// Method for entering minimum four value for set the pin
	public void enterMinimumFourValueForSetPin(String pinEnter) {
		String text = active.getText();
		if (text.contains("Active")) {
		}
		editButton.click();
		action.type(enterPin, pinEnter);
	}

	// Method for entering minimum four value for Update the pin
	public void enterMinimumFourValueForUpdatePin(String pinOld) {
		String text = active.getText();
		if (text.contains("Active")) {
		}
		editButton.click();
		action.type(oldPin, pinOld);
	}

	// Method for entering the incorrect pin
	public void setIncorrectReEnterPin(String pinEnter, String pinReEnter) {
		String text = active.getText();
		if (text.contains("Active")) {
		}
		editButton.click();
		action.type(enterPin, pinEnter);
		action.type(reEnterPin, pinReEnter);
	}

	// Method for entering the data for set the pin
	public void enterDataForSetPin(String pinEnter, String pinReEnter) {
		String text = active.getText();
		if (text.contains("Active")) {
		}
		editButton.click();
		action.type(enterPin, pinEnter);
		action.type(reEnterPin, pinReEnter);
		saveButton.click();
	}

	// Method for getting the succesful message
	public String successfullMessage() {
		action.explicitWait(driver, successfullMessage);
		return successfullMessage.getText();
	}

	// Method for clicking on OK button
	public void clickOnOkButton() {
		action.waitElementToBeClickable();
		action.click(driver, clickOnOK);
	}

	// Method for getting updated error message 
	public String verifyUpdateError() {
		action.explicitWait(driver, updateError);
		return updateError.getText();
	}

	// Method for entering data for update the pin
	public void enterDataForUpdatePin(String pinOld, String pinEnter, String pinReEnter) {
		String text = active.getText();
		if (text.contains("Active")) {
		}
		editButton.click();
		action.type(oldPin, pinOld);
		action.type(enterPin, pinEnter);
		action.type(reEnterPin, pinReEnter);
		updateButton.click();
      
	}

	// Method for getting the error message of Invalid pin
	public String validateErrorInvalidPinMessage() {
		action.explicitWait(driver, invalidPin);
		return invalidPin.getText();
	}

	// Method for clicking on print new card
	public boolean userAbleToPrintNewCard() {
		action.click(driver, cardTab);
		action.explicitWait(driver, printCard);
		action.click(driver, printCard);
                action.jsClick(driver, newPrintCard);
		action.explicitWait(driver, printCardDone);
		action.click(driver, printCardDone);
		return action.isDisplayed(driver, printCardMessage);
	}

	// Method for clicking on duplicate card 
	public boolean userAbleToPrintDuplicateCard() {
		action.click(driver, cardTab);
		action.explicitWait(driver, printCard);
		action.click(driver, printCard);

		action.waitElementToBeClickable();
		action.jsClick(driver, printCardDone);
		return action.isDisplayed(driver, printCardMessage);
		
	}
	
	// Method for getting card tab details
	public PlayerDetailsViewPageRelationsTab validateCardTabDetails() // redirect relation tab
	{
		action.click(driver, cardTab);
		return new PlayerDetailsViewPageRelationsTab(driver);
	}

}
