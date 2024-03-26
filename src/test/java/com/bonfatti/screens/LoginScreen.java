package com.bonfatti.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Já tenho conta, botão")
    @iOSXCUITFindBy(id = "btn_secondary")
    public WebElement btnHaveAccount;

    @AndroidFindBy(id = "ds_ps_input_inputText")
    @iOSXCUITFindBy(id = "txt_input_username")
    public WebElement fieldUserName;

    @AndroidFindBy(id = "Continuar, botão")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    public WebElement btnContinue;

    @AndroidFindBy(id = "/ds_ps_input_inputText")
    @iOSXCUITFindBy(accessibility = "txt_input_password")
    public WebElement fieldPassword;

    @AndroidFindBy(accessibility = "Acessar conta, botão")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Acessar conta\"]")
    public WebElement btnAccessAccount;

    @AndroidFindBy(id = "btn_secondary")
    @iOSXCUITFindBy(id = "ICO BTN CLOSE ONBOARD REMUNERA")
    public WebElement btnClose;

}
