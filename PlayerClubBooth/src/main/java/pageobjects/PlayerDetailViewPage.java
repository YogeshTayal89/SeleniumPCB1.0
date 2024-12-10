package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class PlayerDetailViewPage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public PlayerDetailViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='inner-details-top']/div/div/ul/li[1]/span[text()='Status']")
	WebElement statusOfPlayer;

	@FindBy(xpath = "//*[text()=' OK ']")
	WebElement clickOnOk;
	
	@FindBy(xpath = "//*[text()='EDIT']")
	WebElement clickOnEdit;
	
	@FindBy(xpath = "//*[@class='mat-tab-labelsss']")
	private static List<WebElement> horizontalPartTabs;
	
	// Method for redirect to player details view page
	public boolean isUserRedirectToPlayerDetailViewPage() {
		return action.isDisplayed(driver, statusOfPlayer);
	}
	// method for redirect to player Details View Basic tab
	public PlayerDetailsViewPageBasicTab  redirectToBasicTab(){
		return new PlayerDetailsViewPageBasicTab(driver);
	}
	// method for redirect to player Details View Comment tab
	public PlayerDetailsViewPageCommentsTab  redirectToCommentTab(){
		return new PlayerDetailsViewPageCommentsTab(driver);
	}
	// method for redirect to player Details View Marketing tab
	public PlayerDetailsViewPageMarketingTab  redirectToMarketing(){
		return new PlayerDetailsViewPageMarketingTab(driver);
	}

	// Method for redirect to player details view card tab
	public PlayerDetailsViewPageCardsTab redirectToCardTab() {
		return new PlayerDetailsViewPageCardsTab(driver);
	}
	
	// Method for redirect to player details view page
	public PlayerDetailViewTopPartPage validatePlayerDetails() {
		return new PlayerDetailViewTopPartPage(driver);
	}
	
	// Method for clicking on Ok after getting message
	public void clickOnOk() {
		action.waitElementToBeClickable();
		action.click(driver, clickOnOk);
		action.waitElementToBeClickable();
	}
	
	// Method for displaying Edit button
	public boolean validateViewPageElement() {
		return action.isDisplayed(driver, clickOnEdit);
	}
}
