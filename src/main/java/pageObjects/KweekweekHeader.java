package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Waits;

public class KweekweekHeader {

	
		protected WebDriver driver;
		@FindBy(xpath = "//a[@data-href='/users/login']") 
		private WebElement loginButton;
		@FindBy (id ="logoImage")
		private WebElement kweekweekLogo;
		@FindBy (id = "query_text")
		private WebElement searchField;
		@FindBy (id="query_btn")
		private WebElement queryButton;
		@FindBy (xpath ="//i[@class='fa fa-caret-down']")
		private WebElement extendCategoriesButton;
		@FindBy (xpath = "//a[@class='boxLink']")
		private WebElement eventModule;
		@FindBy (xpath = "//figure/div/p[@class='vector icon-categories-tag']")
		private WebElement categoryOnModule;
		@FindBy (xpath = "//a[@data-href='/events/new']")
		private WebElement addEventButtonOnHeader;
		@FindBy (xpath = "//a[@data-href='/users/sign_up']")
		private WebElement signupButtonOnHeader;
		@FindBy (id = "settings-dropdown")
		private WebElement settingsButtonOnheader;
		@FindBy (xpath = "//a[@class='vector icon-settings_log_out']")
		private WebElement logoutButton;
		
				
		public KweekweekHeader (WebDriver driver){
			this.driver = driver;
		}
		public void clickLoginButtonFromHeader(){
			Waits.waitForElementToBeClickable(driver, loginButton);
			loginButton.click();
		}
		public void clickKweekweekLogo(){
			Waits.waitForElementToBeClickable(driver, kweekweekLogo);
			kweekweekLogo.click();
		}
		public void clickSearchField(){
			Waits.waitForElementToBeClickable(driver, searchField);
			searchField.click();
		}
		public void setQueryTest(String query){
			Waits.waitForElementToBeClickable(driver, searchField);
			searchField.sendKeys(query);
		}
		public void clickSearchButton(){
			Waits.waitForElementToBeClickable(driver, queryButton);
			queryButton.click();
		}
		public void selectOptionFromSearchList(String option){
			String xpath = "/discover/all-categories/events?event_type=";
			Waits.waitForElementToBeClickable(driver,driver.findElement(By.xpath("//a[@href='"+xpath+option+"']"))) ;
			driver.findElement(By.xpath("//a[@href='"+xpath+option+"']")).click();
		}
		
		public List addElementWithXpathToList (String option){
			Waits.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[@class='active' and @data-target='"+option+"']")));
			List<Object> selected = new ArrayList<Object>();
			selected.add(driver.findElement(By.xpath("//a[@class='active' and @data-target='"+option+"']")));
			return selected;
			
		}
		public void removeElementsFromList (List selected){
			selected.removeAll(selected);
		}
		
		public List getListOfOptions(){
			List<String> options = new ArrayList<String>();
			  options.add("featured");
	          options.add("trending");
	          options.add("latest");
	          options.add("affiliate");
	          options.add("vip");
			return options;
			
		}
		public List<String> getListOfCategories() {
			List<String> categories = new ArrayList<String>();
			categories.add("art-culture-item");
			categories.add("entertainment-item");
			categories.add("food-drink-item");
			categories.add("well-being-health-item");
			categories.add("knowledge-item");
			categories.add("networking-item");
			categories.add("nightlife-item");
			categories.add("shopping-item");
			categories.add("sport-item");
			categories.add("travel-item");
			return categories;
		}
		public void selectOptionFromCategoriesList(String category){
			Waits.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//li[@class='" + category + "']")));
			driver.findElement(By.xpath("//li[@class='" + category + "']")).click();
			//System.out.println(driver.findElement(By.xpath("//li[@class='" + category + "']")).getText());
			
		}
		public void clickCategoriesButton(){
			Waits.waitForElementToBeClickable(driver, extendCategoriesButton);
			extendCategoriesButton.click();
		}
		
		public String getCategoryOnModule(){
			Actions action = new Actions(driver);
			Waits.waitForElementToBeClickable(driver, eventModule);
			action.moveToElement(eventModule).build().perform();
			return categoryOnModule.getText();
		}
		
		public String getSelectedCategory (String category){
			Waits.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//li[@class='" + category + "']/a")));
			return driver.findElement(By.xpath("//li[@class='" + category + "']/a")).getText();
			
			
		}
		
		public List addSelectedCategoryToList (String category){
			
		    String text ;
		    
			
			switch (category) {
			case "art-culture-item" : text = "art-culture" ; break;
			case "entertainment-item" : text = "entertainment"; break;
			case "food-drink-item" : text = "food-drink";break;
			case "well-being-health-item" : text = "health-wellbeing" ;break;
			case "knowledge-item" : text = "knowledge"; break;
			case "networking-item" : text = "networking" ; break;
			case "nightlife-item" : text = "nightlife"; break;
			case "shopping-item" : text = "shopping"; break;
			case "travel-item" : text = "travel"; break;
			case "sport-item" : text = "sport";break;
			default : text = null; break;
			}
			List<Object> selectedCategory = new ArrayList<Object>();
			selectedCategory.add(driver.findElement(By.xpath("//a[@class='active' and @data-target='" + text +"']")));
			 
		    return selectedCategory;
		}
		public void clickAddEventButton() {
			Waits.waitForElementToBeClickable(driver, addEventButtonOnHeader);
			addEventButtonOnHeader.click();
			
		}
		public void clickSignupButtonOnHeader() {
			Waits.waitForElementToBeClickable(driver, signupButtonOnHeader);
		    signupButtonOnHeader.click();
		}
		public void clickSettingsButtonOnHeader() {
			Waits.waitForElementToBeClickable(driver, settingsButtonOnheader);
			settingsButtonOnheader.click();
			
		}
		public void clickLogOut() {
			Waits.waitForElementToBeClickable(driver, logoutButton);
			logoutButton.click();
			
		}
		

	}


