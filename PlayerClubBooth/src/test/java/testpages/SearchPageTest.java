package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import actiondriver.Action;
import basepack.BaseClass;
import pageobjects.HomePage;
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;
import pageobjects.SearchPage;
import pageobjects.SearchResultPage;
import utilities.ExcelUtility;
import utilities.RetryMethod;

public class SearchPageTest extends BaseClass {

	Action action = new Action();

	// TC001 - Validate the user is able to see the Search Box on the search player screen.
	@Test(priority = 1, enabled = true)
	public void verifySearchBoxVisible() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();
		Assert.assertTrue(searchPage.validateSearchBox(), "Search box not visible ");

	}

	// TC002 - Validate the user is able to click on the SEARCH button from the search player screen.
	@Test(priority = 2, enabled = true)
	public void verifyPlayerSearchButton() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();
		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 7, 0));
		searchPage = searchPage.clickOnSearch();
		Assert.assertTrue(searchResult.getPlayerDob());
	}

	// TC003 - Validate the user is able to search player by single text field using different criteria separated by comma.
	@Test(priority = 3, retryAnalyzer = RetryMethod.class, enabled = true)
	public void verifySearchWithSeparatedComma() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();
		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 3, 0) + ",");
		searchPage = searchPage.clickOnSearch();
		Assert.assertTrue(searchResult.getPlayerId());
	}

	// TC004 - Validate the user is able to see the instruction in search bar as 'Type or Scan ID & press enter to search.
	@Test(priority = 4, enabled = true)
	public void verifySearchBoxInstruction() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();
		String actual = searchPage.searchInstruction();
		String expected = "Type or Scan ID & press enter to search";
		Assert.assertEquals(actual, expected);

	}

	// TC005 - Validate the user is able to remove the keywords from the search bar using the 'X' icon.
	@Test(priority = 5, enabled = true)
	public void verifySearchCancel() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();
		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 3, 0));
		Assert.assertTrue(searchPage.crossIcon());
		searchPage = searchPage.clickOnCrossIcon();
	}

	// TC006 - Validate the user is able to clear the keywords from the search bar susing the 'X' icon and again able to enter the keywords to the search player.
	@Test(priority = 6, enabled = true,  retryAnalyzer = RetryMethod.class)
	public void verifySearchReEnter() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();
		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 3, 0));
		Assert.assertTrue(searchPage.crossIcon());
		searchPage = searchPage.clickOnCrossIcon();
		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 3, 0));
		searchPage = searchPage.clickOnSearch();
		Assert.assertTrue(searchResult.getPlayerId());
	}

	// TC007 - Validate the user is able to see the "ENROLL" button from the Search player screen.
	@Test(priority = 7, enabled = true)
	public void verifyEnrollButtonVisible() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();
		Assert.assertTrue(searchPage.enrollButton());
	}

	// TC008 - Validate the user is able to redirect to the "Enrollment" screen after clicking on the "ENROLL" button.
	@Test(priority = 8, enabled = true)
	public void verifyEnrollButtonClickable() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();
		searchPage = searchPage.clickOnEnroll();
		String Actual = searchResult.enrollBasicInfo();
		String Expected = "Basic Information";
		Assert.assertEquals(Actual, Expected);

	}

	// TC009 - Validate the user is able to search by text against name of player from the search player screen.
	@Test(priority = 9, enabled = true)
	public void verifySearchByplayerFullName() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		//SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 0, 0) + ","
				+ ExcelUtility.getReadData(1, 1, 0) + "," + ExcelUtility.getReadData(1, 2, 0));
		   searchPage.clickOnSearch();	
		  
		  
	}

	// TC010 - Validate the user is able to search by number against SSNID docs of player from the search player screen.
	@Test(priority = 10, enabled = true, retryAnalyzer = RetryMethod.class)
	public void verifySearchByPlayerSSNID() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(2, 4, 0));
		searchPage = searchPage.clickOnSearch();
		Assert.assertTrue(searchResult.getPlayerSsnIdBox());
	}

	// TC011 - Validate the user is able to search player by driver's license number from search box.
	@Test(priority = 11, enabled = true, retryAnalyzer = RetryMethod.class)
	public void verifySearchByPlayerDLID() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(3, 5, 0));
		searchPage = searchPage.clickOnSearch();

		System.out.println(ExcelUtility.getReadData(3, 5, 0));
		Assert.assertTrue(searchResult.playerDlId());
	}

	// TC012 - Validate the user is able to search player by Date of Birth from search box.
	@Test(priority = 12, enabled = true)
	public void verifySearchByPlayerDOB() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 7, 0));
		searchPage = searchPage.clickOnSearch();
		Assert.assertTrue(searchResult.getPlayerDob());
	}

	// TC013 - Validate the user is able to search player by Player ID from search box.
	@Test(priority = 13, enabled = true)
	public void verifySearchByPlayerID() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 3, 0));
		searchPage = searchPage.clickOnSearch();
		Assert.assertTrue(searchResult.getPlayerId());
	}

	// TC014 - Validate the user is able to search player by First Name from search box.
	@Test(priority = 14, enabled = true)
	public void verifySearchByPlayerFirstName() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 0, 0));
		searchPage = searchPage.clickOnSearch();
	}

	// TC015 - Validate the user is able to search player by Middle Name from search box.
	@Test(priority = 15, enabled = true)
	public void verifySearchByPlayerMiddleName() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 1, 0));
		searchPage = searchPage.clickOnSearch();
	}

	// TC016 - Validate the user is able to search player by Last Name from search box
	@Test(priority = 16, enabled = true)
	public void verifySearchByPlayerLastName() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(2, 1, 0));
		searchPage = searchPage.clickOnSearch();
	}

	// TC017 - Validate the user is able to search player by player card number from search box.
	@Test(priority = 17, enabled = true, retryAnalyzer = RetryMethod.class)
	public void verifySearchByPlayerCardNumber() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 9, 0));
		searchPage = searchPage.clickOnSearch();
		Assert.assertTrue(searchResult.getPlayerCardNumber());
	}

	// TC018 - Validate the user is able to see the correct error message for the minimum characters provided in search box.
	@Test(priority = 18, enabled = true)
	public void verifySearchByMinimumThreeNumber() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 10, 0));
		searchPage = searchPage.clickOnSearch();
		System.out.println(ExcelUtility.getReadData(1, 10, 0));
		String actual = searchPage.enterMinThreeValues();
		String Expected = "Please enter a minimum of 3 characters to search player.";
		Assert.assertEquals(actual, Expected);

	}

	// TC019 - Validate the user is able to see the correct error message for the maximum characters provided in search box
	@Test(priority = 19, enabled = true)
	public void verifySearchByMaxFiftyNumber() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 11, 0));
		searchPage = searchPage.clickOnSearch();
		System.out.println(ExcelUtility.getReadData(1, 11, 0));
		String actual = searchPage.enterMaxFiftyValues();
		String Expected = "Please enter less than 50 characters to search player.";
		Assert.assertEquals(actual, Expected);
	}

	// TC020 - Validate the user is able to search player by Three Separated values from search box.
	@Test(priority = 20, enabled = true)
	public void verifySearchByThreeSeparatedValues() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 0, 0) + ","
				+ ExcelUtility.getReadData(1, 2, 0) + "," + ExcelUtility.getReadData(1, 3, 0));
		searchPage = searchPage.clickOnSearch();
		Assert.assertTrue(searchResult.getPlayerId());

	}

	// TC021 - Validate the search functionality on clicking with Empty Text.
	@Test(priority = 21, enabled = true)
	public void verifySearchByEmptyText() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());

		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.clickOnSearch();
		String actual = searchPage.enterMinThreeValues();
		String Expected = "Please enter a minimum of 3 characters to search player.";

		Assert.assertEquals(actual, Expected);
	}

	// TC0022 - Validate the user is able to search player by passport number from search box.
	@Test(priority = 22, enabled = true)
	public void verifySearchByPlayerPassportID() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		SearchResultPage searchResult = new SearchResultPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(4, 6, 0));
		searchPage = searchPage.clickOnSearch();
		System.out.println(ExcelUtility.getReadData(4, 6, 0));
		Assert.assertTrue(searchResult.playerPassportId().contains(ExcelUtility.getReadData(4, 6, 0)));

	}

	// TC023 - Verify no result found
	@Test(priority = 23, enabled = true)
	public void verifyNoResultFound() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		searchPage = searchPage.getReadDataExcel(ExcelUtility.getReadData(1, 15, 0));
		searchPage = searchPage.clickOnSearch();
		String actual = searchPage.noResultFound();
		String Expected = "No results found";
		System.out.println("Message " + searchPage.noResultFound());

		Assert.assertEquals(actual, Expected);
	}

	// TC023 - Verify no result found
	@Test(priority = 23,retryAnalyzer = RetryMethod.class, groups = "RedeemCoupon")
	public void validatePlayerDetailsMarketingTab() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());

		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		 searchPage
				.validatePlayerDetailsMarketingTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(searchPage.userRedirectToMarketingTab(), "Users are not able to redirect to Marketing tab");
	}

	// TC023 - Verify no result found
	@Test(priority = 23, enabled = true, retryAnalyzer = RetryMethod.class)
	public void validatePlayerDetailsCardTab() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		 searchPage
				.validatePlayerDetailsCardTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(searchPage.userRedirectToCardTab(), "Users are not able to redirect to Card tab");
	}

	// TC023 - Verify no result found
	@Test(priority = 23, groups = "RedeemComp", retryAnalyzer = RetryMethod.class)
	public void validatePlayerDetailsBasicTab() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		SearchPage searchPage = new SearchPage(drivertl.get());

		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		homePage.clickOnSearch();

		 searchPage
				.validatePlayerDetailsBasicTab(ExcelUtility.getReadData(1, 0, 3));

		Assert.assertTrue(searchPage.userRedirectToBasicTab(), "Users are not able to redirect to Basic tab");
	}
}
