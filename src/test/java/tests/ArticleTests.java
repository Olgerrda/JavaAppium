package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.AllureJunit4;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.OnboardingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.OnboardingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for articles")
public class ArticleTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value="Search"),@Feature(value="Article")})
    @DisplayName("Compare article title with expected one")
    @Description("We open 'Java Object-oriented programing language' and make sure the title is as expected")
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Starting test testCompareArticleTitle")
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
        Assert.assertEquals("We see unexpected title", "Java (programming language)", expected_title);
    }

    @Test
    @Features(value = {@Feature(value="Search"),@Feature(value="Article")})
    @DisplayName("Swipe article to the footer")
    @Description("We open an article and swipe it to the footer")
    @Severity(value = SeverityLevel.NORMAL)
    @Step("Starting test testSwipeArticle")
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
