package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Waits;

public class KweekweekEventPage {

	
	WebDriver driver ;
	
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
	
	public void clickBookNowButtonOnEventPage(){
		Waits.waitForVisibilityOfElement(driver, bookNowButton);
		bookNowButton.click();
	}

	public void clickWishlistButtonOnEventPage() {
		Waits.waitForVisibilityOfElement(driver, wishlistButtonOnEventPage);
		wishlistButtonOnEventPage.click();
		
	}

	public void clickAttendeesHeader() {
		Waits.waitForVisibilityOfElement(driver, attendeesHeader);
		attendeesHeader.click();
		
	}

	public void clickFollowersOnEventPage() {
		Waits.waitForVisibilityOfElement(driver, followersOnEventPage);
		followersOnEventPage.click();
		
	}

	public void clickContactHost() {
		Waits.waitForVisibilityOfElement(driver, contactHostButton);
		contactHostButton.click();
		
	}

	public void clickOnHost() {
		Waits.waitForVisibilityOfElement(driver, hostButton);
		hostButton.click();		
	}
}
