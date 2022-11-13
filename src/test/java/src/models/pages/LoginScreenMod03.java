package src.models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.models.components.global.BottomNavComp;
import src.models.components.login.LoginFormComponentMod03;

public class LoginScreenMod03 {
    private final AppiumDriver<MobileElement> appiumDriver;


    public LoginScreenMod03(AppiumDriver<MobileElement> appiumDriver) {

        this.appiumDriver = appiumDriver;
    }

    public BottomNavComp bottomNavComp() {
        return new BottomNavComp(appiumDriver);
    }

    public LoginFormComponentMod03 loginFormComponentMod03() {
        return new LoginFormComponentMod03(appiumDriver);
    }
}
