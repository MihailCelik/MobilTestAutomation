package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestCheckScenariosFifth extends BaseTest {

    public static String textView = "Choose what to allow API Demos to access";
    protected HomePage home_page;
    protected AppPage app_page;
    protected FragmentPage fragment_page;
    protected HideAndShowPage hide_and_show_page;

    @BeforeClass
    public void before(){
        home_page = new HomePage(getAppiumDriver());
        app_page = new AppPage(getAppiumDriver());
        fragment_page = new FragmentPage(getAppiumDriver());
        hide_and_show_page = new HideAndShowPage(getAppiumDriver());
    }

    @Test
    public void TestCheckFifthScenario() {
        Assert.assertEquals(textView, home_page.getTextView(),"Homepage doesn't open!");
        home_page.clickContinueButton();
        home_page.clickPopupOkButton();
        home_page.SelectTextView("App");
        app_page.SelectTextView("Fragment");
        fragment_page.SelectTextView("Hide and Show");
        Assert.assertEquals(2, hide_and_show_page.getHideButtonCount(),
                "The Number doesn't match with expected one!");
        Assert.assertEquals(2,hide_and_show_page.getInitialTextCount(),
                "The Number doesn't match with expected one!");
        hide_and_show_page.clickHideButton(1);
        Assert.assertEquals(1, hide_and_show_page.getHideButtonCount(),
                "The Number doesn't match with expected one!");
        Assert.assertEquals(1, hide_and_show_page.getShowButtonCount(),
                "The Number doesn't match with expected one!");
        Assert.assertEquals(1,hide_and_show_page.getInitialTextCount(),
                "The Number doesn't match with expected one!");
        hide_and_show_page.clickShowButton(0);
        Assert.assertEquals(2, hide_and_show_page.getHideButtonCount(),
                "The Number doesn't match with expected one!");
        Assert.assertEquals(2,hide_and_show_page.getInitialTextCount(),
                "The Number doesn't match with expected one!");
    }

}
