package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Waits;

public class KweekweekProfilePage {

	WebDriver driver;
	@FindBy(xpath ="//hgroup[@class='user-name-section']/h1")
	private WebElement profileUsername;
	
	public KweekweekProfilePage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getUsername(){
		Waits.waitForElementToBeClickable(driver, profileUsername);
		return profileUsername.getText();
		
	}
}
