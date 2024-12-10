package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class PlayerDetailsViewPageMarketingTab extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public PlayerDetailsViewPageMarketingTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Marketing']")
	WebElement marketingTab;

	@FindBy(xpath = "//*[text()=' Promotion ']")
	WebElement promotionText;

	@FindBy(xpath = "//*[contains(text(),' promo ')]")
	WebElement promotionTab;

	@FindBy(xpath = "//*[contains(text(),' coupons ')]")
	WebElement couponsTab;

	@FindBy(xpath = "//*[@class='mat-cell cdk-cell edit-delete cdk-column-editdelete mat-column-editdelete ng-star-inserted']/button[@class='mat-focus-indicator mat-icon-button mat-button-base']/span[@class='mat-button-wrapper']/span[text()=' redeem ']")
	WebElement issuedCoupons;

	@FindBy(xpath = "(//*[@role='table'])[2]/tbody/tr[@class='mat-row cdk-row ng-star-inserted']")
	private static List<WebElement> couponTableStatus;

	@FindBy(xpath = "//*[text()='Redeem coupon']")
	WebElement redeemCouponText;

	@FindBy(xpath = "//*[@role='cell']/button/span/span[text()=' redeem ']")
	WebElement allListedCoupons;

	@FindBy(xpath = "(//*[text()='REDEEM'])[2]")
	WebElement issueCouponRedeemed;

	@FindBy(xpath = "//*[@class='common-popup-content print-inprogress']/p")
	WebElement issueCouponSuccessFullyMsg;

	@FindBy(id = "btnRedeem")
	WebElement redeemCoupons;

	@FindBy(id = "igt_input_redeemText")
	WebElement redeemCouponIds;

	@FindBy(xpath = "(//*[@class='igt-button-label'])[3]")
	WebElement redeemDone;

	@FindBy(xpath = "//*[@class='common-popup-content print-inprogress']/p")
	WebElement redeemStatus;

	@FindBy(xpath = "//*[@class='common-popup-content print-inprogress']/p")
	WebElement successfullyMessage;

	@FindBy(xpath = "//*[@class='btn-common']/span/button/span[text()=' OK ']")
	WebElement clickOnOk;

	@FindBy(xpath = "(//*[@class='common-popup-content change-account-pin redeem-coupon']/div/ul/li)[2]/p")
	WebElement redeemErrorMessage;

	@FindBy(xpath = "//*[text()=' coupons ']")
	WebElement couponElement;

	// Method for redirect to Marketing tab of player details view page
	public boolean isPlayerRedirectToMarketingTab() {
		action.click(driver, marketingTab);
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, promotionText);
	}

	// Method for getting the promotion on marketing tab
	public boolean isPromotionTabDisplayed() {
		action.waitElementToBeClickable();
		action.click(driver, marketingTab);
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, promotionTab);
	}

	// Method for getting the coupons on marketing tab
	public boolean isCouponsTabDisplayed() {
		action.waitElementToBeClickable();
		action.click(driver, marketingTab);
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, couponsTab);
	}

	// Method for checking the issue type coupons enabled
	public boolean isIssueCouponsEnabled() {
		return action.isEnabled(driver, issuedCoupons);
	}

	public boolean redeemedIssuedCoupons() {
		for (WebElement webElement : couponTableStatus) {
			String status = webElement.getText();
			if (status.contains("Issued")) {
				action.waitElementToBeClickable();
				action.jsClick(driver, issuedCoupons);
				action.jsClick(driver, issueCouponRedeemed);
				break;
			}
		}
		return action.isDisplayed(driver, issueCouponSuccessFullyMsg);

	}

	// Method for entering the Invalid coupons
	public boolean invalidCouponIdEntered(String couponId) {
		action.explicitWait(driver, redeemCoupons);
		action.click(driver, redeemCoupons);
		action.type(redeemCouponIds, couponId);
		action.click(driver, redeemDone);
		return action.isDisplayed(driver, redeemStatus);
	}

	// Method for entering the valid coupons
	public boolean validCouponIdEntered(String couponId) {
		action.explicitWait(driver, redeemCoupons);
		action.click(driver, redeemCoupons);
		action.type(redeemCouponIds, couponId);
		action.click(driver, redeemDone);
		return action.isDisplayed(driver, successfullyMessage);
	}

	// Method for clicking on OK
	public void clickOnOK() {
		action.waitElementToBeClickable();
		action.jsClick(driver, clickOnOk);
	}

	// Method for getting error message of Redeem field
	public boolean errorMessageOnRedeem() {
		action.explicitWait(driver, redeemCoupons);
		action.click(driver, redeemCoupons);
		action.click(driver, redeemDone);
		return action.isDisplayed(driver, redeemErrorMessage);
	}

	// Method for marketing tab clickable
	public boolean pageElementDisplay() {
		return action.isDisplayed(driver, couponElement);
	}

	// Method for getting marketing tab details
	public PlayerDetailsViewPageCardsTab validateMarketingTabDetails() {
		action.waitElementToBeClickable();
		action.click(driver, marketingTab);
		action.waitElementToBeClickable();
		return new PlayerDetailsViewPageCardsTab(driver);
	}
}
