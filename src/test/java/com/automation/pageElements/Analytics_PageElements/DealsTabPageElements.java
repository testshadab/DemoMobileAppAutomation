package com.automation.pageElements.Analytics_PageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DealsTabPageElements {

   @AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"DEALS\"]")

    @iOSXCUITFindBy(xpath = "//*[@label=\"DEALS\"]")
    public MobileElement Dealstab;

   // @AndroidFindBy(xpath="//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/dealsContainerFragment\"]//*[@class=\"android.view.ViewGroup\"]")

 @iOSXCUITFindBy(xpath = "//*[contains(@label,\"For you\")] ")
 @AndroidFindBy(xpath = "//*[@text=\"For you\"]")
    public MobileElement ForYoutab;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"All deals Tab\")] ")
    @AndroidFindBy(xpath = "//*[@text=\"All deals\"]")
    public MobileElement Alldealstab;

    //@AndroidFindBy(xpath="//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/dealsContainerFragment\"]//*[@class=\"android.view.ViewGroup\"]")

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Promo Tab\")] ")
    @AndroidFindBy(xpath = "//*[@text=\"Promo Tab\"]")
    public MobileElement Promotab;


    //@AndroidFindBy(xpath="//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/dealsContainerFragment\"]//*[@class=\"android.view.ViewGroup\"]")

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"BOGOTab\")] ")
    @AndroidFindBy(xpath = "//*[@text=\"BOGOTab\"]")
    public MobileElement BOGOstab;

   @iOSXCUITFindBy(xpath = "//*[contains(@label,\"BOGO\")] ")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"BOGO\"]/android.widget.TextView")
    public MobileElement BOGO;

 //android.widget.LinearLayout[@content-desc="BOGO"]/android.widget.TextView

    @AndroidFindBy(xpath = "//*[@text=\"Expiring soon\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Expiring soon\")] ")
    public MobileElement expiringsoontab;

   @AndroidFindBy(id = "iv_promo_banner")
   @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//XCUIElementTypeButton[contains(@name,'imgBackground')]")
   public MobileElement promoDealImage;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Promo\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblHorizontalTitleCVCellTitle' and contains(@label,'Promo')]")
    public MobileElement promoTab;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Items you may like See all\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnSeeAllButtonTitle-Items you buy\"]")
    public MobileElement dealsSeeAll;

   // @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Items you may like See all\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Deli\"]")
    public MobileElement CatDeli;
}
