package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

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
import pageobjects.PlayerDetailsViewPageBasicTab;
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;
import pageobjects.PrintCardPage;
import pageobjects.SearchPage;
import utilities.ExcelUtility;
import utilities.RetryMethod;

public class PlayerDetailsViewTestBasicTab extends BaseClass {
	Action action = new Action();

	// TC049 - Validate that user is redirect to Basictab of Middle part view
	@Test(priority = 52, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateIsPlayerRedirectToBasicTab() {
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

		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = playerDetailViewPage.redirectToBasicTab();

		Assert.assertTrue(playerDetailsBasicTab.isPlayerRedirectToBasicTab(), "the page is not redirect");
	}

	// TC050 - Validate that Preferred name is displayed as per expectations on Middle part
	@Test(priority = 53)
	public void validateIsPlayerPreferredNameDisplayed() {
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

		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = playerDetailViewPage.redirectToBasicTab();

		String actText = playerDetailsBasicTab.isPlayerPreferredNameDisplayed();

		Assert.assertEquals(actText, ExcelUtility.getReadData(1, 3, 1), "Actual expected mismatch");
	}

	// TC051 - Validate that Phone number is displayed as per expectation on Middle part
	@Test(priority = 54, retryAnalyzer = RetryMethod.class)
	public void validateGetNumberOfPlayerDetails() {
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

		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = playerDetailViewPage.redirectToBasicTab();

		String[] actText = playerDetailsBasicTab.getNumberOfPlayerDetails();

		Assert.assertEquals(actText[1].replaceAll("[^\\d]", ""), ExcelUtility.getReadData(1, 7, 1),
				"Actual expected mismatch");
	}

	// TC052 - Validate that Email is displayed as per expectation on Middle part
	@Test(priority = 55, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateGetEmailOfPlayerDetails() {
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

		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = playerDetailViewPage.redirectToBasicTab();

		String[] actText = playerDetailsBasicTab.getEmailOfPlayerDetails();
		Assert.assertEquals(actText[1].trim(), ExcelUtility.getReadData(1, 8, 1), "Actual expected mismatch");
	}

	// TC053 - Validate that Address is displayed as per expectation on Middle part
	@Test(priority = 56, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateGetAddressOfPlayer() {
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

		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = playerDetailViewPage.redirectToBasicTab();

		String[] actText = playerDetailsBasicTab.getAddressOfPlayer();

		Assert.assertEquals(actText[0].trim(), "Home", "Actual expected mismatch");
		Assert.assertEquals(actText[1].trim(), ExcelUtility.getReadData(1, 5, 1), "Actual expected mismatch");
		Assert.assertEquals(actText[2].trim(), "NEW YORK", "Actual expected mistmatch");
		Assert.assertEquals(actText[3].trim(), ExcelUtility.getReadData(1, 6, 1), "Actual expected mismatch");
		Assert.assertEquals(actText[4].trim(), "US", "Actual expected mismatch");
	}

	// TC054 - Validate that user is able to see Basic tab Details.
	@Test(priority = 57, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateBasicTabDetails() {
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

		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = playerDetailViewPage.redirectToBasicTab();
		
		Assert.assertTrue(playerDetailsBasicTab.basicTabDetailsDisplay(), "Basic tab details not display");
	}

	// Validate that user are able to see all Balances Option which is present on basic tab
	@Test(priority = 58, groups = "RedeemComp")
	public void balancesOptionsDisplayed() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = searchPage
				.validatePlayerDetailsBasicTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsBasicTab.balancesOptionsDisplayed(), "Balance Options are not displayed");
	}

	// Validate that user are able to click rewards option from the balances
	@Test(priority = 59, groups = "RedeemComp", retryAnalyzer = RetryMethod.class)
	public void rewardOptionClickabled() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = searchPage
				.validatePlayerDetailsBasicTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsBasicTab.rewardOptionClickabled(), "Reward Options is not clickable");
		Assert.assertTrue(playerDetailsBasicTab.clickOnClose(), "Close button is not clickable");
	}

	// Validate that user are able to click cashback option from the balances
	@Test(priority = 60, groups = "RedeemComp", retryAnalyzer = RetryMethod.class)
	public void cashbackOptionClickabled() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = searchPage
				.validatePlayerDetailsBasicTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsBasicTab.cashbackOptionClickabled(), "Cashback Options is not clickable");
		Assert.assertTrue(playerDetailsBasicTab.clickOnClose(), "Close button is not clickable");
	}

	// Validate that user are able to click primary comp option from the balances
	@Test(priority = 61, groups = "RedeemComp", retryAnalyzer = RetryMethod.class)
	public void primaryCompClickabled() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = searchPage
				.validatePlayerDetailsBasicTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsBasicTab.primaryCompClickabled(), "Balance Options is not clickabled");
		Assert.assertTrue(playerDetailsBasicTab.clickOnClose(), "Close button is not clickabled");
	}

	// Validate that when user click on rewards option then same level text should be display
	@Test(priority = 62, retryAnalyzer = RetryMethod.class, groups = "RedeemComp")
	public void checkRewardsDisplayed() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = searchPage
				.validatePlayerDetailsBasicTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsBasicTab.checkRewardsDisplayed(),
				"Rewards title not displayed after open rewards window ");
		Assert.assertTrue(playerDetailsBasicTab.clickOnClose(), "Close button is not clickabled");
	}

	// Validate that user are able to redeemed reward and able to see the deduction value
	@Test(priority = 63, groups = { "RedeemComp", "Sanity" }, retryAnalyzer = RetryMethod.class)
	public void userAbleToRedeemRewards() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = searchPage
				.validatePlayerDetailsBasicTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsBasicTab.userAbleToRedeemRewards(ExcelUtility.getReadData(1, 0, 4),prop.getProperty("username"),
				prop.getProperty("password")), " User are not able to redeem Rewards");
		playerDetailsBasicTab.clickOnOkAfterSuccessMsg();
		Assert.assertTrue(playerDetailsBasicTab.getRewardsDeductionValue(), "Deduction value not expected ");	
	}

	// Validate that user are able to redeemed cashback and able to see the deduction value
	@Test(priority = 64, groups = { "RedeemComp", "Sanity" }, retryAnalyzer = RetryMethod.class)
	public void userAbleToRedeemCashback() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = searchPage
				.validatePlayerDetailsBasicTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsBasicTab.userAbleToRedeemCashback(ExcelUtility.getReadData(1, 0, 4), prop.getProperty("username"),
				prop.getProperty("password")), " User are not able to redeem cashback Comp");
		playerDetailsBasicTab.clickOnOkAfterSuccessMsg();
		Assert.assertTrue(playerDetailsBasicTab.getCashbackDeductionValue(), "Deduction value not expected ");
	}

	// Validate that user are able to redeemed primary comp and able to see the deduction value
	@Test(priority = 65, groups = { "RedeemComp", "Sanity" }, retryAnalyzer = RetryMethod.class)
	public void userAbleToRedeemPrimaryComp() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = searchPage
				.validatePlayerDetailsBasicTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(playerDetailsBasicTab.userAbleToRedeemPrimaryComp(ExcelUtility.getReadData(1, 0, 4),prop.getProperty("username"),
				prop.getProperty("password")), " User are not able to redeem primary Comp");
		playerDetailsBasicTab.clickOnOkAfterSuccessMsg();
		Assert.assertTrue(playerDetailsBasicTab.getPrimaryCompDeductionValue(), "Deduction value not expected ");
	}
}
