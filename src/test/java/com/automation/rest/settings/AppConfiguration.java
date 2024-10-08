package com.automation.rest.settings;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.rest.RestApiUtils;
import com.automation.rest.config.RestApiConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class AppConfiguration {

    public String url = "https://www-%s.%s.com/content/dam/data/mobile/settings/appconfiguration.json";

    public AppConfiguration(String env, String banner) {
        this.url = String.format(url, env, RestApiUtils.resolveBannerNameForHost(banner));
    }


    public JSONObject getAppConfig() {
        RequestSpecification requestSpec = RestAssured.given();
        Response response = requestSpec.relaxedHTTPSValidation().contentType(ContentType.JSON).get(url);
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setContent(response.body().asString());
        httpResponse.setStatusCode(response.getStatusCode());
        return httpResponse.getJsonResponse();
    }

    public static boolean isFlagEnabledForGivenBanner(String flagName, String banner, String env) {
        boolean isEnabled = false;
        AppConfiguration appConfig = new AppConfiguration(env, banner);
        JSONObject obj = appConfig.getAppConfig();
        try {
            JSONArray arr = obj.getJSONObject("configurations").getJSONArray(flagName);
            if (arr.toList().contains(banner)) {
                isEnabled = true;
            }
        } catch (JSONException je) {
            Assert.assertTrue(false, String.format("Exception caught while reading %s flag value from appconfiguration json", flagName));
        }

        return isEnabled;
    }

    public static boolean isFlagEnabled(String flagName, String banner, String env) {
        boolean isEnabled = false;
        AppConfiguration appConfig = new AppConfiguration(env, banner);
        JSONObject obj = appConfig.getAppConfig();
        try {
            isEnabled = obj.getJSONObject("configurations").getBoolean(flagName);
        } catch (JSONException je) {
            Assert.assertTrue(false, String.format("Exception caught while reading %s flag value from appconfiguration json", flagName));
        }

        return isEnabled;
    }
    
}

