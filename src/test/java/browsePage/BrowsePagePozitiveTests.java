package browsePage;

import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testData.Users;
import utils.Waits;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by vlad.tamas on 3/17/2015.
 */
public class BrowsePagePozitiveTests extends BaseTest{

    @Test
    public void selectAllTypesTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField();
        assertThat(kweekweekBrowsePage.getBrowseSelectedDate(), equalTo("All Dates"));
    }

    @Test
    public void selectTodayTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickBrowseDateField()
                           .clickTodayOptionOnDropDownList();
        assertThat(kweekweekBrowsePage.getBrowseSelectedDate(), equalTo("Today"));
    }

    @Test
    public void selectTomorrowTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickBrowseDateField()
                           .clickTomorrowOptionOnDropDownList();
        assertThat(kweekweekBrowsePage.getBrowseSelectedDate(), equalTo("Tomorrow"));
    }

    @Test
    public void selectThisWeekendTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickBrowseDateField()
                           .clickThisWeekendOptionOnDropDownList();
        assertThat(kweekweekBrowsePage.getBrowseSelectedDate(), equalTo("This weekend"));
    }

    @Test
    public void selectNextWeekTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickBrowseDateField()
                           .scrollDownDateDropDownList()
                           .clickNextWeekOptionOnDropDownList();
        assertThat(kweekweekBrowsePage.getBrowseSelectedDate(), equalTo("Next week"));
    }

    @Test
    public void selectCustomDateTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickBrowseDateField()
                           .scrollDownDateDropDownList()
                           .clickNextWeekOptionOnDropDownList();
        assertThat(kweekweekBrowsePage.getBrowseSelectedDate(), equalTo("Next week"));
    }

    @Test
    public void selectDay10CustomDatePickerTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickBrowseDateField()
                           .scrollDownDateDropDownList()
                           .clickCustomDateOptionOnDropDownList()
                           .clickDay10OnCustomDatePicker();
        assertThat(kweekweekBrowsePage.getBrowseSelectedDate(), startsWith("10"));
    }

    @Test
    public void selectFeaturedEventOnSideMenuTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickFeaturedEventOnSideMenu();
        assertThat(kweekweekBrowsePage.getActiveType(), equalTo("Fashion Week"));
    }

    @Test
    public void selectTrendingEventsOnSideMenuTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickTrendingEventsOnSideMenu();
        assertThat(kweekweekBrowsePage.getActiveType(), equalTo("Trending"));
    }

    @Test
      public void selectLatestEventsOnSideMenuTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                .clickLatestEventsOnSideMenu();
        assertThat(kweekweekBrowsePage.getActiveType(), equalTo("Latest"));
    }

    @Test
    public void selectAffiliateEventsOnSideMenuTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                .clickAffiliateEventsOnSideMenu();
        assertThat(kweekweekBrowsePage.getActiveType(), equalTo("Affiliate"));
    }

    @Test
    public void selectVipEventsOnSideMenuTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                .clickVipEventsOnSideMenu();
        assertThat(kweekweekBrowsePage.getActiveType(), equalTo("VIP"));
    }

    @Test
    public void selectRedeemableEventsOnSideMenuTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                .clickRedeemableEventsOnSideMenu();
        assertThat(kweekweekBrowsePage.getActiveType(), equalTo("Redeemable"));
    }

    @Test
    public void searchByLocationTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .sentCityAtFilterByCityOrPostalCodeField("London")
                           .clickFirstOption();
        assertThat(kweekweekEventPage.getEventlocation(), containsString("London"));
    }

    @Test
    public void selectFreeEventsTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickFilterByPriceField()
                           .selectFreeEvents();
        assertThat(kweekweekBrowsePage.getFilterByPriceFieldText(), equalToIgnoringCase("Free"));
        assertThat(kweekweekBrowsePage.getEventModulePrice(), equalToIgnoringCase("free"));
    }

    @Test
    public void sortByHighestPriceTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickFilterByPriceField()
                           .selectFirtPriceLimit()
                           .clickSortByField()
                           .selectFirtPriceLimit();
        String removeCurrency = kweekweekBrowsePage.getEventModulePrice().substring(1);
        Integer price = Integer.parseInt(removeCurrency);
        assertThat(kweekweekBrowsePage.getFilterByPriceFieldText(), containsString("25"));
        assertThat(price, lessThanOrEqualTo(25));
    }

    @Test
    public void sortByPastStatusTest() {
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickStatusField()
                           .selectPastStatus();
        assertThat(kweekweekBrowsePage.getEventModuleDate(), equalTo("Ended"));
    }

    @Test
    public void resetFiltersTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                .clickStatusField()
                .selectPastStatus()
                .clickFilterByPriceField()
                .selectFreeEvents();
        assertThat(kweekweekBrowsePage.getEventModuleDate(), equalTo("Ended"));
        assertThat(kweekweekBrowsePage.getFilterByPriceFieldText(), equalToIgnoringCase("Free"));
        assertThat(kweekweekBrowsePage.getEventModulePrice(), equalToIgnoringCase("free"));
        kweekweekBrowsePage.clickResetFilters();
        assertThat(kweekweekBrowsePage.getFilterByPriceFieldText(), equalToIgnoringCase("All prices"));
    }

    @Test
    public void loadMoreEventsTest() {
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField().presPageDown();
        assertThat(kweekweekBrowsePage.getNbOfEventsModuleDisplayed(), greaterThan(12));
    }

    @Test
    public void keepFiltersAfterRefreshTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickStatusField()
                           .selectPastStatus()
                           .clickFilterByPriceField()
                           .selectFreeEvents();
        driver.navigate().refresh();
        assertThat(kweekweekBrowsePage.getFilterByPriceFieldText(), equalToIgnoringCase("Free"));
        assertThat(kweekweekBrowsePage.getEventModulePrice(), equalToIgnoringCase("free"));
    }

    @Test
    public void clickBackToTopButtonTest() {
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .presPageDown().presPageDown()
                           .clickBackToTopButton();
        Waits.waitForSomeSeconds(2500);
        assertThat(kweekweekBrowsePage.getEventModuleDate(), not(isEmptyOrNullString()));
    }

    @Test
    public void WishlistEventTest() {
        KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        FacebookPage facebookPage = PageFactory.initElements(driver, FacebookPage.class);
        kweekweekHeader.clickLoginButtonFromHeader();
        kweekweekHomepage.clickLoginWithFacebook();
        facebookPage.setFacebookLoginEmail(Users.getFacebookUser())
                .setFacebookLoginPassword(Users.getFacebookPassword())
                .clickFacebookLoginButton();
        Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.alertContainer);
        Assert.assertTrue(driver.getPageSource().contains("Logged in successfully"));
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        kweekweekBrowsePage.clickSearchField();
        kweekweekBrowsePage.clickAllEventsBySearchField()
                           .clickFirstOption();
        KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
        kweekweekEventPage.clickWishlistButtonOnEventPage();
        Waits.waitForSomeSeconds(800);
        assertThat(kweekweekEventPage.getWishlistButtonStatus(), equalToIgnoringCase("wishlisted"));
    }

    @Test
    public void EditEventTest(){
        KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
        KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
        FacebookPage facebookPage = PageFactory.initElements(driver, FacebookPage.class);
        kweekweekHeader.clickLoginButtonFromHeader();
        kweekweekHomepage.clickLoginWithFacebook();
        facebookPage.setFacebookLoginEmail(Users.getFacebookUser())
                .setFacebookLoginPassword(Users.getFacebookPassword())
                .clickFacebookLoginButton();
        Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.alertContainer);
        Assert.assertTrue(driver.getPageSource().contains("Logged in successfully"));
        
    }
}