package com.bonfatti;

import com.browserstack.local.Local;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import java.util.logging.Logger;

public final class Hooks extends SetupProject {
    private static final Logger logger = Logger.getLogger(Hooks.class.getName());
    private static Hooks INSTANCE;
    private AppiumDriver driver;
    public static final String UserName = "";
    public static final String AccessKey = "";
    public static Local bsLocal = new Local();
    public static final String URL = "https://" + UserName + ":" + AccessKey + "@hub-cloud.browserstack.com/";
    String localIdentifier = String.valueOf(System.currentTimeMillis());

    private static void runBrowserStack(String localIdentifier) throws Exception {

        HashMap<String, String> bsLocalArgs = new HashMap<>();
        bsLocalArgs.put("key", AccessKey);
        bsLocalArgs.put("force", "true");
        bsLocalArgs.put("localIdentifier", localIdentifier);

        if (bsLocal.isRunning())
            bsLocal.stop();

        bsLocal.start(bsLocalArgs);
        System.out.println("Running " + bsLocal.isRunning());
    }

    public enum Platform {
        IOS,
        ANDROID,
        ANDROIDFARM,
        IOSFARM
    }

    private Hooks() {
    }


    public static Hooks getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Hooks();
            INSTANCE.initDriver();
        }
        return INSTANCE;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void initDriver() {
        try {
            SetupProject.installMaven();
            SetupProject.installAppium();
            SetupProject.installDrivers();
            SetupProject.stopAppium();
            SetupProject.startAppium();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro durante a inicialização do Appium", e);
        }


        // Inicializar o driver
        Platform platformEnum = Platform.valueOf(System.getProperty("platform").toUpperCase());
        System.out.println("Plataforma selecionada" + platformEnum);

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            switch (platformEnum) {
                case IOS:
                    capabilities.setCapability("deviceName", "iPhone 15 Pro Max");
                    capabilities.setCapability("platformName", "iOS");
                    capabilities.setCapability("platformVersion", "17.2");
                    capabilities.setCapability("bundleId", "");
                    capabilities.setCapability("automationName", "XCUITest");
                   capabilities.setCapability("udid", "D8386888-644E-4AFC-A1EB-554C9DFCC8C9");
                    driver = new IOSDriver(new URL("http://localhost:4723/"), capabilities);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    System.out.println("iOS driver initialized successfully.");
                    break;
                case ANDROID:
                    capabilities.setCapability("deviceName", "Android");
                    capabilities.setCapability("platformName", "emulator-5554");
                    capabilities.setCapability("automationName", "UiAutomator2");
                    capabilities.setCapability("appPackage", "");
                    capabilities.setCapability("appium:appActivity", "");
                    driver = new AndroidDriver(new URL("http://localhost:4723/"), capabilities);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    System.out.println("Android driver initialized successfully.");
                    break;
                case ANDROIDFARM:
                    capabilities.setCapability("browserstack.user", UserName);
                    capabilities.setCapability("browserstack.key", AccessKey);
                    capabilities.setCapability("device", "iPhone 14");
                    capabilities.setCapability("os_version", "16");
                    capabilities.setCapability("app", "bs://b8b451b4f95e602bb255fdd7fccb6");
                    capabilities.setCapability("project", "Java Appium");
                    capabilities.setCapability("build", "teste");
                    capabilities.setCapability("name", "QA");
                    capabilities.setCapability("browserstack.debug", "true");

                    // Inicialize o driver para iOS com o URL do servidor do BrowserStack
                    driver = new IOSDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    System.out.println("iOS driver initialized successfully.");
                    break;
                case IOSFARM:
                    capabilities.setCapability("os_version", "16");
                    capabilities.setCapability("device", "iPhone 14");
                    capabilities.setCapability("app", "bs://b8b451b4f95e602bb255fdd7");
                    capabilities.setCapability("project", "Teste automation java");
                    capabilities.setCapability("build", "1.0");
                    capabilities.setCapability("name", "Mobile Test e2e");
                    capabilities.setCapability("browserstack.appium_version", "1.22.3");
                    capabilities.setCapability("browserstack.idleTimeout", "30");
                    capabilities.setCapability("browserstack.acceptInsecureCerts", "true");
                    capabilities.setCapability("browserstack.debug", "true");
                    capabilities.setCapability("browserstack.networkLogs", "true");
                    capabilities.setCapability("browserstack.localIdentifier", localIdentifier);
                    try {
                        runBrowserStack(getInstance().localIdentifier);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println(URL);
                    driver = new IOSDriver(new URL(URL), capabilities);
                    System.out.println("iOS farm driver initialized successfully.");
                    break;
            }

        } catch (MalformedURLException e) {
            System.err.println("Erro ao criar URL: " + e.getMessage());
            throw new RuntimeException("Erro ao criar URL", e);
        } catch (Exception e) {
            System.err.println("Erro durante a inicialização do driver: " + e.getMessage());
            throw new RuntimeException("Erro durante a inicialização do driver", e);
        }
    }
}
