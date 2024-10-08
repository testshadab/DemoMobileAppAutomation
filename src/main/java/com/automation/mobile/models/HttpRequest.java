package com.automation.mobile.models;

import org.json.JSONObject;

import java.util.Map;

public class HttpRequest {

    public String Url;
    private Map<String, Object> serviceBody;
    public Map<String, String> Headers;
    private Map<String, Object> params;

    private String stringBody;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public Map<String, String> getHeaders() {
        return Headers;
    }

    public void setHeaders(Map<String, String> headers) {
        Headers = headers;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getStringBody() {
        return stringBody;
    }

    public void setStringBody(String stringBody) {
        this.stringBody = stringBody;
    }

    public Map<String, Object> getServiceBody() {
        return serviceBody;
    }

    public void setServiceBody(Map<String, Object> serviceBody) {
        this.serviceBody = serviceBody;
    }

    @Override
    public String toString() {
        String body = null;
        if (serviceBody != null && !serviceBody.isEmpty()) {
            body = new JSONObject(serviceBody).toString();
        } else if (stringBody != null && !stringBody.isEmpty()) {
            body = stringBody;
        }
        return "HttpRequest{" +
                "Url='" + Url + '\'' +
                ", Body='" + body + '\'' +
                ", Headers=" + Headers +
                ", params=" + params +
                '}';


    }
}