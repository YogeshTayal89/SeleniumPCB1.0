package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryMethod;
import actiondriver.Action;
import basepack.BaseClass;
import pageobjects.EnrollAddressPage;
import pageobjects.EnrollBasicPage;
import pageobjects.EnrollContactsPage;
import pageobjects.EnrollIdentificationPage;
import pageobjects.EnrollMarketingPage;
import pageobjects.EnrollPossibleMatchesPage;
import pageobjects.EnrollPreviewPage;
import pageobjects.HomePage;
import pageobjects.PlayerDetailViewPage;
import pageobjects.PlayerDetailsViewPageMarketingTab;
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;
import pageobjects.PrintCardPage;
import pageobjects.SearchPage;
import utilities.ExcelUtility;

public class PlayerDetailsViewTestMarketingTab extends BaseClass {
	Action action = new Action();

	// TC057 - Validate that user is redirect to Marketing tab of Middle part
	@Test(priority = 68, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateIsPlayerRedirectToMarketingTab() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();

		action.waitElementToBeClickable();
		EnrollIdentificationPage enrollIdentification = enrollBasic.nextClickableAfterDetailsEntered(
				ExcelUtility.getReadData(1, 0, 1), ExcelUtility.getReadData(1, 1, 1), ExcelUtility.getReadData(1, 2, 1),
				ExcelUtility.getReadData(1, 3, 1), ExcelUtility.getReadData(1, 12, 1),
				ExcelUtility.getReadData(1, 13, 1));
		EnrollAddressPage enrollAddressPage = enrollIdentification
				.identificationPageDetailsEntered(ExcelUtility.getReadData(1, 4, 1));

		EnrollContactsPage enrollContacts = enrollAddressPage
				.addressPageDetailsEntered(ExcelUtility.getReadData(1, 5, 1), ExcelUtility.getReadData(1, 6, 1));

		EnrollMarketingPage enrollMarketing = enrollContacts
				.contactsPageDetailsEntered(ExcelUtility.getReadData(1, 7, 1), ExcelUtility.getReadData(1, 8, 1));

		EnrollPreviewPage enrollPreviewPage = enrollMarketing.marketingPageDetailsEntered(
				ExcelUtility.getReadData(1, 9, 1), ExcelUtility.getReadData(1, 10, 1),
				ExcelUtility.getReadData(1, 11, 1));

		EnrollPossibleMatchesPage possibleMatchesPage = enrollPreviewPage.clickOnNextButton();

	    PrintCardPage printCardPage = possibleMatchesPage.savebtn();
		
		possibleMatchesPage.clickOnSaveButton(prop.getProperty("username"), prop.getProperty("password"));

		PlayerDetailViewPage playerDetailViewPage = printCardPage.printCardIsClickable();
		playerDetailViewPage.clickOnOk();

		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = playerDetailViewPage.redirectToMarketing();
	
		Assert.assertTrue(playerDetailsMarketingTab.isPlayerRedirectToMarketingTab(), "the page is not redirect");

	}

	// TC058 - Validate that user is able to see the Promotion button on Marketing tab
	@Test(priority = 69)
	public void validateIsPromotionTabDisplayed() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();

		action.waitElementToBeClickable();
		EnrollIdentificationPage enrollIdentification = enrollBasic.nextClickableAfterDetailsEntered(
				ExcelUtility.getReadData(1, 0, 1), ExcelUtility.getReadData(1, 1, 1), ExcelUtility.getReadData(1, 2, 1),
				ExcelUtility.getReadData(1, 3, 1), ExcelUtility.getReadData(1, 12, 1),
				ExcelUtility.getReadData(1, 13, 1));
		EnrollAddressPage enrollAddressPage = enrollIdentification
				.identificationPageDetailsEntered(ExcelUtility.getReadData(1, 4, 1));

		EnrollContactsPage enrollContacts = enrollAddressPage
				.addressPageDetailsEntered(ExcelUtility.getReadData(1, 5, 1), ExcelUtility.getReadData(1, 6, 1));

		EnrollMarketingPage enrollMarketing = enrollContacts
				.contactsPageDetailsEntered(ExcelUtility.getReadData(1, 7, 1), ExcelUtility.getReadData(1, 8, 1));

		EnrollPreviewPage enrollPreviewPage = enrollMarketing.marketingPageDetailsEntered(
				ExcelUtility.getReadData(1, 9, 1), ExcelUtility.getReadData(1, 10, 1),
				ExcelUtility.getReadData(1, 11, 1));

		EnrollPossibleMatchesPage possibleMatchesPage = enrollPreviewPage.clickOnNextButton();

	    PrintCardPage printCardPage = possibleMatchesPage.savebtn();
		
		possibleMatchesPage.clickOnSaveButton(prop.getProperty("username"), prop.getProperty("password"));

		PlayerDetailViewPage playerDetailViewPage = printCardPage.printCardIsClickable();
		playerDetailViewPage.clickOnOk();

		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = playerDetailViewPage.redirectToMarketing();

		Assert.assertTrue(playerDetailsMarketingTab.isPromotionTabDisplayed(), "Promotion tab is not displayed");
	}

	// TC059 - Validate that user is able to see the Coupons button on Marketing tab
	@Test(priority = 70, retryAnalyzer = RetryMethod.class)
	public void validateIsCouponsTabDisplayed() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();

		action.waitElementToBeClickable();
		EnrollIdentificationPage enrollIdentification = enrollBasic.nextClickableAfterDetailsEntered(
				ExcelUtility.getReadData(1, 0, 1), ExcelUtility.getReadData(1, 1, 1), ExcelUtility.getReadData(1, 2, 1),
				ExcelUtility.getReadData(1, 3, 1), ExcelUtility.getReadData(1, 12, 1),
				ExcelUtility.getReadData(1, 13, 1));
		EnrollAddressPage enrollAddressPage = enrollIdentification
				.identificationPageDetailsEntered(ExcelUtility.getReadData(1, 4, 1));

		EnrollContactsPage enrollContacts = enrollAddressPage
				.addressPageDetailsEntered(ExcelUtility.getReadData(1, 5, 1), ExcelUtility.getReadData(1, 6, 1));

		EnrollMarketingPage enrollMarketing = enrollContacts
				.contactsPageDetailsEntered(ExcelUtility.getReadData(1, 7, 1), ExcelUtility.getReadData(1, 8, 1));

		EnrollPreviewPage enrollPreviewPage = enrollMarketing.marketingPageDetailsEntered(
				ExcelUtility.getReadData(1, 9, 1), ExcelUtility.getReadData(1, 10, 1),
				ExcelUtility.getReadData(1, 11, 1));

		EnrollPossibleMatchesPage possibleMatchesPage = enrollPreviewPage.clickOnNextButton();

	    PrintCardPage printCardPage = possibleMatchesPage.savebtn();
		
		possibleMatchesPage.clickOnSaveButton(prop.getProperty("username"), prop.getProperty("password"));

		PlayerDetailViewPage playerDetailViewPage = printCardPage.printCardIsClickable();
		playerDetailViewPage.clickOnOk();

		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = playerDetailViewPage.redirectToMarketing();

		Assert.assertTrue(playerDetailsMarketingTab.isCouponsTabDisplayed(), "Coupons tab is not displayed");
	}

	// TC060 - Validate that user is able to see the Marketing tab details.
	@Test(priority = 71, retryAnalyzer = RetryMethod.class)
	public void validateMarketingTabDetails() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();

		action.waitElementToBeClickable();
		EnrollIdentificationPage enrollIdentification = enrollBasic.nextClickableAfterDetailsEntered(
				ExcelUtility.getReadData(1, 0, 1), ExcelUtility.getReadData(1, 1, 1), ExcelUtility.getReadData(1, 2, 1),
				ExcelUtility.getReadData(1, 3, 1), ExcelUtility.getReadData(1, 12, 1),
				ExcelUtility.getReadData(1, 13, 1));
		EnrollAddressPage enrollAddressPage = enrollIdentification
				.identificationPageDetailsEntered(ExcelUtility.getReadData(1, 4, 1));

		EnrollContactsPage enrollContacts = enrollAddressPage
				.addressPageDetailsEntered(ExcelUtility.getReadData(1, 5, 1), ExcelUtility.getReadData(1, 6, 1));

		EnrollMarketingPage enrollMarketing = enrollContacts
				.contactsPageDetailsEntered(ExcelUtility.getReadData(1, 7, 1), ExcelUtility.getReadData(1, 8, 1));

		EnrollPreviewPage enrollPreviewPage = enrollMarketing.marketingPageDetailsEntered(
				ExcelUtility.getReadData(1, 9, 1), ExcelUtility.getReadData(1, 10, 1),
				ExcelUtility.getReadData(1, 11, 1));

		EnrollPossibleMatchesPage possibleMatchesPage = enrollPreviewPage.clickOnNextButton();

	    PrintCardPage printCardPage = possibleMatchesPage.savebtn();
		
		possibleMatchesPage.clickOnSaveButton(prop.getProperty("username"), prop.getProperty("password"));

		PlayerDetailViewPage playerDetailViewPage = printCardPage.printCardIsClickable();
		playerDetailViewPage.clickOnOk();

		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = playerDetailViewPage.redirectToMarketing();

		playerDetailsMarketingTab.validateMarketingTabDetails();
		
		Assert.assertTrue(playerDetailsMarketingTab.pageElementDisplay(),"Element not display");
	}

	// Validate that user are able to see issue type coupons are enabled or not.
	@Test(priority = 72, groups = "RedeemCoupon", retryAnalyzer = RetryMethod.class)
	public void isIssueCouponsEnabled() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();

		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = searchPage
				.validatePlayerDetailsMarketingTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsMarketingTab.isIssueCouponsEnabled(), "Issued redeem is not enabled");
	}

	// Validate that user are able to redeem issued type coupons
	@Test(priority = 73, groups = { "RedeemCoupon", "Sanity" }, retryAnalyzer = RetryMethod.class)
	public void redeemedIssuedCoupons() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = searchPage
				.validatePlayerDetailsMarketingTab(ExcelUtility.getReadData(1, 0, 3));
		
		Assert.assertTrue(playerDetailsMarketingTab.redeemedIssuedCoupons(),
				"User are not able to redeem Issued type coupons");
		playerDetailsMarketingTab.clickOnOK();
	}
	
	// Validate that user are able redeemed a coupon with invalid coupons id
	@Test(priority = 74, groups = "RedeemCoupon", retryAnalyzer = RetryMethod.class)
	public void invalidCouponIdEntered() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = searchPage
				.validatePlayerDetailsMarketingTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsMarketingTab.invalidCouponIdEntered(ExcelUtility.getReadData(1, 1, 3)),
				"Coupon id succesfully entered");
		playerDetailsMarketingTab.clickOnOK();
	}

	// Validate that user are able to redeemed a coupon is with valid coupon id
	@Test(priority = 75, groups = { "RedeemCoupon", "Sanity" }, retryAnalyzer = RetryMethod.class)
	public void validCouponIdEntered() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = searchPage
				.validatePlayerDetailsMarketingTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsMarketingTab.validCouponIdEntered(ExcelUtility.getReadData(1, 2, 3)),
				"Coupon id not entered sucessfully");
		playerDetailsMarketingTab.clickOnOK();
	}

	// Validate that messages are displayed when user click on redeem button without entered any value
	@Test(priority = 76, groups = "RedeemCoupon", retryAnalyzer = RetryMethod.class)
	public void errorMessageOnRedeem() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = searchPage
				.validatePlayerDetailsMarketingTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsMarketingTab.errorMessageOnRedeem(), "Is not mandatory");
	}
}
