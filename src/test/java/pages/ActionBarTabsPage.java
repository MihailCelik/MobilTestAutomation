package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionBarTabsPage extends BasePage {

    public static By ADD_NEW_TAB_BUTTON = By.id("com.hmh.api:id/btn_add_tab");
    public static By REMOVE_LAST_TAB_BUTTON = By.id("com.hmh.api:id/btn_remove_tab");
    public static By TOGGLE_TAB_BUTTON = By.id("com.hmh.api:id/btn_toggle_tabs");
    public static By ACTION_BAR = By.id("android:id/action_bar");
    public static By ACTION_BAR_TAB = By.className("android.app.ActionBar$Tab");
    public static By REMOVE_ALL_TABS_BUTTON = By.id("com.hmh.api:id/btn_remove_all_tabs");
    public static By ACTION_BAR_TAB_EMPTY = By.className("android.widget.LinearLayout");
    public static By ACTION_BAR_TAB_TEXT_VIEW = By.className("android.widget.TextView");

    List<WebElement> tabList;
    Boolean booleanResult = true;
    String tabName;

    public ActionBarTabsPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickAddNewTabButton(int count){
        for(int i=1;i<=count;i++){
            clickElement(ADD_NEW_TAB_BUTTON);
        }
    }

    public void clickRemoveLastTabButton(int count){
        for(int i=1;i<=count;i++){
            clickElement(REMOVE_LAST_TAB_BUTTON);
        }
    }

    public void clickToggleTabButton(){
        clickElement(TOGGLE_TAB_BUTTON);
    }

    public boolean checkIfActionBar(){
        return isDisplayed(ACTION_BAR);
    }

    public int getActionBarTabCount(){
        return findElements(ACTION_BAR_TAB).size();
    }

    public boolean checkIfActionBarTab(String value) {
        tabList = findElements(ACTION_BAR_TAB);
        for(int i = 0; i < tabList.size(); ++i) {
            tabName = getTexts(ACTION_BAR_TAB_TEXT_VIEW, i);
            if(value.equals(tabName)){
                booleanResult = false;
                break;
            }
        }
        return booleanResult;
    }

    public void clickRemoveAllTabsButton(){
        clickElement(REMOVE_ALL_TABS_BUTTON);
    }

    public boolean checkIfActionBarTabEmpty(){
        return isDisplayed(ACTION_BAR_TAB_EMPTY);
    }

}
