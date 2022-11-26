package src.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx, AppPackage {
    private AppiumDriver<MobileElement> appiumDriver;

    public static AppiumDriver<MobileElement> getDriver(Platform platform) {
        AppiumDriver<MobileElement> appiumDriver = null;

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(UDID, "34088477240024S");
        desiredCapabilities.setCapability(APP_PACKAGE, "com.wdiodemoapp");
        desiredCapabilities.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        URL appiumServer = null;
        try {
            appiumServer = new URL("http://localhost:4723/wd/hub");
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        // Interact with Mobile Element
        if (appiumDriver != null) {
            appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

            System.out.println("Connected to appium server and launched target app!");
            MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
            loginLabel.click();

        }
        switch (platform) {
            case ANDROID:
                appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);
                break;
            case IOS:
                appiumDriver = new IOSDriver<MobileElement>(appiumServer, desiredCapabilities);
                break;
            default:
                throw new IllegalArgumentException("Platform can't be null!");
        }
        appiumDriver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
        return appiumDriver;
    }

    public AppiumDriver<MobileElement> getDriver(Platform platform, String udid, String systemPort) {
        if (appiumDriver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(PLATFORM_NAME, "android");
            desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(UDID, udid);
            desiredCapabilities.setCapability(APP_PACKAGE, WEBDRIVER_IO);
            desiredCapabilities.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
            desiredCapabilities.setCapability(SYSTEM_PORT, systemPort);
            URL appiumServer = null;
            try {
                appiumServer = new URL("http://localhost:4723/wd/hub");
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }

            // Interact with Mobile Element
            if (appiumDriver != null) {
                appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

                System.out.println("Connected to appium server and launched target app!");
                MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
                loginLabel.click();

            }
            switch (platform) {
                case ANDROID:
                    appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);
                    break;
                case IOS:
                    appiumDriver = new IOSDriver<MobileElement>(appiumServer, desiredCapabilities);
                    break;
                default:
                    throw new IllegalArgumentException("Platform can't be null!");
            }
            appiumDriver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);

        }
        return appiumDriver;
    }

    public void quitDriverSession() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}
