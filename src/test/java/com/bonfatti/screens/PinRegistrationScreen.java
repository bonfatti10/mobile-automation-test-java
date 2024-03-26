package com.bonfatti.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PinRegistrationScreen extends BaseScreen{
    @AndroidFindBy(id = "Criar o PIN, botão")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Criar o PIN\"]")
    public WebElement btnCreatePin;

    @AndroidFindBy(id = "ds_secret_box")
    @iOSXCUITFindBy(id = "ds_secret_box")
    public WebElement setPin;

    @AndroidFindBy(id = "Continuar, botão")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    public WebElement btnContinue;

    @AndroidFindBy(id = "Fechar, botão")
    @iOSXCUITFindBy(id = "Fechar, botão")
    public WebElement btnClose;
}
