package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI {

    static {
        TAB_READING_LISTS = "id:org.wikipedia.alpha:id/nav_tab_reading_lists";
    }

    public AndroidNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
