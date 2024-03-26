package com.bonfatti.actions;

import com.bonfatti.screens.BaseScreen;
import com.bonfatti.screens.PinRegistrationScreen;
import java.time.Duration;

public class PinRegistrationAction extends BaseScreen {
    PinRegistrationScreen pin = new PinRegistrationScreen();

    public void btnPinClick() {
        waitForElementVisibility(pin.btnCreatePin, Duration.ofSeconds(15));
        pin.btnCreatePin.click();
    }
    public void sendPin(String yourPin) {
        pin.setPin.sendKeys(yourPin);
    }
    public void btnContinue() {
        pin.btnContinue.click();
    }
    public void btnPinOKclick() {
        pin.btnClose.click();
    }

    public void createPin() {
        btnPinClick();
        sendPin("121212");
        btnContinue();
        sendPin("121212");
        btnContinue();
        btnPinOKclick();
    }

}
