package com.automation.mobile.services.ahem;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.services.ahem.config.AhemApiConfig;
import com.automation.mobile.services.ahem.constants.AhemMailConstants;

public class AhemEmailService {

    public static HttpResponse getToken(){

        HttpRequest request = new HttpRequest();

        String url = AhemMailConstants.URL + AhemMailConstants.AUTH;

        request.setUrl(url);

        request.setHeaders(AhemApiConfig.getAuthHeaders());

        HttpResponse response = HttpHandler.post(request);

        return response;
    }

    public static HttpResponse getEmailList(String token, String mailBoxName){

        HttpRequest request = new HttpRequest();

        String url = AhemMailConstants.URL + AhemMailConstants.MAIL + "/" + mailBoxName + AhemMailConstants.EMAIL;

        request.setUrl(url);

        request.setHeaders(AhemApiConfig.getHeaders(token));

        HttpResponse response = HttpHandler.get(request);

        return response;
    }

    public static HttpResponse getEmailContent(String token, String mailBoxName, String emailId){

        HttpRequest request = new HttpRequest();

        String url = AhemMailConstants.URL + AhemMailConstants.MAIL + "/" + mailBoxName + AhemMailConstants.EMAIL
                    + "/" + emailId;

        request.setUrl(url);

        request.setHeaders(AhemApiConfig.getHeaders(token));

        HttpResponse response = HttpHandler.get(request);

        return response;
    }

    public static HttpResponse deleteEmailContent(String token, String mailBoxName, String emailId){

        HttpRequest request = new HttpRequest();

        String url = AhemMailConstants.URL + AhemMailConstants.MAIL + "/" + mailBoxName + AhemMailConstants.EMAIL
                + "/" + emailId;

        request.setUrl(url);

        request.setHeaders(AhemApiConfig.getHeaders(token));

        HttpResponse response = HttpHandler.delete(request);

        return response;
    }
}
