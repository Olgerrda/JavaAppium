package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.OnboardingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.OnboardingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    public void testChangeScreenOrientationOnSearchResults() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickAtArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.closeWikipediaGamesDialog();

        String article_title = "Java (programming language)";
        String title_before_rotation = ArticlePageObject.getArticleTitle(article_title);
        rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleTitle(article_title);
        assertEquals("Article title has been changed after rotation", title_before_rotation, title_after_rotation);
        rotateScreenPortrait();
        String title_after_second_rotation = ArticlePageObject.getArticleTitle(article_title);
        assertEquals("Article title has been changed after second rotation", title_before_rotation, title_after_second_rotation);
    }

    @Test
    public void testCheckSearchArticleInBackground() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        this.backgroundApp(2);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

}
