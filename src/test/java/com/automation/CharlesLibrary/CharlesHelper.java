package com.automation.CharlesLibrary;

import com.automation.mobile.appium.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;

import java.util.Objects;

public class CharlesHelper {

    public String getPlatform(){
        return System.getProperty("os.name");

    }

    public String getMobileDeviceType(){
        AppiumDriver driver = AppiumDriverManager.getDriver();
        return Objects.requireNonNull(driver.getPlatformName()).equalsIgnoreCase("ios") ? "iOS" : "Android";

    }

    public String isCharlesProxyEnabled(){
        return System.getProperty("charlesProxyEnabled", "false");
    }

    public String getBanner(){
        return System.getProperty("banner");
    }

}
