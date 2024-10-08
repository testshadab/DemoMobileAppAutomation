package com.automation.rest.constants;

public class RestConstants {

    public static final String testDataFilePathWindows =
            System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\";


    public enum PushNotificationData {

        PUSH_NOTIFICATION_DATA_ANDROID {
            @Override
            public String toString() {
                return "PushNotifBodyData\\android";
            }
        },
        PUSH_NOTIFICATION_DATA_IOS {
            @Override
            public String toString() {
                return "PushNotifBodyData\\ios";
            }
        }

    }

}
