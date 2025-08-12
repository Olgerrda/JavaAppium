package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.OnboardingPageObject;
import lib.ui.factories.OnboardingPageObjectFactory;
import org.junit.Test;

@Epic("Tests for  Onboarding (Android and iOS)")
public class OnboardingTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value="Onboarding")})
    @DisplayName("Swipe Onboarding screens")
    @Description("Pass through Onboarding using swipes")
    @Severity(value = SeverityLevel.NORMAL)
    @Step("Starting test testSwipeOnboarding")
    public void testSwipeOnboarding() {
        if (Platform.getInstance().isMW()) {
            return;
        }
        OnboardingPageObject OnboardingPageObject = OnboardingPageObjectFactory.get(driver);
        OnboardingPageObject.waitForSkipOnboarding();
        OnboardingPageObject.swipeOnboarding(6);
    }

    @Test
    @Features(value = {@Feature(value="Onboarding")})
    @DisplayName("Pass Onboarding screens")
    @Description("Pass through Onboarding with Next button click")
    @Severity(value = SeverityLevel.NORMAL)
    @Step("Starting test testPassThroughWelcome")
    public void testPassThroughWelcome() {
        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMW())) {
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
