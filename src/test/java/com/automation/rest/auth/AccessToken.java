package com.automation.rest.auth;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.pages.BasePage;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.config.RestApiConfig;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AccessToken {
    private String userName;
    private String password;
    Logger logger = LogManager.getLogger(getClass());

    public AccessToken(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getAccessToken() {
        String accessToken;
        HttpRequest request = new HttpRequest();
        String url = ThreadLocalHelper.testCaseData.get().get("ACCESS_TOKEN_HOST_URL") + "/oauth2/ausdvuyculRIYitXg0h7/v1/token";

        Map<String, Object> params = new HashMap<>();

        params.put("username", userName);

        params.put("password", password);

        params.put("grant_type", "password");

        params.put("scope", "openid profile offline_access");

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("authorization", "Basic MG9hZDhhaXd0N1pBN3NXY3owaDc6dGhRaTh6a3gzaVJ4YkpfbDliTno5RzJ3bkR0OXJTcVgyZkxncktwVw==");

        headers.put("accept", "application/json");

        request.setUrl(url);

        request.setHeaders(headers);

        request.setParams(params);

        try {
            logger.info("Get access token request: " + request);
            HttpResponse response = HttpHandler.post(request);
            logger.info("Get access token response: " + response);
            if (response.getStatusCode() == 200) {
                accessToken = response.getJsonResponse().getString("access_token");
                CommonCache.tokenCache.put("accessToken", accessToken);
            } else {
                throw new RuntimeException("Get access token failed, response: " + response);
            }
        } catch (Exception e) {
            throw new RuntimeException("Get access token failed, exception message: " + e.getMessage());
        }
        return accessToken;
    }
}
