package utils;

import org.openqa.selenium.WebDriver;
import java.util.Random;

public class RandomStrings {

	WebDriver driver;
	
	public RandomStrings (WebDriver driver){
		this.driver = driver;
	}
	
	public static String generateRandomString(int size){
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString() + "@blabla.com";
		return output;
	}

}
