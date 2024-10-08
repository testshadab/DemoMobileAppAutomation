package com.automation.mobile.handlers;

import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//
public class HttpHandler {

    public static HttpResponse post(HttpRequest httpRequest) {

        HttpResponse httpResponse = new HttpResponse();
        RequestSpecification request = RestAssured.given();
        request.headers(httpRequest.getHeaders());
        if (null != httpRequest.getParams() && httpRequest.getParams().size() > 0) {

            request.formParams(httpRequest.getParams());
        } else if (null != httpRequest.getStringBody() && !httpRequest.getStringBody().isEmpty()) {
            request.body(httpRequest.getStringBody());
        } else if (null != httpRequest.getServiceBody() && !httpRequest.getServiceBody().isEmpty()) {
            request.body(httpRequest.getServiceBody());
        }
        Response response = request.post(httpRequest.getUrl());
        httpResponse.setStatusCode(response.getStatusCode());
        httpResponse.setContent(response.body().asString());
        return httpResponse;
    }

    public static HttpResponse get(HttpRequest httpRequest) {
        HttpResponse httpResponse = new HttpResponse();
        RequestSpecification request = RestAssured.given();
//        request.log().all();
        request.headers(httpRequest.getHeaders());
        Response response = request.get(httpRequest.getUrl());
//        response.body().prettyPrint();
        httpResponse.setStatusCode(response.getStatusCode());
        httpResponse.setContent(response.body().asString());
        return httpResponse;
    }

    public static HttpResponse patch(HttpRequest httpRequest) {

        HttpResponse httpResponse = new HttpResponse();

        RequestSpecification request = RestAssured.given();

        request.headers(httpRequest.getHeaders());

        Response response = request.patch(httpRequest.getUrl());

        httpResponse.setStatusCode(response.getStatusCode());

        httpResponse.setContent(response.body().asString());

        return httpResponse;
    }

    public static byte[] getDownload(HttpRequest httpRequest) {

        RequestSpecification request = RestAssured.given();

        request.headers(httpRequest.getHeaders());

        Response response = request.get(httpRequest.getUrl());

        byte[] fileBytes = response.getBody().asByteArray();
        return fileBytes;
    }

    public static HttpResponse delete(HttpRequest httpRequest) {
        HttpResponse httpResponse = new HttpResponse();
        RequestSpecification request = RestAssured.given();
        request.headers(httpRequest.getHeaders());
        Response response = request.delete(httpRequest.getUrl());
        httpResponse.setStatusCode(response.getStatusCode());
        httpResponse.setContent(response.body().asString());
        return httpResponse;
    }

    public static HttpResponse deleteWithPayload(HttpRequest httpRequest) {
        HttpResponse httpResponse = new HttpResponse();
        RequestSpecification request = RestAssured.given();
        request.headers(httpRequest.getHeaders());
        request.body(httpRequest.getServiceBody());
        //request.log().all();
        Response response = request.delete(httpRequest.getUrl());
        httpResponse.setStatusCode(response.getStatusCode());
        httpResponse.setContent(response.body().asString());
        return httpResponse;
    }
}