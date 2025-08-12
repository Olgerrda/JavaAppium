package lib.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {

    protected static String
            SEARCH_INPUT_INITIAL,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESUL_ELEMENT,
            SEARCH_EMPTY_RESULTS_ELEMENT,
            SEARCH_RESULTS_LIST_TPL;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Initializing the search field")
    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INPUT_INITIAL, "Cannot find and click init search element", 5);
    }

    @Step("Clicking button to cancel search result")
    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find search back button and click on it", 5);
    }

    @Step("Waiting for search cancel button to disappear")
    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search back button is still present", 5);
    }

    @Step("Typing '{search_line}' to the search line")
    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 20);
    }

    @Step("Waiting for search result")
    public void waitForSearchResult(String search_string){
        String search_result_xpath = getLocatorOfElement(SEARCH_RESULT_BY_SUBSTRING_TPL, search_string);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with search_string " + search_string, 15);
        screenshot(this.takeScreenshot("search_res"));
    }

    @Step("Waiting for search result and select an article by substring in article title")
    public void clickAtArticleWithSubstring(String search_string){
        String search_result_xpath = getLocatorOfElement(SEARCH_RESULT_BY_SUBSTRING_TPL, search_string);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with search_string " + search_string, 10);
    }

    @Step("Getting amount of found articles")
    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(SEARCH_RESUL_ELEMENT, "Cannot find anything by request", 15);
        return this.getAmountOfElements(SEARCH_RESUL_ELEMENT);
    }

    @Step("Waiting for empty result label")
    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULTS_ELEMENT, "Cannot find empty result element", 15);
    }

    @Step("Making sure there are no results for the search")
    public void assertThereIsNoResultOfSearch(String search_string) {
        this.assertElementNotPresent(getLocatorOfElement(SEARCH_RESULT_BY_SUBSTRING_TPL, search_string), "We supposed not find any results");
        screenshot(this.takeScreenshot("no_results"));
    }

    @Step("Waiting for multiple search results")
    public void waitForMultipleSearchResults (String search_string) {
        waitForMultipleElementsPresent
                (getLocatorOfElement(SEARCH_RESULTS_LIST_TPL, search_string), "No search results found", 15);
        screenshot(this.takeScreenshot("multiple"));
    }

    @Step("Waiting for no search results presented")
    public void waitForNoSearchResultsPresent(String search_string) {
        waitForElementNotPresent
                (getLocatorOfElement(SEARCH_RESULTS_LIST_TPL, search_string), "Search results are still present on the page", 5);

    }
}
