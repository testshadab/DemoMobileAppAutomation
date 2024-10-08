package com.automation.rest;

import io.appium.java_client.AppiumDriver;

public class RestService {

	//	protected String authUrl = "https://abs-%s.oktapreview.com/oauth2";

	protected String authUrl = "https://abs-qa2.oktapreview.com/oauth2";

//	protected String hostUrl = "https://www-%s.safeway.com";

	protected String hostUrl = "https://www-qa2.safeway.com/";
	
	protected String nimbusUrl = "https://nimbus-qa1.safeway.com";
	
	public RestService(AppiumDriver driver) {
		String env = getCurrentEnv(driver);
		this.initUrls(env);
	}
	
	public void initUrls(String env) {
		
		this.authUrl = String.format(this.authUrl, env);
		
		this.hostUrl = String.format(this.hostUrl, env);
		
		this.nimbusUrl = String.format(this.nimbusUrl, env);
	}
	
	public String getCurrentEnv(AppiumDriver driver){
		
        return driver.getCapabilities().getCapability("env").toString();
    }

}
