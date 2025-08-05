package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            WIKIGAMES_DIALOG_CLOSE_BUTTON,
            AFTER_WIKIGAMES_SPACE,
            TITLE_BY_SUBSTRING_TPL,
            FOOTER_ELEMENT,
            SAVE_OPTION_BUTTON,
            OPTIONS_ADD_TO_LIST,
            MY_LIST_INPUT_FIELD,
            MY_LIST_OK_BUTTON,
            BACK_FROM_ARTICLE_BUTTON,
            CLOSE_SEARCH_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void closeWikipediaGamesDialog() {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(WIKIGAMES_DIALOG_CLOSE_BUTTON, "Cannot find dialog's close button", 15);
            this.waitForElementAndClick(AFTER_WIKIGAMES_SPACE, "Cannot find space to click after closing dialog", 15);
        }
    }

    public WebElement waitForTitleElement(String substring) {
        String search_result_xpath = getLocatorOfElement(TITLE_BY_SUBSTRING_TPL, substring);
        return this.waitForElementPresent(search_result_xpath, "Cannot find title " + substring + " on page", 15);
    }

    public String getArticleTitle(String substring) {
        WebElement title_element = waitForTitleElement(substring);
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }

    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        } else if (Platform.getInstance().isIOS()){
            this.swipeUpTillElementAppear(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        } else {
            this.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        }
    }

    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(
                SAVE_OPTION_BUTTON, "Cannot find button to save article", 5);
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_LIST, "Cannot find option to add article to reading list", 5);
        this.waitForElementAndClear(
                MY_LIST_INPUT_FIELD, "Cannot find text input to clear it", 5);
        this.waitForElementAndSendKeys(
                MY_LIST_INPUT_FIELD, name_of_folder,"Cannot put text into articles folder input", 5);
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON, "Cannot press Ok button", 5);
    }

    public void addArticleToMySaved() {
        this.waitForElementAndClick(OPTIONS_ADD_TO_LIST, "Cannot find option to add article to reading list", 5);
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                BACK_FROM_ARTICLE_BUTTON, "Cannot close article, cannot find back link", 5);
        this.waitForElementAndClick(
                CLOSE_SEARCH_BUTTON, "Cannot close search list, cannot find X button", 5);
    }

    public void checkArticleTitle(String substring) {
        this.assertElementPresent(getLocatorOfElement(TITLE_BY_SUBSTRING_TPL, substring), "Cannot find the title of article");
    }
}
