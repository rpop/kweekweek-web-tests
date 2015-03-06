package signupTest;

import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.KweekweekHeader;
import pageObjects.KweekweekHomepage;
import utils.RandomStrings;
import utils.Waits;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static testData.ErrorMessages.*;
import static testData.Users.*;
import static utils.Calendar.getCurrentDate;

/**
 * Created by vlad.tamas on 3/4/2015.
 */

public class SignupPozitiveTest extends BaseTest{

    @Test
    public void checkSignupErrorValidationsTest() {
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        kweekweekHeader.clickSignupButtonOnHeader();
        kweekweekHeader.clickSignUpButtonOnSignUpForm();
        assertThat(kweekweekHeader.getSignupAlertMessage(), equalTo(SIGNUP_ERROR_ALERT_TOP));
    }

    @Test
    public void checkMissingPasswordErrorValidationTest(){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        kweekweekHeader.clickSignupButtonOnHeader();
        Waits.waitForSomeSeconds(800);
        kweekweekHomePage.setFirstName(RandomStrings.generateRandomString(5))
                         .setLastName(RandomStrings.generateRandomString(7))
                         .setEmailOnSignup(EMAIL)
                         .selectGender()
                         .selectDob(getCurrentDate());
        Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignUpButtonOnSignUpForm();
        assertThat(kweekweekHeader.getSignupAlertMessage(), equalTo(SIGNUP_ERROR_ALERT_TOP));
    }

    @Test
    public void invalidLenghtPasswordErrorValidationTest(){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        Waits.waitForSomeSeconds(800);
        kweekweekHomePage.setFirstName(RandomStrings.generateRandomString(5))
                .setLastName(RandomStrings.generateRandomString(7))
                .setEmailOnSignup(RandomStrings.generateRandomEmailString(6))
                .selectGender()
                .selectDob(getCurrentDate())
                .setPasswordOnSignupPopup(SHORTPASS)
                .setConfirmPassword(SHORTPASS)
                .clickSignupButtonOnRegisterPopup();
        Waits.waitForSomeSeconds(1500);
        assertThat(kweekweekHomePage.getSignUpPasswError(), equalTo(SIGNUP_ERROR_SHORT_PASSW));
    }

    @Test
    public void signupEmailTakenErrorValidationTest(){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        Waits.waitForSomeSeconds(800);
        kweekweekHomePage.setFirstName(RandomStrings.generateRandomString(5))
                .setLastName(RandomStrings.generateRandomString(7))
                .setEmailOnSignup(LOCKEDEMAIL)
                .selectGender()
                .selectDob(getCurrentDate())
                .setPasswordOnSignupPopup(SHORTPASS)
                .setConfirmPassword(SHORTPASS)
                .clickSignupButtonOnRegisterPopup();
        Waits.waitForSomeSeconds(1500);
        assertThat(kweekweekHomePage.getSignUpEmailTakenError(), equalTo(SIGNUP_ERROR_TAKEN_EMAIL));
    }

    @Test
    public void succesfullSignUpWithEmailTest(){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        Waits.waitForSomeSeconds(800);
        kweekweekHomePage.setFirstName(RandomStrings.generateRandomString(5))
                .setLastName(RandomStrings.generateRandomString(7))
                .setEmailOnSignup(RandomStrings.generateRandomEmailString(6))
                .selectGender()
                .selectDob(getCurrentDate())
                .setPasswordOnSignupPopup(LOCKEDPASS)
                .setConfirmPassword(LOCKEDPASS)
                .clickSignupButtonOnRegisterPopup();
        Waits.waitForSomeSeconds(1500);
        assertThat(kweekweekHomePage.getSignUpConfirmationText(), equalTo("Sign up - confirmation"));
    }

    @DataProvider
    public Object[][] invalidPasswForSignUp(){
        return new Object[][]{
                {"123456", "123455", SIGNUP_ERROR_NOTMATCH_PASSW},
                {"123456", "", SIGNUP_ERROR_NOTMATCH_PASSW},
                {"", "", SIGNUP_ERROR_REQUIRED_PASSW},
                {"123", "123", SIGNUP_ERROR_SHORT_PASSW}
        };
    }

    @Test(dataProvider = "invalidPasswForSignUp")
    public void invalidPasswordErrorValidationTest(String passw, String confirmPassw, String errorMessage){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        Waits.waitForSomeSeconds(800);
        kweekweekHomePage.setFirstName(RandomStrings.generateRandomString(5))
                .setLastName(RandomStrings.generateRandomString(7))
                .setEmailOnSignup(RandomStrings.generateRandomEmailString(6))
                .selectGender()
                .selectDob(getCurrentDate())
                .setPasswordOnSignupPopup(passw)
                .setConfirmPassword(confirmPassw)
                .clickSignupButtonOnRegisterPopup();
        Waits.waitForSomeSeconds(1500);
        assertThat(kweekweekHomePage.getSignUpPasswError(), equalTo(errorMessage));
    }

}