package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.util.List;

public class XPathLearning {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver= DriverFactory.getDriver(Platform.ANDROID);
        try {
            //navigate to Login form
           MobileElement mnLoginEle= appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            mnLoginEle.click();
            List<MobileElement> credFieldsdEle= appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USERNAME_INDEX=0;
            final int PASSWORD_INDEX=1;
            credFieldsdEle.get(USERNAME_INDEX).sendKeys("teo@sth.com");
            credFieldsdEle.get(PASSWORD_INDEX).sendKeys("12345678");

            MobileElement loginInstructionElem= appiumDriver.findElement(MobileBy
                    .AndroidUIAutomator("new UiSelector().textContains(\"When the device\")"));
            System.out.println(loginInstructionElem.getText());
            Thread.sleep(3000);


        }
        catch (Exception e){
          e.printStackTrace();
        }
    }
}
