package com.automation.mobile.services.bitrise;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.services.bitrise.constants.BitriseConstants;
import com.automation.mobile.services.bitrise.config.BitriseApiConfig;

import java.util.HashMap;
import java.util.Map;

public class ArtifactService {

    public static HttpResponse getArtifactList(String appSlug, String buildSlug){

        HttpRequest request = new HttpRequest();

        String token = System.getenv("BITRISE_TOKEN");

        String url = BitriseConstants.URL + BitriseConstants.APPS + "/" +
                appSlug + BitriseConstants.BUILDS + "/" + buildSlug + BitriseConstants.ARTIFACTS;

        request.setUrl(url);

        request.setHeaders(BitriseApiConfig.getHeaders(token));

        HttpResponse response = HttpHandler.get(request);

        return response;
    }

    public static HttpResponse getArtifact(String appSlug, String buildSlug, String artifactSlug){

        HttpRequest request = new HttpRequest();

        String token = System.getenv("BITRISE_TOKEN");

        String url = BitriseConstants.URL + BitriseConstants.APPS + "/" +
                appSlug + BitriseConstants.BUILDS + "/" + buildSlug + BitriseConstants.ARTIFACTS + "/" + artifactSlug;

        request.setUrl(url);

        request.setHeaders(BitriseApiConfig.getHeaders(token));

        HttpResponse response = HttpHandler.get(request);

        return response;
    }

    public static byte[] downloadArtifact(String downloadUrl){

        HttpRequest request = new HttpRequest();

        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Content-Type", "application/json");

        headers.put("Connection", "keep-alive");

        request.setUrl(downloadUrl);

        request.setHeaders(headers);

        byte[] response = HttpHandler.getDownload(request);

        return response;
    }
}
