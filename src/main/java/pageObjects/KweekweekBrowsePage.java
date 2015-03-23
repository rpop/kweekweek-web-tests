package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

import java.util.ArrayList;
import java.util.List;

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

	public KweekweekBrowsePage clickBrowseDateField(){
		Waits.waitForElementToBeClickable(driver, eventSearchDatesOption);
		eventSearchDatesOption.click();
		return this;
	}

	@FindBy (xpath = "//div[@id='js-category-filters']/ul//a[@class='active']")
	private WebElement activeCategory;

	public String getActiveCategory(){
		Waits.waitForElementToBeClickable(driver, activeCategory);
		return activeCategory.getText();
	}

	@FindBy (xpath = "//div[@id='js-type-filters']/ul//a[@class='active']")
	private WebElement activeType;

	public String getActiveType(){
		Waits.waitForElementToBeClickable(driver, activeType);
		return activeType.getText();
	}

	@FindBy (xpath = "//div[@id='events-results-holder']/div/figure")
	private WebElement firstEventDisplayed;

	public KweekweekBrowsePage clickFirstOption() {
		Waits.waitForVisibilityOfElement(driver, firstEventDisplayed);
		firstEventDisplayed.click();
		return null;
	}

	@FindBy (xpath = "//div[@id='query_area']/div/ul/li[1]")
	private WebElement allEventsBySearchField;

	public KweekweekBrowsePage clickAllEventsBySearchField(){
		Waits.waitForVisibilityOfElement(driver, allEventsBySearchField);
		allEventsBySearchField.click();
		return this;
	}

	@FindBy (xpath = "//div[@id='select2-drop']/ul/li[2]")
	private WebElement todayOptionOnDropDownList;

	public KweekweekBrowsePage clickTodayOptionOnDropDownList(){
		Waits.waitForElementToBeClickable(driver, todayOptionOnDropDownList);
		todayOptionOnDropDownList.click();
		return this;
	}

	@FindBy (xpath = "//div[@id='select2-drop']/ul/li[1]")
	private WebElement allDatesOptionOnDropDownList;

	public KweekweekBrowsePage clickAllDatesOptionOnDropDownList(){
		Waits.waitForVisibilityOfElement(driver, todayOptionOnDropDownList);
		todayOptionOnDropDownList.click();
		return this;
	}

	@FindBy (xpath = "//div[@id='select2-drop']/ul/li[3]")
	private WebElement tomorrowOptionOnDropDownList;

	public KweekweekBrowsePage clickTomorrowOptionOnDropDownList(){
		Waits.waitForElementToBeClickable(driver, todayOptionOnDropDownList);
		tomorrowOptionOnDropDownList.click();
		return this;
	}

	@FindBy (xpath = "//div[@id='select2-drop']/ul/li[4]")
	private WebElement thisWeekendOptionOnDropDownList;

	public KweekweekBrowsePage clickThisWeekendOptionOnDropDownList() {
		Waits.waitForElementToBeClickable(driver, todayOptionOnDropDownList);
		thisWeekendOptionOnDropDownList.click();
		return this;
	}

	@FindBy (xpath = "//div[@id='select2-drop']/ul/li[5]")
	private WebElement nextWeekOptionOnDropDownList;

	public KweekweekBrowsePage clickNextWeekOptionOnDropDownList() {
		Waits.waitForElementToBeClickable(driver, todayOptionOnDropDownList);
		nextWeekOptionOnDropDownList.click();
		return this;
	}

	public KweekweekBrowsePage scrollDownOnDropDown() {
		Waits.waitForElementToBeClickable(driver, eventSearchDatesOption);
		eventSearchDatesOption.click();
		return this;
	}

	@FindBy (xpath = "//div[@id='select2-drop']/ul")
	private WebElement dateDropDownList;

	public KweekweekBrowsePage scrollDownDateDropDownList() {
		Waits.waitForElementToBeClickable(driver, dateDropDownList);
		Actions actions = new Actions(driver);
		actions.moveToElement(dateDropDownList).build().perform();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 50);");
		return this;
	}

	@FindBy (xpath = "//div[@id='ui-datepicker-div']/table/tbody/tr[2]/td[3]/a")
	private WebElement day10InCustomDatePicker;

	public KweekweekBrowsePage clickDay10OnCustomDatePicker() {
		Waits.waitForElementToBeClickable(driver, day10InCustomDatePicker);
		day10InCustomDatePicker.click();
		return this;
	}

	@FindBy (xpath = "//div[@id='select2-drop']/ul/li[6]")
	private WebElement customDateOptionOnDropDownList;

	public KweekweekBrowsePage clickCustomDateOptionOnDropDownList() {
		Waits.waitForElementToBeClickable(driver, customDateOptionOnDropDownList);
		customDateOptionOnDropDownList.click();
		return this;
	}

	@FindBy (xpath = "//*[@id='js-type-filters']/ul/li[2]/a")
	private WebElement featuredEventOnSideMenu;

	public KweekweekBrowsePage clickFeaturedEventOnSideMenu() {
		Waits.waitForElementToBeClickable(driver, featuredEventOnSideMenu);
		featuredEventOnSideMenu.click();
		return this;
	}

	@FindBy (xpath = "//*[@id='js-type-filters']/ul/li[3]/a")
	private WebElement trendingEventOnSideMenu;

	public KweekweekBrowsePage clickTrendingEventsOnSideMenu() {
		Waits.waitForElementToBeClickable(driver, trendingEventOnSideMenu);
		trendingEventOnSideMenu.click();
		return this;
	}

	@FindBy (xpath = "//*[@id='js-type-filters']/ul/li[4]/a")
	private WebElement latestEventOnSideMenu;

	public KweekweekBrowsePage clickLatestEventsOnSideMenu() {
		Waits.waitForElementToBeClickable(driver, trendingEventOnSideMenu);
		latestEventOnSideMenu.click();
		return this;
	}

	@FindBy (xpath = "//*[@id='js-type-filters']/ul/li[5]/a")
	private WebElement affiliateEventOnSideMenu;

	public KweekweekBrowsePage clickAffiliateEventsOnSideMenu() {
		Waits.waitForElementToBeClickable(driver, trendingEventOnSideMenu);
		affiliateEventOnSideMenu.click();
		return this;
	}

	@FindBy (xpath = "//*[@id='js-type-filters']/ul/li[6]/a")
	private WebElement vipEventOnSideMenu;

	public KweekweekBrowsePage clickVipEventsOnSideMenu() {
		Waits.waitForElementToBeClickable(driver, vipEventOnSideMenu);
		vipEventOnSideMenu.click();
		return this;
	}

	@FindBy (xpath = "//*[@id='js-type-filters']/ul/li[7]/a")
	private WebElement redeemableEventOnSideMenu;

	public KweekweekBrowsePage clickRedeemableEventsOnSideMenu() {
		Waits.waitForElementToBeClickable(driver, vipEventOnSideMenu);
		redeemableEventOnSideMenu.click();
		return this;
	}

	@FindBy (xpath = "//*[@id='js-filter-by-city']")
	private WebElement filterByCityOrPostalCodeField;

	public KweekweekBrowsePage sentCityAtFilterByCityOrPostalCodeField(String text) {
		Waits.waitForElementToBeClickable(driver, filterByCityOrPostalCodeField);
		filterByCityOrPostalCodeField.sendKeys(text, Keys.ENTER, Keys.ENTER);
		return this;
	}

	@FindBy (xpath = "//div[@id='s2id_js-filter-by-price']")
	private WebElement filterByPriceField;

	public KweekweekBrowsePage clickFilterByPriceField() {
		Waits.waitForElementToBeClickable(driver, filterByPriceField);
		filterByPriceField.click();
		return this;
	}

	public String getFilterByPriceFieldText() {
		Waits.waitForElementToBeClickable(driver, filterByPriceField);
		return filterByPriceField.getText();
	}

	@FindBy (xpath = "//ul[@id='select2-results-4']/li[2]")
	private WebElement filterByFreePrice;

	public KweekweekBrowsePage selectFreeEvents() {
		Waits.waitForElementToBeClickable(driver, filterByPriceField);
		filterByFreePrice.click();
		return this;
	}

	@FindBy (xpath = "//ul[@id='select2-results-4']/li[2]")
	private WebElement firstPriceLimit;

	public KweekweekBrowsePage selectFirtPriceLimit() {
		Waits.waitForElementToBeClickable(driver, firstPriceLimit);
		return this;
	}

	@FindBy (xpath = "//p[@class='price']")
	private WebElement eventModulePrice;

	public String getEventModulePrice() {
		Waits.waitForElementToBeClickable(driver, eventModuleOnBrowse);
		return eventModulePrice.getText();
	}

	//div[@class='col-lg-4 col-md-6 col-sm-6 col-xs-7']//a
	@FindBy (xpath = "//div[@id='s2id_js-sort']")
	private WebElement sortByField;

	public KweekweekBrowsePage clickSortByField() {
		Waits.waitForElementToBeClickable(driver, sortByField);
		sortByField.click();
		return this;
	}

	@FindBy (xpath = "//div[@id='s2id_js-sort']/a")
	private WebElement sortByHighestPrice;

	public KweekweekBrowsePage clickSortByHighestPrice() {
		Waits.waitForElementToBeClickable(driver, sortByHighestPrice);
		sortByHighestPrice.click();
		return this;
	}

	@FindBy (xpath = "//*[@id='s2id_js-filter-past']/a")
	private WebElement statusField;

	public KweekweekBrowsePage clickStatusField() {
		Waits.waitForElementToBeClickable(driver, statusField);
		statusField.click();
		return this;
	}

	@FindBy (xpath = "//*[@id='select2-drop']/ul/li[2]")
	private WebElement statusPast;

	public KweekweekBrowsePage selectPastStatus() {
		Waits.waitForElementToBeClickable(driver, statusPast);
		statusPast.click();
		return this;
	}


	@FindBy (xpath = "//*[@class='vertical-centered-element']/p/time")
	private WebElement eventModuleDate;

	public String getEventModuleDate() {
		Waits.waitForVisibilityOfElement(driver, eventModuleDate);
		return eventModuleDate.getText();
	}

	@FindBy (xpath = "//*[@id='reset-filters']/span")
	private WebElement resetFiltersButton;

	public KweekweekBrowsePage clickResetFilters() {
		Waits.waitForElementToBeClickable(driver, resetFiltersButton);
		resetFiltersButton.click();
		return this;
	}

	public List getDownloadAppsExternalLinks(WebDriver driver){
		List<WebElement> elementList = new ArrayList();
		elementList = driver.findElements(By.xpath("//div[@class='download-links']//a"));
		List<WebElement> finalList = new ArrayList();
		for (WebElement element : elementList)
		{
			if (element.getAttribute("href") != null){
				finalList.add(element);
			}
		}
		return finalList;
	}

	public KweekweekBrowsePage presPageDown(){
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		return this;
	}

	public Integer getNbOfEventsModuleDisplayed(){
		List<WebElement> eventsModuleList = new ArrayList();
		eventsModuleList = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-12 col-xs-12 event-item show_all_tabs']"));
		return eventsModuleList.size();
	}

	@FindBy (xpath = "//*[@id='scrollUp']")
	private WebElement backToTopButton;

	public KweekweekBrowsePage clickBackToTopButton() {
		Waits.waitForElementToBeClickable(driver, backToTopButton);
		backToTopButton.click();
		return this;
	}
}