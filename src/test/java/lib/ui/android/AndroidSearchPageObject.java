package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INPUT_INITIAL = "xpath://*[contains(@text, 'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text, 'Search Wikipedia')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia.alpha:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia.alpha:id/search_results_list']//*[contains(@text,'{SUBSTRING}')]";
        SEARCH_RESUL_ELEMENT = "xpath://*[contains(@text, 'Linkin Park discography')]";
        SEARCH_EMPTY_RESULTS_ELEMENT = "xpath://*[@text='No results']";
        SEARCH_RESULTS_LIST_TPL = "xpath://*[@resource-id='org.wikipedia.alpha:id/page_list_item_title' and contains(@text, '{SUBSTRING}')]";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
