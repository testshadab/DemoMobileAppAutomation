package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class StartUpPageElements {

  // text = This mobile application uses device caching to improve the user experience.
  @iOSXCUITFindBy(
      accessibility = "This mobile application uses device caching to improve the user experience.")
  @AndroidFindBy(id = "com.safeway.client.android.safeway:id/textInfo")
  public MobileElement useCacheText;

    //"LEARN MORE" button
    @iOSXCUITFindBy(accessibility = "lest Started")
    @AndroidFindBy(id = "com.safeway.client.android.safeway:id/textLetsStarted")
    public MobileElement learnMoreButton;

  // "CONTINUE" button
  @iOSXCUITFindBy(accessibility = "Continue")
  @AndroidFindBy(id = "com.safeway.client.android.safeway:id/tv_continue_as_guest")
  public MobileElement continueButton;
}
