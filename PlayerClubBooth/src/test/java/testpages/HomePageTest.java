
package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepack.BaseClass;
import pageobjects.EnrollBasicPage;
import pageobjects.HomePage;
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;
import pageobjects.SearchPage;

public class HomePageTest extends BaseClass {

	// Validate user is able to click on search
	@Test(groups = "Sanity")
	public void validateSearchClick() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		SearchPage searchPage = homePage.clickOnSearch();
		boolean result = searchPage.validateRecentText();
		Assert.assertTrue(result);

	}

	// Validate that user is able to click on Enroll
	@Test(groups = "Sanity")
	public void validateEnrollClick() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasic = homePage.clickOnEnroll();
		boolean result = enrollBasic.isUserRedirectToEnrollmentPage();
		Assert.assertTrue(result);
	}
}
