package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ContextMenuPage extends BasePage {

    public static By LONG_PRESS = By.id("com.hmh.api:id/long_press");
    public static By MENU_TEXT = By.className("android.widget.TextView");

    public ContextMenuPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickLongPressButton(){
        clickAndHold(LONG_PRESS);
    }

    public String getMenuText(int value){
        return getTexts(MENU_TEXT, value);
    }

}
