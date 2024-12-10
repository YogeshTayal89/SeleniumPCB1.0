package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
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
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;
import pageobjects.PrintCardPage;
import utilities.RetryMethod;

public class PlayerDetailViewTest extends BaseClass {
	Action action = new Action();

	// TC043 - Validate that user is able to redirect to Player Details View Page
	@Test(priority = 45, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateIsUserRedirectToPlayerDetailsViewPage() {
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
		Assert.assertTrue(playerDetailViewPage.isUserRedirectToPlayerDetailViewPage(),
				"User is not redirected to the Preview Page");
	
	}

	// TC044 - Validate that user is able to see all details after Enroll.
	@Test(priority = 46, retryAnalyzer = RetryMethod.class)
	public void validatePlayerDetails() {
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

		playerDetailViewPage.validatePlayerDetails();
		playerDetailViewPage.clickOnOk();
		
		Assert.assertTrue(playerDetailViewPage.validateViewPageElement(), "Element not display");
	}
}
