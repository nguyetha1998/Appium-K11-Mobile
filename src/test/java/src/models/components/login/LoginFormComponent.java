package src.models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {
    AppiumDriver<MobileElement> appiumDriver;

    private static final By userNameSel = MobileBy.AccessibilityId("input-email");
    private static final By passwordSel = MobileBy.AccessibilityId("input-password");
    private static final By btnLoginSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public MobileElement userNameElem() {
        return appiumDriver.findElement(userNameSel);
    }

    public MobileElement passWordElem() {
        return appiumDriver.findElement(passwordSel);
    }

    public MobileElement btnLoginElem() {
        return appiumDriver.findElement(btnLoginSel);
    }
}
