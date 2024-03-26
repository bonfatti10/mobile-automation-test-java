package com.bonfatti.tests;

import com.bonfatti.Hooks;
import com.bonfatti.SetupProject;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class BaseTest extends SetupProject {

    private AppiumDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Hooks.getInstance().getDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        SetupProject.stopAppium();
    }
}
