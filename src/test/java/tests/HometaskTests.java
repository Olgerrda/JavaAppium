package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.OnboardingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.OnboardingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

@Epic("Hometasks tests")
public class HometaskTests extends CoreTestCase {

    //Ex3
    @Test
    @Features(value = {@Feature(value="Onboarding"),@Feature(value="Search")})
    @DisplayName("Ex3 - Cancel search")
    @Description("Search for 'Batman' and then cancel search")
    @Severity(value = SeverityLevel.NORMAL)
    @Step("Starting test testCancelSearch")
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
    @Features(value = {@Feature(value="Onboarding")})
    @DisplayName("Ex5 - Swipe onboarding with wait for the next screen")
    @Description("Pass through Onboarding with Next button wait and click")
    @Severity(value = SeverityLevel.NORMAL)
    @Step("Starting test testSwipeOnboardingWithWaitForNextScreen")
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
    @Features(value = {@Feature(value="Search"),@Feature(value="Article"),@Feature(value="Onboarding")})
    @DisplayName("Compare article title with expected one")
    @Description("Open 'Java Object-oriented programing language' and make sure the title is as expected")
    @Severity(value = SeverityLevel.NORMAL)
    @Step("Starting test testArticleTitlePresent")
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

