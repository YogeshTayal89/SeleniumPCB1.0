package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class PlayerDetailsViewPageRelationsTab extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public PlayerDetailsViewPageRelationsTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Relations']")
	WebElement relationsTab;

	@FindBy(xpath = "//*[text()=' Link ID ']")
	WebElement linkIdText;

	@FindBy(xpath = "//*[@id='linkButton']")
	WebElement linkButton;

	// Method for redirect to Relation tab of player details view page
	public boolean isPlayerRedirectToRelationsTab() {
		action.waitElementToBeClickable();
		action.click(driver, relationsTab);
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, linkIdText);
	}

	// Method for getting linked button
	public boolean isLinkbuttonDisplayed() {
		action.waitElementToBeClickable();
		action.click(driver, relationsTab);
		action.waitElementToBeClickable();
		return linkButton.isDisplayed();
	}
}
