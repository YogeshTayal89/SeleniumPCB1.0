package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;
import utilities.ExcelUtility;

public class SearchPage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	ExcelUtility exl = new ExcelUtility();
	@FindBy(xpath = "//div[contains(text(),'Recent Searches')]")
	WebElement recentBtn;

	@FindBy(id = "igt_input_search")
	WebElement searchInput;

	@FindBy(xpath = "//span[text()='SEARCH']")
	WebElement searchBtn;

	@FindBy(xpath = "//*[contains(@class,'detail-col')]")
	List<WebElement> playerlist;

	@FindBy(xpath = "//input[@id='igt_input_search']")
	WebElement inputtype;

	@FindBy(xpath = "//*[@id='form_igt_input_search']")
	WebElement searchIcon;

	@FindBy(xpath = "//p[text()='Please refine your search criteria and try again or enroll the player.']")
	WebElement appBody;

	@FindBy(xpath = "//h2[@id='no-result-found-title']")
	WebElement noResult;

	@FindBy(xpath = "//input[@name='igt_input_search']")
	WebElement searchInstruction;

	@FindBy(xpath = "//igt-icon[@class=\"search-icon ng-star-inserted\"]//child::div")
	WebElement crossIcon;

	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary ng-star-inserted']")
	WebElement enroll;

	@FindBy(id = "minimum-character-errMsg")
	WebElement minThreeNumber;

	@FindBy(id = "minimum-character-errMsg")
	WebElement maxFiftyNumber;

	@FindBy(xpath = "//*[@class='igt-w player-details']/h3")
	WebElement getNameText;

	@FindBy(xpath = "//*[@class='igt-w player-details']/h3")
	WebElement fullName;

	@FindBy(xpath = "//*[@class='img-container']")
	List<WebElement> nameList;

	@FindBy(xpath = "//*[text()='Marketing']")
	WebElement nextToMarketingTab;

	@FindBy(xpath = "//*[text()=' Promotion ']")
	WebElement marketingTabElement;

	@FindBy(xpath = "//*[text()='Cards']")
	WebElement nextToCardTab;

	@FindBy(xpath = "(//*[text()='Cards'])[2]")
	WebElement cardTabElement;

	@FindBy(xpath = "//*[text()='Basic']")
	WebElement nextToBasicTab;

	@FindBy(xpath = "//*[text()='Balances']")
	WebElement basicTabElement;

//	public void clickAsPerList(String lastname) {
//		for (int i = 1; i < nameList.size(); i++) {
//			if (nameList.get(i).getText().contains(lastname)) {
//				action.implicitWait(getDriver());
//				nameList.get(i).click();
//			}
//		}
//	}

	// Method for getting recent text
	public boolean validateRecentText() {
		return action.isDisplayed(driver, recentBtn);
	}

	// Method for entering data
	public SearchPage getReadDataExcel(String value) {
		action.explicitWait(driver, searchInput);
		action.type(searchInput, value);
		return new SearchPage(driver);

	}

	// Method for clicking on search
	public SearchPage clickOnSearch() {
		action.click(driver, searchBtn);
		return new SearchPage(driver);

	}

	// Method for getting search box
	public boolean validateSearchBox() {
		action.click(driver, searchIcon);
		action.explicitWait(driver, searchIcon);
		return action.isDisplayed(getDriver(), searchIcon);
	}

	// Method for  getting search instructions
	public String searchInstruction() {
		return searchInstruction.getAttribute("data-placeholder");
	}

	// Method for getting cross icon 
	public boolean crossIcon() {
		return action.isDisplayed(driver, crossIcon);
	}

	// Method for clicking on Cross icon
	public SearchPage clickOnCrossIcon() {
		action.click(driver, crossIcon);
		return new SearchPage(driver);

	}

	// Method for getting Enroll button
	public boolean enrollButton() {
		return action.isDisplayed(getDriver(), enroll);
	}

	// Method for clicking on Enroll
	public SearchPage clickOnEnroll() {
		action.click(driver, enroll);
		return new SearchPage(driver);
	}

	// Method for getting current URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// Method for entering Minimum three value
	public String enterMinThreeValues() {
		return minThreeNumber.getText();
	}

	// Method for entering Maximum fifty value
	public String enterMaxFiftyValues() {
		return maxFiftyNumber.getText();
	}

	// Method for getting no result found message
	public String noResultFound() {
		action.explicitWait(driver, noResult);
		return noResult.getText();
	}

	// Method for getting details of marketing tab
	public PlayerDetailsViewPageMarketingTab validatePlayerDetailsMarketingTab(String player) {
		action.type(searchInput, player);
		action.click(driver, searchBtn);
		action.click(driver, nextToMarketingTab);
		return new PlayerDetailsViewPageMarketingTab(driver);
	}

	// Method for redirect to Marketing tab of player details view page
	public boolean userRedirectToMarketingTab() {
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, marketingTabElement);
	}

	// Method for getting details of Card tab
	public PlayerDetailsViewPageCardsTab validatePlayerDetailsCardTab(String player) {
		action.type(searchInput, player);
		action.click(driver, searchBtn);
		action.click(driver, nextToCardTab);
		return new PlayerDetailsViewPageCardsTab(driver);
	}

	// Method for redirect to Card tab of player details view page
	public boolean userRedirectToCardTab() {
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, cardTabElement);
	}

	// Method for getting details of Basic tab
	public PlayerDetailsViewPageBasicTab validatePlayerDetailsBasicTab(String player) {
		action.type(searchInput, player);
		action.click(driver, searchBtn);
		action.waitElementToBeClickable();
		action.click(driver, nextToBasicTab);
		action.waitElementToBeClickable();
		return new PlayerDetailsViewPageBasicTab(driver);
	}

	// Method for redirect to Basic tab of player details view page
	public boolean userRedirectToBasicTab() {
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, basicTabElement);
	}
}
