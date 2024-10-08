package com.automation.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.models.Result;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.config.RestApiConfig;

import io.appium.java_client.AppiumDriver;

public class LoginService extends RestService{

	public AppiumDriver driver = AppiumDriverManager.getDriver();
	//public BasePage basePage = new BasePage(driver);;

	public LoginService(AppiumDriver driver) {

		super(driver);
	}

	public Result getAccessToken() throws IOException {

		Result result = new Result();

		HttpRequest request = new HttpRequest();

		String url = this.authUrl + "/ausdvuyculRIYitXg0h7/v1/token";

		Map<String, Object> params = new HashMap<>();

		params.put("username", ThreadLocalHelper.testCaseData.get().get("USERNAME"));

		params.put("password", ThreadLocalHelper.testCaseData.get().get("PASSWORD"));

		params.put("grant_type", "password");

		params.put("scope", "openid profile offline_access");

		Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

		headers.put("Host", "abs-qa1.oktapreview.com");

		headers.put("authorization", "Basic MG9hZDhhaXd0N1pBN3NXY3owaDc6dGhRaTh6a3gzaVJ4YkpfbDliTno5RzJ3bkR0OXJTcVgyZkxncktwVw==");

		headers.put("accept", "application/json");

		request.setUrl(url);

		request.setHeaders(headers);

		request.setParams(params);

		try {
			HttpResponse response = HttpHandler.post(request);

			System.out.print("RESPONSE CODE = " + response.getStatusCode());

			if(response.getStatusCode() == 200) {

				CommonCache.tokenCache.put("accessToken", response.getJsonResponse().getString("access_token"));

				System.out.print(response.getJsonResponse().getString("access_token"));

				result.setStatus(true);

				result.setStatusMsg("Get Access Token Successfull");
			}
			else{
				result.setStatus(false);

				result.setStatusMsg("Get Access Token Failed");
			}
		}
		catch(Exception e) {

			result.setStatus(false);

			result.setStatusMsg("Get Access Token Failed with Exception :: " + e.toString());
		}

		return result;
	}
}
