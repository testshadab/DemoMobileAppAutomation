package com.automation.pages.AnalyticsPages;

import com.automation.pageElements.Analytics_PageElements.RewardPageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RewardPage extends BasePage {

    RewardPageElements RewardPageElement = new RewardPageElements();

   public RewardPage(AppiumDriver driver){
       super(driver);
       PageFactory.initElements(new AppiumFieldDecorator(driver),RewardPageElement);

    }

    public  void clickonHomeReward() throws InterruptedException{
        Thread.sleep(1000);
        if(driver.getPlatformName().equalsIgnoreCase("ios")){
            scrollDownForElement(RewardPageElement.homeReward);
            RewardPageElement.homeReward.click();
            }
        else{
            if(scrollDownForElement( RewardPageElement.homeReward)){
                RewardPageElement.homeReward.click();
            }

        }

    }


}
