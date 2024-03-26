package com.bonfatti.screens;

import com.bonfatti.Hooks;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    public BaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(Hooks.getInstance().getDriver()), this);
    }
    protected void waitForElementVisibility(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Hooks.getInstance().getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
