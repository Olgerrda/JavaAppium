package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {

    static {
        TAB_READING_LISTS = "css:li>a.menu__item--watchlist";
        OPEN_NAVIGATION = "css:#main-menu-input";
    }

    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
