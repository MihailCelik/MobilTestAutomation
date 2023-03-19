package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestCheckScenariosThird extends BaseTest {

    String alert_text;
    public static String textView = "Choose what to allow API Demos to access";
    protected HomePage home_page;
    protected AppPage app_page;
    protected AlertDialogsPage alert_dialogs_page;

    @BeforeClass
    public void before(){
        home_page = new HomePage(getAppiumDriver());
        app_page = new AppPage(getAppiumDriver());
        alert_dialogs_page = new AlertDialogsPage(getAppiumDriver());
    }

    @Test
    public void TestCheckThirdScenario() {
        Assert.assertEquals(textView, home_page.getTextView(),"Homepage doesn't open!");
        home_page.clickContinueButton();
        home_page.clickPopupOkButton();
        home_page.SelectTextView("App");
        app_page.SelectTextView("Alert Dialogs");
        alert_dialogs_page.clickListDialogButton();
        alert_text = alert_dialogs_page.clickHeaderTitleButton();
        Assert.assertEquals(alert_text,alert_dialogs_page.getHeaderTitle(),
                "Text doesn't match with expected one!");
    }

}
