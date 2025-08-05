package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ReadingListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSReadingListsPageObject extends ReadingListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        GOT_IT_DIALOG_BUTTON = "xpath://XCUIElementTypeButton[@name='Close']";
        DELETE_SAVED_ARTICLE_BUTTON = "id:swipe action delete";
    }

    public iOSReadingListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
