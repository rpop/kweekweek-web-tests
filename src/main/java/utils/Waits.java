package utils;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Waits {
	
	
	
	
	public static void waitForVisibilityOfElement(WebDriver driver,WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void waitForSomeSeconds(int seconds){
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {}
	
	}
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}


	public static void fluentWait(final WebDriver driver, int sec, final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(sec, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				 driver.findElement(locator);
				return null;
			}
		});
	};
}
