package src.models.components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import src.driver.DriverFactory;
import src.driver.Platform;

public class BottomNavComp {
    AppiumDriver<MobileElement> appiumDriver;
    private static final By navLoginBtnSel = MobileBy.AccessibilityId("Login");

    public BottomNavComp(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public MobileElement loginIconElem(){
        return appiumDriver.findElement(navLoginBtnSel);
    }
    public  void clickOnIconLogin(){
        appiumDriver.findElement(navLoginBtnSel).click();
    }
}
