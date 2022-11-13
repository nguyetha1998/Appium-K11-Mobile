package src.models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import src.models.components.global.BottomNavComp;
import src.models.components.login.LoginFormComponent;

public class LoginScreenMod01 {
    private final AppiumDriver<MobileElement> appiumDriver;


    public LoginScreenMod01(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public BottomNavComp bottomNavComp(){
        return new BottomNavComp(appiumDriver);
    }
    public LoginFormComponent loginFormComponent(){
        return new LoginFormComponent(appiumDriver);
    }
}
