
package testpages;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepack.BaseClass;
import pageobjects.PortalLoginPage;

/**
 * 
 */
public class PortalLoginTest extends BaseClass {

	@Test(groups = "Smoke")
	public void validateTitle() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		String actTitle = portalLoginPage.portalGetTitle(); // Call the getTitle method and store in string
		Assert.assertEquals(actTitle, "System Web Portal 1.2.0.30"); // Verification

	}

	@Test(groups = { "Smoke", "Sanity" })
	public void validateIGTportalLogin() {
		PortalLoginPage portalLoginPage = new PortalLoginPage(drivertl.get()); // Create object of PortalLogin Class
		 portalLoginPage.igtPortalLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		// Store the result to object of PortalLanding class
		// boolean result=portalLanding.clickPCBBtnOfLandingPage();
		// Assert.assertTrue(result);

	}

}
