package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class EnrollPreviewPage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public EnrollPreviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Player Info']")
	WebElement redirectToPreviewPage;

	@FindBy(xpath = "//*[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary ng-star-inserted']/span[2]")
	WebElement nextButton;
	
	@FindBy(xpath = "//*[text()='Possible Matches']")
	WebElement possibleMatches;
	
	// Method for displaying next page element
	public boolean nextPageElementDisplay() {
		action.explicitWait(driver, possibleMatches);
      return action.isDisplayed(driver, possibleMatches);
	}

	// Method for redirect to Preview page
	public boolean isUserRedirectToPreviewPage() {
		action.waitElementToBeClickable();
		return action.isDisplayed(driver, redirectToPreviewPage);
	}

	// Method for clicking on Next button 
	public EnrollPossibleMatchesPage clickOnNextButton() {
		action.waitElementToBeClickable();
		action.click(driver, nextButton);
		return new EnrollPossibleMatchesPage(driver);
	}
}
