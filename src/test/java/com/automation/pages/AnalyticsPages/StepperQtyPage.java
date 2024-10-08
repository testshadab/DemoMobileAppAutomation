package com.automation.pages.AnalyticsPages;

import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import com.automation.pageElements.Analytics_PageElements.StepperQtyPageElements;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepperQtyPage extends BasePage {

    StepperQtyPageElements StepperQtyPageElements = new StepperQtyPageElements();
//    HomePageElements HomePageElements = new HomePageElements();
    WebDriverWait wt= new WebDriverWait(driver,30);

    public StepperQtyPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), StepperQtyPageElements);

    }
    public void clickonNext()throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            StepperQtyPageElements.ClickNextButton.click();
        }else{
            StepperQtyPageElements.ClickCacheText.click();
            StepperQtyPageElements.ClickNextButton.click();
            Thread.sleep(10000);
        }
    }
    public void clickonHomeTab() throws InterruptedException {
        Thread.sleep(10000);

//
//        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
//            if(StepperQtyPageElements.ClickCacheText.isDisplayed()){
//                StepperQtyPageElements.ClickCacheText.click();
//            }
//            if(      StepperQtyPageElements.ClickNextButton.isDisplayed()){
//                StepperQtyPageElements.ClickNextButton.click();
//            }
//            StepperQtyPageElements.ClickNextButton.click();
//        }else{
//            if(StepperQtyPageElements.ClickCacheText.isDisplayed()) {
//                StepperQtyPageElements.ClickCacheText.click();
//            }
//            StepperQtyPageElements.ClickNextButton.click();
//            Thread.sleep(10000);
//        }

        StepperQtyPageElements.homeTab.click();
        Thread.sleep(10000);


        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (StepperQtyPageElements.NoteficationAllow.isDisplayed()) {
                StepperQtyPageElements.NoteficationAllow.click();

            }

          // System.out.println("next calling");
           // StepperQtyPageElements.ClickNextButton.click();
            if(StepperQtyPageElements.ClickNextButton.isDisplayed()){
              //  System.out.println("next calling");
                StepperQtyPageElements.ClickNextButton.click();
            }
            if(StepperQtyPageElements.ClickCacheTextMA.isDisplayed()){
               // System.out.println("next calling");
                StepperQtyPageElements.ClickCacheTextMA.click();
            }


        }
       else{
            /*if(StepperQtyPageElements.ClickCacheText.isDisplayed()) {
                StepperQtyPageElements.ClickCacheText.click();
            }*/
            StepperQtyPageElements.ClickNextButton.click();
            Thread.sleep(10000);
        }
    }
     public  void clickonSearch()throws InterruptedException{

         StepperQtyPageElements.searchProduct.click();
         Thread.sleep(10000);

     }

     public void clickonTrendingitem()throws InterruptedException{

         StepperQtyPageElements.currentlyTrendingProduct.click();
         if (driver.getPlatformName().equalsIgnoreCase("ios")) {
             StepperQtyPageElements.closeGray.click();
         }
         Thread.sleep(30000);
     }

    public void searchCancelBackButton() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            StepperQtyPageElements.searchCancel.click();
        } else{
            StepperQtyPageElements.androidBackArrow.click();
        }
    }

    public void recentlySearch()throws InterruptedException{
        StepperQtyPageElements.recentlySearchedProduct.click();
        Thread.sleep(10000);
    }
    public void searchProduct() throws InterruptedException {
        Thread.sleep(10000);
       // System.out.println("Search calling1");
       // StepperQtyPageElements.clickSearch.click();
       // StepperQtyPageElements.searchProduct.sendKeys(" Granny Smith large Apple");
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            StepperQtyPageElements.clickSearch.click();
            StepperQtyPageElements.searchProductEnter.sendKeys(" Granny Smith large Apple");
             StepperQtyPageElements.searchProductEnter.sendKeys(Keys.ENTER);
             waitForLoadingComplete();
             Thread.sleep(10000);
             if(StepperQtyPageElements.closeGray.isDisplayed()) {
                 StepperQtyPageElements.closeGray.click();
             }
        } else {
            StepperQtyPageElements.searchProduct.click();
            StepperQtyPageElements.searchProduct.sendKeys(" Granny Smith large Apple");
            androidKeyboardClickDone();
        }

        Thread.sleep(10000);


    }

    public void searchProductHalfname() throws InterruptedException {
        Thread.sleep(10000);
        //StepperQtyPageElements.searchProduct.click();
        // StepperQtyPageElements.searchProduct.sendKeys(" Granny Smith large Apple");
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            StepperQtyPageElements.clickSearch.click();
            StepperQtyPageElements.searchProductEnter.sendKeys(" Granny Smith");
            Thread.sleep(10000);
            StepperQtyPageElements.autosuggestion.click();
           // StepperQtyPageElements.searchProductEnter.sendKeys(Keys.ENTER);
            Thread.sleep(10000);
            if(StepperQtyPageElements.closeGray.isDisplayed()) {
                StepperQtyPageElements.closeGray.click();
            }
        } else {
            StepperQtyPageElements.searchProduct.click();
            StepperQtyPageElements.searchProduct.sendKeys(" Granny Smith");
            Thread.sleep(10000);
            StepperQtyPageElements.autosuggestion.click();
           // androidKeyboardClickDone();
        }
        // StepperQtyPageElements.searchProductEnter.sendKeys(Keys.ENTER);
        Thread.sleep(10000);

    }

    public void clickonProduct() throws InterruptedException {
//        waitForLoadingComplete();
//        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
//            StepperQtyPageElements.closeGray.click();
//        }
       // Thread.sleep(10000);
        StepperQtyPageElements.selectProduct.click();
        Thread.sleep(30000);

    }

    public void AddtoCart() {

        StepperQtyPageElements.Addtocart.click();
    }

    public void addQuantity() throws InterruptedException {
        Thread.sleep(5000);
        StepperQtyPageElements.addQuantity.click();
       // System.out.println("add Qun");

        waitForLoadingComplete();
        Thread.sleep(5000);
    }

    public void addQuantitySearchproduct() throws InterruptedException {
        Thread.sleep(5000);
        for(int i=0;i<=20;i++) {
            StepperQtyPageElements.addQuantity.click();
            waitForLoadingComplete();
        }
    }

    public void RemoveItem() throws InterruptedException {
        //Thread.sleep(30000);

        StepperQtyPageElements.myCartCount.click();
        waitForLoadingComplete();
        StepperQtyPageElements.removeIcon.click();
        Thread.sleep(20000);
    }

    public void decreaseQuantity() throws InterruptedException {
        Thread.sleep(5000);
        StepperQtyPageElements.deleteQuantity.click();
        Thread.sleep(20000);

    }

    public void selectsFirstProduct() {
        StepperQtyPageElements.firstItemFrame.click();
    }

    public void addItems() {
       // waitForclick(StepperQtyPageElements.addButton);
        StepperQtyPageElements.addButton.click();
    }

   /* public void IncreaseInIOS() {​​​​​​​​

        StepperQtyPageElements.oneincart.click();
        enterKey(StepperQtyPageElements.oneincart,"2");
        //waitForTextPresentInElement(StepperQtyPageElements.oneincart, "12");
        StepperQtyPageElements.updateqty.click();
    }​​​​​​​​*/

    public void IncreaseInAndroid() {


            StepperQtyPageElements.plusSign.click();
        StepperQtyPageElements.plusSign.click();
        }

    }

