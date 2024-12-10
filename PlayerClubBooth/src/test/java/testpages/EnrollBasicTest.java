package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import actiondriver.Action;
import basepack.BaseClass;
import pageobjects.EnrollBasicPage;
import pageobjects.HomePage;
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;

public class EnrollBasicTest extends BaseClass {
	Action action = new Action();

	// TC001 - Validate that the user is able to redirect to the Enrollment page by clicking on the ENROLLMENT tile.
	@Test(priority = 1, enabled = true, groups = "Sanity")
	public void validateIsUserRedirectToEnrollmentPage() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();

		Assert.assertTrue(enrollBasic.isUserRedirectToEnrollmentPage(),
				"User is not redirected to the Enrollment page.");
	}

	// TC002 - Validate that user is able to redirect to the search page while clicked on Cancel button of the basic Information page.
	@Test(priority = 2, enabled = true)
	public void validateCancelButtonOfBasicPage() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();

		action.waitElementToBeClickable();
		String actText = enrollBasic.cancelBtnOfBasicPage();
		Assert.assertEquals(actText, "Recent Searches", "Actual and expected value mismatch");
	}

	// TC004 - Validate that user is able to see the error message of the First Name field on the Basic Information page.
	@Test(priority = 4, enabled = true)
	public void validateErrorTextOfFirstName() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();

		action.waitElementToBeClickable();
		String actText = enrollBasic.errorTextOfFirstName();

		Assert.assertNotNull(actText, "First Name is Mandatory field");
		Assert.assertEquals(actText, "Please enter \"First Name\".", "Actual and expected value mismatch");
	}

	// TC005 - Validate that user is able to see the error message of the Last Name field on the Basic Information page.
	@Test(priority = 5, enabled = true)
	public void validateErrorTextOfLastName() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();

		action.waitElementToBeClickable();
		String actText = enrollBasic.errorTextOfLastName();

		Assert.assertNotNull(actText, "Last Name is Mandatory field");
		Assert.assertEquals(actText, "Please enter \"Last Name\".", "Actual and expected value mismatch");
	}

	// TC007 - Validate that user is able to see the error message of the DOB field on the Basic Information page.
	@Test(priority = 7, enabled = true)
	public void validateErrorTextOfDOB() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();

		action.waitElementToBeClickable();
		String actText = enrollBasic.errorTextOfDOB();

		Assert.assertNotNull(actText, "Last field is Mandatory field");
                Assert.assertEquals(actText, "Please Select \"DOB\"", "Actual and expected value mismatch");
	}

	// TC008 - Validate that user is able to enter details of the Basic Page.
	@Test(priority = 8, groups = "Sanity")
	public void nextClickableAfterDetailsEntered() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();

		action.waitElementToBeClickable();
		enrollBasic.nextClickableAfterDetailsEntered(ExcelUtility.getReadData(1, 0, 1), ExcelUtility.getReadData(1, 1, 1),
				ExcelUtility.getReadData(1, 2, 1), ExcelUtility.getReadData(1, 3, 1),
				ExcelUtility.getReadData(1, 12, 1), ExcelUtility.getReadData(1, 13, 1));

		Assert.assertTrue(enrollBasic.ableToClickNext(), "Next button not clickable");
		
	}
}
