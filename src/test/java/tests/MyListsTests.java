package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";

    @Test
    public void testSaveFirstArticleToMyList() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickAtArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.closeWikipediaGamesDialog();
        ArticlePageObject.waitForTitleElement("Java (programming language)");

        String article_title = ArticlePageObject.getArticleTitle("Java (programming language)");

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        ReadingListsPageObject ReadingListsPageObject = ReadingListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            ReadingListsPageObject.openFolderByName(name_of_folder);
        }
        ReadingListsPageObject.clickCloseDialogButton();
        ReadingListsPageObject.swipeByArticleToDelete(article_title);
    }

}
