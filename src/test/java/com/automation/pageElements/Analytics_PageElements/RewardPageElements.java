package com.automation.pageElements.Analytics_PageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RewardPageElements {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View My rewards\"]")

   // @AndroidFindBy(xpath="//android.widget.Button[@text=\"Rewards\"]")
    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"View My rewards link\"]")
   // @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"View My rewards link\"]")
    public MobileElement homeReward;

}

