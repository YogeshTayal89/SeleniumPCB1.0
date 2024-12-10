package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.RetryMethod;
import actiondriver.Action;
import basepack.BaseClass;
import pageobjects.EnrollBasicPage;
import pageobjects.EnrollIdentificationPage;
import pageobjects.HomePage;
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;

public class EnrollIdentificationTest extends BaseClass {
	Action action = new Action();

	// TC009 - Validate that user is able to redirect to the Identification page.
	@Test(priority = 9, groups = "Sanity")
	public void validateIsUserRedirectToIdentificationPage() {
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

		Assert.assertTrue(enrollIdentification.isUserRedirectToIdentificationPage(),
				"User is not redirected to the Identification Page");
	}

	// TC010 - Validate that user is able to see the RefuseID and select the checkbox.
	@Test(priority = 10)
	public void validateRefusedIdButtonClickable() {
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

		Assert.assertTrue(enrollIdentification.refusedIdButtonClickable(), "refused btn not clickabled ");

	}

	// TC012 - Validate that the user is able to select the Type of id's from the dropdown.
	@Test(priority = 14, retryAnalyzer = RetryMethod.class)
	public void validateTypesDropDownValuesSelected() {
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

		Assert.assertTrue(enrollIdentification.typesDropDownValuesSelected(),
				"Type value of Indentification page are not selected");
	}

	// TC013 - Validate that user is able to see the error message of Id field on the Identification page.
	@Test(priority = 15)
	public void validateErrorTextOfId() {
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
		String actText = enrollIdentification.errorTextOfId();

		Assert.assertNotNull(actText, "Id is Mandatory field");
		Assert.assertEquals(actText, "Please enter \"ID\".", "Actual and expected value mismatch");
	}

	// TC014 - Validate that user is able to see the error message of State field on the Identification page.
	@Test(priority = 16, enabled = true)
	public void validateErrorTextOfState() {
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
		String actText = enrollIdentification.errorTextOfState();

		Assert.assertNotNull(actText, "State field is Mandatory field");
		Assert.assertEquals(actText, "Please select “State”.", "Actual and expected value mismatch");
	}

	// TC07 - Validate that user is able to see the error message of Expiry date field on the Identification page.
	@Test(priority = 17, enabled = true)
	public void validateErrorTextOfExpiryDate() {
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
		String actText = enrollIdentification.errorTextOfExpiryDate();

		Assert.assertNotNull(actText, "Expiry date is Mandatory field");
		Assert.assertEquals(actText, "Please enter \"Expiry Date\".", "Actual and expected value mismatch");
	}

	// TC017 - Validate that user is able to enter the details of Identification Page.
	@Test(priority = 19, groups = "Sanity")
	public void validateIdentificationDetailsEntered() {
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
		enrollIdentification.identificationPageDetailsEntered(ExcelUtility.getReadData(1, 4, 1));

		String actData = enrollIdentification.identificationPageData();

		Assert.assertEquals(actData, ExcelUtility.getReadData(1, 4, 1), "Actual and Expected are not match");
	}

	// TC018 - Validate that user is able to click on Id button of Identification page.
	@Test(priority = 20, enabled = true, retryAnalyzer = RetryMethod.class)
	public void validateClickOnId() {
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

		Assert.assertTrue(enrollIdentification.clickOnId(ExcelUtility.getReadData(1, 4, 1)),
				" Add Id button is not clickable");

		enrollIdentification.identificationPageDetailsEntered(ExcelUtility.getReadData(1, 4, 1));
	}

	// TC019 - Validate that user is able to click on Delete button of Identification page.
	@Test(priority = 21, enabled = true, retryAnalyzer = RetryMethod.class)
	public void validateClickOnDelete() {
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

		Assert.assertTrue(enrollIdentification.clickOnDelete(ExcelUtility.getReadData(1, 4, 1)),
				" Delete button is not clickable");

		enrollIdentification.identificationPageDetailsEntered(ExcelUtility.getReadData(1, 4, 1));
	}
	// TC019 - Validate that user is able to click on Edit button of Identification page.
	@Test(priority = 21, enabled = true)
	public void validateclickOnEdit() {
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
		Assert.assertTrue(enrollIdentification.clickOnEdit(ExcelUtility.getReadData(1, 4, 1)),
				" Edit button is not clickable");		
	}
}
