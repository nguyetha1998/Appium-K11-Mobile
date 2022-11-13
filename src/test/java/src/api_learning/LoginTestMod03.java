package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.models.components.login.LoginFormComponentMod03;
import src.models.pages.LoginScreenMod03;

public class LoginTestMod03 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            LoginScreenMod03 loginScreenMod03 = new LoginScreenMod03(appiumDriver);
            LoginFormComponentMod03 loginFormComponentMod03 = loginScreenMod03.loginFormComponentMod03();

            loginScreenMod03.bottomNavComp().clickOnIconLogin();
            loginFormComponentMod03.userNameElem("teo@sth.com").passWordElem("12345678").clickOnBtnLogin();

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
