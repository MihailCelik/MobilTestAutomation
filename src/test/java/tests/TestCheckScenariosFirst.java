package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestCheckScenariosFirst extends BaseTest {

    public static String textView = "Choose what to allow API Demos to access";
    protected HomePage home_page;
    protected AppPage app_page;
    protected ActionBarTabsPage action_bar_tabs_page;
    protected ActionBarPage action_bar_page;

    @BeforeClass
    public void before(){
        home_page = new HomePage(getAppiumDriver());
        app_page = new AppPage(getAppiumDriver());
        action_bar_tabs_page = new ActionBarTabsPage(getAppiumDriver());
        action_bar_page = new ActionBarPage(getAppiumDriver());
    }

    @Test
    public void TestCheckFirstScenario() {
        Assert.assertEquals(textView, home_page.getTextView(),"Homepage doesn't open!");
        home_page.clickContinueButton();
        home_page.clickPopupOkButton();
        home_page.SelectTextView("App");
        app_page.SelectTextView("Action Bar");
        action_bar_page.SelectTextView("Action Bar Tabs");
        Assert.assertTrue(action_bar_tabs_page.checkIfActionBar(), "Toggle Tab Button active");
        action_bar_tabs_page.clickToggleTabButton();
        action_bar_tabs_page.clickAddNewTabButton(3);
        Assert.assertEquals(3, action_bar_tabs_page.getActionBarTabCount(),
                "The Number of Action Bar Tab doesn't match with expected one!");
        action_bar_tabs_page.clickRemoveLastTabButton(1);
        Assert.assertTrue(action_bar_tabs_page.checkIfActionBarTab("TAB 2"),
                "The wrong element has been deleted!");
        action_bar_tabs_page.clickRemoveAllTabsButton();
        Assert.assertTrue(action_bar_tabs_page.checkIfActionBarTabEmpty(), "Active tab is available");
    }

}
