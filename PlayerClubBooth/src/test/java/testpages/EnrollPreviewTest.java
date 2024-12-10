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
import pageobjects.EnrollPreviewPage;
import pageobjects.HomePage;
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;

public class EnrollPreviewTest extends BaseClass {
	Action action = new Action();

	// TC036 - Validate that user is able to redirect to the Preview Page.
	@Test(priority = 38, groups = "Sanity")
	public void validateIsUserRedirectToPreviewPage() {
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

		Assert.assertTrue(enrollPreviewPage.isUserRedirectToPreviewPage(),
				"User is not redirected to the Preview Page");
	}

	// TC037 - Validate that user is able to click on Next button of the Preview Page.
	@Test(priority = 39, groups = "Sanity",retryAnalyzer = RetryMethod.class)
	public void validateClickOnNextButton() {
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

	   enrollPreviewPage.clickOnNextButton();
	
		Assert.assertTrue(enrollPreviewPage.nextPageElementDisplay(),"Element not display");
	}
}
