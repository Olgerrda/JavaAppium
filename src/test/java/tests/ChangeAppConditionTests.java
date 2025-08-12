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
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for change application condition (Android and iOS)")
public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value="Onboarding"),@Feature(value="Search"),@Feature(value="Article"),@Feature(value="App State Changes")})
    @DisplayName("Change screen orientation on search article page")
    @Description("Open found article, rotate screen twice and make sure article title was not changed")
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Starting test testChangeScreenOrientationOnSearchResults")
    public void testChangeScreenOrientationOnSearchResults() {
        if (Platform.getInstance().isMW()) {
            return;
        }
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
        Assert.assertEquals("Article title has been changed after rotation", title_before_rotation, title_after_rotation);
        rotateScreenPortrait();
        String title_after_second_rotation = ArticlePageObject.getArticleTitle(article_title);
        Assert.assertEquals("Article title has been changed after second rotation", title_before_rotation, title_after_second_rotation);
    }

    @Test
    @Features(value = {@Feature(value="Onboarding"),@Feature(value="Search"),@Feature(value="Article"),@Feature(value="App State Changes")})
    @DisplayName("Move app to background on search article")
    @Description("Search for article, move app to background for 2 seconds and check search results still present")
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Starting test testCheckSearchArticleInBackground")
    public void testCheckSearchArticleInBackground() {
        if (Platform.getInstance().isMW()) {
            return;
        }
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
