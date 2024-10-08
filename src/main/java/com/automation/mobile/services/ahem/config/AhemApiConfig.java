package com.automation.mobile.services.ahem.config;

import java.util.HashMap;
import java.util.Map;

public class AhemApiConfig {

    public static ThreadLocal<Map<String, Object>> cache = new ThreadLocal<>();

    public static Map<String, String> getHeaders(String token){

        Map<String, String> headers = new HashMap<String, String>();

        headers.put("accept", "application/json");

        headers.put("Authorization", "Bearer " + token);

        return headers;
    }

    public static Map<String, String> getAuthHeaders(){

        Map<String, String> headers = new HashMap<String, String>();

        headers.put("accept", "application/json");

        headers.put("Content-Type", "text/plain");

        return headers;
    }
}
