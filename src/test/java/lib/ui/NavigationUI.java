package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {

    protected static String
            TAB_READING_LISTS;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        this.waitForElementAndClick(
                TAB_READING_LISTS, "Cannot find navigation button to My lists", 5);
    }
}
