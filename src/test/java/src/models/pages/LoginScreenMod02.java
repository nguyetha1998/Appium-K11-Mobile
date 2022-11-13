package src.models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.models.components.global.BottomNavComp;
import src.models.components.login.LoginFormComponentMod02;

public class LoginScreenMod02 {
    private final AppiumDriver<MobileElement> appiumDriver;


    public LoginScreenMod02(AppiumDriver<MobileElement> appiumDriver) {

        this.appiumDriver = appiumDriver;
    }

    public BottomNavComp bottomNavComp() {
        return new BottomNavComp(appiumDriver);
    }

    public LoginFormComponentMod02 loginFormComponentMod02() {
        return new LoginFormComponentMod02(appiumDriver);
    }
}
