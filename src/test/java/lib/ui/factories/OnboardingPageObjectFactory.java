package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.OnboardingPageObject;
import lib.ui.android.AndroidOnboardingPageObject;
import lib.ui.ios.iOSOnboardingPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OnboardingPageObjectFactory {

    public static OnboardingPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidOnboardingPageObject(driver);
        } else {
            return new iOSOnboardingPageObject(driver);
        }
    }
}
