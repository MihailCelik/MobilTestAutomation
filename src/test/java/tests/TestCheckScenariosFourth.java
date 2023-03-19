package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestCheckScenariosFourth extends BaseTest {

    public static String textView = "Choose what to allow API Demos to access";
    protected HomePage home_page;
    protected AppPage app_page;
    protected FragmentPage fragment_page;
    protected ContextMenuPage context_menu_page;

    @BeforeClass
    public void before(){
        home_page = new HomePage(getAppiumDriver());
        app_page = new AppPage(getAppiumDriver());
        fragment_page = new FragmentPage(getAppiumDriver());
        context_menu_page = new ContextMenuPage(getAppiumDriver());
    }

    @Test
    public void TestCheckFourthScenario() {
        Assert.assertEquals(textView, home_page.getTextView(),"Homepage doesn't open!");
        home_page.clickContinueButton();
        home_page.clickPopupOkButton();
        home_page.SelectTextView("App");
        app_page.SelectTextView("Fragment");
        fragment_page.SelectTextView("Context Menu");
        context_menu_page.clickLongPressButton();
        Assert.assertEquals("Menu A",context_menu_page.getMenuText(0),
                "Text doesn't match with expected one!");
        Assert.assertEquals("Menu B",context_menu_page.getMenuText(1),
                "Text doesn't match with expected one!");
    }

}
