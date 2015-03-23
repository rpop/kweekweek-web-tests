package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Waits;

import java.util.ArrayList;
import java.util.List;

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
    
	public KweekweekHomepage clickLoginButtonOnLoginPopup () {
		Waits.waitForElementToBeClickable(driver, loginButton);
		loginButton.click();
		return this;
		
	}
	
	public KweekweekHomepage clickUsernameField(){
		Waits.waitForElementToBeClickable(driver, loginUsernameField);
		loginUsernameField.click();
		return this;
	}
	
	public KweekweekHomepage setLoginUsername(String username){
		Waits.waitForElementToBeClickable(driver, loginUsernameField);
		loginUsernameField.clear();
		loginUsernameField.sendKeys(username);
		return this;
	}
	
	public KweekweekHomepage clickPasswordField(){
		Waits.waitForElementToBeClickable(driver, loginPasswordField );
		loginPasswordField.click();
		return this;
	}
	
	public KweekweekHomepage setLoginPassword(String password){
		Waits.waitForElementToBeClickable(driver, loginPasswordField);
		loginPasswordField.clear();
		loginPasswordField.sendKeys(password);
		return this;
	}

	public KweekweekHomepage clickLoginWithFacebook() {
		Waits.waitForElementToBeClickable(driver, loginWithFacebookButton);
		loginWithFacebookButton.click();
		return this;
	}
	
	public String getCssValueForField(WebElement element){
		Waits.waitForElementToBeClickable(driver, element);
		return element.getCssValue("border-color");
		
	}
	
	public KweekweekHomepage clickOnEachElement(WebElement element){
		Waits.waitForElementToBeClickable(driver, element);
		element.click();
		return this;
	}
	
	public List<WebElement> getFieldsToBeClickedOnLoginPopup(){
		List<WebElement> fieldsToBeClicked = new ArrayList<WebElement>();
		fieldsToBeClicked.add(loginUsernameField);
		fieldsToBeClicked.add(loginPasswordField);
		return fieldsToBeClicked;
		
	}

	public KweekweekHomepage clickForgotPasswordLink() {
		Waits.waitForElementToBeClickable(driver, forgotPasswordLink);
		forgotPasswordLink.click();
		return this;
	}

	public KweekweekHomepage enterEmailResetPassword(String emailToReset) {
		Waits.waitForElementToBeClickable(driver, resetPasswordEmailField);
		resetPasswordEmailField.clear();
		resetPasswordEmailField.sendKeys(emailToReset);
		return this;
	}

	public KweekweekHomepage clickResetPasswordSubmitButton() {
		Waits.waitForElementToBeClickable(driver,resetPasswordSubmitButton );
		resetPasswordSubmitButton.click();
		return this;
		
	}

	public KweekweekHomepage setNewPassword(String password) {
		Waits.waitForElementToBeClickable(driver, newPasswordField);
		newPasswordField.clear();
		newPasswordField.sendKeys(password);
		return this ;
	}
	
	public KweekweekHomepage setNewPasswordConfirmation (String password){
		Waits.waitForElementToBeClickable(driver,confirmNewPasswordField );
		confirmNewPasswordField.clear();
		confirmNewPasswordField.sendKeys(password);
		return this;
	}

	public KweekweekHomepage clickChangePassword() {
		Waits.waitForElementToBeClickable(driver, changePasswordButton);
		changePasswordButton.click();
		return this;
	}

	public KweekweekHomepage clickEventModule() {
		Waits.waitForElementToBeClickable(driver, eventModuleOnHomepage);
		eventModuleOnHomepage.click();
		return this;
	}
	
	public KweekweekHomepage hoverOverPoster (){
		Waits.waitForElementToBeClickable(driver, eventModuleOnHomepage);
		Actions action = new Actions(driver);
		//action.keyDown(Keys.PAGE_DOWN);
		action.moveToElement(eventModuleOnHomepage).build().perform();
       	return this;	
	}

	public KweekweekHomepage clickWishlistButtonOnModule() {
		Waits.waitForElementToBeClickable(driver, wishlistButtonOnModule);
		wishlistButtonOnModule.click();
		return this;
	}

	public KweekweekHomepage clickUserOnPoster() {
		Waits.waitForElementToBeClickable(driver, hostOnPoster);
		hostOnPoster.click();
		return this;
	}

	public  KweekweekHomepage setFirstName(String firstName) {
		Waits.waitForElementToBeClickable(driver, firstNameField);
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
		return this;
	}

	public KweekweekHomepage setLastName(String lastName) {
		Waits.waitForElementToBeClickable(driver, lastNameField);
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
		return this;
	}

	public KweekweekHomepage selectGender() {
		Waits.waitForElementToBeClickable(driver, genderExpandArrow);
		genderExpandArrow.click();
		Waits.waitForElementToBeClickable(driver, maleOption);
		maleOption.click();
		return this;
	}

	public KweekweekHomepage selectDob(String dateOfBirth) {
		Waits.waitForElementToBeClickable(driver, dobField);
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", dobField); 
		dobField.sendKeys(dateOfBirth);
		((JavascriptExecutor) driver).executeScript("arguments[0].deleteElement", dobField);
		dobField.sendKeys(Keys.RETURN);
		return this;
	}

	public KweekweekHomepage setPasswordOnSignupPopup(String password) {
		Waits.waitForElementToBeClickable(driver, passwordField);
		passwordField.clear();
		passwordField.sendKeys(password);
		return this;
	}

	public KweekweekHomepage setConfirmPassword(String confirmPassword) {
		Waits.waitForElementToBeClickable(driver, confirmPasswordFieldOnSignup);
		confirmPasswordFieldOnSignup.clear();
		confirmPasswordFieldOnSignup.sendKeys(confirmPassword);
		return this;
	}

	public KweekweekHomepage setEmailOnSignup(String emailOnSignup) {
		Waits.waitForElementToBeClickable(driver, emailFieldOnSignup);
		emailFieldOnSignup.clear();
		emailFieldOnSignup.sendKeys(emailOnSignup);
		return this;
	}

	public KweekweekHomepage clickConfirmButtonOnConfirmationPopup() {
		Waits.waitForElementToBeClickable(driver, confirmButton);
		confirmButton.click();
		return this;
	}

	public KweekweekHomepage clickSignupButtonOnRegisterPopup() {
		Waits.waitForElementToBeClickable(driver, signupButton);
		signupButton.click();
		return this;
	}

	public KweekweekHomepage closeConfirmPopup() {
		Waits.waitForElementToBeClickable(driver, closeConfirmPopupButton);
		closeConfirmPopupButton.click();
		return this;
	}
	
	public KweekweekHomepage clickFirstNameField() {
		Waits.waitForElementToBeClickable(driver, firstNameField);
	   	firstNameField.click();
	   	return this;
	}

	@FindBy (id="custom")
	private WebElement confirmationTextForAssert;

	public String getSignUpConfirmationText(){
		Waits.waitForVisibilityOfElement(driver, confirmationTextForAssert);
		return confirmationTextForAssert.getText();
	}

	@FindBy (xpath = "//div[@class='form-group password required user_password has-error']/span")
	private WebElement passwToShortError;

	public String getSignUpPasswError(){
		Waits.waitForVisibilityOfElement(driver, passwToShortError);
		return passwToShortError.getText();
	}

	@FindBy (xpath = "//div[@class='form-group email required user_email has-error']/span")
	private WebElement emailTakenError;

	public String getSignUpEmailTakenError(){
		Waits.waitForVisibilityOfElement(driver, emailTakenError);
		return emailTakenError.getText();
	}

	@FindBy (xpath = "//input[@class='btn btn btn-primary btn-login']")
	private WebElement confirmSignUpButton;

	public KweekweekHomepage clickConfirmSignUpButton() {
		Waits.waitForElementToBeClickable(driver, confirmSignUpButton);
		confirmSignUpButton.click();
		return this;
	}

	@FindBy (id="kwk_users_confirm_account_form_username")
	private WebElement usernameConfirmationField;

	public String getUsernameConfirmationValue(){
		//Waits.waitForVisibilityOfElement(driver, confirmationTextForAssert);
		return usernameConfirmationField.getText();
	}

	@FindBy (xpath = "//a[@class='primary-link']")
	private WebElement termsAndConditionsLinkOnSignupPopUp;

	public KweekweekHomepage clickTermsAndConditionsLinkOnSignupPopUp(){
		Waits.waitForElementToBeClickable(driver, termsAndConditionsLinkOnSignupPopUp);
		termsAndConditionsLinkOnSignupPopUp.click();
		return this;
	}

	public String getLoginWithFacebookButtonText(){
		Waits.waitForElementToBeClickable(driver, loginWithFacebookButton);
		return loginWithFacebookButton.getText();
	}

	@FindBy (xpath = "//a[@class='switchLink primary-link']")
	private WebElement loginLinkOnSignupPopUp;

	public KweekweekHomepage clickLoginLinkOnSignupPopUp(){
		Waits.waitForElementToBeClickable(driver, loginLinkOnSignupPopUp);
		loginLinkOnSignupPopUp.click();
		return this;
	}

	@FindBy (xpath = "//div[@class='modal-content']/div/button")
	private WebElement closeSignupPopUpButton;

	public KweekweekHomepage clickCloseSignupPopUpButton(){
		Waits.waitForElementToBeClickable(driver, closeSignupPopUpButton);
		closeSignupPopUpButton.click();
		return this;
	}

	public KweekweekHomepage selectDateOfBirth(String day, String month, String year){
		Waits.waitForElementToBeClickable(driver, dobField);
		dobField.click();
		Select yearSelection = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		yearSelection.selectByValue(year);
		Select monthSelection = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		monthSelection.selectByVisibleText(month);
		List<WebElement> taskList = driver.findElements(By.xpath("//a[contains(@href,'#')]"));
		for (WebElement element : taskList) {
			if (element.getText().contains(day)) {
				element.click();
				break;
			}
		}
		return this;
	}

	@FindBy (xpath = "//ul[@class='slides']/li[@class='flex-active-slide']")
	private WebElement homepageActiveSlider;

	@FindBy (css = ".flexslider>.flex-direction-nav>li")
	private WebElement sliderPreviousButton;

	public KweekweekHomepage clickSliderPreviousButton(){
		Waits.waitForVisibilityOfElement(driver, homepageActiveSlider);
		Actions action = new Actions(driver);
		action.moveToElement(homepageActiveSlider).build().perform();
		action.moveToElement(sliderPreviousButton).build().perform();
		action.click(sliderPreviousButton).build().perform();
		return this;
	}

	@FindBy (xpath = "//a[@class='flex-next']")
	private WebElement sliderNextButton;

	public KweekweekHomepage clickSliderNextButton(){
		Waits.waitForVisibilityOfElement(driver, homepageActiveSlider);
		Actions action = new Actions(driver);
		action.moveToElement(homepageActiveSlider).build().perform();
		action.moveToElement(sliderNextButton).build().perform();
		action.click(sliderNextButton).build().perform();
		return this;
	}

	@FindBy (xpath = "//ul[@class='slides']/li[@class='flex-active-slide']/div[@class='captionContainer']//a")
	private WebElement sliderHyperlinkedContainer;

	public KweekweekHomepage clickSliderHyperlinkedContainer(){
		Waits.waitForElementToBeClickable(driver, sliderHyperlinkedContainer);
		sliderHyperlinkedContainer.click();
		return this;
	}

	@FindBy (xpath = "//ul[@class='slides']/li[@class='flex-active-slide']/div[@class='captionContainer']//span[@class='provider-name']")
	private WebElement sliderHyperlinkedProviderName;

	public String getSliderHyperlinkedProviderName(){
		return sliderHyperlinkedProviderName.getText();
	}

	@FindBy (xpath = "//div[@class='box-header']/div")
	private WebElement eventProviderTitle;

	public String getEventProviderTitle(){
		return eventProviderTitle.getText();
	}

	@FindBy (xpath = "//ul[@class='flex-direction-nav']/li")
	private WebElement sliderPreviousButton2;

	public String getSliderPreviousButtonColorAtHover() {
		Waits.waitForVisibilityOfElement(driver, homepageActiveSlider);
		Actions action = new Actions(driver);
		action.moveToElement(homepageActiveSlider).build().perform();
		action.moveToElement(sliderPreviousButton).build().perform();
		//action.clickAndHold(sliderPreviousButton).build().perform();
		Waits.waitForSomeSeconds(3000);
		return sliderPreviousButton.getCssValue("color");
	}

	@FindBy (xpath = "//div[@class='events-section']/div[2]/div[7]//a")
	private WebElement seeMoreEventsTodayLink;

	@FindBy (xpath = "//div[@class='events-section']/div[5]/div[7]//a")
	private WebElement seeMoreEventsLatestLink;

	@FindBy (xpath = "//div[@class='events-section']/div[3]/div[7]//a")
	private WebElement seeMoreEventsTomorrowLink;

	public KweekweekHomepage clickSeeMoreEventsLink(String event){
		if (event.contains("latest")) {
			Waits.waitForElementToBeClickable(driver, seeMoreEventsLatestLink);
			seeMoreEventsLatestLink.click();
		}
		if (event.contains("today")) {
			Waits.waitForElementToBeClickable(driver, seeMoreEventsTodayLink);
			seeMoreEventsTodayLink.click();
		}
		if (event.contains("tomorrow")) {
			Waits.waitForElementToBeClickable(driver, seeMoreEventsTomorrowLink);
			seeMoreEventsTomorrowLink.click();
		}
		return this;
	}

	public KweekweekHomepage clickDiscoverEvents(String event){
		WebElement discoverEvents = driver.findElement(By.xpath("//div[@id='filters']/ul//a[@data-target='" +event+"']"));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN);
		action.moveToElement(discoverEvents).build().perform();
		action.click(discoverEvents).build().perform();
		return this;
	}

	@FindBy (xpath = "//div[@id='categories-link']/a")
	private WebElement categoriesDropDownBtn;

	public KweekweekHomepage clickCategoriesDropDownBtn(){
		Waits.waitForElementToBeClickable(driver, categoriesDropDownBtn);
		categoriesDropDownBtn.click();
		return this;
	}

	public KweekweekHomepage selectCategoryToBrowse(String category) {
		WebElement discoverEvents = driver.findElement(By.xpath("//div[@class='categ-item submenu']/ul//a[contains(text(), '" + category + "')]"));
		discoverEvents.click();
		return this;
	}

	@FindBy (css = ".col-sm-4.col-xs-6>figure>figcaption>p>a")
	private WebElement firstCategory;

	public String[] getCategoryColorAtHover() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN);
		String initialColor = firstCategory.getCssValue("background-color");
		action.moveToElement(firstCategory).build().perform();
		Waits.waitForSomeSeconds(1000);
		String afterHoverColor = firstCategory.getCssValue("background-color");
		String arrColor[] = {initialColor, afterHoverColor};
		return arrColor;
	}

	@FindBy (css = ".btn.btn-default.border-white.large")
	private WebElement howItWorksButton;

	public void clickHowItWorksButton() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN);
		Waits.waitForElementToBeClickable(driver, howItWorksButton);
		action.click(howItWorksButton).build().perform();
		Waits.waitForSomeSeconds(3500);
	}

	public List getDownloadAppsExternalLinks(WebDriver driver){
		List<WebElement> elementList = new ArrayList();
		elementList = driver.findElements(By.xpath("//div[@class='download-links']//a"));
		List<WebElement> finalList = new ArrayList();
		for (WebElement element : elementList)
		{
			if (element.getAttribute("href") != null){
				finalList.add(element);
			}
		}
		return finalList;
	}

	@FindBy (css = "#query_text")
	private WebElement searchField;

	public KweekweekHomepage clickSearchField(){
		Waits.waitForElementToBeClickable(driver, searchField);
		searchField.click();
		return this;
	}

	@FindBy (xpath = "//div[@id='query_area']/div/ul/li/a")
	private WebElement searchFieldAllEvents;

	public KweekweekHomepage clickSearchFieldAllEvents(){
		Waits.waitForElementToBeClickable(driver, searchFieldAllEvents);
		searchFieldAllEvents.click();
		return this;
	}
}