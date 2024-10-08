package com.automation.pages.mealsPages;

import com.automation.pageElements.meals.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.meals.pageElements.ZipCodePageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZipCodePage extends BasePage {
  public ZipCodePageElements zipCodePageElements = new ZipCodePageElements();
  public GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();

  public ZipCodePage(AppiumDriver driver) {
//tet
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), zipCodePageElements);
    PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
  }

  public void waitForZipCodePageDisplayed() {
    //        waitForLoadingComplete();

    //        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
    //
    //            if(isElementDisplayed(zipCodePageElements.AllowNotification,10))
    //
    //                clickElement(zipCodePageElements.AllowNotification);
    //
    //
    //            if (isElementDisplayed(zipCodePageElements.Allow, 10))
    //                clickElement(zipCodePageElements.Allow);
    //        }

    if (driver.getPlatformName().equalsIgnoreCase("android")) {
      if (isElementDisplayed(zipCodePageElements.allowNotificationAndroid, 10));
//        zipCodePageElements.allowNotificationAndroid.click();
      zipCodePageElements.allowNotificationAndroid.click();

      //            if (isElementDisplayed(zipCodePageElements.Allow, 10))
      //                clickElement(zipCodePageElements.Allow);
    }

    waitVar.until(ExpectedConditions.elementToBeClickable(zipCodePageElements.zipCodeEditText));
    waitForLoadingComplete();
  }

  public void clickSignInButton() {
    zipCodePageElements.signInHereButton.click();
  }

  public void enterZipCode(String zipCode) {
    //        zipCodePageElements.zipCodeEditText.clear();
    if (driver.getPlatformName().equalsIgnoreCase("ios")) {
      deleteCurrentTextInEditText(zipCodePageElements.zipCodeEditText);
    } else {
      zipCodePageElements.zipCodeEditText.clear();
    }
    if (driver.getPlatformName().equalsIgnoreCase("android")) {
      enterKey(zipCodePageElements.zipCodeEditText, zipCode);
      clickElement(zipCodePageElements.registerZipCodeNext);
    } else if (driver.getPlatformName().equalsIgnoreCase("ios"))
      enterKey(zipCodePageElements.zipCodeEditText, zipCode);
  }

  public void enterMFAZipCode(String zipCode) {
    zipCodePageElements.zipCodeEditText.clear();
    if (driver.getPlatformName().equalsIgnoreCase("android")) {
      enterKey(zipCodePageElements.zipCodeEditText, zipCode);
      clickElement(zipCodePageElements.registerZipCodeNext);
    } else if (driver.getPlatformName().equalsIgnoreCase("ios"))
      enterKey(zipCodePageElements.zipCodeEditText, zipCode);
  }

  /* public void enterZipCode(String zipCode){
   //   zipCodePageElements.zipCodeEditText.clear();
      if(driver.getPlatformName().equalsIgnoreCase("android"))
          enterFromKeyboard(zipCodePageElements.zipCodeEditText, "76109");
      else if(driver.getPlatformName().equalsIgnoreCase("ios"))
          for (int i = 0; i < 5; i++){
              enterKey(zipCodePageElements.zipCodeEditText, "\b");

          }
      enterKey(zipCodePageElements.zipCodeEditText, "76109");
      waitForLoadingComplete();
    //  Thread.sleep(2000);
  }*/

  public void enterinStoreZipCode(String zipCode) {
    //   zipCodePageElements.zipCodeEditText.clear();
    if (driver.getPlatformName().equalsIgnoreCase("android"))
      enterFromKeyboard(zipCodePageElements.zipCodeEditText, zipCode);
    else if (driver.getPlatformName().equalsIgnoreCase("ios"))
      for (int i = 0; i < 5; i++) {
        enterKey(zipCodePageElements.zipCodeEditText, "\b");
      }
    waitForLoadingComplete();
    enterKey(zipCodePageElements.zipCodeEditText, zipCode);
    waitForLoadingComplete();
    //  Thread.sleep(2000);
  }

  /* public void enterZipCode(String zipCode){
   //   zipCodePageElements.zipCodeEditText.clear();
      if(driver.getPlatformName().equalsIgnoreCase("android"))
          enterFromKeyboard(zipCodePageElements.zipCodeEditText, "76109");
      else if(driver.getPlatformName().equalsIgnoreCase("ios"))
          for (int i = 0; i < 5; i++){
              enterKey(zipCodePageElements.zipCodeEditText, "\b");

          }
      enterKey(zipCodePageElements.zipCodeEditText, "76109");
      waitForLoadingComplete();
    //  Thread.sleep(2000);
  }*/

  /*
      public void enterinStoreZipCode(String zipCode){
          //   zipCodePageElements.zipCodeEditText.clear();
          if(driver.getPlatformName().equalsIgnoreCase("android"))
              enterFromKeyboard(zipCodePageElements.zipCodeEditText, zipCode);
          else if(driver.getPlatformName().equalsIgnoreCase("ios"))
              for (int i = 0; i < 5; i++){
                  enterKey(zipCodePageElements.zipCodeEditText, "\b");

              }
          waitForLoadingComplete();
          enterKey(zipCodePageElements.zipCodeEditText, zipCode);
          waitForLoadingComplete();
          //  Thread.sleep(2000);
      }
  */

  public void clickNextButton() {
    zipCodePageElements.enterButton.click();
  }

  public void clickUseMyLocation() {
    clickElement(zipCodePageElements.useMyLocationButton);
    hideKeyBoard();
  }

  public void waitForNonServiceZipCodePageDisplayed() {
    waitForDisplayed(zipCodePageElements.notAreaTitle);
  }

  public void enterEmail(String email) {
    enterKey(zipCodePageElements.invalidZipEmailTextEdit, email);
  }

  public void emailTextNextButton() {
    clickElement(zipCodePageElements.invalidZipNextButton);
  }

  public void waitForNonServiceConfirmationPage() {
    waitForDisplayed(zipCodePageElements.thankYouText);
  }

  public void clickNextAfterRegistration() {
    waitForLoadingComplete();
    if (driver.getPlatformName().equalsIgnoreCase("android")) {
      clickElement(zipCodePageElements.registerZipCodeNext);
    }

    waitForLoadingComplete();
    //   waitForLoadingComplete();
    //   Thread.sleep(1000);
  }

  public void KioskTextIsDisplayed() {
    try {

      Assert.assertTrue(zipCodePageElements.kioskText.isDisplayed());
    } catch (Exception ex) {

    }
  }

  public void LockerTextIsDisplayed() {
    try {

      Assert.assertTrue(zipCodePageElements.lockerText.isDisplayed());
    } catch (Exception ex) {

    }
  }

  public void CounterTextIsDisplayed() {
    try {

      Assert.assertTrue(zipCodePageElements.counterText.isDisplayed());
    } catch (Exception ex) {

    }
  }

  public void zipCodeEditIsDisplayed() {
    try {

      Assert.assertTrue(zipCodePageElements.zipCodeEditButton.isDisplayed());
    } catch (Exception ex) {

    }
  }

  public void clickOnZipCodeRightArrowButton() {
    if (driver.getPlatformName().equalsIgnoreCase("ios")) {
      waitForLoadingComplete();
      driver.findElement(By.name("whiteRightArrow")).click();
    } else {
      waitForLoadingComplete();
      //            clickElement(zipCodePageElements.rightArrowZipCodePage);
      clickElement(
          driver.findElement(
              By.xpath(
                  "//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/btn_next\"]")));
    }
  }

  public void clickZipCodeRightArrow() {
    try {

      if (driver.getPlatformName().equalsIgnoreCase("ios")) {
        waitForLoadingComplete();
        clickElement(driver.findElement(By.name("whiteRightArrow")));
      } else {
        waitForLoadingComplete();
        //            clickElement(homePageElements.whiteRightArrow);
        clickElement(
            driver.findElement(
                By.xpath(
                    "//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/btn_next\"]")));
      }
    } catch (Exception ex) {

    }
  }
}
