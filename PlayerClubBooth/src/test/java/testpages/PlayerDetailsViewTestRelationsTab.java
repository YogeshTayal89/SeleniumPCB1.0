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
import pageobjects.PlayerDetailViewTopPartPage;
import pageobjects.PlayerDetailsViewPageBasicTab;
import pageobjects.PlayerDetailsViewPageCardsTab;
import pageobjects.PlayerDetailsViewPageCommentsTab;
import pageobjects.PlayerDetailsViewPageMarketingTab;
import pageobjects.PlayerDetailsViewPageRelationsTab;
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;
import pageobjects.PrintCardPage;
import utilities.ExcelUtility;
import utilities.RetryMethod;

public class PlayerDetailsViewTestRelationsTab extends BaseClass {
	Action action = new Action();

	// TC063 - Validate that user is able to redirect to Relations tab of Middle part
	@Test(priority = 81, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateIsPlayerRedirectToRelationsTab() {
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

		PlayerDetailViewTopPartPage playerDetailsViewPageTop = playerDetailViewPage.validatePlayerDetails();

		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = playerDetailsViewPageTop.validateTopPartDetails();

		PlayerDetailsViewPageCommentsTab playerDetailsCommentTab = playerDetailsBasicTab.validateBasicTabDetails();

		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = playerDetailsCommentTab.clickOnCommentTab();

		PlayerDetailsViewPageCardsTab playerDetailsCardTab = playerDetailsMarketingTab.validateMarketingTabDetails();

		PlayerDetailsViewPageRelationsTab playerDetailsRelationTab = playerDetailsCardTab.validateCardTabDetails();

		Assert.assertTrue(playerDetailsRelationTab.isPlayerRedirectToRelationsTab(), "the page is not redirect");
		
	}

	// TC064 - Validate that user is able to see the Add Link button on Relations tab
	@Test(priority = 82, retryAnalyzer = RetryMethod.class)
	public void validateIsLinkbuttonDisplayed() {
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

		PlayerDetailViewTopPartPage playerDetailsViewPageTop = playerDetailViewPage.validatePlayerDetails();

		PlayerDetailsViewPageBasicTab playerDetailsBasicTab = playerDetailsViewPageTop.validateTopPartDetails();

		PlayerDetailsViewPageCommentsTab playerDetailsCommentTab = playerDetailsBasicTab.validateBasicTabDetails();

		PlayerDetailsViewPageMarketingTab playerDetailsMarketingTab = playerDetailsCommentTab.clickOnCommentTab();

		PlayerDetailsViewPageCardsTab playerDetailsCardTab = playerDetailsMarketingTab.validateMarketingTabDetails();

		PlayerDetailsViewPageRelationsTab playerDetailsRelationTab = playerDetailsCardTab.validateCardTabDetails();

		Assert.assertTrue(playerDetailsRelationTab.isLinkbuttonDisplayed(), "Link button is not displayed");
	}
}
