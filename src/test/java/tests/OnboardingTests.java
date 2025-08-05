package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.OnboardingPageObject;
import lib.ui.factories.OnboardingPageObjectFactory;
import org.junit.Test;

public class OnboardingTests extends CoreTestCase {

    @Test
    public void testSwipeOnboarding() {
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.waitForSkipOnboarding();
        OnboardingPageObject.swipeOnboarding(6);
    }

    @Test
    public void testPassThroughWelcome() {
        if (Platform.getInstance().isAndroid()) {
            return;
        }
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.waitForLearnMoreLink();
        OnboardingPageObject.clickNextButton();
        OnboardingPageObject.waitForNewWaysToExploreText();
        OnboardingPageObject.clickNextButton();
        OnboardingPageObject.waitForAddOrEditPreferredLangLink();
        OnboardingPageObject.clickNextButton();
        OnboardingPageObject.waitForLearnMoreAboutDataCollectedLink();
        OnboardingPageObject.clickGetStartedButton();
    }

}
