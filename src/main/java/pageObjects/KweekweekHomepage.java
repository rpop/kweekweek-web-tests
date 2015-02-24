package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomStrings;
import utils.Waits;

public class KweekweekHomepage {
	
	WebDriver driver ;
	
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
    @FindBy (xpath="//a[@class='boxLink']")
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
	
	
	
	public void clickLoginButtonOnLoginPopup () {
		Waits.waitForVisibilityOfElement(driver, loginButton);
		loginButton.click();
		
	}
	
	public void clickUsernameField(){
		Waits.waitForVisibilityOfElement(driver, loginUsernameField);
		loginUsernameField.click();
	}
	
	public void setLoginUsername(String username){
		Waits.waitForVisibilityOfElement(driver, loginUsernameField);
		loginUsernameField.clear();
		loginUsernameField.sendKeys(username);
	}
	
	public void clickPasswordField(){
		Waits.waitForVisibilityOfElement(driver, loginPasswordField );
		loginPasswordField.click();
	}
	
	public void setLoginPassword(String password){
		Waits.waitForVisibilityOfElement(driver, loginPasswordField);
		loginPasswordField.clear();
		loginPasswordField.sendKeys(password);
	}

	public void clickLoginWithFacebook() {
		Waits.waitForVisibilityOfElement(driver, loginWithFacebookButton);
		loginWithFacebookButton.click();
    }
	
	public String getCssValueForField(WebElement element){
		Waits.waitForVisibilityOfElement(driver, element);
		return element.getCssValue("border-color");
		
	}
	
	public void clickOnEachElement(WebElement element){
		Waits.waitForVisibilityOfElement(driver, element);
		element.click();
	}
	
	public List<WebElement> getFieldsToBeClickedOnLoginPopup(){
		List<WebElement> fieldsToBeClicked = new ArrayList<WebElement>();
		fieldsToBeClicked.add(loginUsernameField);
		fieldsToBeClicked.add(loginPasswordField);
		return fieldsToBeClicked;
		
	}

	public void clickForgotPasswordLink() {
		Waits.waitForVisibilityOfElement(driver, forgotPasswordLink);
		forgotPasswordLink.click();
	}

	public void enterEmailResetPassword(String emailToReset) {
		Waits.waitForVisibilityOfElement(driver, resetPasswordEmailField);
		resetPasswordEmailField.clear();
		resetPasswordEmailField.sendKeys(emailToReset);
		
	}

	public void clickResetPasswordSumitButton() {
		Waits.waitForVisibilityOfElement(driver,resetPasswordSubmitButton );
		resetPasswordSubmitButton.click();
		
	}

	public void setNewPassword(String password) {
		Waits.waitForVisibilityOfElement(driver, newPasswordField);
		newPasswordField.clear();
		newPasswordField.sendKeys(password);
		
	}
	
	public void setNewPasswordConfirmation (String password){
		Waits.waitForVisibilityOfElement(driver,confirmNewPasswordField );
		confirmNewPasswordField.clear();
		confirmNewPasswordField.sendKeys(password);
	}

	public void clickChangePassword() {
		Waits.waitForVisibilityOfElement(driver, changePasswordButton);
		changePasswordButton.click();
		
	}

	public void clickEventModule() {
		Waits.waitForVisibilityOfElement(driver, eventModuleOnHomepage);
		eventModuleOnHomepage.click();
		
	}
	
	public void hoverOverPoster (){
	    Waits.waitForVisibilityOfElement(driver, eventModuleOnHomepage);
		Actions action = new Actions(driver);
		action.moveToElement(eventModuleOnHomepage).build().perform();
       		
	}

	public void clickWishlistButtonOnModule() {
		Waits.waitForVisibilityOfElement(driver, wishlistButtonOnModule);
		wishlistButtonOnModule.click();
		
	}

	public void clickUserOnPoster() {
		Waits.waitForVisibilityOfElement(driver, hostOnPoster);
		hostOnPoster.click();
	}

	public  void setFirstName(String firstName) {
		Waits.waitForVisibilityOfElement(driver, firstNameField);
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		Waits.waitForVisibilityOfElement(driver, lastNameField);
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
	}

	public void selectGender() {
		Waits.waitForVisibilityOfElement(driver, genderExpandArrow);
		genderExpandArrow.click();
		Waits.waitForVisibilityOfElement(driver, maleOption);
		maleOption.click();
		
	}

	public void selectDob(String dateOfBirth) {
		Waits.waitForVisibilityOfElement(driver, dobField);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", dobField); 
		dobField.sendKeys(dateOfBirth);
		((JavascriptExecutor) driver).executeScript("arguments[0].deleteElement", dobField); 
		
	}

	public void setPasswordOnSignupPopup(String password) {
		Waits.waitForVisibilityOfElement(driver, passwordField);
		passwordField.clear();
		passwordField.sendKeys(password);
		
	}

	public void setConfirmPassword(String confirmPassword) {
		Waits.waitForVisibilityOfElement(driver, confirmPasswordFieldOnSignup);
		confirmPasswordFieldOnSignup.clear();
		confirmPasswordFieldOnSignup.sendKeys(confirmPassword);
		
	}

	public void setEmailOnSignup(String emailOnSignup) {
		Waits.waitForVisibilityOfElement(driver, emailFieldOnSignup);
		emailFieldOnSignup.clear();
		emailFieldOnSignup.sendKeys(emailOnSignup);
		
	}

	public void clickConfirmButtonOnConfirmationPopup() {
		Waits.waitForVisibilityOfElement(driver, confirmButton);
		confirmButton.click();
		
	}

	public void clickSignupButtonOnRegisterPopup() {
		Waits.waitForVisibilityOfElement(driver, signupButton);
		signupButton.click();
		
	}

	public void closeConfirmPopup() {
		Waits.waitForVisibilityOfElement(driver, closeConfirmPopupButton);
		closeConfirmPopupButton.click();
		
	}
	
	public void clickFirstNameField() {
		
	   Waits.waitForVisibilityOfElement(driver, firstNameField);
	   firstNameField.click();
	}
	
 
	
	
	
	

}