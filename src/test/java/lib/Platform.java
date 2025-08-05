package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final String APPIUM_URL = "http://127.0.0.1:4723";

    private static Platform instance;

    private Platform() {}

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception {
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidCapabilities());
        } else if (this.isIOS()) {
            return new IOSDriver(URL, this.getIOSCapabilities());
        } else if (this.isMW()) {
            return new ChromeDriver(this.getMwChromeOptions());
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value " + this.getPlatformVar());
        }
    }
    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }
    public boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }
    public boolean isMW() {
        return isPlatform(PLATFORM_MOBILE_WEB);
    }
    private DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel9");
        capabilities.setCapability("platformVersion", "15");
        capabilities.setCapability("appPackage", "org.wikipedia.alpha");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", "/Users/olga/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/app-alpha-universal-release.apk");
        return capabilities;
    }
    private DesiredCapabilities getIOSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 16 Pro");
        capabilities.setCapability("platformVersion", "18.3");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", "/Users/olga/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/Wikipedia745.app");
        return capabilities;
    }
    private ChromeOptions getMwChromeOptions() {
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=360,640");
        return chromeOptions;
    }
    private boolean isPlatform(String my_platform) {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }
    public String getPlatformVar() {
        return System.getenv("PLATFORM");
    }
}
