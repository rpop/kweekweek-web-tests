package homepageTests;
import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.KweekweekHomepage;
import utils.Waits;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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

    @Test
    public void clickTodayUnderDescoveryEventsTest(){
        KweekweekHomepage kweekweekHomePage = PageFactory.initElements(driver, KweekweekHomepage.class);
        kweekweekHomePage.clickDiscoverEventsToday()
                         .clickSeeMoreEventsLink();
        Waits.waitForSomeSeconds(4000);
        //incomplet
    }
}