package com.automation.pages.AnalyticsPages;

import com.automation.pageElements.Analytics_PageElements.OrderConfirmationPageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BasePage {
    OrderConfirmationPageElements OrderConfirmationPageElements=new OrderConfirmationPageElements();

    public OrderConfirmationPage(AppiumDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),OrderConfirmationPageElements);

    }

    public void clickonCart(){
       // System.out.println("Cart Click");
        OrderConfirmationPageElements.myCart.click();

    }
    public void searchProduct(String Product) throws InterruptedException {
        Thread.sleep(10000);
        // System.out.println("Search calling1");
        // StepperQtyPageElements.clickSearch.click();
        // StepperQtyPageElements.searchProduct.sendKeys(" Granny Smith large Apple");
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            OrderConfirmationPageElements.clickSearch.click();
          //  OrderConfirmationPageElements.searchProductEnter.sendKeys(" Granny Smith large Apple");
            OrderConfirmationPageElements.searchProductEnter.sendKeys(Product);
            OrderConfirmationPageElements.searchProductEnter.sendKeys(Keys.ENTER);
            waitForLoadingComplete();
            Thread.sleep(10000);
            if(OrderConfirmationPageElements.closeGray.isDisplayed()) {
                OrderConfirmationPageElements.closeGray.click();
            }
        } else {
            OrderConfirmationPageElements.searchProduct.click();
            OrderConfirmationPageElements.searchProduct.sendKeys(Product);
            androidKeyboardClickDone();

        }

        Thread.sleep(10000);


    }

    public void clickonAddProduct(){

        OrderConfirmationPageElements.AddProduct.click();

    }

    public void addQuantitySearchproduct() throws InterruptedException {
        Thread.sleep(5000);
        for(int i=1;i<=18;i++) {
            OrderConfirmationPageElements.addQuantity.click();
           // waitForLoadingComplete();
            //System.out.println(i);
            Thread.sleep(3000);
        }
        waitForLoadingComplete();
        Thread.sleep(5000);
    }

}



