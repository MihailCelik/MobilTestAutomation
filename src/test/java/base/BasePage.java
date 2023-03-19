package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    AppiumDriver driver;
    WebDriverWait wait;
    Actions act;

    public BasePage(AppiumDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        act = new Actions(driver);
    }

    public static final String values = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static SecureRandom random = new SecureRandom();

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public void sendKeys(By by, String text) {
        clear(by);
        findElement(by).sendKeys(text);
    }

    public void clickElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    public void clickAndHold(By by) {
        act.moveToElement(findElement(by)).clickAndHold().build().perform();
    }

    public void clear(By by) {
        findElement(by).clear();
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public String getTexts(By by, int index) {
        return findElements(by).get(index).getText();
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElements(by);
    }

    public void findElementByXPath(String by) {
        driver.findElementByXPath(by).click();
    }

    public void clickElements(By by, int index) {
        findElements(by).get(index).click();
    }

    public boolean isDisplayed(By by) {
        return driver.findElement(by).isEnabled();
    }

    public void swipeUp(int press_xOffset, int press_yOffset, int xOffset, int yOffset){
        TouchAction swipe = new TouchAction(driver)
                .press(PointOption.point(press_xOffset, press_yOffset))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(xOffset, yOffset))
                .release()
                .perform();
    }

    public void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void windowHandle() {
        Set<String> windowHandles = driver.getWindowHandles();
        for(String windowHandle : windowHandles){
            driver.switchTo().window(windowHandle);}
    }

    public String getAttribute(By by, String value) {
        return findElement(by).getAttribute(value);
    }

    public void doubleClickElement(By by, int index) {
        act.doubleClick(findElements(by).get(index)).perform();
    }

    public void doubleClick(By by) {
        act.doubleClick(findElement(by)).perform();
    }

    public void moveToElement (By by) {
        act.moveToElement(findElement(by)).build().perform();
    }

    public String randomValueProvider(int count){
        StringBuilder randomValueMaker = new StringBuilder(count);
        for(int i=0;i<count;i++){
            randomValueMaker.append(values.charAt(random.nextInt(values.length())));
        }
        return randomValueMaker.toString();
    }

}
