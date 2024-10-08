package com.automation.steps;

import com.automation.helpers.AppActions;
import com.automation.helpers.DeviceHelper;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.appium.DesiredCapabilityBuilder;
import com.automation.mobile.entities.MobileConfType;
import com.automation.mobile.manager.DataFileManager;
import com.automation.mobile.util.CommonUtil;
import com.automation.mobile.util.GlobalVar;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FilenameUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class HookService {

  AppiumDevice appiumDevice = AppiumDeviceManager.getDevice();
  //    GG_DashboardPage dashboardPage;
  boolean alwaysCleanAppState;

  public HookService() {
    this.alwaysCleanAppState = CommonUtil.getBooleanSystemProperty("cleanAppState", true);
    if (!alwaysCleanAppState) {
      System.out.println(
          "Not providing fresh app installation for each scenario. ONLY FOR LOCAL DEVELOPMENT");
    }
  }

  @Before

  //    @Before
  //    public void beforeScenario(Scenario scenario) throws IOException {
  //        String debugKey = System.getProperty("debug", "false");
  //        if (null != debugKey && !debugKey.isEmpty()) {
  //            this.debug = Boolean.parseBoolean(debugKey);
  //        }
  //        if (debug) {
  //            boolean isSessionCreated = false;
  //            if (appiumDevice == null) {
  //                synchronized (GlobalVar.DEVICE_LIST) {
  //                    for (String mobile : GlobalVar.DEVICE_LIST.keySet()) {
  //                        Map<String, String> tempMap = GlobalVar.DEVICE_LIST.get(mobile);
  //                        if (tempMap.get("STATE").equalsIgnoreCase("available")) {
  //                            tempMap.put("STATE", "BUSY");
  //                            System.out.println(GlobalVar.DEVICE_LIST);
  //
  //                            //create appium device
  //                            appiumDevice = new AppiumDevice(tempMap);
  //                            AppiumDeviceManager.setDevice(appiumDevice);
  //
  //                            //create desired capability
  //                            DesiredCapabilityBuilder.buildDesiredCapability(appiumDevice);
  //                            System.out.println(appiumDevice);
  //                            System.out.println(Thread.currentThread().getId());
  //
  //                            //create appium server
  //                            AppiumDriver appiumDriver = new AppiumDriverManager().
  //                                    initializeDriver(new
  // URL(appiumDevice.getConfigureData(MobileConfType.APPIUM_SERVER)),
  //                                            DesiredCapabilityBuilder.getDesiredCapability());
  //                            AppiumDriverManager.setDriver(appiumDriver);
  //                            AppiumDriverManager.addDriver(appiumDriver);
  //
  //                            //Below code will install the app again, this will ensure execution
  // always starts on signin page
  //                            try {
  //                                new
  // DeviceHelper(AppiumDriverManager.getDriver()).unInstallApp();
  //                                new DeviceHelper(AppiumDriverManager.getDriver()).installApp();
  //                                AppiumDriverManager.getDriver().launchApp();
  //                            } catch (Exception e) {
  //                                System.out.println("Exception caught while installing the app
  // again, that's ok moving on..");
  //                            }
  //
  //                            isSessionCreated = true;
  //                            break;
  //                        }
  //                    }
  //                }
  //            }
  //
  //            setTestCaseData();
  //
  //            // App is launched already when driver is created, so now launching app based on
  // flag
  //            if (!isSessionCreated) {
  //                AppiumDriverManager.getDriver().launchApp();
  //            }
  //        }
  //    }

  public void before(Scenario scenario) throws IOException, InterruptedException {
    System.out.println("**************hooks*********************" + Thread.currentThread().getId());
    boolean isSessionCreated = false;
    if (appiumDevice == null) {
      synchronized (GlobalVar.DEVICE_LIST) {
        for (String mobile : GlobalVar.DEVICE_LIST.keySet()) {
          Map<String, String> tempMap = GlobalVar.DEVICE_LIST.get(mobile);
          if (tempMap.get("STATE").equalsIgnoreCase("available")) {
            tempMap.put("STATE", "BUSY");
            System.out.println(GlobalVar.DEVICE_LIST);

            // create appium device
            appiumDevice = new AppiumDevice(tempMap);
            AppiumDeviceManager.setDevice(appiumDevice);

            // create desired capability
            DesiredCapabilityBuilder.buildDesiredCapability(appiumDevice);
            System.out.println(appiumDevice);
            System.out.println(Thread.currentThread().getId());

            // create appium server
            AppiumDriver appiumDriver =
                new AppiumDriverManager()
                    .initializeDriver(
                        new URL(appiumDevice.getConfigureData(MobileConfType.APPIUM_SERVER)),
                        DesiredCapabilityBuilder.getDesiredCapability());
            AppiumDriverManager.setDriver(appiumDriver);
            AppiumDriverManager.addDriver(appiumDriver);

            if (this.alwaysCleanAppState) {
              // Below code will install the app again, this will ensure execution always starts on
              // signin page
              try {
                new DeviceHelper(AppiumDriverManager.getDriver()).unInstallApp();
                new DeviceHelper(AppiumDriverManager.getDriver()).installApp();
                AppiumDriverManager.getDriver().launchApp();
              } catch (Exception e) {
                System.out.println(
                    "Exception caught while installing the app again, that's ok moving on..");
              }
            }

            isSessionCreated = true;
            break;
          }
        }
      }
    }

    setTestCaseData();

    // App is launched already when driver is created, so now launching app based on flag
    if (!isSessionCreated) {
      AppiumDriverManager.getDriver().launchApp();
    }
  }

  public void setTestCaseData() throws FileNotFoundException {

    String featureName = getFeatureName();

    if (!featureName.equalsIgnoreCase(ThreadLocalHelper.featureName.get())) {

      DataFileManager dataFileManager = new DataFileManager(featureName, appiumDevice);

      ThreadLocalHelper.featureName.set(featureName);
      dataFileManager.read();
      ThreadLocalHelper.testCaseData.set(dataFileManager.getTestCaseData());
      System.out.println("tets"+dataFileManager.getTestCaseData().toString());
    }
  }

  @AfterStep
  public void afterStep(Scenario scenario) throws IOException {
    if (scenario.isFailed()) {
      AppiumDevice device = AppiumDeviceManager.getDevice();
      String deviceName = device.getConfigureData(MobileConfType.DEVICE_NAME);
      String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
      scenario.attach(
          CommonUtil.captureScresenshot(AppiumDriverManager.getDriver()),
          "image/png",
          device.getBanner() + "_" + deviceName + "_" + currentDate);
    }
  }

  //    @After
  //    public void afterScenario(Scenario scenario){
  //        DeviceHelper deviceHelper = new DeviceHelper(AppiumDriverManager.getDriver());
  //
  //        if (!alwaysCleanAppState) {
  //            System.out.println("Not reseting to fresh state after scenario. ONLY USE FOR LOCAL
  // DEVELOPMENT");
  //            return;
  //        }
  //
  //        try {
  //            dashboardPage = new GG_DashboardPage(AppiumDriverManager.getDriver());
  //            new AppActions().terminateApp();
  //            new AppActions().relaunchApp();
  //            if (appiumDevice.getPlatform().equalsIgnoreCase("android")) {
  //                if (dashboardPage.waitForCacheContinue(20)) {
  //                    dashboardPage.clickContinueCache();
  //                }
  //            }
  //            if (scenario.getSourceTagNames().toString().contains("@network_scenario")) {
  //                dashboardPage.clickOkIfDisplayed();
  //            }
  //            dashboardPage.handleTutorial();
  //            dashboardPage.goToHomeTabWithTutorialHandling();
  //            dashboardPage.signOutFromTheApp();
  //        } catch (Exception e) {
  //            e.printStackTrace();
  //        }
  //        AppiumDriverManager.getDriver().closeApp();
  //    }

  //    @After
  //    public void performStepsForScenarioSignInConsistency(Scenario desiredScenario) throws
  // IOException, InterruptedException {
  //        if (desiredScenario.isFailed()) {
  //            if (!desiredScenario.getSourceTagNames().toString().contains("@end_scenario")) {
  //                try {
  //                    //Perform Failure Steps
  //                    new AppActions().terminateApp();
  //                    new AppActions().relaunchApp();
  //                    dashboardPage = new GG_DashboardPage(AppiumDriverManager.getDriver());
  //                    if (dashboardPage.waitForFeedbackForm(7)) {
  //                        dashboardPage.clickOnCancelButtonFeedbackFormIfDisplayed();
  //                    } else {
  //                        new
  // GG_ShoppingModePage(AppiumDriverManager.getDriver()).enterDefaultZipCodeAndStartShopping();
  //                    }
  //
  //                    if
  // (desiredScenario.getSourceTagNames().toString().contains("@network_scenario")) {
  //                        dashboardPage.clickOkIfDisplayed();
  //                    }
  //
  //                    if (appiumDevice.getPlatform().equalsIgnoreCase("android")) {
  //                        dashboardPage.clickContinueCache();
  //                    }
  //                    dashboardPage.handleTutorial();
  //                    if (!dashboardPage.isStartupPageDisplayed()) {
  //                        dashboardPage.goToHomeTabWithTutorialHandling();
  //                    }
  //
  //                    // Handling failures involving network scenarios: we will turn on the
  // internet here if the network scenario has failed
  //                    if
  // (desiredScenario.getSourceTagNames().toString().contains("@network_scenario")) {
  //                        new
  // DeviceHelper(AppiumDriverManager.getDriver()).turnOnInternetByPlatform();
  //                        Thread.sleep(5000);
  //                        new AppActions().relaunchApp();
  //                        Thread.sleep(5000);
  //                    }
  //                } catch (Exception e) {
  //                    e.printStackTrace();
  //                }
  //
  //            }
  //        }
  //    }

  public String getFeatureName() {
    String featurePath = ThreadLocalHelper.feature.get().getUri().getPath();
    return FilenameUtils.removeExtension(featurePath.substring(featurePath.lastIndexOf("/") + 1));
  }
}
