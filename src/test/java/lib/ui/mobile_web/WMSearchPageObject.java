package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WMSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INPUT_INITIAL = "css:button#searchIcon";
        SEARCH_INPUT = "css:input.cdx-text-input__input";
        SEARCH_CANCEL_BUTTON = "css:button[aria-label='Close search dialog']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://span[contains(@class,'cdx-menu-item__text__description')]/bdi[contains(text(),'{SUBSTRING}')]";
        SEARCH_RESUL_ELEMENT = "css:ul.cdx-menu__listbox>li.cdx-menu-item";
        SEARCH_EMPTY_RESULTS_ELEMENT = "css:p.mw-search-nonefound";
        SEARCH_RESULTS_LIST_TPL = "xpath://XCUIElementTypeStaticText[contains(@value,'{SUBSTRING}')]";
    }

    public WMSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
