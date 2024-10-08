package com.automation.mobile.models;

import org.json.JSONArray;
import org.json.JSONObject;

public class HttpResponse {

    private int statusCode;
    private String content;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JSONObject getJsonResponse() {
        return new JSONObject(this.content);
    }

    public JSONArray getJsonArrayResponse() {

        return new JSONArray(this.content);
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "statusCode=" + statusCode +
                ", content='" + content + '\'' +
                '}';
    }
}
