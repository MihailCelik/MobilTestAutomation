package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestCheckScenariosSecond extends BaseTest {

    public static String textView = "Choose what to allow API Demos to access";
    protected HomePage home_page;
    protected AppPage app_page;
    protected ActivityPage activity_page;
    protected CustomTitlePage custom_title_page;

    @BeforeClass
    public void before(){
        home_page = new HomePage(getAppiumDriver());
        app_page = new AppPage(getAppiumDriver());
        activity_page = new ActivityPage(getAppiumDriver());
        custom_title_page = new CustomTitlePage(getAppiumDriver());
    }

    @Test
    public void TestCheckSecondScenario() {
        Assert.assertEquals(textView, home_page.getTextView(),"Homepage doesn't open!");
        home_page.clickContinueButton();
        home_page.clickPopupOkButton();
        home_page.SelectTextView("App");
        app_page.SelectTextView("Activity");
        activity_page.SelectTextView("Custom Title");
        custom_title_page.enterLeftTextEdit("Left Automation");
        custom_title_page.clickLeftTextButton();
        custom_title_page.enterRightTextEdit("Right Automation");
        custom_title_page.clickRightTextButton();
        Assert.assertEquals("Left Automation", custom_title_page.getLeftText(),
                "Text doesn't match with expected one!");
        Assert.assertEquals("Right Automation", custom_title_page.getRightText(),
                "Text doesn't match with expected one!");
        Assert.assertEquals("Left Automation", custom_title_page.getLeftTextEdit(),
                "Text doesn't match with expected one!");
        Assert.assertEquals("Right Automation", custom_title_page.getRightTextEdit(),
                "Text doesn't match with expected one!");
    }

}
