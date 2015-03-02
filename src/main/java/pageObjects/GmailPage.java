package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utils.Waits;

import env.TestAppEnv;

public class GmailPage {

	private WebDriver driver;
	@FindBy (id="Email")
	private WebElement gmailLoginEmailField;
	@FindBy(id="Passwd")
	private WebElement gmailLoginPasswordField;
	@FindBy(id="signIn")
	private WebElement gmailSigninButton;
	@FindBy(xpath="//span[contains(.,'Reset your KweekWeek password')]")
	private WebElement resetPasswordEmail;
	@FindBy (xpath="//img[@alt='Reset password']")
	private WebElement resetPasswordButton;
	@FindBy (xpath="//div[@data-tooltip='Delete']")    
    private WebElement gmailDeleteMailButton;
    @FindBy (xpath="//div[@data-tooltip='Select']/div/span[@role='checkbox']")
    private WebElement mailCheckbox;
    @FindBy(xpath="//span[contains(.,'Unlock your KweekWeek account')]")
	private WebElement unlockAccountEmail;
    @FindBy(xpath="//a[contains(.,'Unlock my account')]")
	private WebElement unlockAccountLink;
	
	
	
	public GmailPage(WebDriver driver){
		this.driver = driver;
	}
	
	public GmailPage getGmailLoginPage(){
		driver.get(TestAppEnv.getGmailLoginPage());
		return this;
	}
	public GmailPage setGmailLoginEmail(String email){
		Waits.waitForElementToBeClickable(driver, gmailLoginEmailField);
		gmailLoginEmailField.clear();
		gmailLoginEmailField.sendKeys(email);
		return this;
	}
	public GmailPage setGmailLoginPassword(String password){
		Waits.waitForElementToBeClickable(driver, gmailLoginPasswordField);
		gmailLoginPasswordField.clear();
        gmailLoginPasswordField.sendKeys(password);
        return this;
	}
	
	public GmailPage clickGmailSigninButton(){
		Waits.waitForElementToBeClickable(driver, gmailSigninButton);
		gmailSigninButton.click();
		return this;
	}
	
	public GmailPage clickGmailResetPasswordEmail(){
		Waits.waitForElementToBeClickable(driver, resetPasswordEmail);
		resetPasswordEmail.click();
		return this;
	}
	
	public GmailPage clickGmailResetPasswordButton(){
		Waits.waitForElementToBeClickable(driver, resetPasswordButton);
		resetPasswordButton.click();
		return this;
	}
	
	public GmailPage deleteResetPasswordEmail(){
		Waits.waitForElementToBeClickable(driver, gmailDeleteMailButton);
		gmailDeleteMailButton.click();
		return this;
	}
	public GmailPage loginToGmail(String email, String password){
		Waits.waitForElementToBeClickable(driver, gmailLoginEmailField);
		setGmailLoginEmail(email);
		Waits.waitForSomeSeconds(2000);
		setGmailLoginPassword(password);
		clickGmailSigninButton();
		return this;
	}
	
	public GmailPage clickMailCheckbox(){
		Waits.waitForElementToBeClickable(driver, mailCheckbox);
		mailCheckbox.click();
		return this;
	}
	
	public GmailPage clickDeleteAllButtonInHeader(){
		Waits.waitForElementToBeClickable(driver, gmailDeleteMailButton);
		gmailDeleteMailButton.click();
		return this;
	}
	
	public GmailPage clickResetLink(){
		Waits.waitForElementToBeClickable(driver, resetPasswordEmail);
		clickGmailResetPasswordButton();
		clickGmailResetPasswordButton();
		return this;
	}
	
	public GmailPage deleteAllEmailsAfterTest(WebDriver driver){
		clickMailCheckbox();
	    clickDeleteAllButtonInHeader();
	    return this;
	}

	public GmailPage clickGmailUnlockEmail() {
		Waits.waitForElementToBeClickable(driver, unlockAccountEmail);
	   unlockAccountEmail.click();
		return this;
	
	}

	public GmailPage clickUnlockAccountLinkInMail() {
		Waits.waitForElementToBeClickable(driver, unlockAccountLink );
	   unlockAccountLink.click();
	   return this;
		
	}
	
	
        
	}


