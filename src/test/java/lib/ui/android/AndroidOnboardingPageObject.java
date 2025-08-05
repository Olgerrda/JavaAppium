package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.OnboardingPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidOnboardingPageObject extends OnboardingPageObject {
    static  {
        SKIP_ONBOARDING_BUTTON = "xpath://*[contains(@text, 'Skip')]";
        GET_STARTED_BUTTON = "id:org.wikipedia.alpha:id/fragment_onboarding_done_button";
        ONBOARDING_SCREEN_TITLE_TPL = "xpath://*[contains(@text, '{SUBSTRING}')]";
        ONBOARDING_DONE_BUTTON = "id:org.wikipedia.alpha:id/fragment_onboarding_done_button";
        WIKIPEDIA_HEADER = "id:org.wikipedia.alpha:id/main_toolbar_wordmark";
    }
    public AndroidOnboardingPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
