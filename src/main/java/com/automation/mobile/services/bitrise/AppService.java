package com.automation.mobile.services.bitrise;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.services.bitrise.constants.BitriseConstants;
import com.automation.mobile.services.bitrise.config.BitriseApiConfig;

public class AppService {

    public static HttpResponse getAppList(){

        HttpRequest request = new HttpRequest();

        String token = System.getenv("BITRISE_TOKEN");

        request.setUrl(BitriseConstants.URL + BitriseConstants.APPS);

        request.setHeaders(BitriseApiConfig.getHeaders(token));

        HttpResponse response = HttpHandler.get(request);

        return response;
    }
}
