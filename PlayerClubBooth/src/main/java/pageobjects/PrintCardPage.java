package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class PrintCardPage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public PrintCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Print Card']")
	WebElement redirectToPrintCardPage;

	@FindBy(xpath = "(//*[text()='CANCEL'])[7]")
	WebElement cancelButton;
	@FindBy(xpath = "(//*[text()='Cards'])[1]")
	WebElement cardTab;

	@FindBy(xpath = "//*[text()=' No. of Cards ']")
	WebElement cardNumber;

	@FindBy(xpath = "//*[contains(text(),' PRINT ')]")
	WebElement printCard;

	@FindBy(xpath = "//*[text()=' OK ']")
	WebElement clickOnOK;
	
	@FindBy(xpath = "//*[text()='Player Info']")
	WebElement playerInfoPage;

	// Method for redirect to Print card page
	public boolean isUserRedirectToPrintCardPage() {
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, redirectToPrintCardPage);
	}

	// Method for clicking on Cancel button
	public boolean cancelButtonIsClickable() {

		action.click(driver, cancelButton);
		return action.isDisplayed(driver, playerInfoPage);
	}

	// Method for clicking on Print card
	public PlayerDetailViewPage printCardIsClickable() {
		action.waitElementToBeClickable();
		action.jsClick(driver, printCard);

		return new PlayerDetailViewPage(driver);
	}
	
	// Method for displaying next page element
	public boolean nextPageElementDisplay() {
		action.waitElementToBeClickable();
		action.jsClick(driver, clickOnOK);

		return action.isDisplayed(driver, playerInfoPage);
	}
}
