package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.GmailPage;
import pageObjects.KweekweekHeader;
import pageObjects.KweekweekHomepage;
import testData.Users;
import utils.Properties;
import utils.Waits;
import env.TestAppEnv;

public class BaseLoginTest {

	protected WebDriver driver;

    @BeforeMethod
    public void setup(){
    	Properties.setProperty();
		driver = new ChromeDriver();
		//driver = Properties.getFirefoxProfile();
		driver.manage().window().maximize();
		driver.get(TestAppEnv.getUrl());
		//driver.navigate().refresh();
		loginBeforeTest();
		
		}

    @AfterMethod
    public void tearDown(ITestResult result) {
    	
    	if (result.getName().contains("Mail")){
    		GmailPage gmailPage = PageFactory.initElements(driver, GmailPage.class);
    		driver.get("https://mail.google.com/mail/#inbox");
    		gmailPage.deleteAllEmailsAfterTest(driver);
    	}
		Waits.waitForSomeSeconds(3000);
      	driver.quit();
    }
    
    public void loginBeforeTest(){
    	KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.setLoginUsername(Users.NORMALUSER)
		                 .setLoginPassword(Users.NORMALPASSWORD)
		                 .clickLoginButtonOnLoginPopup();
    }
}
