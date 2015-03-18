package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Waits;

public class KweekweekDashboardPage {
	
	WebDriver driver;
	
	@FindBy (xpath="//div[@id='statistics-region']/div/h5")
	private WebElement firstLastName;
	@FindBy (xpath="//a[.='View profile']")
	private WebElement viewProfileLink;
	@FindBy (xpath="//li[@class='settings']/a/span")
	private WebElement settingsOnDashboard;
	@FindBy(id="settings-wrapper")
	public WebElement settingsMenuDashboard;
	
	
	
	public KweekweekDashboardPage (WebDriver driver){
		this.driver = driver;
	}

	public String getFirstLastName() {
		Waits.waitForElementToBeClickable(driver, firstLastName);
		return firstLastName.getText();
		
	}

	public void clickViewProfile() {
		Waits.waitForElementToBeClickable(driver, viewProfileLink);
		viewProfileLink.click();
		
	}

	public void clickSettingsOnDashboard() {
		Waits.waitForElementToBeClickable(driver, settingsOnDashboard);
		settingsOnDashboard.click();
		
	}
	
	public List getSettingsMenuOptions (){
		List<WebElement> settingsMenu = driver.findElements(By.xpath("//a[starts-with(@href, '#settings')]")); 
		return settingsMenu;
	}
	
	public void clickOptionOnSettingsMenu(WebElement element){
		Waits.waitForElementToBeClickable(driver, element);
		element.click();
	}

	public void clickOptionOnDashboardMenu(String entry) {
		Waits.waitForSomeSeconds(1000);
		WebElement menuOption = driver.findElement(By.xpath("//div[@class='left-navigation']/ul/li/a/span[contains(text(),'" + entry + "')]"));
		Waits.waitForElementToBeClickable(driver, menuOption);
		menuOption.click();
	}
	
	public List getEntriesOnDashboardMenuOption(){
		List<String> menuOptions= new ArrayList<String>();
		menuOptions.add("Calendar");
		menuOptions.add("Event management");
		menuOptions.add("Rewards");
		menuOptions.add("Interests");
		return menuOptions;
	}
	
	
	

}
