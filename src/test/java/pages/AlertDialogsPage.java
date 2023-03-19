package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.concurrent.ThreadLocalRandom;

public class AlertDialogsPage extends BasePage {

    public static By LIST_DIALOG = By.id("com.hmh.api:id/select_button");
    public static By HEADER_TITLE = By.className("android.widget.TextView");

    int index;
    int value;
    String text;
    String result;

    public AlertDialogsPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickListDialogButton(){
        clickElement(LIST_DIALOG);
    }

    public String clickHeaderTitleButton(){
        index = ThreadLocalRandom.current().nextInt(1, 5);
        text = getTexts(HEADER_TITLE, index);
        clickElements(HEADER_TITLE, index);
        value = index - 1;
        result = "You selected: "+ value +" , "+ text;
        return result;
    }

    public String getHeaderTitle(){
        return getText(HEADER_TITLE);
    }

}
