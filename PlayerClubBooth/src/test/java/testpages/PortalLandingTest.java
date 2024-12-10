
package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepack.BaseClass;
import pageobjects.EnrollBasicPage;
import pageobjects.HomePage;
import pageobjects.PortalLandingPage;
import pageobjects.PortalLoginPage;

public class PortalLandingTest extends BaseClass {

	@Test(priority = 1, groups = "Sanity")
	public void validateclickPCBBtnOfLandingPage() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		PortalLandingPage portalLandingPage = portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		HomePage homePage = portalLandingPage.clickPcbBtnOfLandingPage();
		EnrollBasicPage enrollBasicPage = homePage.clickOnEnroll();

		Assert.assertTrue(enrollBasicPage.isUserRedirectToEnrollmentPage(),
				"User is not redirected to the Enrollment page.");
	}

}
