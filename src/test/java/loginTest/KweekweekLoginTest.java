package loginTest;


import base.BaseTest;
import env.TestAppEnv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testData.Users;
import utils.Iterations;
import utils.RandomStrings;
import utils.Waits;

import java.util.List;

public class KweekweekLoginTest extends BaseTest {
	 	
	@Test(enabled=true)
	public void openLoginPopupFromHeader(){
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.loginPasswordField);
		Assert.assertTrue(kweekweekHomepage.loginPasswordField.isDisplayed());
	}
	
	@Test 
	public void successfulLoginWithEmailWithRedirectToDashboard() {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader =  PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField()
						 .setLoginUsername(Users.getNormalUser())
						 .clickPasswordField()
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
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
		kweekweekHomepage.clickUsernameField()
		                 .setLoginUsername("all4winning")
						 .setLoginPassword("incorrectPassword")
						 .clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
	}
	
	@Test
	public void correctMessageNoPassword() {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField()
						 .setLoginUsername("all4winning")
						 .clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
	}
	@Test
	public void correctMessageNoUsername(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField()
						 .setLoginUsername("")
						 .setLoginPassword("12341234")
						 .clickLoginButtonOnLoginPopup();
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
		kweekweekHomepage.clickUsernameField()
						 .setLoginUsername("incorrectUsername")
						 .setLoginPassword("incorrectPassword")
						 .clickLoginButtonOnLoginPopup();
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
	    facebookPage.setFacebookLoginEmail(Users.getFacebookUser())
	    			.setFacebookLoginPassword(Users.getFacebookPassword())
	    			.clickFacebookLoginButton();
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
		kweekweekHomepage.clickForgotPasswordLink()
						 .enterEmailResetPassword("sanityautotest@gmail.com")
						 .clickResetPasswordSubmitButton();
		gmailPage.getGmailLoginPage()
				 .loginToGmail("sanityautotest@gmail.com", "Pitech01")
			     .clickGmailResetPasswordEmail()
			     .clickGmailResetPasswordButton();
		Iterations.moveToNextWindow(driver);
		kweekweekHomepage.setNewPassword("123123")
						 .setNewPasswordConfirmation("123123")
						 .clickChangePassword();
		Waits.waitForSomeSeconds(2000);
		Assert.assertTrue(driver.getPageSource().contains("Password changed successfully. You are now logged in"));
		
	}
	
	@Test
	public void loginBeforeCheckout(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver,KweekweekHeader.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver,KweekweekBrowsePage.class);
		//Waits.waitForSomeSeconds(500);
		//UtilityActions.scrollWithJsExecutor(driver, driver.findElement(By.xpath("//a[@class='boxLink']")));
		driver.get(TestAppEnv.getUrl() + "/discover/all-categories/events");
		kweekweekBrowsePage.clickEventOnBrowsePage();
		kweekweekEventPage.clickBookNowButtonOnEventPage();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser())
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(1000);
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully")&& driver.findElement(By.xpath("//h3[@class='modal-title']")).getText().contains("Book tickets"));
	}
	
	@Test
	public void loginBeforeWishlistOnBrowse(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
		driver.get(TestAppEnv.getUrl() + "/discover/all-categories/events");
		kweekweekBrowsePage.hoverOverPosterOnBrowsePage();
		kweekweekHomepage.clickWishlistButtonOnModule()
						 .setLoginUsername(Users.getNormalUser())
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(1000);
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully")&& driver.getCurrentUrl().contains("staging.kweekweek.com/discover/all-categories/events"));
		
	}
	
	@Test
	public void loginBeforeWishlistOnEventPage(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
		driver.get(TestAppEnv.getUrl() + "/discover/all-categories/events");
		kweekweekBrowsePage.clickEventOnBrowsePage();
		kweekweekEventPage.clickWishlistButtonOnEventPage();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser())
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(1000);
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully")&& driver.getPageSource().contains("Wishlist"));
					
	}
	
	@Test
	public void loginBeforeClickingAttendees(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		kweekweekHomepage.clickEventModule();
		kweekweekEventPage.clickAttendeesHeader();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser())
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[@class='modal-title']")).getText().contains("Attendees"));
			
	}
	
	@Test
	public void loginBeforeClickingFollowers(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
		kweekweekHomepage.clickEventModule();
		kweekweekEventPage.clickFollowersOnEventPage();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser())
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
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
		kweekweekHomepage.setLoginUsername(Users.getNormalUser())
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
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
		kweekweekHomepage.setLoginUsername(Users.getNormalUser())
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
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
		kweekweekHomepage.setLoginUsername(Users.getNormalUser())
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
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
		kweekweekHomepage.setLoginUsername(Users.getNormalUser())
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
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
		kweekweekHomepage.setEmailOnSignup(email)
						 .selectGender()
						 .selectDob("02/05/2014")
						 .setPasswordOnSignupPopup("123123")
						 .setConfirmPassword("123123")
						 .clickFirstNameField();
		Waits.waitForSomeSeconds(1000);
		kweekweekHomepage.clickSignupButtonOnRegisterPopup();
		Waits.waitForSomeSeconds(2000);
		kweekweekHomepage.closeConfirmPopup() ;
		Waits.waitForSomeSeconds(1000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.setLoginUsername(email)
						 .setLoginPassword("123123")
						 .clickLoginButtonOnLoginPopup()
						 .clickConfirmButtonOnConfirmationPopup();
		Waits.waitForSomeSeconds(2000);
		Assert.assertTrue(driver.getPageSource().contains("Logged in successfully"));
	}
	
	@Test
	public void successfullyLogOut(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		Waits.waitForSomeSeconds(1000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.setLoginUsername(Users.getNormalUser())
						 .setLoginPassword(Users.getNormalPassword())
						 .clickLoginButtonOnLoginPopup();
		Waits.waitForSomeSeconds(2000);
		kweekweekHeader.clickSettingsButtonOnHeader();
		kweekweekHeader.clickLogOut();
		Assert.assertTrue(driver.getPageSource().contains("Logged out successfully"));
	}
	
	@Test 
	public void unlockAccountFromUnlockMail(){
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		GmailPage gmailPage = PageFactory.initElements(driver, GmailPage.class);
		Waits.waitForSomeSeconds(1000);
		kweekweekHeader.clickLoginButtonFromHeader();
		for (int i = 0; i < 12; i++) {
				//Waits.waitForSomeSeconds(500);
				kweekweekHomepage.setLoginUsername(Users.LOCKEDUSER);
				//Waits.waitForSomeSeconds(500);
				kweekweekHomepage.setLoginPassword("randomshitsdgsds");
				//Waits.waitForSomeSeconds(500);
				kweekweekHomepage.clickLoginButtonOnLoginPopup();
				Waits.waitForSomeSeconds(500);
		}
		gmailPage.getGmailLoginPage()
				 .loginToGmail("sanityautotest@gmail.com", "Pitech01")
				 .clickGmailUnlockEmail()
				 .clickUnlockAccountLinkInMail();
		Iterations.moveToNextWindow(driver);
		kweekweekHomepage.setLoginUsername(Users.LOCKEDUSER)
						 .setLoginPassword(Users.LOCKEDPASS)
						 .clickLoginButtonOnLoginPopup();
		
		
	}
	

	
	
	
}

