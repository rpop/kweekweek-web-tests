package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Waits;

public class FacebookPage {

	private WebDriver driver;
	@FindBy (id="email")
	private WebElement facebookLoginEmailField;
	@FindBy(id="pass")
	private WebElement facebookLoginPasswordField;
	@FindBy (id="loginbutton")
	private WebElement facebookLoginButton;
	
	public FacebookPage(WebDriver driver){
		this.driver = driver;
	}
	
//	public FacebookPage clickFacebookEmailField(){
//		Waits.waitForElementToBeClickable(driver, facebookLoginEmailField);
//	    facebookLoginEmailField.click();
//	    return this;
//	}
	
	public FacebookPage setFacebookLoginEmail(String facebookLoginEmail){
		Waits.waitForElementToBeClickable(driver, facebookLoginEmailField);
		facebookLoginEmailField.clear();
		facebookLoginEmailField.sendKeys(facebookLoginEmail);
		return this;
	}
	
	public FacebookPage clickFacebookPasswordField(){
		Waits.waitForElementToBeClickable(driver, facebookLoginPasswordField);
		facebookLoginPasswordField.click();
		return this;
	}
	
	public FacebookPage setFacebookLoginPassword(String facebookLoginPassword){
		Waits.waitForElementToBeClickable(driver, facebookLoginEmailField);
		facebookLoginPasswordField.clear();
		facebookLoginPasswordField.sendKeys(facebookLoginPassword);
		return this;
	}
	
	public FacebookPage clickFacebookLoginButton(){
		Waits.waitForElementToBeClickable(driver, facebookLoginButton);
		facebookLoginButton.click();
		return this;
	}

	}


