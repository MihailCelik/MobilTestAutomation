package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public static By CONTINUE = By.id("com.android.permissioncontroller:id/continue_button");
    public static By TEXT_VIEW = By.className("android.widget.TextView");
    public static By OK_BUTTON = By.id("android:id/button1");

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void clickContinueButton(){
        clickElement(CONTINUE);
    }

    public void clickPopupOkButton(){
        clickElement(OK_BUTTON);
    }

    public String getTextView(){
        return getText(TEXT_VIEW);
    }

    public void SelectTextView(String element){
        findElementByXPath("//android.widget.TextView[@text='"+element+"']");
    }

}
