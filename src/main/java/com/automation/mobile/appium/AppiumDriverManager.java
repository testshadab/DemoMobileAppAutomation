package com.automation.mobile.appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AppiumDriverManager {


    private static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    private static List<AppiumDriver> listDrivers = new ArrayList<AppiumDriver>();

    public static AppiumDriver getDriver() {
        return appiumDriver.get();
    }

    public AppiumDriver initializeDriver(URL appiumServer, DesiredCapabilities ds) {
        return new AppiumDriver(appiumServer, ds);
    }

    public static void setDriver(AppiumDriver driver) {
        appiumDriver.set(driver);
    }

    public static void addDriver(AppiumDriver driver) {
        listDrivers.add(driver);
    }

    public static void closeAllDrivers() {

        for (AppiumDriver driver : listDrivers) {

            driver.quit();
        }
    }
}
