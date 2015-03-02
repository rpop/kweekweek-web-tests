package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomStrings;
import utils.Waits;

public class KweekweekHomepage {
	
	private WebDriver driver ;
	
	public KweekweekHomepage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy (name="commit")
	private WebElement loginButton;
	@FindBy (id="user_password")
	public WebElement loginPasswordField;
	@FindBy (id="user_login")
	public WebElement loginUsernameField;
    @FindBy(xpath="//a[@class='login-facebook']")
	private WebElement loginWithFacebookButton;
    @FindBy(id="alert-container")
    public WebElement alertContainer;
    @FindBy (xpath="//div[@class='alert alert-error col-lg-12 col-md-12 col-sm-12 col-xs-12']")
    public WebElement errorAlert;
    @FindBy (xpath="//a[@href='/users/password/new']")
	private WebElement forgotPasswordLink;
    @FindBy (id="user_email")
	private WebElement resetPasswordEmailField;
    @FindBy (name="commit")
	private WebElement resetPasswordSubmitButton;
    @FindBy (name="user[password]")
	private WebElement newPasswordField;
    @FindBy (name="user[password_confirmation]")
    private WebElement confirmNewPasswordField;
    @FindBy(name="commit")
	private WebElement changePasswordButton;
    @FindBy (xpath="//div[@data-filter='featured']/figure/a")
	private WebElement eventModuleOnHomepage;
    @FindBy (xpath="//a[@class='vector like icon-enjoy js-wishlist']")
	private WebElement wishlistButtonOnModule;
    @FindBy (xpath="//p[@class='vector icon-user']")
	private WebElement hostOnPoster;
    @FindBy (id = "user_forename")
	private WebElement firstNameField;
    @FindBy (id="user_surname")
	private WebElement lastNameField;
    @FindBy (xpath="//div[@class='select2-result-label']")
	private WebElement maleOption;
    @FindBy (xpath = "//span[@class='select2-arrow']")
    private WebElement genderExpandArrow;
    @FindBy (id = "user_birthday")
	private WebElement dobField;
    @FindBy (id="user_password")
	private WebElement passwordField;
    @FindBy (id="user_password_confirmation")
	private WebElement confirmPasswordFieldOnSignup;
    @FindBy (id="user_email")
	private WebElement emailFieldOnSignup;
    @FindBy (xpath="//form[@id='new_kwk_users_confirm_account_form']/div[@id='action-buttons']/input[@value='Confirm']")
	private WebElement confirmButton;
    @FindBy (xpath="//form[@id='new_user']//input[@type='submit']")
	private WebElement signupButton;
    @FindBy (xpath = "//div[@class='modal-header']/button[@type='button']")
	private WebElement closeConfirmPopupButton;
	
	
	public WebElement getElementFromHomepageClass(WebElement element){
		return element;
	}
    
	public void clickLoginButtonOnLoginPopup () {
		Waits.waitForElementToBeClickable(driver, loginButton);
		loginButton.click();
		
	}
	
	public void clickUsernameField(){
		Waits.waitForElementToBeClickable(driver, loginUsernameField);
		loginUsernameField.click();
	}
	
	public void setLoginUsername(String username){
		Waits.waitForElementToBeClickable(driver, loginUsernameField);
		loginUsernameField.clear();
		loginUsernameField.sendKeys(username);
	}
	
	public void clickPasswordField(){
		Waits.waitForElementToBeClickable(driver, loginPasswordField );
		loginPasswordField.click();
	}
	
	public void setLoginPassword(String password){
		Waits.waitForElementToBeClickable(driver, loginPasswordField);
		loginPasswordField.clear();
		loginPasswordField.sendKeys(password);
	}

	public void clickLoginWithFacebook() {
		Waits.waitForElementToBeClickable(driver, loginWithFacebookButton);
		loginWithFacebookButton.click();
    }
	
	public String getCssValueForField(WebElement element){
		Waits.waitForElementToBeClickable(driver, element);
		return element.getCssValue("border-color");
		
	}
	
	public void clickOnEachElement(WebElement element){
		Waits.waitForElementToBeClickable(driver, element);
		element.click();
	}
	
	public List<WebElement> getFieldsToBeClickedOnLoginPopup(){
		List<WebElement> fieldsToBeClicked = new ArrayList<WebElement>();
		fieldsToBeClicked.add(loginUsernameField);
		fieldsToBeClicked.add(loginPasswordField);
		return fieldsToBeClicked;
		
	}

	public void clickForgotPasswordLink() {
		Waits.waitForElementToBeClickable(driver, forgotPasswordLink);
		forgotPasswordLink.click();
	}

	public void enterEmailResetPassword(String emailToReset) {
		Waits.waitForElementToBeClickable(driver, resetPasswordEmailField);
		resetPasswordEmailField.clear();
		resetPasswordEmailField.sendKeys(emailToReset);
		
	}

	public void clickResetPasswordSubmitButton() {
		Waits.waitForElementToBeClickable(driver,resetPasswordSubmitButton );
		resetPasswordSubmitButton.click();
		
	}

	public void setNewPassword(String password) {
		Waits.waitForElementToBeClickable(driver, newPasswordField);
		newPasswordField.clear();
		newPasswordField.sendKeys(password);
		
	}
	
	public void setNewPasswordConfirmation (String password){
		Waits.waitForElementToBeClickable(driver,confirmNewPasswordField );
		confirmNewPasswordField.clear();
		confirmNewPasswordField.sendKeys(password);
	}

	public void clickChangePassword() {
		Waits.waitForElementToBeClickable(driver, changePasswordButton);
		changePasswordButton.click();
		
	}

	public void clickEventModule() {
		Waits.waitForElementToBeClickable(driver, eventModuleOnHomepage);
		eventModuleOnHomepage.click();
		
	}
	
	public void hoverOverPoster (){
		Waits.waitForElementToBeClickable(driver, eventModuleOnHomepage);
		Actions action = new Actions(driver);
		//action.keyDown(Keys.PAGE_DOWN);
		action.moveToElement(eventModuleOnHomepage).build().perform();
       		
	}

	public void clickWishlistButtonOnModule() {
		Waits.waitForElementToBeClickable(driver, wishlistButtonOnModule);
		wishlistButtonOnModule.click();
		
	}

	public void clickUserOnPoster() {
		Waits.waitForElementToBeClickable(driver, hostOnPoster);
		hostOnPoster.click();
	}

	public  void setFirstName(String firstName) {
		Waits.waitForElementToBeClickable(driver, firstNameField);
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		Waits.waitForElementToBeClickable(driver, lastNameField);
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
	}

	public void selectGender() {
		Waits.waitForElementToBeClickable(driver, genderExpandArrow);
		genderExpandArrow.click();
		Waits.waitForElementToBeClickable(driver, maleOption);
		maleOption.click();
		
	}

	public void selectDob(String dateOfBirth) {
		Waits.waitForElementToBeClickable(driver, dobField);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", dobField); 
		dobField.sendKeys(dateOfBirth);
		((JavascriptExecutor) driver).executeScript("arguments[0].deleteElement", dobField); 
		
	}

	public void setPasswordOnSignupPopup(String password) {
		Waits.waitForElementToBeClickable(driver, passwordField);
		passwordField.clear();
		passwordField.sendKeys(password);
		
	}

	public void setConfirmPassword(String confirmPassword) {
		Waits.waitForElementToBeClickable(driver, confirmPasswordFieldOnSignup);
		confirmPasswordFieldOnSignup.clear();
		confirmPasswordFieldOnSignup.sendKeys(confirmPassword);
		
	}

	public void setEmailOnSignup(String emailOnSignup) {
		Waits.waitForElementToBeClickable(driver, emailFieldOnSignup);
		emailFieldOnSignup.clear();
		emailFieldOnSignup.sendKeys(emailOnSignup);
		
	}

	public void clickConfirmButtonOnConfirmationPopup() {
		Waits.waitForElementToBeClickable(driver, confirmButton);
		confirmButton.click();
		
	}

	public void clickSignupButtonOnRegisterPopup() {
		Waits.waitForElementToBeClickable(driver, signupButton);
		signupButton.click();
		
	}

	public void closeConfirmPopup() {
		Waits.waitForElementToBeClickable(driver, closeConfirmPopupButton);
		closeConfirmPopupButton.click();
		
	}
	
	public void clickFirstNameField() {
		
		Waits.waitForElementToBeClickable(driver, firstNameField);
	   firstNameField.click();
	}
	
 
	
	
	
	

}