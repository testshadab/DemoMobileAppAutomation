package com.automation.mobile.services.perfecto.config;

import java.util.HashMap;
import java.util.Map;

public class PerfectoApiConfig {

    public static Map<String, String> getHeaders(String token){

        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Perfecto-Authorization", token);

        return headers;
    }
}
