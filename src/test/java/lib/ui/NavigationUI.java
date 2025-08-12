package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {

    protected static String
            TAB_READING_LISTS,
            OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Open navigation")
    public void openNavigation() {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 5);
        } else {
            System.out.println("Method openNavigation() does nothing for the platform " + Platform.getInstance().getPlatformVar());
        }
        screenshot(this.takeScreenshot("navigation"));
    }

    @Step("Click My Lists")
    public void clickMyLists() {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(TAB_READING_LISTS, "Cannot find navigation button to My lists with some attempts", 5);
        } else {
            this.waitForElementAndClick(TAB_READING_LISTS, "Cannot find navigation button to My lists", 5);
        }
        screenshot(this.takeScreenshot("my_lists"));
    }
}
