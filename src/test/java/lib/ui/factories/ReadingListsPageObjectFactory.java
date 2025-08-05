package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.ReadingListsPageObject;
import lib.ui.android.AndroidReadingListsPageObject;
import lib.ui.ios.iOSReadingListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReadingListsPageObjectFactory {

    public static ReadingListsPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidReadingListsPageObject(driver);
        } else {
            return new iOSReadingListsPageObject(driver);
        }
    }
}
