package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;

public class AppPage extends BasePage {

    public AppPage(AppiumDriver driver) {
        super(driver);
    }

    public void SelectTextView(String element){
        findElementByXPath("//android.widget.TextView[@text='"+element+"']");
    }

}
