package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.models.pages.LoginScreenMod01;

public class LoginTestMod01 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            LoginScreenMod01 loginScreenMod01= new LoginScreenMod01(appiumDriver);
            // cach 1
//            loginScreenMod01.bottomNavComp().loginIconElem().click();
//            loginScreenMod01.userNameElem().sendKeys("teo@sth.com");
//            loginScreenMod01.passWordElem().sendKeys("12345678");
//            loginScreenMod01.btnLoginElem().click();
            // cach 2
            loginScreenMod01.bottomNavComp().clickOnIconLogin();
            loginScreenMod01.loginFormComponent().userNameElem().sendKeys("teo@sth.com");
            loginScreenMod01.loginFormComponent().passWordElem().sendKeys("12345678");
            loginScreenMod01.loginFormComponent().btnLoginElem().click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
