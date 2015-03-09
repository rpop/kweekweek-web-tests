package base;

import env.TestAppEnv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.GmailPage;
import utils.Properties;
import utils.Waits;


public class BaseTest {
     protected WebDriver driver;

    @BeforeMethod
    public void setup(){
    	Properties.setProperty();
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
//		driver.get("https://www.google.ro");
//		Cookie ck = new Cookie("mobile_app_desktop", "0---2015-03-06+07%3A24%3A36");
//		driver.manage().addCookie(ck);
//		Robot robot = new Robot();
//		Press ESC key
//		robot.keyPress(InputEvent.VK_ESCAPE);
//		robot.keyRelease(InputEvent.VK_ESCAPE);
		driver.manage().window().maximize();
		driver.get(TestAppEnv.getUrl());
		driver.navigate().refresh();
		Waits.waitForSomeSeconds(1000);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
    	
    	if (result.getName().contains("Mail")){
    		GmailPage gmailPage = PageFactory.initElements(driver, GmailPage.class);
    		driver.get("https://mail.google.com/mail/#inbox");
    		gmailPage.deleteAllEmailsAfterTest(driver);
    	}
		Waits.waitForSomeSeconds(3000);
      //driver.quit();
    }
}