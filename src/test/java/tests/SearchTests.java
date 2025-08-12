package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.OnboardingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.OnboardingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for search articles")
public class SearchTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value="Search"),@Feature(value="Onboarding")})
    @DisplayName("Simple article search")
    @Description("Search for 'Java' and make sure 'Java Object-oriented programing language' article is found")
    @Severity(value = SeverityLevel.BLOCKER)
    @Step("Starting test testSimpleSearch")
    public void testSimpleSearch() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");
    }

    @Test
    @Features(value = {@Feature(value="Search"),@Feature(value="Onboarding")})
    @DisplayName("Cancel search")
    @Description("Search for 'Java' and then cancel search")
    @Severity(value = SeverityLevel.NORMAL)
    @Step("Starting test testCancelSearch")
    public void testCancelSearch() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    @Features(value = {@Feature(value="Search"),@Feature(value="Onboarding")})
    @DisplayName("Search articles and get amount of found articles")
    @Description("We search for 'Linkin Park discography' and make sure not null results found")
    @Severity(value = SeverityLevel.NORMAL)
    @Step("Starting test testAmountOfNotEmptySearch")
    public void testAmountOfNotEmptySearch() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();

        String search_line = "Linkin Park discography";
        SearchPageObject.typeSearchLine(search_line);

        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        Assert.assertTrue("We found too few results", amount_of_search_results > 0);
    }

    @Test
    @Features(value = {@Feature(value="Search"),@Feature(value="Onboarding")})
    @DisplayName("Search articles and get 0 found articles")
    @Description("We search for 'adsfalskflkr' and make sure no results found")
    @Severity(value = SeverityLevel.MINOR)
    @Step("Starting test testAmountOfEmptySearch")
    public void testAmountOfEmptySearch() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.clickSkipOnboarding();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();

        String search_line = "adsfalskflkr";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch(search_line);
    }

}
