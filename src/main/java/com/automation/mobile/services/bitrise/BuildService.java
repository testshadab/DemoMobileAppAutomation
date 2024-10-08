package com.automation.mobile.services.bitrise;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.services.bitrise.constants.BitriseConstants;
import com.automation.mobile.services.bitrise.config.BitriseApiConfig;

public class BuildService {

    public static HttpResponse getBuildList(String appSlug){

        HttpRequest request = new HttpRequest();

        String token = System.getenv("BITRISE_TOKEN");

        String url = BitriseConstants.URL + BitriseConstants.APPS + "/" + appSlug + BitriseConstants.BUILDS;

        request.setUrl(url);

        request.setHeaders(BitriseApiConfig.getHeaders(token));

        HttpResponse response = HttpHandler.get(request);

        return response;
    }

    public static  HttpResponse getBuild(String appSlug, String buildSlug){

        HttpRequest request = new HttpRequest();

        String token = System.getenv("BITRISE_TOKEN");

        String url = BitriseConstants.URL + BitriseConstants.APPS + "/" +
                        appSlug + BitriseConstants.BUILDS + "/" + buildSlug;

        request.setUrl(url);

        request.setHeaders(BitriseApiConfig.getHeaders(token));

        HttpResponse response = HttpHandler.get(request);

        return response;

    }
}
