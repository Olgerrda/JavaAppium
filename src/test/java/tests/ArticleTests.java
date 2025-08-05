package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.OnboardingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.OnboardingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testCompareArticleTitle() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickAtArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.closeWikipediaGamesDialog();

        String expected_title = ArticlePageObject.getArticleTitle("Java (programming language)");
        assertEquals("We see unexpected title", "Java (programming language)", expected_title);
    }

    @Test
    public void testSwipeArticle() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Appium";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickAtArticleWithSubstring("Automation for Apps");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.closeWikipediaGamesDialog();
        ArticlePageObject.waitForTitleElement(search_line);
        ArticlePageObject.swipeToFooter();
    }
}
