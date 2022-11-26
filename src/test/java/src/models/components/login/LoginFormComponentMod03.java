package src.models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginFormComponentMod03 {
    AppiumDriver<MobileElement> appiumDriver;

    private static final By userNameSel = MobileBy.AccessibilityId("input-email");
    private static final By incorrectEmailSel = MobileBy.xpath("//*[contains(@text,'Please enter a valid email address')]");
    private static final By passwordSel = MobileBy.AccessibilityId("input-password");
    private static final By incorrectPasswordSel = MobileBy.xpath("//*[contains(@text,'Please enter at least 8 characters')]");
    private static final By btnLoginSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponentMod03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Input userName as {userName}")
    public LoginFormComponentMod03 userNameElem(String userName) {
        MobileElement userNameElem= appiumDriver.findElement(userNameSel);
        userNameElem.clear();
        userNameElem.sendKeys(userName);
        return this;
    }

    public String incorrectUserNameTxt() {
        return appiumDriver.findElement(incorrectEmailSel).getText();
    }
    @Step("Input password as {password}")
    public LoginFormComponentMod03 passWordElem(String password) {
        MobileElement passwordElem= appiumDriver.findElement(passwordSel);
        passwordElem.clear();
        passwordElem.sendKeys(password);
        return this;
    }
    public String incorrectPasswordTxt() {
        return appiumDriver.findElement(incorrectPasswordSel).getText();
    }
    @Step("Click on button Login")
    public LoginFormComponentMod03 clickOnBtnLogin() {
        appiumDriver.findElement(btnLoginSel).click();
        return this;
    }
}
