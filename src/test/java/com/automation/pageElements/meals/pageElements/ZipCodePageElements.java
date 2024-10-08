package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

public class ZipCodePageElements {
//teet
    //zipcode title
    //android text : "ZIP Code"
    @iOSXCUITFindBy(accessibility = "ZIP Code")
    @AndroidFindBy(id = "title")
    public MobileElement zipCodeTitle;

    //zipcode input
    //@iOSXCUITFindBy(accessibility = "Zip Code")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name =='Zip Code'")
    @AndroidFindBy(id = "com.safeway.client.android.safeway:id/edit_text")
    //@CacheLookup
    public MobileElement zipCodeEditText;

    //next button
    @iOSXCUITFindBy(accessibility = "Tap to Confirm zipcode")
    @AndroidFindBy(accessibility = "Confirm Zip Code")
    @CacheLookup
    public MobileElement enterButton;

    //use my location
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name ENDSWITH 'location'")
    @AndroidFindBy(id = "btn_use_loc")
    @CacheLookup
    public MobileElement useMyLocationButton;

    //sign in here
    @iOSXCUITFindBy(accessibility = "Sign In Here")
    @AndroidFindBy(id = "link_text_signin")
    @CacheLookup
    public MobileElement signInHereButton;

    //second zip code page when enter invalid zipcode
    //we are not in your area yet
    //android text : "We're not in your area yet."
    @iOSXCUITFindBy(accessibility = "We’re not in your area yet.")
    @AndroidFindBy(id = "textView")
    @CacheLookup
    public MobileElement notAreaTitle;

    //update info to email address text file
    @iOSXCUITFindBy(accessibility = "Email")
    @AndroidFindBy(id = "edit_text_email")
    @CacheLookup
    public MobileElement invalidZipEmailTextEdit;

    //next button
    @iOSXCUITFindBy(accessibility = "Confirm email")
    @AndroidFindBy(id = "btnNotifyMe")
    @CacheLookup
    public MobileElement invalidZipNextButton;

    //enter another zip code
    @iOSXCUITFindBy(accessibility = "Enter Another ZIP Code")
    @AndroidFindBy(id = "try_another_zip")
    @CacheLookup
    public MobileElement enterAnotherZipCodeLink;

    //thank you text in confirm zip code email
    @iOSXCUITFindBy(accessibility = "Thank You!")
    @AndroidFindBy(id = "thankyou") //need to be changed after issue fixed
    @CacheLookup
    public MobileElement thankYouText;

    //after create account zip code page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(id = "btn_next")
    public MobileElement registerZipCodeNext;

//    @AndroidFindBy(id = "")
//    // @AndroidFindBy(id = "iv_user_avatar")
//    public MobileElement Allow;

    @iOSXCUITFindBy(xpath = "//*[@name=\"Allow notifications\"]")
    public MobileElement AllowNotification;

    @AndroidFindBy(id ="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public MobileElement allowNotificationAndroid;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Zip Code\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'edit_text')]")
    public MobileElement zipCodeEditButton;
    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/edit_text"]

    @iOSXCUITFindBy(xpath = "//*[@label=\"Zip Code\"]")
    @AndroidFindBy(xpath="//*[contains(@resource-id,'btn_next')]")
    public MobileElement rightArrowZipCodePage;

    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/btn_next"]


   // @iOSXCUITFindBy(xpath = "//*[@label=\"Counter Pickup\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label STARTSWITH 'Counter Pickup'")
    @AndroidFindBy(id = "Counter Pickup")
    public MobileElement counterText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label STARTSWITH 'Kiosk Pickup'")
    @AndroidFindBy(id = "Kiosk Pickup")
    public MobileElement kioskText;


    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label STARTSWITH 'Locker Pickup'")
    @AndroidFindBy(id = "Locker Pickup")
    public MobileElement lockerText;

}
