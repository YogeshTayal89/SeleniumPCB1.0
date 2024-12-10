package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.RetryMethod;
import actiondriver.Action;
import basepack.BaseClass;
import pageobjects.PlayerDetailsViewPageCardsTab;
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
import pageobjects.SearchPage;

public class PlayerDetailsViewTestCardsTab extends BaseClass {
	Action action = new Action();
	
	public void enrollPlayer() {
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
		printCardPage.nextPageElementDisplay();
		PlayerDetailsViewPageCardsTab playerDetailsCardTab  = playerDetailViewPage.redirectToCardTab();
		playerDetailsCardTab.clickOnCardTab();
	
	}

	// Validate that user are able to set our card pin number
	@Test(priority = 78, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateSetCardPinNumber() {

		enrollPlayer();

		PlayerDetailsViewPageCardsTab playerDetailsCardTab = new PlayerDetailsViewPageCardsTab(drivertl.get());
		playerDetailsCardTab.validateActiveCard();
		String actual = playerDetailsCardTab.validateSetPinPopUp(); // verify set pin popup
		String expected = "Set Card PIN";
		Assert.assertEquals(actual, expected);
		System.out.println("Set pin popup Message is " + playerDetailsCardTab.validateSetPinPopUp());
		playerDetailsCardTab.cancelButton();

		playerDetailsCardTab.enterMinimumFourValueForSetPin(ExcelUtility.getReadData(1, 8, 2));// verify error message
		String actual1 = playerDetailsCardTab.validateErrorPinMessage();
		String expected1 = "PIN must be 4 to 8 digits.";
		Assert.assertEquals(actual1, expected1);
		System.out.println("Set pin error Message is " + playerDetailsCardTab.validateErrorPinMessage());
		playerDetailsCardTab.cancelButton();

		playerDetailsCardTab.setIncorrectReEnterPin(ExcelUtility.getReadData(1, 0, 2),
				ExcelUtility.getReadData(1, 2, 2));// verify incorrectrenterpin
		String actual2 = playerDetailsCardTab.errorMessage();
		String expected2 = "Re-entered PIN doesn't match with the entered PIN.";
		Assert.assertEquals(actual2, expected2);
		System.out.println("Error message is " + playerDetailsCardTab.errorMessage());
		playerDetailsCardTab.cancelButton();

		playerDetailsCardTab.enterDataForSetPin(ExcelUtility.getReadData(1, 0, 2), ExcelUtility.getReadData(1, 1, 2));
		String actual3 = playerDetailsCardTab.successfullMessage();
		String expected3 = "PIN has been added successfully";
		Assert.assertEquals(actual3, expected3);
		System.out.println(" message is " + playerDetailsCardTab.successfullMessage());
		playerDetailsCardTab.clickOnOkButton();
	
	}

	// Validate that user are able to update our card pin number
	@Test(priority = 79, groups = "Sanity", retryAnalyzer = RetryMethod.class)
	public void validateUpdateCardPinNumber() {
		enrollPlayer();

		PlayerDetailsViewPageCardsTab playerDetailsCardTab = new PlayerDetailsViewPageCardsTab(drivertl.get());
		playerDetailsCardTab.enterDataForSetPin(ExcelUtility.getReadData(1, 0, 2), ExcelUtility.getReadData(1, 1, 2));
		playerDetailsCardTab.clickOnOkButton();

		playerDetailsCardTab.validateActiveCard();// verify update pin popup
		String actual = playerDetailsCardTab.validateSetPinPopUp(); // verify set pin popup change in to update pin
		String expected = "Change Card PIN";
		Assert.assertEquals(actual, expected);
		System.out.println("popup Message is " + playerDetailsCardTab.validateSetPinPopUp());
		playerDetailsCardTab.cancelButton();

		playerDetailsCardTab.enterMinimumFourValueForUpdatePin(ExcelUtility.getReadData(1, 8, 2));// verify error message
		String actual1 = playerDetailsCardTab.validateErrorPinMessage();
		String expected1 = "PIN must be 4 to 8 digits.";
		Assert.assertEquals(actual1, expected1);
		System.out.println("pin error Message is " + playerDetailsCardTab.validateErrorPinMessage());
		playerDetailsCardTab.cancelButton();

		playerDetailsCardTab.enterDataForUpdatePin(ExcelUtility.getReadData(1, 2, 2),
				ExcelUtility.getReadData(1, 3, 2), ExcelUtility.getReadData(1, 4, 2));
		String actual2 = playerDetailsCardTab.verifyUpdateError();
		String expected2 = "Old PIN is incorrect.";
		Assert.assertEquals(actual2, expected2);
		System.out.println("Error message is " + playerDetailsCardTab.verifyUpdateError());
		playerDetailsCardTab.clickOnOkButton();

		// verify invalid pin message during update pin
		playerDetailsCardTab.enterDataForUpdatePin(ExcelUtility.getReadData(1, 1, 2),
				ExcelUtility.getReadData(1, 3, 2), ExcelUtility.getReadData(1, 7, 2));
		String actual3 = playerDetailsCardTab.validateErrorInvalidPinMessage();
		String expected3 = "Re-entered PIN doesn't match with the entered PIN.";
		Assert.assertEquals(actual3, expected3);
		System.out.println("Invalid error Message is " + playerDetailsCardTab.validateErrorInvalidPinMessage());
		playerDetailsCardTab.cancelButton();
		playerDetailsCardTab.enterDataForUpdatePin(ExcelUtility.getReadData(1, 1, 2),
				ExcelUtility.getReadData(1, 3, 2), ExcelUtility.getReadData(1, 4, 2));
		String actual4 = playerDetailsCardTab.successfullMessage();
		String expected4 = "PIN has been changed successfully.";
		Assert.assertEquals(actual4, expected4);
		System.out.println("message is " + playerDetailsCardTab.successfullMessage());
		playerDetailsCardTab.clickOnOkButton();
	}

	// Validate that user are able to print a card for our updated information
	@Test(priority = 80, groups = "Sanity", enabled = false)
	public void userAbleToCardPrint() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageCardsTab playerDetailsCardTab = searchPage
				.validatePlayerDetailsCardTab(ExcelUtility.getReadData(1, 0, 3));
		playerDetailsCardTab.clickOnOk();   
		Assert.assertTrue(playerDetailsCardTab.userAbleToPrintNewCard(), "User are not able to Print a card");
		playerDetailsCardTab.clickOnOk();
	    
	}

	// Validate that user are able to print a duplicate card
	@Test(priority = 81, groups = "Sanity", retryAnalyzer = RetryMethod.class, enabled = false)
	public void userAbleToPrintDuplicateCard() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		PlayerDetailsViewPageCardsTab playerDetailsCardTab = searchPage
				.validatePlayerDetailsCardTab(ExcelUtility.getReadData(1, 0, 3));
		
		Assert.assertTrue(playerDetailsCardTab.userAbleToPrintDuplicateCard(), "user are not able to print duplicate card");
		playerDetailsCardTab.clickOnOk();
	    
	}
}
