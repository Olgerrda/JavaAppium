package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.OnboardingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.OnboardingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class HometaskTests extends CoreTestCase {

    //Ex3
    @Test
    public void testCancelSearch() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        String search_line = "Batman";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForMultipleSearchResults(search_line);
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForNoSearchResultsPresent(search_line);
    }

    //Ex5
    @Test
    public void testSwipeOnboardingWithWaitForNextScreen() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.waitForSkipOnboarding();
        OnboardingPageObject.swipeOnboardingLeft(1000);
        OnboardingPageObject.waitForNextOnboardingScreenPresent("New ways to explore");
        OnboardingPageObject.swipeOnboardingLeft(1000);
        if (Platform.getInstance().isIOS()) {
            OnboardingPageObject.waitForNextOnboardingScreenPresent("Search in over 300 languages");
        } else {
            OnboardingPageObject.waitForNextOnboardingScreenPresent("Reading lists with sync");
        }
        OnboardingPageObject.swipeOnboardingLeft(1000);
        if (Platform.getInstance().isIOS()) {
            OnboardingPageObject.waitForNextOnboardingScreenPresent("Help make the app better");
        } else {
            OnboardingPageObject.waitForNextOnboardingScreenPresent("Data & Privacy");
        }
        OnboardingPageObject.finishOnboarding();
    }

    //Ex6
    @Test
    public void testArticleTitlePresent() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickAtArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.closeWikipediaGamesDialog();
        ArticlePageObject.checkArticleTitle("Java (programming language)");
    }
}

