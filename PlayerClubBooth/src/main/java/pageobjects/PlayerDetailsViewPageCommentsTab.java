package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class PlayerDetailsViewPageCommentsTab extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public PlayerDetailsViewPageCommentsTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'No Comments found')]")
	WebElement redirectToCommentTab;

	@FindBy(xpath = "//*[text()='Comments']")
	WebElement commentTab;

	@FindBy(xpath = "//*[text()='COMMENT']")
	WebElement clickOnAddComment;

	@FindBy(xpath = "(//*[@appearance='outline'])[1]/div/div[1]/div[3]/textarea")
	WebElement sendInputInComment;

	@FindBy(xpath = "(//*[@class='mat-slide-toggle-label'])[4]")
	WebElement privateButton;

	@FindBy(xpath = "//*[text()=' SUBMIT ']")
	WebElement submitTab;


	// Method for redirect to Comment tab of player details view page
	public boolean isPlayerRedirectToCommentTab() {
		action.click(driver, commentTab);
		return action.isDisplayed(driver, redirectToCommentTab);
	}
	
	// Method for clicking on comment tab
	public boolean commentTabClickabled() {
		if (action.waitElementTillNotVisible(commentTab) != null) {
			action.waitElementTillNotVisible(commentTab).click();
			return true;
		} else {
			// Log or handle the case where the element is not clickable
			return false;
		}
	}
	
	// Method for entering the data in comment box
	public PlayerDetailsViewPageMarketingTab clickOnCommentTab() {
		action.click(driver, commentTab);
		action.waitElementToBeClickable();
		action.jsClick(driver, clickOnAddComment);
		action.explicitWait(driver, sendInputInComment);
		action.jsClick(driver, sendInputInComment);
		action.type(sendInputInComment, "testing");
		action.explicitWait(driver, privateButton);
		action.click(driver, privateButton);
		action.explicitWait(driver, submitTab);
		action.click(driver, submitTab);
		action.waitElementToBeClickable();
		return new PlayerDetailsViewPageMarketingTab(driver);
	}
}
