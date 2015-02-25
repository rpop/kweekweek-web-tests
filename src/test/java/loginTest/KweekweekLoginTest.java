package loginTest;


import java.util.Iterator;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.FacebookPage;
import pageObjects.GmailPage;
import pageObjects.KweekweekEventPage;
import pageObjects.KweekweekHeader;
import pageObjects.KweekweekHomepage;
import testData.Users;
import utils.Iterations;
import utils.RandomStrings;
import utils.Waits;

import base.BaseTest;

public class KweekweekLoginTest extends BaseTest {
	 	
	@Test(enabled=true)
	public void openLoginPopupFromHeader(){
		KweekweekHeader kweekweekHeader = new PageFactory().initElements(driver, KweekweekHeader.class);
		KweekweekHomepage kweekweekHomepage = new PageFactory().initElements(driver, KweekweekHomepage.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.loginPasswordField);
		Assert.assertTrue(kweekweekHomepage.loginPasswordField.isDisplayed());
	}
	
	@Test 
	public void successfulLoginWithEmailWithRedirectToDashboard() {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = new PageFactory().initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.clickPasswordField();
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
	    kweekweekHomepage.clickLoginButtonOnLoginPopup();
	    Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.alertContainer);
	    Waits.waitForSomeSeconds(3000);
	    Assert.assertTrue(driver.getPageSource().contains("Logged in successfully")&& driver.getCurrentUrl().contains("dashboard#discover"));
	}
	@Test
	public void correctMessageWrongPassword(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.setLoginUsername("all4winning");
		kweekweekHomepage.setLoginPassword("incorrectPassword");
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
	}
	
	@Test
	public void correctMessageNoPassword() {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.setLoginUsername("all4winning");
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
	}
	@Test
	public void correctMessageNoUsername() {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.setLoginUsername("");
		kweekweekHomepage.setLoginPassword("12341234");
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
		
	}
	
	@Test
	public void correctMessageNoCredentials() {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
		
	}
	
	@Test
	public void correctMessageWrongCredentials() throws InterruptedException {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.setLoginUsername("incorrectUsername");
		kweekweekHomepage.setLoginPassword("incorrectPassword");
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
		
	}
	
	@Test 
	public void successfulLoginWithFacebook(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		FacebookPage facebookPage = PageFactory.initElements(driver, FacebookPage.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickLoginWithFacebook();
	    facebookPage.setFacebookLoginEmail(Users.getFacebookUser());
	    facebookPage.setFacebookLoginPassword(Users.getFacebookPassword());
	    facebookPage.clickFacebookLoginButton();
	    Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.alertContainer);
	    Assert.assertTrue(driver.getPageSource().contains("Logged in successfully"));
	}
	
	@Test
	public void checkThatInputFieldsAreHighlighted() {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		
		List<WebElement> elements = kweekweekHomepage.getFieldsToBeClickedOnLoginPopup();
		
		for (WebElement element : elements){
		
			kweekweekHomepage.clickOnEachElement(element);
			Waits.waitForSomeSeconds(3000);
		    String value = kweekweekHomepage.getCssValueForField(element);
		    Assert.assertEquals(value,"rgb(252, 206, 6)");
	}
	}
	
	@Test
	public void forgotPasswordMail() {
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver,KweekweekHeader.class);
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		GmailPage gmailPage = PageFactory.initElements(driver, GmailPage.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickForgotPasswordLink();
		kweekweekHomepage.enterEmailResetPassword("sanityautotest@gmail.com");
		kweekweekHomepage.clickResetPasswordSumitButton();
		gmailPage.getGmailLoginPage();
		gmailPage.loginToGmail("sanityautotest@gmail.com", "Pitech01");
		gmailPage.clickGmailResetPasswordEmail();
		gmailPage.clickGmailResetPasswordButton();
		Iterations.moveToNextWindow(driver);
		kweekweekHomepage.setNewPassword("123123");
		kweekweekHomepage.setNewPasswordConfirmation("123123");
		kweekweekHomepage.clickChangePassword();
		Waits.waitForSomeSeconds(2000);
		Assert.assertTrue(driver.getPageSource().contains("Password changed successfully. You are now logged in"));
		
	}
	
	@Test
	public void loginBeforeCheckout(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver,KweekweekHeader.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		kweekweekHomepage.clickEventModule();
		kweekweekEventPage.clickBookNowButtonOnEventPage();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(1000);
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully")&& driver.findElement(By.xpath("//h3[@class='modal-title']")).getText().contains("Book tickets"));
	}
	
	@Test
	public void loginBeforeWishlistOnBrowse(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		driver.get("http://staging.kweekweek.com/discover/all-categories/events");
		kweekweekHomepage.hoverOverPoster();
		kweekweekHomepage.clickWishlistButtonOnModule();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(1000);
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully")&& driver.getCurrentUrl().contains("staging.kweekweek.com/discover/all-categories/events"));
		
	}
	
	@Test
	public void loginBeforeWishlistOnEventPage(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		kweekweekHomepage.clickEventModule();
		kweekweekEventPage.clickWishlistButtonOnEventPage();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(1000);
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully")&& driver.getPageSource().contains("Wishlist"));
					
	}
	
	@Test
	public void loginBeforeClickingAttendees(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		kweekweekHomepage.clickEventModule();
		kweekweekEventPage.clickAttendeesHeader();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@class='modal-title']")).getText().contains("Attendees"));
			
	}
	
	@Test
	public void loginBeforeClickingFollowers(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		kweekweekHomepage.clickEventModule();
		kweekweekEventPage.clickFollowersOnEventPage();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, driver.findElement(By.xpath("//h3[@class='modal-title']")));
		Waits.waitForSomeSeconds(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@class='modal-title']")).getText().contains("Followers"));
	}
	
	@Test
	public void loginBeforeClickingContactHost(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		kweekweekHomepage.clickEventModule();
		kweekweekEventPage.clickContactHost();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, driver.findElement(By.xpath("//h3[@class='modal-title']")));
		Waits.waitForSomeSeconds(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@class='modal-title']")).getText().contains("Contact host"));
		
	}
	
	@Test
	public void loginBeforeClickingAddEvent(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickAddEventButton();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(3000);
		Waits.waitForVisibilityOfElement(driver, driver.findElement(By.xpath("//div[@class='action-buttons']")));
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully")&& driver.findElement(By.xpath("//div[@class='page-title']")).getText().contains("Create an event in")); 
		
	}
	
	@Test
	public void loginWithoutRedirectFromEventPage(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		kweekweekHomepage.clickEventModule();
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(2000);
		Waits.waitForVisibilityOfElement(driver, driver.findElement(By.xpath("//div[@class='title']")));
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully")&& driver.getPageSource().contains("Hosted by"));
	}
	
	@Test
	public void loginWithoutRedirectFromProfile(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		kweekweekHomepage.clickEventModule();
		kweekweekEventPage.clickOnHost();
		Waits.waitForSomeSeconds(1000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(2000);
		Waits.waitForVisibilityOfElement(driver, driver.findElement(By.xpath("//div[@class='js-contact-host']")));
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully")&& driver.getPageSource().contains("Host information"));
		
	}
	
	@Test
	public void loginWithUnconfirmedAccount(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickSignupButtonOnHeader();
		kweekweekHomepage.setFirstName("name");
		kweekweekHomepage.setLastName("last");
		String email = RandomStrings.generateRandomString(20);
		kweekweekHomepage.setEmailOnSignup(email);
		kweekweekHomepage.selectGender();
		kweekweekHomepage.selectDob("02/05/2014");
		kweekweekHomepage.setPasswordOnSignupPopup("123123");
		kweekweekHomepage.setConfirmPassword("123123");
		kweekweekHomepage.clickFirstNameField();
		Waits.waitForSomeSeconds(1000);
		kweekweekHomepage.clickSignupButtonOnRegisterPopup();
		Waits.waitForSomeSeconds(2000);
		kweekweekHomepage.closeConfirmPopup() ;
		Waits.waitForSomeSeconds(1000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.setLoginUsername(email);
		kweekweekHomepage.setLoginPassword("123123");
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		kweekweekHomepage.clickConfirmButtonOnConfirmationPopup();
		Waits.waitForSomeSeconds(2000);
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully"));
	}
	
	@Test
	public void successfullyLogOut(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(1000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser());
		kweekweekHomepage.setLoginPassword(Users.getNormalPassword());
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		//Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickSettingsButtonOnHeader();
		kweekweekHeader.clickLogOut();
		Assert.assertTrue(driver.getPageSource().contains("Logged out successfully"));
	}
	

	
	
	
}

