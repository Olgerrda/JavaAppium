package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ReadingListsPageObject extends MainPageObject {

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            GOT_IT_DIALOG_BUTTON,
            DELETE_SAVED_ARTICLE_BUTTON;

    public ReadingListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void openFolderByName(String folder_name) {
        String folder_name_locator = getLocatorOfElement(FOLDER_BY_NAME_TPL, folder_name);
        this.waitForElementAndClick
                (folder_name_locator, "Cannot find folder by name " + folder_name, 5);
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_title_locator = getLocatorOfElement(ARTICLE_BY_TITLE_TPL, article_title);
        this.waitForElementPresent
                (article_title_locator, "Cannot find saved article by title " + article_title, 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_title_locator = getLocatorOfElement(ARTICLE_BY_TITLE_TPL, article_title);
        this.waitForElementNotPresent
                (article_title_locator, "Cannot delete saved article " + article_title, 15);
    }

    public void swipeByArticleToDelete(String article_title) {
        String article_title_locator = getLocatorOfElement(ARTICLE_BY_TITLE_TPL, article_title);
        this.waitForArticleToAppearByTitle(article_title);
        this.swipeElementToLeft
                (article_title_locator, "Cannot find saved article");

        if (Platform.getInstance().isIOS()) {
            this.waitForElementAndClick(DELETE_SAVED_ARTICLE_BUTTON, "Cannot find Delete saved article button", 5);
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void clickCloseDialogButton() {
        this.waitForElementAndClick
                (GOT_IT_DIALOG_BUTTON, "Cannot find Got it dialog button", 5);
    }
}
