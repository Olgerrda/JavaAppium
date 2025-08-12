package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
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
            OPTIONS_REMOVE_FROM_LIST,
            MY_LIST_INPUT_FIELD,
            MY_LIST_OK_BUTTON,
            BACK_FROM_ARTICLE_BUTTON,
            CLOSE_SEARCH_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Closing Wikipedia games dialog (the method does nothing for iOS and Mobile Web)")
    public void closeWikipediaGamesDialog() {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(WIKIGAMES_DIALOG_CLOSE_BUTTON, "Cannot find dialog's close button", 15);
            this.waitForElementAndClick(AFTER_WIKIGAMES_SPACE, "Cannot find space to click after closing dialog", 15);
        }
    }

    @Step("Waiting for title on the article page")
    public WebElement waitForTitleElement(String substring) {
        String search_result_xpath = getLocatorOfElement(TITLE_BY_SUBSTRING_TPL, substring);
        return this.waitForElementPresent(search_result_xpath, "Cannot find title " + substring + " on page", 15);
    }

    @Step("Getting article title")
    public String getArticleTitle(String substring) {
        WebElement title_element = waitForTitleElement(substring);
        screenshot(this.takeScreenshot("article_title"));
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }

    }

    @Step("Swiping to footer on article page")
    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        } else if (Platform.getInstance().isIOS()){
            this.swipeUpTillElementAppear(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        } else {
            this.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        }
    }

    @Step("Adding the article to my list")
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

    @Step("Adding the article to my saved articles")
    public void addArticleToMySaved() {
        if (Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_LIST, "Cannot find option to add article to reading list", 5);
    }

    @Step("Removing the article from saved if it has been added")
    public void removeArticleFromSavedIfAdded() {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_LIST)) {
            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_LIST, "Cannot click button to remove from saved", 1);
            this.waitForElementPresent(OPTIONS_ADD_TO_LIST, "Cannot find button to add article to saved list after removing it from this list before");
        }
    }

    @Step("Closing the article")
    public void closeArticle() {
        if ((Platform.getInstance().isIOS()) || (Platform.getInstance().isAndroid())) {
            this.waitForElementAndClick(
                    BACK_FROM_ARTICLE_BUTTON, "Cannot close article, cannot find back link", 5);
            this.waitForElementAndClick(
                    CLOSE_SEARCH_BUTTON, "Cannot close search list, cannot find X button", 5);
        } else {
            System.out.println("Method closeArticle() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    @Step("Checking the article's title")
    public void checkArticleTitle(String substring) {
        this.assertElementPresent(getLocatorOfElement(TITLE_BY_SUBSTRING_TPL, substring), "Cannot find the title of article");
    }
}
