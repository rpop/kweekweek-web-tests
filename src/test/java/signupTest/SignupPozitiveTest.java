package signupTest;

import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
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
        kweekweekHeader.enterFirstNameOnSingUpField(RandomStrings.generateRandomString(5));
        kweekweekHeader.enterLastNameOnSingUpField(RandomStrings.generateRandomString(6));
        kweekweekHeader.enterEmailOnSingUpField(EMAIL);
       // kweekweekHeader.selectGenderOnSignUpForm(GENDER_M);
        kweekweekHomePage.selectGender()
                .selectDob(getCurrentDate());
        assertThat(kweekweekHeader.getSignupAlertMessage(), equalTo(SIGNUP_ERROR_ALERT));
    }

    @Test
    public void succesfullSignUpWithEmail(){

    }
}
