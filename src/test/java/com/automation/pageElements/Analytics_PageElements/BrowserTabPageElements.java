package com.automation.pageElements.Analytics_PageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BrowserTabPageElements {

   //@AndroidFindBy(xpath="//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/browseFragment\"]//*[@class=\"android.view.ViewGroup\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"BROWSE\"]")
    @AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"BROWSE\"]")
    public MobileElement Browsetab;

    @iOSXCUITFindBy(xpath = "//*[@name=\"Looking for deals, Go to Deals\"]")
   @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    public MobileElement BrowseGotoDeals;


}
