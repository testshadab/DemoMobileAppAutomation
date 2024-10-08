package com.automation.mobile.listener;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.appium.AppiumServerManager;
import com.automation.mobile.entities.FileLocations;
import com.beust.jcommander.Parameter;
import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.File;
import java.io.IOException;

public class TestNGListener implements ISuiteListener {

    public void onStart(ISuite iSuite) {
        new AppiumServerManager().startAppiumServer();
        System.out.println("*************start server*************");
    }

    @Override
    public void onFinish(ISuite iSuite) {
    	AppiumDriverManager.closeAllDrivers();
        new AppiumServerManager().stopAppiumServer();
        System.out.println("*************stop server*************");
    }
}
