package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.models.pages.LoginScreenMod02;

public class LoginTestMod02 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            LoginScreenMod02 loginScreenMod02 = new LoginScreenMod02(appiumDriver);

            loginScreenMod02.bottomNavComp().clickOnIconLogin();
            loginScreenMod02.loginFormComponentMod02().userNameElem("teo@sth.com");
            loginScreenMod02.loginFormComponentMod02().passWordElem("12345678");
            loginScreenMod02.loginFormComponentMod02().clickOnBtnLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
