package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.util.List;

import java.time.Duration;

public class SwipeHorizontally {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            //navigate to Login form
            MobileElement mnLoginEle = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            mnLoginEle.click();

            WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 5L);
            webDriverWait.until(ExpectedConditions.
                    visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Swipe horizontal\")")));

            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartPoint = 90 * screenWidth / 100;
            int xEndPoint = 10 * screenWidth / 100;
            int yStartPoint = 70 * screenHeight / 100;
            int yEndPoint = 70 * screenHeight / 100;

            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction<>(appiumDriver);
            final int MAX_SWIPE = 5;
//            for (int i = 0; i < MAX_SWIPE; i++) {
//                touchAction
//                        .press(startPoint)
//                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
//                        .moveTo(endPoint)
//                        .release()
//                        .perform();
//            }
//            MobileElement horizontallyElem = appiumDriver.findElement(MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])/android.widget.TextView"));
//            MobileElement horizontallyElem = appiumDriver.findElement(MobileBy
//                    .AndroidUIAutomator("new UiSelector().textContains(\"TDD\")"));
//            System.out.println(horizontallyElem.getText());
            //           MobileElement horizontallyElem = appiumDriver.findElement(MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])/android.widget.TextView"));
//            List<MobileElement> textViewHorizonElem = appiumDriver.findElements(MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])/android.widget.TextView"));

            int i = 0;
//            while (!textViewHorizonElem.get(0).getText().equals("COMPATIBLE")) {
//                touchAction
//                        .press(startPoint)
//                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
//                        .moveTo(endPoint)
//                        .release()
//                        .perform();
//                i++;
//                System.out.println("+++++++++++++++++++++++");
//                System.out.println(i);
//                System.out.println(textViewHorizonElem.get(0).getText());
//
//            }


            boolean check = true;
//            do{
//                touchAction
//                        .press(startPoint)
//                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
//                        .moveTo(endPoint)
//                        .release()
//                        .perform();
//                List<MobileElement> textViewHorizonElem = appiumDriver.findElements(MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])/android.widget.TextView"));
//                if (textViewHorizonElem.get(0).getText().equals("COMPATIBLE")) {
//                    check = false;
//                    System.out.println(textViewHorizonElem.get(0).getText());
//                }
//                System.out.println(textViewHorizonElem.get(0).getText());
//            }
            //           while (check);
            while (check & i < 6) {
                List<MobileElement> textViewHorizonElem = appiumDriver.findElements(MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"slideTextContainer\"])/android.widget.TextView"));
                System.out.println(i + "\t" + textViewHorizonElem.get(0).getText());
                touchAction
                        .press(startPoint)
                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                        .moveTo(endPoint)
                        .release()
                        .perform();


                if (textViewHorizonElem.get(0).getText().equals("COMPATIBLE")) {
                    check = false;
                    System.out.println(textViewHorizonElem.get(0).getText());
                }
                i++;
                System.out.println("+++++++++++++++++++++++");

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
