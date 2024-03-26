package com.bonfatti.actions;

import com.bonfatti.screens.BaseScreen;
import com.bonfatti.screens.LoginScreen;
import java.time.Duration;


public class LoginAction  extends BaseScreen {
    LoginScreen loginScreen = new LoginScreen();

    public void haveAccountClick() {
        loginScreen.btnHaveAccount.isDisplayed();
        loginScreen.btnHaveAccount.click();
    }
    public void inputUserName(String email) {
        loginScreen.fieldUserName.sendKeys(email);
    }
    public void btnContinueClick() {
        loginScreen.btnContinue.click();
    }
    public void inputPassWord(String passWord){
       waitForElementVisibility(loginScreen.fieldPassword, Duration.ofSeconds(15));
       loginScreen.fieldPassword.sendKeys(passWord);
    }

    public void btnAccessAccount() {
        loginScreen.btnAccessAccount.click();
    }

    public void btnCloseClick() {
        loginScreen.btnClose.click();
    }

    public void doLogin() throws InterruptedException {
        haveAccountClick();
        inputUserName("autom_@mock.com");
        btnContinueClick();
        inputPassWord("ps654321");
        btnAccessAccount();
        Thread.sleep(15000);
        btnCloseClick();
    }
}
