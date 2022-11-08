package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.context.Contexts;
import src.context.WaitMoreThanOneContext;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.util.ArrayList;
import java.util.List;


public class HybridContext {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            appiumDriver.findElement(MobileBy.AccessibilityId("Webview")).click();
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
            wait.until(new WaitMoreThanOneContext(appiumDriver));

            for (String contextHandle : appiumDriver.getContextHandles()) {
                System.out.println("Context:" + contextHandle);
            }
            appiumDriver.context(Contexts.WEB_VIEW);
            WebElement navToggleBtnEle = appiumDriver.findElementByCssSelector(".navbar__toggle ");
            navToggleBtnEle.click();
            List<MenuItemData> menuItemDataList= new ArrayList<>();
            List<MobileElement> mobileElementList = appiumDriver.findElementsByCssSelector(".menu__list li a");
            if (mobileElementList.isEmpty()) {
                throw new RuntimeException("ERR");
            }
            for (MobileElement menuItem : mobileElementList) {
                String itemText= menuItem.getText();
                String itemHref= menuItem.getAttribute("href");
                if (itemText.isEmpty()){
                    menuItemDataList.add(new MenuItemData("Github",itemHref));
                  //  System.out.println("Github: "+ itemHref);
                }
                else {
                    menuItemDataList.add(new MenuItemData(itemText,itemHref));
                  //  System.out.println(itemText.concat(": ")+ itemHref);
                }
                List<MenuItemData> expectedMenu= new ArrayList<>();

            }
            System.out.println(menuItemDataList);

            appiumDriver.context(Contexts.NATIVE);
            appiumDriver.findElement(MobileBy.AccessibilityId("Home")).click();
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
    public static class MenuItemData{
        private final String name;
        private final String href;

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        @Override
        public String toString() {
            return "MenuItemData{" +
                    "name='" + name + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }
}
