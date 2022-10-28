package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.DriverFactory;
import src.driver.Platform;

public class LoginFormTest {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            //navigate to login page
            MobileElement navLoginBtnEle =  appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnEle.click();
            //Find login form element
            MobileElement emailTxtEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordTxtEle = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnEle = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));


            //interact login page
            emailTxtEle.sendKeys("teo@sth.com");
            passwordTxtEle.sendKeys("12345678");
            loginBtnEle.click();
            //verification dialog
            WebDriverWait webDriverWait= new WebDriverWait(appiumDriver,10L);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            //print dialog content
            MobileElement loginDialogEle= appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println("digalog conetnt:" +loginDialogEle.getText());
            //debug
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
