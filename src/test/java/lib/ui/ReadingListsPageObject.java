package lib.ui;

import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ReadingListsPageObject extends MainPageObject {

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            GOT_IT_DIALOG_BUTTON,
            DELETE_SAVED_ARTICLE_BUTTON,
            REMOVE_FROM_SAVED_BUTTON;

    public ReadingListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Open folder with name 'folder_name'")
    public void openFolderByName(String folder_name) {
        String folder_name_locator = getLocatorOfElement(FOLDER_BY_NAME_TPL, folder_name);
        screenshot(this.takeScreenshot("folder"));
        this.waitForElementAndClick
                (folder_name_locator, "Cannot find folder by name " + folder_name, 5);
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_title_locator = getLocatorOfElement(ARTICLE_BY_TITLE_TPL, article_title);
        this.waitForElementPresent
                (article_title_locator, "Cannot find saved article by title " + article_title, 15);
        screenshot(this.takeScreenshot("article"));
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_title_locator = getLocatorOfElement(ARTICLE_BY_TITLE_TPL, article_title);
        this.waitForElementNotPresent
                (article_title_locator, "Cannot delete saved article " + article_title, 15);
    }

    @Step("Delete article from reading list")
    public void deleteArticleFromReadingList(String article_title) {
        String article_title_locator = getLocatorOfElement(ARTICLE_BY_TITLE_TPL, article_title);
        this.waitForArticleToAppearByTitle(article_title);

        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            this.swipeElementToLeft(article_title_locator, "Cannot find saved article");
        } else {
            String remove_locator = getLocatorOfElement(REMOVE_FROM_SAVED_BUTTON, article_title);
            this.waitForElementAndClick(remove_locator, "Cannot click button to remove article from saved", 10);
            driver.navigate().refresh();
        }

        if (Platform.getInstance().isIOS()) {
            this.waitForElementAndClick(DELETE_SAVED_ARTICLE_BUTTON, "Cannot find Delete saved article button", 5);
        }
        if (!Platform.getInstance().isMW()) {
            this.waitForArticleToDisappearByTitle(article_title);
        }
        screenshot(this.takeScreenshot("article_deleted"));
    }

    @Step("Close dialog")
    public void clickCloseDialogButton() {
        if (!Platform.getInstance().isMW()) {
            this.waitForElementAndClick(GOT_IT_DIALOG_BUTTON, "Cannot find Got it dialog button", 5);
        } else {
            System.out.println("Method clickCloseDialogButton() is not applicable for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Check article 'article_title' is in the reading list")
    public void checkArticleInReadingList(String article_title) {
        String article_title_locator = getLocatorOfElement(ARTICLE_BY_TITLE_TPL, article_title);
        this.assertElementNotPresent(article_title_locator, "Article is not in the reading list");
        screenshot(this.takeScreenshot("article_title_in_reading_list"));
    }
}
