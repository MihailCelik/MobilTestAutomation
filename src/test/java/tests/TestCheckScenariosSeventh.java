package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestCheckScenariosSeventh extends BaseTest {

    public static String textView = "Choose what to allow API Demos to access";
    public static String contentForTab = "Content for tab with tag Tab 30";
    protected HomePage home_page;
    protected ViewsPage views_page;
    protected TabsPage tabs_page;

    @BeforeClass
    public void before(){
        home_page = new HomePage(getAppiumDriver());
        views_page = new ViewsPage(getAppiumDriver());
        tabs_page = new TabsPage(getAppiumDriver());
    }

    @Test
    public void TestCheckSeventhScenario() {
        Assert.assertEquals(textView, home_page.getTextView(),"Homepage doesn't open!");
        home_page.clickContinueButton();
        home_page.clickPopupOkButton();
        home_page.SelectTextView("Views");
        views_page.swipeUpToTab(0,2000,0,0);
        views_page.SelectTextView("Tabs");
        tabs_page.SelectTextView("5. Scrollable");
        tabs_page.swipeUpToTab(1000,300,-3000,300);
        Assert.assertTrue(tabs_page.checkIfTabDisplayed("TAB 30"), "Scrolling to Tab was wrong!");
        tabs_page.clickTab("TAB 30");
        Assert.assertEquals(contentForTab,tabs_page.getContentForTab(), "The message content does not match!");
    }

}
