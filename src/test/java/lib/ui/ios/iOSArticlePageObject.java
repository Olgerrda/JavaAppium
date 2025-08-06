package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']";
        FOOTER_ELEMENT = "id:View article in browser";
        SAVE_OPTION_BUTTON = "id:org.wikipedia.alpha:id/page_save";
        OPTIONS_ADD_TO_LIST = "id:Save for later";
        MY_LIST_INPUT_FIELD = "id:org.wikipedia.alpha:id/text_input";
        MY_LIST_OK_BUTTON = "id:android:id/button1";
        BACK_FROM_ARTICLE_BUTTON = "id:Back";
        CLOSE_SEARCH_BUTTON = "xpath://XCUIElementTypeButton[@name='Cancel']";
    }
    public iOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
