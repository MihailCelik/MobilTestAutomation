package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TestCheckScenariosSixth extends BaseTest {

    String notify_text;
    String notify_message;
    public static String textView = "Choose what to allow API Demos to access";
    protected HomePage home_page;
    protected AppPage app_page;
    protected NotificationPage notification_page;
    protected IncomingMessagePage incoming_message_page;

    @BeforeClass
    public void before(){
        home_page = new HomePage(getAppiumDriver());
        app_page = new AppPage(getAppiumDriver());
        notification_page = new NotificationPage(getAppiumDriver());
        incoming_message_page = new IncomingMessagePage(getAppiumDriver());
    }

    @Test
    public void TestCheckSixthScenario() {
        Assert.assertEquals(textView, home_page.getTextView(),"Homepage doesn't open!");
        home_page.clickContinueButton();
        home_page.clickPopupOkButton();
        home_page.SelectTextView("App");
        app_page.SelectTextView("Notification");
        notification_page.SelectTextView("IncomingMessage");
        incoming_message_page.clickShowNotifyButton();
        incoming_message_page.swipeUpNotificationDetail(523,34,564,1664);
        Assert.assertTrue(incoming_message_page.checkIfNotifyApiDemo(),
                "Notification Api Demo message not found.");
        notify_text = incoming_message_page.getNotifyText();
        incoming_message_page.clickNotifyText();
        notify_message = incoming_message_page.getNotifyMessage();
        Assert.assertTrue(notify_message.contains(notify_text), "The message content does not match!");
    }

}
