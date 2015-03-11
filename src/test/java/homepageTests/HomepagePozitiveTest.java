package homepageTests;
import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.KweekweekBrowsePage;
import pageObjects.KweekweekHomepage;
import utils.Waits;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

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
        assertThat(color, equalTo("rgba(253, 203, 5, 1)")); // nu stie ia culoarea potrivita
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
}