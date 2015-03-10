package signupTest;

import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.KweekweekHeader;
import pageObjects.KweekweekHomepage;
import utils.RandomStrings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static testData.ErrorMessages.*;
import static testData.Users.NORMALPASSWORD;
import static utils.Calendar.getCurrentDate;

/**
 * Created by vlad.tamas on 3/9/2015.
 */
public class SignupNegativeTest extends BaseTest {
    @Test
    public void checkSignupErrorValidationsTest() {
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        kweekweekHeader.clickSignupButtonOnHeader();
        //Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignUpButtonOnSignUpForm();
        assertThat(kweekweekHeader.getSignupAlertMessage(), equalTo(SIGNUP_ERROR_ALERT_TOP));
    }

    @DataProvider
    public Object[][] invalidEmailForSignUp(){
        return new Object[][]{
                {"vlad.tamas@pitechnologies.ro", SIGNUP_ERROR_TAKEN_EMAIL},
                {"s1w2gf3a45a6c", SIGNUP_ERROR_INVALID_EMAIL},
                {"Vlad@", SIGNUP_ERROR_INVALID_EMAIL},
                {"@gmail.com", SIGNUP_ERROR_INVALID_EMAIL},
                {"name@gmail..com", SIGNUP_ERROR_INVALID_EMAIL},
                {"name.. @gmail.com", SIGNUP_ERROR_INVALID_EMAIL},
                {"name@192.168.1.1.0", SIGNUP_ERROR_INVALID_EMAIL},
                {"Vlad@yahoocom", SIGNUP_ERROR_INVALID_EMAIL}
        };
    }

    @Test(dataProvider = "invalidEmailForSignUp")
    public void signupEmailTakenErrorValidationTest(String email, String errorMessage){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        //Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        //Waits.waitForSomeSeconds(800);
        kweekweekHomePage.setFirstName(RandomStrings.generateRandomString(5))
                .setLastName(RandomStrings.generateRandomString(7))
                .setEmailOnSignup(email)
                .selectGender()
                .selectDob(getCurrentDate())
                .setPasswordOnSignupPopup(NORMALPASSWORD)
                .setConfirmPassword(NORMALPASSWORD)
                .clickSignupButtonOnRegisterPopup();
        //Waits.waitForSomeSeconds(1500);
        assertThat(kweekweekHomePage.getSignUpEmailTakenError(), equalTo(errorMessage));
    }

    @DataProvider
    public Object[][] invalidPasswForSignUp(){
        return new Object[][]{
                {"123456", "123455", SIGNUP_ERROR_NOTMATCH_PASSW},
                {"123456", "", SIGNUP_ERROR_NOTMATCH_PASSW},
                {"", "", SIGNUP_ERROR_REQUIRED_PASSW},
                {"", "123456", SIGNUP_ERROR_REQUIRED_PASSW},
                {"123", "123", SIGNUP_ERROR_SHORT_PASSW}
        };
    }

    @Test(dataProvider = "invalidPasswForSignUp")
    public void invalidPasswordErrorValidationTest(String passw, String confirmPassw, String errorMessage){
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        //Waits.waitForSomeSeconds(800);
        kweekweekHeader.clickSignupButtonOnHeader();
        //Waits.waitForSomeSeconds(800);
        kweekweekHomePage.setFirstName(RandomStrings.generateRandomString(5))
                .setLastName(RandomStrings.generateRandomString(7))
                .setEmailOnSignup(RandomStrings.generateRandomEmailString(6))
                .selectGender()
                .selectDob(getCurrentDate())
                .setPasswordOnSignupPopup(passw)
                .setConfirmPassword(confirmPassw)
                .clickSignupButtonOnRegisterPopup();
        //Waits.waitForSomeSeconds(1500);
        assertThat(kweekweekHomePage.getSignUpPasswError(), equalTo(errorMessage));
    }
}