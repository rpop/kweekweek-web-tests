package pageObjects;

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

	@FindBy (xpath = "//span[@id='select2-chosen-3']")
	private WebElement eventSearchDatesOption;

	public String getBrowseSelectedDate(){
		Waits.waitForElementToBeClickable(driver, eventSearchDatesOption);
		return eventSearchDatesOption.getText();
	}

	@FindBy (xpath = "//div[@id='js-category-filters']/ul//a[@class='active']")
	private WebElement activeCategory;

	public String getActiveCategory(){
		Waits.waitForElementToBeClickable(driver, activeCategory);
		return activeCategory.getText();
	}

	@FindBy (xpath = "//div[@id='events-results-holder']/div/figure")
	private WebElement firstEventDisplayed;

	public KweekweekBrowsePage clickFirstOption() {
		Waits.waitForVisibilityOfElement(driver, firstEventDisplayed);
		firstEventDisplayed.click();
		return null;
	}
}