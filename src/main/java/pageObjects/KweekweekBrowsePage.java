package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utils.Waits;

public class KweekweekBrowsePage extends KweekweekHeader{

	

	public KweekweekBrowsePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="//div[@data-filter='today']/figure/a")
	private WebElement eventModuleOnBrowse;
	
	public void clickEventOnBrowsePage(){
		Waits.waitForElementToBeClickable(driver, eventModuleOnBrowse);
		eventModuleOnBrowse.click();
	}
	public void hoverOverPosterOnBrowsePage (){
		Waits.waitForElementToBeClickable(driver, eventModuleOnBrowse);
		Actions action = new Actions(driver);
		//action.keyDown(Keys.PAGE_DOWN);
		action.moveToElement(eventModuleOnBrowse).build().perform();
		
	}
}
