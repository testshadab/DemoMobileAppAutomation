package com.automation.pages.mealsPages;

import com.automation.pageElements.meals.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.meals.pageElements.ZipCodePageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZipCodePage1 extends BasePage {

    public ZipCodePageElements zipCodePageElements = new ZipCodePageElements();
    public GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();

    public ZipCodePage1(AppiumDriver driver) {

        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), zipCodePageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
    }

    public void waitForZipCodePageDisplayed1() {

        waitForLoadingComplete();

        if (driver.getPlatformName().equalsIgnoreCase("iOS")) {

            if (isElementDisplayed(dashboardPageElements.allownotificationsBtn, 10)) {
                clickElement(dashboardPageElements.allownotificationsBtn);
                clickElement(dashboardPageElements.dontAllowBtn);
            }

            waitForLoadingComplete();

            waitVar.until(ExpectedConditions.elementToBeClickable(zipCodePageElements.zipCodeEditText));
            waitForLoadingComplete();


        }
    }
}
