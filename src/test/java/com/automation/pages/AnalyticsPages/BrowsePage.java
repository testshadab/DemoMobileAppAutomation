package com.automation.pages.AnalyticsPages;

import com.automation.pageElements.Analytics_PageElements.BrowserTabPageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class BrowsePage  extends BasePage{

    BrowserTabPageElements BrowserTabPageElements = new BrowserTabPageElements();

    public BrowsePage (AppiumDriver driver){
        super(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver),BrowserTabPageElements);

    }

    public void clickonBrowseTab(){
        BrowserTabPageElements.Browsetab.click();
    }

}
