package utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Properties {
	
	public static String pathToProject = System.getProperty("user.dir");
	public static String chromeProperty = "webdriver.chrome.driver";
	public static String pathToChromedriver = "\\src\\main\\resources\\drivers\\chromedriver.exe";
	public static String firefoxProfileDir = "\\src\\main\\resources\\profiles\\qamepmr9.automation";
	
	public static String setProperty(){
		return System.setProperty(chromeProperty, pathToProject + pathToChromedriver);
	}
	
	public static WebDriver getFirefoxProfile(){
		FirefoxProfile profile = new FirefoxProfile(new File(pathToProject + firefoxProfileDir));
		return new FirefoxDriver(profile);
	}
}
