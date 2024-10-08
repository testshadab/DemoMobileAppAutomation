package com.automation.pages;

import com.automation.mobile.appium.DesiredCapabilityBuilder;
import com.automation.pageElements.meals.pageElements.StartUpPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartUpPage extends BasePage{
    private StartUpPageElements startUpPageElements = new StartUpPageElements();
    public StartUpPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), startUpPageElements);
    }

    public void clickContinue()  {
        if(DesiredCapabilityBuilder.getDesiredCapability().getCapability(MobileCapabilityType.PLATFORM_NAME)
                .toString().equalsIgnoreCase("android")) {
            startUpPageElements.continueButton.click();
        }

    }

    public  void waitForStartUpPageDisplayed(){
        if(DesiredCapabilityBuilder.getDesiredCapability().getCapability(MobileCapabilityType.PLATFORM_NAME)
                .toString().equalsIgnoreCase("android")){
        waitVar.until(ExpectedConditions.visibilityOf(startUpPageElements.useCacheText));}
    }
//dd

}
