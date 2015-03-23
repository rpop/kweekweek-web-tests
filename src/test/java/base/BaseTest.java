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

import java.util.concurrent.TimeUnit;


public class BaseTest {
	protected WebDriver driver;


	@BeforeMethod
	public void setup(){
		Properties.setProperty();
		driver = new ChromeDriver();
		//driver = Properties.getFirefoxProfile();
		driver.manage().window().maximize();
		driver.get(TestAppEnv.getUrl());
		//driver.navigate().refresh();
		Waits.waitForSomeSeconds(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Waits.waitForSomeSeconds(2000);
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
}