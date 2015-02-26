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
	
	public void getGmailLoginPage(){
		driver.get(TestAppEnv.getGmailLoginPage());
	}
	public void setGmailLoginEmail(String email){
		Waits.waitForElementToBeClickable(driver, gmailLoginEmailField);
		gmailLoginEmailField.clear();
		gmailLoginEmailField.sendKeys(email);
	}
	public void setGmailLoginPassword(String password){
		Waits.waitForElementToBeClickable(driver, gmailLoginPasswordField);
		gmailLoginPasswordField.clear();
        gmailLoginPasswordField.sendKeys(password);
	}
	
	public void clickGmailSigninButton(){
		Waits.waitForElementToBeClickable(driver, gmailSigninButton);
		gmailSigninButton.click();
	}
	
	public void clickGmailResetPasswordEmail(){
		Waits.waitForElementToBeClickable(driver, resetPasswordEmail);
		resetPasswordEmail.click();
	}
	
	public void clickGmailResetPasswordButton(){
		Waits.waitForElementToBeClickable(driver, resetPasswordButton);
		resetPasswordButton.click();
	}
	
	public void deleteResetPasswordEmail(){
		Waits.waitForElementToBeClickable(driver, gmailDeleteMailButton);
		gmailDeleteMailButton.click();
	}
	public void loginToGmail(String email, String password){
		Waits.waitForElementToBeClickable(driver, gmailLoginEmailField);
		setGmailLoginEmail(email);
		Waits.waitForSomeSeconds(2000);
		setGmailLoginPassword(password);
		clickGmailSigninButton();
		
	}
	
	public void clickMailCheckbox(){
		Waits.waitForElementToBeClickable(driver, mailCheckbox);
		mailCheckbox.click();
	}
	
	public void clickDeleteAllButtonInHeader(){
		Waits.waitForElementToBeClickable(driver, gmailDeleteMailButton);
		gmailDeleteMailButton.click();
	}
	
	public void clickResetLink(){
		Waits.waitForElementToBeClickable(driver, resetPasswordEmail);
		clickGmailResetPasswordButton();
		clickGmailResetPasswordButton();
	}
	
	public void deleteAllEmailsAfterTest(WebDriver driver){
		clickMailCheckbox();
	    clickDeleteAllButtonInHeader();
	    
	}

	public void clickGmailUnlockEmail() {
		Waits.waitForElementToBeClickable(driver, unlockAccountEmail);
	   unlockAccountEmail.click();
		
	}

	public void clickUnlockAccountLinkInMail() {
		Waits.waitForElementToBeClickable(driver, unlockAccountLink );
	   unlockAccountLink.click();
		
	}
	
	
        
	}


