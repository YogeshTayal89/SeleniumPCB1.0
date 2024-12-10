package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
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
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;
import pageobjects.PrintCardPage;

public class PrintCardTest extends BaseClass {
	Action action = new Action();

	// TC040 - Validate that user is able to redirect to the Print Card Page.
	@Test(priority = 42, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateIsUserRedirectToPrintCardPage() {
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


		Assert.assertTrue(printCardPage.isUserRedirectToPrintCardPage(), "User is not redirect to Print card Page");
	}

	// TC041 - Validate that user is able to click on Cancel button of Print Card Page.
	@Test(priority = 43, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateCancelButtonIsClickable() {
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


		Assert.assertTrue(printCardPage.cancelButtonIsClickable(), "Cancel button not working properly");

	}

	// TC042 - Validate that user is able to click on Print Card button of the Print Card Page.
	@Test(priority = 44, groups = "Sanity")
	public void validatePrintCardIsClickable() {
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

		 printCardPage.printCardIsClickable();

		Assert.assertTrue(printCardPage.nextPageElementDisplay(),"Element not display");
	}
}
