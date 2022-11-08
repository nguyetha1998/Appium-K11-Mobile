package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.internal.CapabilityHelpers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.io.File;
import java.io.OutputStream;

public class TalkingScreenShoot {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            MobileElement navLoginBtnEle =  appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnEle.click();

            File base64ScreenShotData= appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation=System.getProperty("user.dir").concat("/screenshots/").concat("LoginScreen.png");
            FileUtils.copyFile(base64ScreenShotData,new File(fileLocation));
            //Area
            MobileElement loginScreenEle= appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));

            File base64LoginFormData= loginScreenEle.getScreenshotAs(OutputType.FILE);
            String loginFormFileLocation=System.getProperty("user.dir").concat("/screenshots/").concat("LoginFormScreen.png");
            FileUtils.copyFile(base64LoginFormData,new File(loginFormFileLocation));
            //Detech Platform
            Capabilities caps= appiumDriver.getCapabilities();
            String platform= CapabilityHelpers.getCapability(caps,"platformName",String.class);
            System.out.println("Curent platform: "+ platform);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
