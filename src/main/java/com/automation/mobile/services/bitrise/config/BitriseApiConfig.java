package com.automation.mobile.services.bitrise.config;

import java.util.HashMap;
import java.util.Map;

public class BitriseApiConfig {

    public static Map<String, String> getHeaders(String token){

        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Authorization", token);

        headers.put("accept", "application/json");

        return headers;
    }
}
