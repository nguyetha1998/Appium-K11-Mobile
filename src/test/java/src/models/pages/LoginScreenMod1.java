package src.models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginScreenMod1 {
    private final AppiumDriver<MobileElement>  appiumDriver;
    private static final By usernameSel = MobileBy.AccessibilityId("");
    private static final By passwordSel = MobileBy.AccessibilityId("");
    private static final By btnLoginSel = MobileBy.AccessibilityId("");

    public LoginScreenMod1(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
}
