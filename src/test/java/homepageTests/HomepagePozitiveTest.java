package homepageTests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.KweekweekBrowsePage;
import pageObjects.KweekweekEventPage;
import pageObjects.KweekweekHomepage;
import utils.CheckBrokenLinks;
import utils.Waits;

import java.net.URL;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by vlad.tamas on 3/10/2015.
 */
public class HomepagePozitiveTest extends BaseTest {

    @Test
    public void clickSliderPreviousButtonTest(){
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        kweekweekHomePage.clickSliderPreviousButton();
        Waits.waitForSomeSeconds(2000);
    }

    @Test
    public void clickSliderNextButtonTest(){
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        kweekweekHomePage.clickSliderNextButton();
        Waits.waitForSomeSeconds(2000);
    }

    @Test
    public void clicLinkOnSliderLinkTest(){
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        String providerName = kweekweekHomePage.getSliderHyperlinkedProviderName();
        kweekweekHomePage.clickSliderHyperlinkedContainer();
        Waits.waitForSomeSeconds(2000);
        assertThat(providerName, equalTo(kweekweekHomePage.getEventProviderTitle()));
    }

    @Test
    public void getSliderPreviousButtonColorAtHoverTest(){
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        String color = kweekweekHomePage.getSliderPreviousButtonColorAtHover();
        System.out.println(color);
        assertThat(color, equalTo("rgba(253, 203, 5, 1)")); //todo nu stie culoarea potrivita
    }

    @DataProvider
    public Object[][] discoverEvents(){
        return new Object[][]{
                {"tomorrow", "Tomorrow"},
                {"today", "Today"},
                {"latest", "All Dates"}
        };
    }

    @Test(dataProvider = "discoverEvents")
    public void DescoveryEventsTest(String dayEvent, String dayEventOnBrowsePage){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        kweekweekHomePage.clickDiscoverEvents(dayEvent)
                         .clickSeeMoreEventsLink(dayEvent);
        assertThat(kweekweekBrowsePage.getBrowseSelectedDate(), equalToIgnoringCase(dayEventOnBrowsePage));
    }

    @Test
    public void browseByCategoryTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        kweekweekHomePage.clickCategoriesDropDownBtn()
                         .selectCategoryToBrowse("Entertainment");
        assertThat(kweekweekBrowsePage.getActiveCategory(), equalToIgnoringCase("Entertainment"));
    }

    @Test
    public void geCategoryColorAtHoverTest(){
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        String color[] = kweekweekHomePage.getCategoryColorAtHover();
        assertThat(color[0], not(equalTo(color[1])));
    }

    @Test
    public void clickHowItWorksButtonTest(){
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        kweekweekHomePage.clickHowItWorksButton();
        assertThat(driver.getCurrentUrl(), containsString("how-it-works"));
    }

    @Test
    public void downloadAppsExternalLinksTest() throws Exception{
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        List<WebElement> allLinksList = kweekweekHomePage.getDownloadAppsExternalLinks(driver);
        for(WebElement element : allLinksList) {
            try {
                assertThat(CheckBrokenLinks.isLinkBroken(new URL(element.getAttribute("href"))), equalTo("OK 200"));
            } catch (Exception e) {
                System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured; " + e.getMessage());
            }
        }
    }

    @Test
    public void checkRecomandationTest(){
        KweekweekBrowsePage kweekweekBrowsePage = PageFactory.initElements(driver, KweekweekBrowsePage.class);
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        KweekweekEventPage kweekweekEventPage = PageFactory.initElements(driver, KweekweekEventPage.class);
        kweekweekHomePage.clickSearchField()
                         .clickSearchFieldAllEvents();
        kweekweekBrowsePage.clickFirstOption();
        assertThat(kweekweekEventPage.getEventCategory(), equalTo(kweekweekEventPage.getRecommendationEventCategory()));
    }
}