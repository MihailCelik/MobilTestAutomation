package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;

public class ViewsPage extends BasePage {

    public ViewsPage(AppiumDriver driver) {
        super(driver);
    }

    public void swipeUpToTab(int press_xOffset, int press_yOffset, int xOffset, int yOffset){
        swipeUp(press_xOffset, press_yOffset, xOffset, yOffset);
    }
    public void SelectTextView(String element){
        findElementByXPath("//android.widget.TextView[@text='"+element+"']");
    }

}
