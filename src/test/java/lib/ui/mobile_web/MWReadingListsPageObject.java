package lib.ui.mobile_web;

import lib.ui.ReadingListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWReadingListsPageObject extends ReadingListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'page-summary-list')]//h3[contains(text(),'{SUBSTRING}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'page-summary-list')]//h3[contains(text(),'{SUBSTRING}')]/../../a[contains(@class,'watched')]";
    }

    public MWReadingListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
