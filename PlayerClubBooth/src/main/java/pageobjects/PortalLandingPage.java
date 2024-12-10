package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import basepack.BaseClass;

public class PortalLandingPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//h3[contains(text(),'Players Club Booth')]")
	WebElement clickPCBBtn;

	WebDriver driver = null;
	public PortalLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method for clicking on PCB of Landing page
	public HomePage clickPcbBtnOfLandingPage() {
		action.waitElementToBeClickable();
		action.click(driver, clickPCBBtn);
		//action.switchToFrameByName(driver, "iframe-PatronManagment"); // For QA Environment
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe"))); // For Dev environment
		return new HomePage(driver);
	}

}
