package src.test_flows.authenication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;
import src.models.components.login.LoginFormComponentMod03;
import src.models.pages.LoginScreenMod03;
import src.test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {

    private String userName;
    private String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String userName, String password) {
        super(appiumDriver);
        this.userName = userName;
        this.password = password;
    }

    public void login() {
        LoginScreenMod03 loginScreen = new LoginScreenMod03(appiumDriver);
        LoginFormComponentMod03 loginFormComponent = loginScreen.loginFormComponentMod03();
        if (!userName.isEmpty()) {
            loginFormComponent.userNameElem(userName);
        }
        if (!password.isEmpty()) {
            loginFormComponent.passWordElem(password);
        }
        loginFormComponent.clickOnBtnLogin();
    }

    public void verifyLogin() {
        boolean userNameValid = isUserNameValid();
        boolean passwordValid = isPasswordValid();
        LoginFormComponentMod03 loginFormComp = new LoginScreenMod03(appiumDriver).loginFormComponentMod03();
        if (userNameValid && passwordValid) {
            verifyCorrectLoginCreds();
        }
        if (!userNameValid) {
            verifyUserNameIncorrectLogin(loginFormComp);
        }
        if (!passwordValid) {
            verifyPasswordIncorrectLogin(loginFormComp);
        }

    }

    private boolean isUserNameValid() {
        return EmailValidator.getInstance().isValid(userName);
    }

    private boolean isPasswordValid() {
        return password.length() >= 8;
    }

    private void verifyUserNameIncorrectLogin(LoginFormComponentMod03 loginFormComp) {
        String actualIncorrectEmailText = loginFormComp.incorrectUserNameTxt();
        String expectedIncorrectEmailText = "Please enter a valid email address";
        System.out.println("actualIncorrectEmailText: " + actualIncorrectEmailText);
        System.out.println("expectedIncorrectEmailText: " + expectedIncorrectEmailText);
//        if(!actualIncorrectEmailText.equalsIgnoreCase(expectedIncorrectEmailText)){
//            throw new RuntimeException("ERR, actual Incorrect Email Text");
//        }
//        Verifier.equals(actualIncorrectEmailText,expectedIncorrectEmailText);
//        Verifier.equals(1,2);
//        Assert.assertTrue(actualIncorrectEmailText.equalsIgnoreCase(expectedIncorrectEmailText),"Err actual not true");
        Assert.assertEquals(actualIncorrectEmailText,expectedIncorrectEmailText,"Err equals");
    }

    private void verifyPasswordIncorrectLogin(LoginFormComponentMod03 loginFormComp) {
        String actualIncorrectPasswordText = loginFormComp.incorrectPasswordTxt();
        String expectedIncorrectPasswordText = "Please enter at least 8 characters";
        System.out.println("actualIncorrectPasswordText: " + actualIncorrectPasswordText);
        System.out.println("expectedIncorrectEmailText: " + expectedIncorrectPasswordText);
    }

    private void verifyCorrectLoginCreds() {
        System.out.println("success");
    }


}
