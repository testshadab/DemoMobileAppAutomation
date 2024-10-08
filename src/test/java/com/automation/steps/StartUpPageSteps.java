package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.StartUpPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StartUpPageSteps {
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public StartUpPage startUpPage = new StartUpPage(driver);


    @Given("^startup page is displayed$")
    public void startup_page_is_displayed() {
        try {
            if(driver.getPlatformName().equalsIgnoreCase("android")) {
                startUpPage.waitForStartUpPageDisplayed();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @When("^user clicks continue button on startup page$")
    public void user_clicks_continue_button_on_startup_page() {
        try
        {
            startUpPage.clickContinue();
        }catch(Exception e){

        }
    }
//ddd
}
