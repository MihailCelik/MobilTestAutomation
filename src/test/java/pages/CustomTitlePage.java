package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CustomTitlePage extends BasePage {

    public static By LEFT_TEXT_EDIT = By.id("com.hmh.api:id/left_text_edit");
    public static By LEFT_TEXT_BUTTON = By.id("com.hmh.api:id/left_text_button");
    public static By LEFT_TEXT = By.id("com.hmh.api:id/left_text");
    public static By RIGHT_TEXT_EDIT = By.id("com.hmh.api:id/right_text_edit");
    public static By RIGHT_TEXT_BUTTON = By.id("com.hmh.api:id/right_text_button");
    public static By RIGHT_TEXT = By.id("com.hmh.api:id/right_text");

    public CustomTitlePage(AppiumDriver driver) {
        super(driver);
    }

    public void clickLeftTextButton(){
        clickElement(LEFT_TEXT_BUTTON);
    }

    public void clickRightTextButton(){
        clickElement(RIGHT_TEXT_BUTTON);
    }

    public void enterLeftTextEdit(String text){
        sendKeys(LEFT_TEXT_EDIT, text);
    }

    public void enterRightTextEdit(String text){
        sendKeys(RIGHT_TEXT_EDIT, text);
    }

    public String getRightText(){
        return getText(RIGHT_TEXT);
    }

    public String getLeftText(){
        return getText(LEFT_TEXT);
    }

    public String getRightTextEdit(){
        return getText(RIGHT_TEXT_EDIT);
    }

    public String getLeftTextEdit(){
        return getText(LEFT_TEXT_EDIT);
    }

}
