package signupTest;

import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.FacebookPage;
import pageObjects.KweekweekHeader;
import pageObjects.KweekweekHomepage;
import utils.RandomStrings;
import utils.Waits;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static testData.Users.*;
import static utils.Calendar.getCurrentDate;

/**
 * Created by vlad.tamas on 3/4/2015.
 */

public class SignupPozitiveTest extends BaseTest{

    @Test
    public void reachConfirmationSignUpWithEmailTest(){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        //Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
       // Waits.waitForPartialTextInElement(driver, 10, By.xpath("//a[@class='login-facebook']"), "Sign up with");
      //  Waits.waitForSomeSeconds(800);
        kweekweekHomePage.setFirstName(RandomStrings.generateRandomString(5))
                         .setLastName(RandomStrings.generateRandomString(7))
                         .setEmailOnSignup(RandomStrings.generateRandomEmailString(6))
                         .selectGender()
                         .selectDob(getCurrentDate())
                         .setPasswordOnSignupPopup(LOCKEDPASS)
                         .setConfirmPassword(LOCKEDPASS)
                         .clickSignupButtonOnRegisterPopup();
        Waits.waitForSomeSeconds(2000);
        assertThat(kweekweekHomePage.getSignUpConfirmationText(), equalTo("Sign up - confirmation"));
    }

    @Test
    public void succesfullSignUpWithEmailTest(){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
       // Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        //Waits.waitForSomeSeconds(800);
        kweekweekHomePage.setFirstName(RandomStrings.generateRandomString(5))
                         .setLastName(RandomStrings.generateRandomString(7))
                         .setEmailOnSignup(RandomStrings.generateRandomEmailString(6))
                         .selectGender()
                         .selectDob(getCurrentDate())
                         .setPasswordOnSignupPopup(LOCKEDPASS)
                         .setConfirmPassword(LOCKEDPASS)
                         .clickSignupButtonOnRegisterPopup();
        //Waits.waitForSomeSeconds(2000);
        String username = kweekweekHomePage.getUsernameConfirmationValue();
        kweekweekHomePage.clickConfirmSignUpButton();
        //Waits.waitForSomeSeconds(2000);
        assertThat(driver.getPageSource().contains(username), is(true));
    }

    @Test
    public void checkTermsAndConditionsLinkOnSignupPopupTest(){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        //Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        //Waits.waitForSomeSeconds(2000);
        kweekweekHomePage.clickTermsAndConditionsLinkOnSignupPopUp();
        assertThat(driver.getCurrentUrl().contains("pages/terms"), is(true));
    }

    @Test
    public void checkLoginLinkOnSignupPopupTest(){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        //Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        //Waits.waitForSomeSeconds(2000);
        kweekweekHomePage.clickLoginLinkOnSignupPopUp();
        assertThat(kweekweekHomePage.getLoginWithFacebookButtonText(), equalTo("Sign up with Facebook"));
    }

    @Test(enabled = false)
    public void successfulSignUpWithFacebookTest(){
        KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        FacebookPage facebookPage = PageFactory.initElements(driver, FacebookPage.class);
        //Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        //Waits.waitForSomeSeconds(2000);
        kweekweekHomepage.clickLoginWithFacebook();
        facebookPage.setFacebookLoginEmail(FACEBOOKUSER1)
                    .setFacebookLoginPassword(FACEBOOKPASSWORD1)
                    .clickFacebookLoginButton();
        Waits.waitForSomeSeconds(2000);
        String username = kweekweekHomepage.getUsernameConfirmationValue();
        kweekweekHomepage.clickConfirmSignUpButton();
        Waits.waitForSomeSeconds(2000);
        assertThat(driver.getPageSource().contains(username), is(true));
    }

    @Test
    public void closeSignUpPopupTest(){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        //Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        //Waits.waitForSomeSeconds(2000);
        kweekweekHomePage.clickCloseSignupPopUpButton();
        Waits.waitForSomeSeconds(500);
        assertThat(driver.getPageSource().contains("Sign up with Facebook"), is(false));
    }

    @Test
    public void Test(){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        //Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        //Waits.waitForSomeSeconds(2000);
        kweekweekHomePage.selectDateOfBirth("25", "April", "1980");
    }
}