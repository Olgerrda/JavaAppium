package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.OnboardingPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSOnboardingPageObject extends OnboardingPageObject {

    static {
        SKIP_ONBOARDING_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";
        ONBOARDING_SCREEN_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']";
        WIKIPEDIA_HEADER = "id:wikipedia";
        LEARN_MORE_LINK = "xpath://XCUIElementTypeStaticText[@name='Learn more about Wikipedia']";
        NEW_WAYS_TO_EXPLORE = "id:New ways to explore";
        ADD_EDIT_PREFERRED_LANG = "xpath://XCUIElementTypeButton[@name='Add or edit preferred languages']";
        LEARN_MORE_ABOUT_DATA = "xpath://XCUIElementTypeButton[@name='Learn more about data collected']";
        NEXT_BUTTON = "xpath://XCUIElementTypeButton[@name='Next']";
        GET_STARTED_BUTTON = "xpath://XCUIElementTypeButton[@name='Get started']";
    }
    public iOSOnboardingPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
