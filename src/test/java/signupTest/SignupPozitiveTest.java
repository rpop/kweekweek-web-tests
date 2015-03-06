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
import static testData.ErrorMessages.SIGNUP_ERROR_ALERT;
import static testData.Users.EMAIL;
import static testData.Users.LOCKEDPASS;
import static utils.Calendar.getCurrentDate;

/**
 * Created by vlad.tamas on 3/4/2015.
 */

public class SignupPozitiveTest extends BaseTest{

    @Test
    public void checkSignupErrorValidations() {
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        kweekweekHeader.clickSignupButtonOnHeader();
        kweekweekHeader.clickSignUpButtonOnSignUpForm();
        assertThat(kweekweekHeader.getSignupAlertMessage(), equalTo(SIGNUP_ERROR_ALERT));
    }

    @Test
    public void checkMissingPasswordErrorValidations(){
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
        assertThat(kweekweekHeader.getSignupAlertMessage(), equalTo(SIGNUP_ERROR_ALERT));
    }

    @Test
    public void succesfullSignUpWithEmail(){
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
    public Object[][] invalidDataForSignUp(){
        return new Object[][]{
                {"as", "123"},
                {"", ""},
                {"", "pitech123"},
                {"lpa", ""}
        };
    }
}