package utils;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UtilityActions {

	  WebDriver driver;
	
	public UtilityActions (WebDriver driver){
		this.driver = driver;
	}
	
	public static void scrollPageDown(WebDriver driver){
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight," + "document.body.scrollHeight,document.documentElement.clientHeight))");
	}

	public static void scrollDownUsingActions(WebDriver driver){
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
	}
	
	public static void scrollWithJsExecutor(WebDriver driver, WebElement element){
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", element);
	}
	
	public static void zoomWithScroll(WebDriver driver){
		try {
			Robot robot = new Robot();
			robot.mouseWheel(+1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String  getAttributeValueOfElement (WebElement element, String attribute){
		return element.getAttribute(attribute);
	}
	
	
}
