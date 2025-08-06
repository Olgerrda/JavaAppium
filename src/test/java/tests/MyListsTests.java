package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";
    private static final String
            login = "Olgalearn",
            password = "Test12345678";

    @Test
    public void testSaveFirstArticleToMyList() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickAtArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.closeWikipediaGamesDialog();
        String title = "Java (programming language)";
        ArticlePageObject.waitForTitleElement(title);

        String article_title = ArticlePageObject.getArticleTitle(title);

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }
        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement(title);
            assertEquals("We are not on the same page after login", article_title, ArticlePageObject.getArticleTitle(title));
            ArticlePageObject.addArticleToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();

        ReadingListsPageObject ReadingListsPageObject = ReadingListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            ReadingListsPageObject.openFolderByName(name_of_folder);
        }
        ReadingListsPageObject.clickCloseDialogButton();
        ReadingListsPageObject.deleteArticleFromReadingList(article_title);
    }

    @Test
    public void testDeleteOneOfTwoSavedArticles() {
        if (Platform.getInstance().isMW()) {
            OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
            OnboardingPageObject.clickSkipOnboarding();

            SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
            SearchPageObject.initSearchInput();
            String search_line =  "Java";
            SearchPageObject.typeSearchLine(search_line);
            SearchPageObject.clickAtArticleWithSubstring("bject-oriented programming language");

            ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
            String title = "Java (programming language)";
            ArticlePageObject.waitForTitleElement(title);
            ArticlePageObject.addArticleToMySaved();

            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement(title);
            assertEquals("We are not on the same page after login", title, ArticlePageObject.getArticleTitle(title));
            ArticlePageObject.addArticleToMySaved();

            SearchPageObject.initSearchInput();
            SearchPageObject.typeSearchLine(search_line);
            SearchPageObject.clickAtArticleWithSubstring("igh-level programming language");
            ArticlePageObject.addArticleToMySaved();

            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openNavigation();
            NavigationUI.clickMyLists();

            ReadingListsPageObject ReadingListsPageObject = ReadingListsPageObjectFactory.get(driver);
            ReadingListsPageObject.deleteArticleFromReadingList(search_line);
            ReadingListsPageObject.checkArticleInReadingList(search_line);
        } else {
            System.out.println("Test applicable only for mobile web");
        }
    }

}
