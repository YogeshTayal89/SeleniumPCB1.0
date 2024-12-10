package pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;
import basepack.BaseClass;

public class PlayerDetailViewTopPartPage extends BaseClass {

	Action action = new Action();

	WebDriver driver = null;

	public PlayerDetailViewTopPartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='inner-details-top']/div/div/ul/li[1]/span[text()='Status']")
	WebElement statusOfPlayer;

	@FindBy(xpath = "//*[@class='inner-details-top']/div/div/h3")
	WebElement playerName;

	@FindBy(xpath = "//*[text()='Basic']")
	WebElement basicTab;

	@FindBy(xpath = "//*[@class='inner-details-top']/div/div/ul/li[3]/span[2]")
	WebElement enrolledId;

	@FindBy(xpath = "//*[@class='inner-details-top']/div/div/ul/li[3]/span[2]/span")
	WebElement idPopUp;

	@FindBy(xpath = "//*[text()='close']")
	WebElement closePopUp;

	@FindBy(xpath = "((//*[@class='mat-card-content igt-card-inner-content'])[1]/div/ul)[1]/li")
	List<WebElement> topPartDetails;


	// Method for redirect to player details top page
	public boolean isUserRedirectToPlayerDetailsTopPage() {
		return action.isDisplayed(driver, statusOfPlayer);
	}

	// Method for getting First name
	public String isPlayerFirstNameDisplayed() {
		String name[] = playerName.getText().split("[\\s,]+");
		String firstName = name[1];
		return firstName;
	}

	// Method for getting Mid name
	public String isPlayerMidNameDisplayed() {
		String name[] = playerName.getText().split("[\\s,]+");
		String MidName = name[2];
		return MidName;
	}

	// Method for getting Last name
	public String isPlayerLastNameDisplayed() {
		String name[] = playerName.getText().split("[\\s,]+");
		String lastName = name[3];
		return lastName;

	}

	// Method for getting ID
	public String[] isIdDislayed() {
		String[] idValue = enrolledId.getText().split("\\s+(?=[0-9])|(?<=[0-9])\\s+");
		System.out.println(Arrays.toString(idValue));
		return idValue;
	}

	// Method for Basic tab clickable
	public boolean nextPageElementDisplay() {
	 return action.isDisplayed(driver, statusOfPlayer);
	}

	// Method for getting Top part details of player details view page
	public PlayerDetailsViewPageBasicTab validateTopPartDetails() {
		return new PlayerDetailsViewPageBasicTab(driver);
	}
}
