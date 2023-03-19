package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HideAndShowPage extends BasePage {

    public static By BUTTON_HIDE = By.xpath("//android.widget.Button[@text='Hide']");
    public static By BUTTON_SHOW = By.xpath("//android.widget.Button[@text='Show']");
    public static By INITIAL_TEXT = By.className("android.widget.EditText");

    public HideAndShowPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickHideButton(int index){
        clickElements(BUTTON_HIDE, index);
    }

    public void clickShowButton(int index){
        clickElements(BUTTON_SHOW, index);
    }

    public int getShowButtonCount(){
        return findElements(BUTTON_SHOW).size();
    }

    public int getHideButtonCount(){
        return findElements(BUTTON_HIDE).size();
    }

    public int getInitialTextCount(){
        return findElements(INITIAL_TEXT).size();
    }

}
