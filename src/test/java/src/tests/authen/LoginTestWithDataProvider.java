package src.tests.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import src.driver.DriverFactory;
import src.driver.Platform;
import src.test_data.models.LoginCred;
import src.test_data.untils.DataObjectBuilder;
import src.test_flows.authenication.LoginFlow;

import java.util.ArrayList;
import java.util.List;

public class LoginTestWithDataProvider {
    @Test(dataProvider = "loginData")
    public void testLogin(LoginCred loginCred) {
//        System.out.println(loginCred);

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            String userName = loginCred.getUserName();
            String password = loginCred.getPassword();
            LoginFlow loginFlow = new LoginFlow(appiumDriver, userName, password);
            loginFlow.goToLoginScreen();
            loginFlow.login();
            loginFlow.verifyLogin();

        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }

    @DataProvider(name = "loginData")
    private LoginCred[] loginCredListDataSet() {
//        LoginCred[] loginCredList = new LoginCred[]{
//                new LoginCred("", ""),
//                new LoginCred("teso", "12345678"),
//                new LoginCred("teo@sth.com", "1234567"),
//                new LoginCred("teo@sth.com", "12345678")
//        };
//        return loginCredList;
        String fileLocationList = "/src/test/java/src/tests/gson/loginDataList.json";
        return DataObjectBuilder.buildDataObject(fileLocationList, LoginCred[].class);
    }
}