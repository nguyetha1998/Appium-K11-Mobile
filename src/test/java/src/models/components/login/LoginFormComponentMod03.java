package src.models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponentMod03 {
    AppiumDriver<MobileElement> appiumDriver;

    private static final By userNameSel = MobileBy.AccessibilityId("input-email");
    private static final By passwordSel = MobileBy.AccessibilityId("input-password");
    private static final By btnLoginSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponentMod03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public LoginFormComponentMod03 userNameElem(String userName) {
        appiumDriver.findElement(userNameSel).sendKeys(userName);
        return this;
    }

    public LoginFormComponentMod03 passWordElem(String password) {
         appiumDriver.findElement(passwordSel).sendKeys(password);
         return this;
    }

    public LoginFormComponentMod03 clickOnBtnLogin() {
         appiumDriver.findElement(btnLoginSel).click();
         return this;
    }
}
