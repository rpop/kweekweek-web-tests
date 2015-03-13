package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

public class KweekweekEventPage {

	
	private WebDriver driver ;
	
	@FindBy (id="book_ticket_button")
	private WebElement bookNowButton;
	@FindBy(xpath="//span[@class='event_wishlist_span']")
	private WebElement wishlistButtonOnEventPage;
    @FindBy (id="attendees-count")
	private WebElement attendeesHeader;
    @FindBy (xpath="//div[@id='host_stats']/div/div[2]/a")
	private WebElement followersOnEventPage;
    @FindBy (id="contact-host-btn")
	private WebElement contactHostButton;
    @FindBy (xpath="//a[@class='host-link']")
	private WebElement hostButton;
	
	
	
	public KweekweekEventPage (WebDriver driver){
		this.driver=driver;
	}
	
	public KweekweekEventPage clickBookNowButtonOnEventPage(){
		Waits.waitForElementToBeClickable(driver, bookNowButton);
		bookNowButton.click();
		return this;
	}

	public KweekweekEventPage clickWishlistButtonOnEventPage() {
		Waits.waitForElementToBeClickable(driver, wishlistButtonOnEventPage);
		wishlistButtonOnEventPage.click();
		return this;
	}

	public KweekweekEventPage clickAttendeesHeader() {
		Waits.waitForElementToBeClickable(driver, attendeesHeader);
		attendeesHeader.click();
		return this;
	}

	public KweekweekEventPage clickFollowersOnEventPage() {
		Waits.waitForElementToBeClickable(driver, followersOnEventPage);
		followersOnEventPage.click();
		return this;
	}

	public KweekweekEventPage clickContactHost() {
		Waits.waitForElementToBeClickable(driver, contactHostButton);
		contactHostButton.click();
		return this;
	}

	public KweekweekEventPage clickOnHost() {
		Waits.waitForElementToBeClickable(driver, hostButton);
		hostButton.click();	
		return this;
	}

	@FindBy (xpath="//div[@class='col-xs-12 event-description-row event-category']/div/span[@class='icon-label']/a")
	private WebElement eventCategory;

	public String getEventCategory() {
		Waits.waitForElementToBeClickable(driver, eventCategory);
		return eventCategory.getText();
	}

	@FindBy (xpath="//p[@class='vector icon-categories-tag']")
	private WebElement recommendationEventCategory;

	@FindBy (xpath="//div[@class='col-lg-3 col-md-4 col-sm-6 col-xs-12 event-item show_all_tabs']")
	private WebElement recommendationEvent;

	public String getRecommendationEventCategory() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN);
		action.moveToElement(recommendationEvent).build().perform();
		Waits.waitForSomeSeconds(2000);
		return recommendationEventCategory.getText();
	}


}
