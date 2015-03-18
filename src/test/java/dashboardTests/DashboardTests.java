package dashboardTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import env.TestAppEnv;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import pageObjects.KweekweekDashboardPage;
import pageObjects.KweekweekHeader;
import pageObjects.KweekweekHomepage;
import pageObjects.KweekweekProfilePage;
import testData.Users;
import utils.Properties;
import utils.StringModifiers;
import utils.UtilityActions;
import utils.Waits;
import loginTest.KweekweekLoginTest;

import base.BaseTest;

public class DashboardTests extends BaseTest{
	
	
	
	@Override@BeforeMethod
	public void setup(){
		super.setup();
		loginBeforeTest();
		
   }
	public void loginBeforeTest(){
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.setLoginUsername(Users.NORMALUSER)
		                 .setLoginPassword(Users.NORMALPASSWORD)
		                 .clickLoginButtonOnLoginPopup();
		}

	@Test
	public void redirectToProfileTest(){
		KweekweekDashboardPage kweekweekDashboard = PageFactory.initElements(driver, KweekweekDashboardPage.class);
		KweekweekProfilePage kweekweekProfilePage = PageFactory.initElements(driver, KweekweekProfilePage.class);
		String firstLast = kweekweekDashboard.getFirstLastName();
		kweekweekDashboard.clickViewProfile();
		assertThat(kweekweekProfilePage.getUsername(), equalTo(StringModifiers.removeWhiteSpaces(firstLast)));
		
	}
	
	@Test
	public void settingsMenuOpensTest(){
		KweekweekDashboardPage kweekweekDashboard = PageFactory.initElements(driver, KweekweekDashboardPage.class);
		kweekweekDashboard.clickSettingsOnDashboard();
		String value = UtilityActions.getAttributeValueOfElement(kweekweekDashboard.settingsMenuDashboard, "style");
		assertThat(value,equalTo("display: block;"));
	}
	
	@Test
	public void settingsMenuRedirectTest(){
		KweekweekDashboardPage kweekweekDashboard = PageFactory.initElements(driver, KweekweekDashboardPage.class);
		kweekweekDashboard.clickSettingsOnDashboard();
		List<WebElement> list = kweekweekDashboard.getSettingsMenuOptions();
		for (WebElement option : list){
			kweekweekDashboard.clickOptionOnSettingsMenu(option);
			Waits.waitForSomeSeconds(1000);
			String href = UtilityActions.getAttributeValueOfElement(option, "href");
			Assert.assertTrue(driver.getCurrentUrl().contains(href));
		}
	}
	
	@Test
	public void dashboardMenuRedirectTest(){
		KweekweekDashboardPage kweekweekDashboard = PageFactory.initElements(driver, KweekweekDashboardPage.class);
		List<String> menuEntries = kweekweekDashboard.getEntriesOnDashboardMenuOption();
		for (String entry : menuEntries){
			kweekweekDashboard.clickOptionOnDashboardMenu(entry);
			Waits.waitForSomeSeconds(1000);
			WebElement pageTitle = driver.findElement(By.xpath("//div[contains(@class,'page-title')]/h1"));
			Waits.waitForElementToBeClickable(driver, pageTitle);
			assertThat(entry, equalTo(pageTitle.getText()));
		}
	}
	
	
}
