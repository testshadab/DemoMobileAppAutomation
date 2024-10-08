package com.automation.mobile.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLocations  {
    public static String APPLICATION_DIRECTORY = System.getProperty("user.dir");
    public static String OUTPUT_DIRECTORY = System.getenv("OUTPUT_DIRECTORY") != null
            ? "/" + System.getenv("OUTPUT_DIRECTORY") + "/" : "/target/";

    public static String PARALLEL_XML_LOCATION = OUTPUT_DIRECTORY + "testNG.xml";
    public static final String MOBILE_APP_LOCATION = APPLICATION_DIRECTORY + "/src/test/resources/Apps/";
    public static final String BANNER_CONFIG_DIRECTORY = APPLICATION_DIRECTORY + "/src/test/resources/BannerConfig/";
    public static final String MOBILE_CONFIG_DIRECTORY = APPLICATION_DIRECTORY + "/src/test/resources/MobileDevices/";
    public static String SCREENSHOTS_DIRECTORY = OUTPUT_DIRECTORY + "screenshot/";
    public static String DISTRIBUTE_CLASS_DIRECTORY = APPLICATION_DIRECTORY + "/src/test/java/";
    public static String DATA_DIRECTORY = APPLICATION_DIRECTORY + "/src/test/resources/data/";
    public static String PATH_TAGFILE=APPLICATION_DIRECTORY+"/src/test/resources/TestData/Tag_Property_Files/";
    public static String PATH_CHARLES_TEST_DATA_FILE=APPLICATION_DIRECTORY+"/src/test/resources/TestData/Expected_TestData/";
    public static String ANDROID_CHARLES_SESSION_FILE=APPLICATION_DIRECTORY+"/Session_Files/Android/";
    public static String IOS_CHARLES_SESSION_FILE=APPLICATION_DIRECTORY+"/Session_Files/iOS/";
    public static String ANDROID_CHARLES_CONVERTED_FILE=PATH_TAGFILE+"/Android/";
    public static String IOS_CHARLES_CONVERTED_FILE=PATH_TAGFILE+"/iOS/";
    //testng xml
    //screenshot   /src/test/

    public static String REPORT_DIRECTORY = APPLICATION_DIRECTORY + "/output/report/";     //_" + currentDateTime() + "/";
    public static String DEVICE_LOGS_DIRECTORY = REPORT_DIRECTORY + "devicelogs/";
    public static String currentDateTime(){
        String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return currentDate;
    }
    String ANDROID_SCREENSHOTS_DIRECTORY = SCREENSHOTS_DIRECTORY + "android/";
    String IOS_SCREENSHOTS_DIRECTORY = SCREENSHOTS_DIRECTORY + "iOS/";

    String APPIUM_LOGS_DIRECTORY = OUTPUT_DIRECTORY + "appiumlogs/";
    String ADB_LOGS_DIRECTORY = OUTPUT_DIRECTORY + "adblogs/";

    public String getBannerConfigPath(String banner, String environment){
        return BANNER_CONFIG_DIRECTORY + banner + "/shop/"
                +banner + "_shop_" + environment + ".properties";
    }

    public String getMobileConfigPath(String mobileDevice){
        return MOBILE_CONFIG_DIRECTORY + mobileDevice + ".properties";
    }
}

