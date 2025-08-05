package lib.ui.ios;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INPUT_INITIAL = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeButton[@name='Cancel']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESUL_ELEMENT = "xpath://XCUIElementTypeCell";
        SEARCH_EMPTY_RESULTS_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        SEARCH_RESULTS_LIST_TPL = "xpath://XCUIElementTypeStaticText[contains(@value,'{SUBSTRING}')]";
    }

    public iOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
