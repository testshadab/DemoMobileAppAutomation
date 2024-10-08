package com.automation.pages.AnalyticsPages;

import com.automation.pageElements.Analytics_PageElements.DealsTabPageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DealsPage extends BasePage {

    com.automation.pageElements.Analytics_PageElements.DealsTabPageElements DealsTabPageElements = new DealsTabPageElements();

    WebDriverWait wt = new WebDriverWait(driver, 30);

    public DealsPage(AppiumDriver driver) {
        super(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), DealsTabPageElements);

    }

    public void clickonDealsTab() {
        DealsTabPageElements.Dealstab.click();
    }

    public void clickonForyouTab() {
        DealsTabPageElements.ForYoutab.click();
    }

    public void clickonAllDeals() {

        DealsTabPageElements.Alldealstab.click();

    }

    public void clickonSeeAll() {
        scrollDownForElement(DealsTabPageElements.dealsSeeAll);

        DealsTabPageElements.dealsSeeAll.click();

    }

    public void clickonPromo() {

        // DealsTabPageElements.Promotab.click();
        DealsTabPageElements.promoTab.click();

    }

    public void clickonBOGO() {

        DealsTabPageElements.BOGO.click();

    }

    public void clickonExpiringsoon() {

        DealsTabPageElements.expiringsoontab.click();

    }

    public void clickonqualifyingproduct() {
        //waitForLoadingComplete();
        // waitForDisplayed(DealsTabPageElements.promoDealImage,10);
        DealsTabPageElements.promoDealImage.click();
    }

    public void clickonCategory(String cat) {
        //System.out.println("//XCUIElementTypeOther[@name=\""+cat+"\"]/XCUIElementTypeOther");
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            String catagory = "//XCUIElementTypeOther[@name=\"" + cat + "\"]";
            scrollDownForElement(catagory);
            //   scrollDownForElement( DealsTabPageElements.CatDeli);
            // DealsTabPageElements.CatDeli.click();
            // clickElement(CatDeli);
            driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"" + cat + "\"]")).click();

        } else {
            //android.widget.TextView[@text="Deli"]
            String catagory = "//android.widget.TextView[@text=\""+cat+"\"]";
            scrollDownForElement(catagory);
            //   scrollDownForElement( DealsTabPageElements.CatDeli);
            // DealsTabPageElements.CatDeli.click();
            // clickElement(CatDeli);
            driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + cat + "\"]")).click();
        }

    }
}
