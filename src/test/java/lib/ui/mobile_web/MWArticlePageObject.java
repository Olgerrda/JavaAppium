package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE_BY_SUBSTRING_TPL = "xpath://span[contains(@class, 'mw-page-title-main') and contains(text(), '{SUBSTRING}')]"; //"css:span.mw-page-title-main[contains(text(),'{SUBSTRING}')]";
        FOOTER_ELEMENT = "css:footer";
        //SAVE_OPTION_BUTTON = "id:org.wikipedia.alpha:id/page_save";
        OPTIONS_ADD_TO_LIST = "css:#page-actions-watch a#ca-watch";
        //MY_LIST_INPUT_FIELD = "id:org.wikipedia.alpha:id/text_input";
       // MY_LIST_OK_BUTTON = "id:android:id/button1";
        //BACK_FROM_ARTICLE_BUTTON = "id:Back";
        //CLOSE_SEARCH_BUTTON = "xpath://XCUIElementTypeButton[@name='Cancel']";
    }
    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
