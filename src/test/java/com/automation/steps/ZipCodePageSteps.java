package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.pages.mealsPages.ZipCodePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ZipCodePageSteps {
    AppiumDevice device = AppiumDeviceManager.getDevice();
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public ZipCodePage zipCodePage = new ZipCodePage(driver);
//wsw
    @Then("^zipcode page is displayed$")
    public void zipcode_page_is_displayed() throws Throwable {
        zipCodePage.waitForZipCodePageDisplayed();
        zipCodePage.enterZipCode(AppiumDeviceManager.getDevice().getinStoreZipCode());

    }

    @When("^user clicks Sign in button on zipcode page$")
    public void user_clicks_Sign_in_button_on_zipcode_page() throws Throwable {
        zipCodePage.clickSignInButton();
    }

    @When("^user enters \"([^\"]*)\" in zipcode page$")
    public void user_enters_in_zipcode_page(String zipcode) throws Throwable {
        String regex = "\\d+";
        if (zipcode.equalsIgnoreCase("zipcode_diff")) {
            zipCodePage.enterZipCode(device.getConfigureData(BannerConfType.BANNER_ZIPCODE_DIFF));

        } else if (zipcode.matches(regex)) {
            zipCodePage.enterZipCode(zipcode);
        } else if (zipcode.equalsIgnoreCase("instore")) {
            zipCodePage.enterZipCode(device.getConfigureData(BannerConfType.BANNER_INSTOREZIPCODE));
        } else {
            zipCodePage.enterZipCode(device.getZipCode(zipcode));
        }
    }



    @When("^user enters \"([^\"]*)\" in store zipcode page$")
    public void user_enters_instore_zipcode_page(String zipcode) throws Throwable {
        if (zipcode.equalsIgnoreCase("zipcode")) {

            zipCodePage.enterMFAZipCode(device.getZipCode(zipcode));
        } else if (zipcode.equalsIgnoreCase("zipcode_diff")) {
            zipCodePage.enterZipCode(device.getConfigureData(BannerConfType.BANNER_ZIPCODE_DIFF));
        } else {
            zipCodePage.enterinStoreZipCode("zipcode");
        }
    }


    @When("^user clicks next button on zipcode page$")
    public void user_clicks_next_button_on_zipcode_page() throws Throwable {
        zipCodePage.clickNextButton();
    }

    @When("^user clicks use current location on zipcode page$")
    public void userClicksUseCurrentLocationOnZipcodePage() {
        zipCodePage.clickUseMyLocation();
    }

    @Then("^non-service zip code page is displayed$")
    public void nonServiceZipCodePageIsDisplayed() {
        zipCodePage.waitForNonServiceZipCodePageDisplayed();
    }

    @When("^user enter \"([^\"]*)\" and click next to register on non-service zipcode page$")
    public void userEnterAndClickNextToRegisterOnNonServiceZipcodePage(String email) throws Throwable {
        zipCodePage.enterEmail(email);
    }

    @Then("^service email confirmation is displayed on zipcode page$")
    public void serviceEmailConfirmationIsDisplayedOnZipcodePage() {
        zipCodePage.waitForNonServiceConfirmationPage();
    }

    @And("^user click next button on non-service zipcode page$")
    public void userClickNextButtonOnNonServiceZipcodePage() {
        zipCodePage.emailTextNextButton();
    }

    @Then("^user clicks next button after registration on zipcode page$")
    public void userClicksNextButtonAfterRegistrationOnZipcodePage() {
        if (driver instanceof AndroidDriver) {
            zipCodePage.clickNextAfterRegistration();
        }
    }


    @And("^verify 'Locker Pickup' text is displayed$")
    public void verifyLockerText() {
        zipCodePage.LockerTextIsDisplayed();
    }

    @And("^verify 'Counter Pickup' text is displayed$")
    public void verifyCounterText() {
        zipCodePage.CounterTextIsDisplayed();
    }

    @And("^verify 'Kiosk Pickup' text is displayed$")
    public void verifyKioskText() {
        zipCodePage.KioskTextIsDisplayed();
    }


    @And("^user verify zip code is displayed$")
    public void verifyZipCode() {
        zipCodePage.zipCodeEditIsDisplayed();
    }
    @When("^user click on zip code right arrow button$")
    public void tabOnRightArrowButton(){
        zipCodePage.clickOnZipCodeRightArrowButton();
    }
    @And("^user clicks zip code right arrow$")
    public void clickOnZipCodeRighrArrow() {
        zipCodePage.clickZipCodeRightArrow();
    }

}




