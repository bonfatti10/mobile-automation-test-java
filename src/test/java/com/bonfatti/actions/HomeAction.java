package com.bonfatti.actions;

import com.bonfatti.screens.BaseScreen;
import com.bonfatti.screens.HomeScreen;

import java.time.Duration;

public class HomeAction extends BaseScreen {
    HomeScreen home = new HomeScreen();


    public void btnAllowClick() {
        home.btnAllow.click();
    }

    public void btnInvestimentsClick() {
        waitForElementVisibility(home.btnInvestments, Duration.ofSeconds(15));
        home.btnInvestments.click();
    }

    public void btnFixeClick() {
        home.btnApplayMoney.click();
    }

    public void btnFixedIncomeClick() {
        home.btnFixedIncome.click();
    }

    public void titleIsVisible() {
        home.fieldTitleFixed.isDisplayed();
    }

    public void homeToInvestments() {
        btnInvestimentsClick();
        btnFixeClick();
        btnFixedIncomeClick();
        titleIsVisible();
    }
}
