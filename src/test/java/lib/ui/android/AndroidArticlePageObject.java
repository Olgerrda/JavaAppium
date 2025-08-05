package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
            WIKIGAMES_DIALOG_CLOSE_BUTTON = "id:org.wikipedia.alpha:id/closeButton";
            AFTER_WIKIGAMES_SPACE = "id:org.wikipedia.alpha:id/snackbar_text";
            TITLE_BY_SUBSTRING_TPL = "xpath://*[@resource-id='pcs']//*[@text='{SUBSTRING}']";
            FOOTER_ELEMENT = "xpath://*[@text='View article in browser']";
            SAVE_OPTION_BUTTON = "id:org.wikipedia.alpha:id/page_save";
            OPTIONS_ADD_TO_LIST = "xpath://android.widget.Button[@resource-id='org.wikipedia.alpha:id/snackbar_action']";
            MY_LIST_INPUT_FIELD = "id:org.wikipedia.alpha:id/text_input";
            MY_LIST_OK_BUTTON = "id:android:id/button1";
            BACK_FROM_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
            CLOSE_SEARCH_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }
    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
