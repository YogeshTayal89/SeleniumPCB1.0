package pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class PlayerDetailsViewPageBasicTab extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public PlayerDetailsViewPageBasicTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()='Basic']")
	WebElement basicTab;

	@FindBy(xpath = "//*[text()='Player Info']")
	WebElement playerInfoText;

	@FindBy(xpath = "(//*[@class='mat-card-content igt-card-inner-content'])[1]/div/ul[1]/li[2]")
	WebElement playerPreferredName;

	@FindBy(xpath = "(//*[@class='mat-card-content igt-card-inner-content'])[1]/div/ul[1]/li[6]")
	WebElement phoneOfPlayer;

	@FindBy(xpath = "(//*[@class='mat-card-content igt-card-inner-content'])[1]/div/ul[1]/li[8]")
	WebElement emailOfPlayer;

	@FindBy(xpath = "(//*[@class='mat-card-content igt-card-inner-content'])[1]/div/ul[1]/li[10]")
	WebElement addressOfPlayer;

	@FindBy(xpath = "//*[text()='Balances']")
	WebElement balancesTab;

	@FindBy(xpath = "(//*[@class='mat-focus-indicator mat-stroked-button mat-button-base ng-star-inserted']/span/span)[2]")
	WebElement closeWindow;

	@FindBy(xpath = "(//*[@class='mat-card-content igt-card-inner-content'])[2]//ul/li")
	private static List<WebElement> allBalancesOptions;

	@FindBy(xpath = "(//mat-card-content[@class='mat-card-content igt-card-inner-content']/div/ul/li[@class='ng-star-inserted']/span)[1]")
	WebElement rewardsBalance;

	@FindBy(xpath = "(//*[@class='ng-star-inserted']//span/div)[1]")
	WebElement rewardsBalanceArrow;

	@FindBy(xpath = "//*[text()='Cash Back']")
	WebElement cashback;

	@FindBy(xpath = "(//*[@class='ng-star-inserted']//span/div)[2]")
	WebElement cashbackArrow;

	@FindBy(xpath = "//*[text()='Primary Comp']")
	WebElement primaryComp;

	@FindBy(xpath = "(//*[@class='ng-star-inserted']//span/div)[3]")
	WebElement primaryCompArrow;

	@FindBy(xpath = "//*[@role='dialog'][@style='transform: none;']/div/h2")
	WebElement rewardsWindow;

	@FindBy(xpath = "((//*[@class='mat-card-content igt-card-inner-content'])[2]/div/ul/li)[1]")
	WebElement checkRewardsPoints;

	@FindBy(xpath = "(//*[@class='mat-row cdk-row ng-star-inserted'])[1]")
	WebElement rewardsOutlet;

	@FindBy(xpath = "//*[@class='responsvie-table scroll-mat-common balance-comp-table']/table/tbody/tr")
	private static List<WebElement> allSiteOneItems;

	@FindBy(xpath = "//*[text()=' Issue ']")
	WebElement clickOnIssue;
	@FindBy(xpath = "//textarea[@placeholder='Enter restricted comment'][@data-placeholder='Enter restricted comment']")
	WebElement enterComments;

	@FindBy(xpath = "(//*[@placeholder='Enter user name'])[2]")
	WebElement enterUserName;

	@FindBy(xpath = "(//*[@placeholder='Enter password'])[2]")
	WebElement enterUserNamePassword;

	@FindBy(xpath = "//*[text()=' OK ']")
	WebElement clickOnOK;

	@FindBy(xpath = "//*[@class='common-popup-content print-inprogress']/p")
	WebElement successfullyCompMsg;

	@FindBy(xpath = "//*[text()=' OK ']")
	WebElement clickOnCompOk;

	@FindBy(xpath = "((//*[@class='mat-card-content igt-card-inner-content'])[2]/div/ul/li)[2]")
	WebElement checkCashback;

	@FindBy(xpath = "(//*[@class='mat-row cdk-row ng-star-inserted'])[1]")
	WebElement cashbackOutlet;

	@FindBy(xpath = "((//*[@class='mat-card-content igt-card-inner-content'])[2]/div/ul/li)[3]")
	WebElement checkPrimaryComp;

	@FindBy(xpath = "(//*[@class='mat-row cdk-row ng-star-inserted'])[1]")
	WebElement primaryCompOutlet;

	@FindBy(xpath = "(//*[@id='igt_input_'])[6]")
	WebElement rewardsDecuctionValue;

	// Method for redirect to Basic tab of player details view page
	public boolean isPlayerRedirectToBasicTab() {
		action.click(driver, basicTab);
		return action.isDisplayed(driver, playerInfoText);
	}

	// Method for getting preferred name
	public String isPlayerPreferredNameDisplayed() {
		String name = playerPreferredName.getText();
		System.out.println(name);
		return name;
	}

	// Method for getting Number 
	public String[] getNumberOfPlayerDetails() {
		String[] value = phoneOfPlayer.getText().split(":|,");
		return value;
	}

	// Method for getting Email 
	public String[] getEmailOfPlayerDetails() {
		String[] value = emailOfPlayer.getText().split(":|,");
		System.out.println(Arrays.toString(value));
		return value;
	}

	// Method for getting Address
	public String[] getAddressOfPlayer() {
		String[] value = addressOfPlayer.getText().split(":|,");
		for (int j = 0; j < value.length; j++) {
			System.out.print(value[j].trim());
		}
		return value;
	}

	// Method for displaying bucket options
	public boolean balancesOptionsDisplayed() {
		for (WebElement webElement : allBalancesOptions) {
			System.out.println(webElement.getText().toString());
		}
		return action.isDisplayed(driver, balancesTab);
	}

	// Method for clicking on rewards
	public boolean rewardOptionClickabled() {
		if (action.isEnabled(driver, rewardsBalance)) {
			action.click(driver, rewardsBalanceArrow);
			System.out.println("Reward Option successfully clickabled from balance tab");
			return true;
		} else {
			System.out.println("Reward Option not clickabled from balance tab");
			return false;
		}
	}

	// Method for clicking on Cashback 
	public boolean cashbackOptionClickabled() {	
		if (action.waitElementTillNotVisible(cashbackArrow) != null) {
			action.waitElementTillNotVisible(cashbackArrow).click();
			return true;
		} else {
			// Log or handle the case where the element is not clickable
			return false;
		}
	}

	// Validate that reward option displayed or not
	public boolean checkRewardsDisplayed() {
		action.click(driver, rewardsBalanceArrow);
		return action.isDisplayed(driver, rewardsWindow);
	}

	// Validate that primary comp clickabled or not
	public boolean primaryCompClickabled() {
		if (action.waitElementTillNotVisible(primaryCompArrow) != null) {
			action.waitElementTillNotVisible(primaryCompArrow).click();
			return true;
		} else {
			// Log or handle the case where the element is not clickable
			return false;
		}
	}

	// Method for clicking on Close button
	public boolean clickOnClose() {
		action.explicitWait(driver, closeWindow);
		action.jsClick(driver, closeWindow);
		return action.isDisplayed(driver, balancesTab);
	}

	// Method for getting basic tab details
	public PlayerDetailsViewPageCommentsTab validateBasicTabDetails() {
		action.click(driver, basicTab);
		action.waitElementToBeClickable();
		return new PlayerDetailsViewPageCommentsTab(driver);
	}
	
	// Method for clicking on Next button
	public boolean ableToClickNext() {
		return action.isDisplayed(driver, balancesTab);
	}

	// Method for redeemed rewards
	public boolean userAbleToRedeemRewards(String comment , String userId, String pswrd) {
		String points = checkRewardsPoints.getText();
		System.out.println(points);
		action.click(driver, checkRewardsPoints);
		action.click(driver, rewardsOutlet);
		action.type(enterComments, comment);
		action.waitElementToBeClickable();
		action.click(driver, clickOnIssue);
		action.waitElementToBeClickable();
		action.type(enterUserName, userId);
		action.type(enterUserNamePassword, pswrd);
		action.click(driver, clickOnOK);

		return action.isDisplayed(driver, successfullyCompMsg);
	}

	// Method for Clicking on OK after getting message
	public void clickOnOkAfterSuccessMsg() {
		action.waitElementToBeClickable();
		action.jsClick(driver, clickOnCompOk);
		action.waitElementToBeClickable();
	}

	// Method for getting deduction value after redeemed rewards
	public boolean getRewardsDeductionValue() {
		String points = checkRewardsPoints.getText();
		System.out.println(points);
		return action.isDisplayed(driver, checkRewardsPoints);
	}

	// Method for redeemed Cashback
	public boolean userAbleToRedeemCashback(String comment,String userId, String pswrd) {
	String points = checkCashback.getText();
	System.out.println(points); 
		action.click(driver, checkCashback);
		action.click(driver, cashbackOutlet);
		action.type(enterComments, comment);
		action.waitElementToBeClickable();
		action.click(driver, clickOnIssue);
		action.type(enterUserName, userId);
		action.type(enterUserNamePassword, pswrd);
		action.click(driver, clickOnOK);
		return action.isDisplayed(driver, successfullyCompMsg);
	}

	// Method for getting deduction value after redeemed Cashback
	public boolean getCashbackDeductionValue() {
		String points = checkCashback.getText();
		System.out.println(points);
		
		return action.isDisplayed(driver, cashback);
	}

	// Method for redeemed Primary comp
	public boolean userAbleToRedeemPrimaryComp(String comment,String userId, String pswrd) {
		String points = checkPrimaryComp.getText();
		System.out.println(points);
		action.click(driver, checkPrimaryComp);
		action.click(driver, primaryCompOutlet);
		action.type(enterComments, comment);
		action.waitElementToBeClickable();
		action.click(driver, clickOnIssue);
		action.type(enterUserName, userId);
		action.type(enterUserNamePassword, pswrd);
		action.click(driver, clickOnOK);
		return action.isDisplayed(driver, successfullyCompMsg);
	}

	// Method for getting deduction value after redeemed Primary comp 
	public boolean getPrimaryCompDeductionValue() {
		String points = checkPrimaryComp.getText();
		System.out.println(points);
		return action.isDisplayed(driver, checkPrimaryComp);
	}
	
	// Method for displaying basic tab
	public boolean basicTabDetailsDisplay() {
		return action.isDisplayed(driver, playerInfoText);
	}
}
