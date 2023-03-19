package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class IncomingMessagePage extends BasePage {

    public static By NOTIFY_BUTTON = By.id("com.hmh.api:id/notify");
    public static By NOTIFY_MESSAGE = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android." +
            "widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    public static By NOTIFY_API_DEMO = By.xpath("//android.widget.TextView[@text='API Demos']");
    public static By NOTIFY_TEXT = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout[1]" +
            "/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout[1]/android.widget." +
            "FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView");

    public IncomingMessagePage(AppiumDriver driver) {
        super(driver);
    }

    public void clickShowNotifyButton(){
        clickElement(NOTIFY_BUTTON);
    }

    public void swipeUpNotificationDetail(int press_xOffset, int press_yOffset, int xOffset, int yOffset){
        swipeUp(press_xOffset, press_yOffset, xOffset, yOffset);
    }

    public boolean checkIfNotifyApiDemo(){
        return isDisplayed(NOTIFY_API_DEMO);
    }

    public String getNotifyText(){
        return getText(NOTIFY_TEXT);
    }

    public void clickNotifyText(){
        clickElement(NOTIFY_TEXT);
    }

    public String getNotifyMessage(){
        return getText(NOTIFY_MESSAGE);
    }

}
