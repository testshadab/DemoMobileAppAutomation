package com.automation.mobile.appium;

import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.entities.ConfigType;
import com.automation.mobile.entities.FileLocations;
import com.automation.mobile.entities.MobileConfType;
import com.automation.mobile.helpers.ExecutionHelper;
import com.automation.mobile.util.PerfectoLabUtils;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DesiredCapabilityBuilder {
    private static ThreadLocal<DesiredCapabilities> desiredCapabilitiesThreadLocal = new ThreadLocal<>();

    public static DesiredCapabilities getDesiredCapability() {
        return desiredCapabilitiesThreadLocal.get();
    }

    private static String getAppPath(AppiumDevice appiumDevice) throws IOException {

        String platform = appiumDevice.getConfigureData(MobileConfType.PLATFORM_NAME);

        String banner = appiumDevice.getConfigureData(ConfigType.BANNER);

        String environment = appiumDevice.getConfigureData(ConfigType.APP_ENVIRONMENT);

        String deviceType = appiumDevice.getConfigureData(MobileConfType.DEVICE_TYPE);

        String appName = banner;

        String appPath = FileLocations.MOBILE_APP_LOCATION + platform + "/" + environment + "/";

        if (deviceType.equalsIgnoreCase("cloud")) {


            String cloudToken = appiumDevice.getConfigureData(MobileConfType.CLOUD_TOKEN);

            if (platform.equalsIgnoreCase("ios")) {


                appName += "Delivery.ipa";
            }
            else{

                appName = "src-"+appName+"-debug-unsigned.apk";
            }

            appPath += appName;

            if (!ExecutionHelper.getRepositoryList(platform, cloudToken, "PRIVATE:apps/" + appName)) {

                if (Files.notExists(Paths.get(appPath))) {

                    ExecutionHelper.downloadBuild(appiumDevice);
                }
                PerfectoLabUtils.uploadMedia("safeway.perfectomobile.com", cloudToken, appPath, "PRIVATE:apps/" + appName);
            }
        } else {
            if (platform.equalsIgnoreCase("ios")) {

                appName += ".app";
            } else {

                appName += ".apk";
            }
            appPath += appName;
        }
        return appPath;
    }

    private static String getAppName(AppiumDevice appiumDevice) {

        String deviceType = appiumDevice.getConfigureData(MobileConfType.DEVICE_TYPE);

        String banner = appiumDevice.getConfigureData(ConfigType.BANNER);

        String platform = appiumDevice.getConfigureData(MobileConfType.PLATFORM_NAME);

        String appName = banner;

        if (deviceType.equalsIgnoreCase("cloud")) {



            if (platform.equalsIgnoreCase("ios")) {


//                appName += "-" + buildSlug + ".ipa";
                appName += "Delivery.ipa";
            }
            else{


//                appName += "-" + buildSlug + ".apk";
                appName = "src-"+appName+"-debug-unsigned.apk";
            }
        } else {
            if (platform.equalsIgnoreCase("ios")) {

                appName += ".app";
            } else {

                appName += ".apk";
            }
        }
        return appName;
    }

	/*
	 * public static void buildDesiredCapability(Map<String, String> deviceInfo)
	 * throws IOException {
		String platform = deviceInfo.get("platformname");
		String banner = deviceInfo.get("banner");
		String appPath = getAppPath(platform, deviceInfo.get("env"), banner);
		String appName = getAppName(platform, deviceInfo.get("env"), banner);
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceInfo.get("udid"));
		desiredCapabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, deviceInfo.get("applicationName"));
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceInfo.get("devicename"));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, deviceInfo.get("platformname"));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceInfo.get("platformversion"));
		desiredCapabilities.setCapability("banner", banner);
		desiredCapabilities.setCapability("env", deviceInfo.get("env"));
		desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		if (platform.equalsIgnoreCase("android")) {
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, deviceInfo.get("packageName"));
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, deviceInfo.get("activityName"));
			if (deviceInfo.get("avd") != null) {
				desiredCapabilities.setCapability(AndroidMobileCapabilityType.AVD, deviceInfo.get("avd"));
			}
		} else if (platform.equalsIgnoreCase("ios")) {
			desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, deviceInfo.get("bundleId"));
		}
		//ios sign capability
		if (platform.equalsIgnoreCase("ios")) {
			desiredCapabilities.setCapability("xcodeOrgId", "M24ZKV33Z2");
			desiredCapabilities.setCapability("xcodeSigningId","Apple Development");
			desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		}
		String deviceType = deviceInfo.get("safewaydevice");
		desiredCapabilities.setCapability("safewaydevice", deviceType);
		if (deviceType.equalsIgnoreCase("cloud"))  {
			String user = deviceInfo.get("user");
			String password = deviceInfo.get("password");
			String cloudServer = deviceInfo.get("CloudServer");
			String cloudToken = deviceInfo.get("token");
			desiredCapabilities.setCapability("user", user);
			desiredCapabilities.setCapability("password", password);
			PerfectoLabUtils.uploadMedia("safeway.perfectomobile.com",cloudToken, appPath , "PRIVATE:apps/" + appName);
			desiredCapabilities.setCapability(MobileCapabilityType.APP, "PRIVATE:apps/" + appName);
		} else {
			//local device install app
			desiredCapabilities.setCapability("user", deviceInfo.get("User"));
			desiredCapabilities.setCapability("password", deviceInfo.get("Password"));
			desiredCapabilities.setCapability(MobileCapabilityType.APP, appPath);
		}
		desiredCapabilitiesThreadLocal.set(desiredCapabilities);
	}
	*/

    public static void buildDesiredCapability(AppiumDevice appiumDevice) throws IOException {
        AppiumDevice ad = appiumDevice;
        String platform = ad.getConfigureData(MobileConfType.PLATFORM_NAME);
        String banner = ad.getConfigureData(ConfigType.BANNER);
        String env = ad.getConfigureData(ConfigType.APP_ENVIRONMENT);
        String deviceType = ad.getConfigureData(MobileConfType.DEVICE_TYPE);
        String appPath = getAppPath(ad);
        String appName = getAppName(ad);
        DesiredCapabilities dc = new DesiredCapabilities();

//		dc.setCapability(MobileCapabilityType.UDID, ad.getConfigureData(MobileConfType.UDID));
//		dc.setCapability(MobileCapabilityType.APPLICATION_NAME, ad.getConfigureData(MobileConfType.APPLICATION_NAME));
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, ad.getConfigureData(MobileConfType.DEVICE_NAME));
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, ad.getConfigureData(MobileConfType.PLATFORM_NAME));
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, ad.getConfigureData(MobileConfType.PLATFORM_VERSION));
        dc.setCapability("enableAppiumBehavior", true);
        dc.setCapability("banner", banner);
        dc.setCapability("env", env);
        dc.setCapability(MobileCapabilityType.FULL_RESET, false);
        dc.setCapability(MobileCapabilityType.NO_RESET, true);
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);


        if (platform.equalsIgnoreCase("android")) {
            dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ad.getConfigureData(BannerConfType.PACKAGE_NAME));
            dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ad.getConfigureData(BannerConfType.ACTIVITY_NAME));
            if (ad.getConfigureData(MobileConfType.AVD) != null) {
                dc.setCapability(AndroidMobileCapabilityType.AVD, ad.getConfigureData(MobileConfType.AVD));
            }
        } else if (platform.equalsIgnoreCase("ios")) {
            dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, ad.getConfigureData(BannerConfType.BUNDLE_ID));
        }

        //ios sign capability
        if (platform.equalsIgnoreCase("ios")) {
            //dc.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, ad.getConfigureData(MobileConfType.IOS_XCODE_ORGID));
            //dc.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID,ad.getConfigureData(MobileConfType.IOS_XCODE_SIGNINGID));
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            dc.setCapability("iOSResign", true);
            dc.setCapability("simpleIsVisibleCheck",true);
            dc.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG,false);
        }

        if (deviceType.equalsIgnoreCase("cloud")) {
            String user = ad.getConfigureData(MobileConfType.CLOUD_USER);
            String password = ad.getConfigureData(MobileConfType.CLOUD_PASSWORD);
//			String cloudServer = ad.getConfigureData(MobileConfType.CLOUD_SERVER);
//			String cloudToken = ad.getConfigureData(MobileConfType.CLOUD_TOKEN);
            dc.setCapability("user", user);
            dc.setCapability("password", password);
            dc.setCapability("securityToken", appiumDevice.getCouldToken());

//			try {
//				//PerfectoLabUtils.uploadMedia("safeway.perfectomobile.com", cloudToken, appPath, "PRIVATE:apps/" + appName);
//				//PerfectoLabUtils.uploadMedia("safeway.perfectomobile.com", cloudToken, appPath, "PRIVATE:apps/" + appName);
//				//PerfectoLabUtils.uploadMedia("safeway.perfectomobile.com", cloudToken, appPath, "PUBLIC:/" + appName);
//
//			} catch (Exception e){
//				e.printStackTrace();
//			}
            dc.setCapability(MobileCapabilityType.APP, "PRIVATE:apps/" + appName);
            dc.setCapability("cloudAppPath", "PRIVATE:apps/" + appName);
        } else {
            //local device install app
            dc.setCapability(MobileCapabilityType.UDID, ad.getConfigureData(MobileConfType.UDID));
            dc.setCapability(MobileCapabilityType.APPLICATION_NAME, ad.getConfigureData(MobileConfType.APPLICATION_NAME));
            dc.setCapability(MobileCapabilityType.APP, appPath);
        }
        desiredCapabilitiesThreadLocal.set(dc);
        System.out.println(desiredCapabilitiesThreadLocal.get().toString());
    }
}