package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	
	
	
	public static void waitForVisibilityOfElement(WebDriver driver,WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void waitForSomeSeconds(int seconds){
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {}
	
	}
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
}
