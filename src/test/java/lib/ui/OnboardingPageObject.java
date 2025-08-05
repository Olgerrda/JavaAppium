package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OnboardingPageObject extends MainPageObject {

    protected static String
            SKIP_ONBOARDING_BUTTON,

            ONBOARDING_SCREEN_TITLE_TPL,
            ONBOARDING_DONE_BUTTON,
            WIKIPEDIA_HEADER,
            LEARN_MORE_LINK,
            NEW_WAYS_TO_EXPLORE,
            ADD_EDIT_PREFERRED_LANG,
            LEARN_MORE_ABOUT_DATA,
            NEXT_BUTTON,
            GET_STARTED_BUTTON,
            SKIP_BUTTON;

    public OnboardingPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickSkipOnboarding() {
        if (!Platform.getInstance().isMW()) {
            this.waitForElementAndClick(SKIP_ONBOARDING_BUTTON, "Cannot find Skip button", 15);
        }
    }

    public void waitForSkipOnboarding() {
        this.waitForElementPresent(SKIP_ONBOARDING_BUTTON, "Cannot find Skip button", 15);
    }

    public void swipeOnboarding(int max_swipes) {
        this.swipeLeftToElement(GET_STARTED_BUTTON,"Cannot find Get started button", max_swipes);
    }

    public void swipeOnboardingLeft(int time_of_swipe_ms) {
        this.swipeLeft(time_of_swipe_ms);
    }

    public void waitForNextOnboardingScreenPresent(String screen_title) {
        this.waitForElementPresent
                (getLocatorOfElement(ONBOARDING_SCREEN_TITLE_TPL, screen_title), "Cannot load onboarding screen with title " + screen_title, 15);
    }

    public void finishOnboarding () {
        this.waitForElementAndClick
                (GET_STARTED_BUTTON, "Cannot find Get Started button ", 15);
        this.waitForElementPresent
                (WIKIPEDIA_HEADER, "Cannot find Wikipedia header", 15);
    }

    public void waitForLearnMoreLink() {
        this.waitForElementPresent(LEARN_MORE_LINK, "Cannot find 'Learn more about Wikipedia' link", 20);
    }

    public void waitForNewWaysToExploreText() {
        this.waitForElementPresent(NEW_WAYS_TO_EXPLORE, "Cannot find 'New Ways to Explore' header", 10);
    }

    public void waitForAddOrEditPreferredLangLink() {
        this.waitForElementPresent(ADD_EDIT_PREFERRED_LANG, "Cannot find 'Add or Edit Preferred Lang' link", 10);
    }

    public void waitForLearnMoreAboutDataCollectedLink() {
        this.waitForElementPresent(LEARN_MORE_ABOUT_DATA, "Cannot find 'Learn more about data collected' link", 10);
    }

    public void clickNextButton() {
        this.waitForElementAndClick(NEXT_BUTTON, "Cannot find and click Next button", 10);
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find and click Get Started button", 10);
    }

    public void clickSkip() {
        this.waitForElementAndClick(SKIP_BUTTON, "Cannot find Skip button", 20);
    }
}
