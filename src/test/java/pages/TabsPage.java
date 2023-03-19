package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TabsPage extends BasePage {

    public static By CONTENT = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
            "FrameLayout[2]/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/android." +
            "widget.TextView");

    public TabsPage(AppiumDriver driver) {
        super(driver);
    }

    public void SelectTextView(String element){
        findElementByXPath("//android.widget.TextView[@text='"+element+"']");
    }

    public void swipeUpToTab(int press_xOffset, int press_yOffset, int xOffset, int yOffset){
        swipeUp(press_xOffset, press_yOffset, xOffset, yOffset);
    }

    public void clickTab(String element){
        findElementByXPath("//android.widget.TextView[@text='"+element+"']");
    }

    public boolean checkIfTabDisplayed(String element){
        return isDisplayed(By.xpath("//android.widget.TextView[@text='"+element+"']"));
    }

    public String getContentForTab(){
        return getText(CONTENT);
    }

}
