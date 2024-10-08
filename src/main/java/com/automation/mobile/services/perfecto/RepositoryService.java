package com.automation.mobile.services.perfecto;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.services.perfecto.config.PerfectoApiConfig;
import com.automation.mobile.services.perfecto.constants.PerfectoConstants;

public class RepositoryService {

    public static HttpResponse getFileList(String platformName, String cloudToken){

        HttpRequest request = new HttpRequest();

        String url = PerfectoConstants.URL + PerfectoConstants.ARTIFACTS + "?artifactType=" + platformName;

        request.setUrl(url);

        request.setHeaders(PerfectoApiConfig.getHeaders(cloudToken));

        HttpResponse response = HttpHandler.get(request);

        return response;
    }

}
